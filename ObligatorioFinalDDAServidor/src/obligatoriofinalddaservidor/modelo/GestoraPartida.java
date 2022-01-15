/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddaservidor.modelo;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import obligatoriofinalddainterfaz.*;

/**
 *
 * @author Camila
 */
public class GestoraPartida {
    private static GestoraPartida instancia;
    private ArrayList<Partida> partidas;
    private Partida partidaActual;
    
    private GestoraPartida(){
        partidas = new ArrayList();
        partidaActual = new Partida();
    }
    
    public static GestoraPartida getInstancia(){
        if(instancia == null){
            instancia = new GestoraPartida();
        }
        return instancia;
    }
    
    public int obtenerIdPartidaActual(){
        return partidaActual.getId();
    }
    
    public int ingresarJugador(String usuario){
        partidaActual.ingresarJugador(usuario);
        int idPartidaActual = partidaActual.getId();
        if(partidaActual.isIniciada()){
            Partida partida = new Partida(idPartidaActual,partidaActual.getJugador1(),partidaActual.getJugador2(),partidaActual.getTablero());
            partidas.add(partida);
            partidaActual = new Partida();
            return idPartidaActual;
        }
        return 0;
    }
    
    private Partida obtenerPartidaPorId(int id){
        for(Partida partida : partidas){
            if (partida.getId() == id){
                return partida;
            }
        }
        return null;
    }
    
    public String obtenerJugador1PorId(int id){
        return obtenerPartidaPorId(id).getJugador1();
    }
    
    public String obtenerJugador2PorId(int id){
        return obtenerPartidaPorId(id).getJugador2();
    }
    
    public Casillero[][] obtenerTableroPorId(int id){
        return obtenerPartidaPorId(id).getTablero();
    }
    
    public Evento destaparCasillero(int id, int row, int col, int jugador){
        try {
            return obtenerPartidaPorId(id).destaparCasillero(row,col,jugador);
        } catch (Exception ex) {
            Logger.getLogger(GestoraPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int obtenerTurnoPorId(int id){
        return obtenerPartidaPorId(id).getJugadorTurno();
    }
}
