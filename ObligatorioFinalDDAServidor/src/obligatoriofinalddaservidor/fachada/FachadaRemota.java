/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddaservidor.fachada;

import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import obligatoriofinalddainterfaz.*;
import obligatoriofinalddaservidor.modelo.*;

/**
 *
 * @author Camila
 */
public class FachadaRemota implements IFachadaRemota{
    private ArrayList<IObserverRemoto> observadores;
    private GestoraPartida gestora = GestoraPartida.getInstancia();
    
    public FachadaRemota(){
        observadores = new ArrayList<>();
    }

    @Override
    public void agregarObservador(IObserverRemoto observer) throws RemoteException {
        observadores.add(observer);
    }

    public void notificarObservadores(Evento evento, Object object){
        for(IObserverRemoto observer : observadores){
            try {
                observer.update(evento, object);
            } catch (RemoteException ex) {
                Logger.getLogger(FachadaRemota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public int obtenerIdPartidaActual() throws RemoteException {
        return gestora.obtenerIdPartidaActual();
    }

    @Override
    public void ingresarJugador(String usuario) throws RemoteException {
        int id = gestora.ingresarJugador(usuario);
        if (id != 0){
            notificarObservadores(Evento.InicioPartida, id);
        }
    }
    
    @Override
    public String obtenerJugador1PorId(int id){
        return gestora.obtenerJugador1PorId(id);
    }
    
    @Override
    public String obtenerJugador2PorId(int id){
        return gestora.obtenerJugador2PorId(id);
    }
    
    @Override
    public Casillero[][] obtenerTableroPorId(int id){
        return gestora.obtenerTableroPorId(id);
    }
    
    @Override
    public void destaparCasillero(int id, int row, int col, int jugador){
        Evento e = gestora.destaparCasillero(id,row,col,jugador);
        if(e == Evento.SiguienteTurno){
            notificarObservadores(Evento.SiguienteTurno, id);
        } else if (e == Evento.FinalizarPartida){
            notificarObservadores(Evento.FinalizarPartida,id);
        }
    }
    
    @Override
    public int obtenerTurnoPorId(int id){
        return gestora.obtenerTurnoPorId(id);
    }
}
