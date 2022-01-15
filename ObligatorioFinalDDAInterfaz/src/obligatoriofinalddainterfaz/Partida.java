/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddainterfaz;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Camila
 */
public class Partida implements Serializable{
    private static int siguienteID = 1;
    private int id;
    private String jugador1;
    private String jugador2;
    private int jugadorTurno;
    private Casillero[][] tablero;
    private boolean finalizada;
    private boolean iniciada;
    
    public Partida(){
        iniciada = false;
        id = siguienteID++;
        generarTablero();
    }
    
    public Partida(int id, String jugador1, String jugador2, Casillero[][] tablero){
        this.id = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorTurno = 1;
        this.tablero = tablero;
        this.iniciada = true;
        this.finalizada = false;
    }
    
    private void generarTablero(){
        tablero = new Casillero[5][5];
        for(int i =0; i<tablero.length;i++ ){
            for(int j =0; j<tablero[0].length;j++){
                tablero [i][j]= new Casillero();
            }
        }
        asignarMinas();
    }
    
    private void asignarMinas(){
        int cantMinas = 4;
        while(cantMinas>0){
            Random r = new Random();
            int x = r.nextInt(5);
            int y = r.nextInt(5);
            Casillero c = tablero[x][y];
            if(c.isMina())continue;
            c.setMina(true);
            cantMinas--;
        }
    }
    
    public void ingresarJugador(String usuario){
        if(jugador1 == null){
            jugador1 = usuario;
        } else {
            jugador2 = usuario;
            iniciada = true;
        }
    }

    public int getId() {
        return id;
    }
    
    public boolean isIniciada(){
        return iniciada;
    }
    
    public String getJugador1(){
        return jugador1;
    }
    
    public String getJugador2(){
        return jugador2;
    }
    
    public Casillero[][] getTablero(){
        return tablero;
    }

    public int getJugadorTurno() {
        return jugadorTurno;
    }

    public void setJugadorTurno(int jugadorTurno) {
        this.jugadorTurno = jugadorTurno;
    }
    
    public Evento destaparCasillero(int row, int col, int jugador) throws Exception{
        if(jugador != jugadorTurno)throw new Exception("No es el turno");
        Casillero c = tablero[row][col];
        if(c.isDestapado()){
            throw new Exception ("Ya está destapada");
        }
        if (!finalizada){
            c.setDestapado(true);
            c.setJugadorDestapador(jugadorTurno);
        }
        if (!c.isMina() && !finalizada){
            if(jugadorTurno == 1){
                jugadorTurno = 2;
            } else {
                jugadorTurno = 1;
            }
            return Evento.SiguienteTurno;
        } else {
            finalizada = true;
            return Evento.FinalizarPartida;
        }
    }
}
