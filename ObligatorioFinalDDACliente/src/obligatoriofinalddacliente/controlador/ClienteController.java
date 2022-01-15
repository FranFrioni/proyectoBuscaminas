/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddacliente.controlador;

import java.rmi.RemoteException;
import obligatoriofinalddainterfaz.*;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import obligatoriofinalddacliente.libreria.AppCliente;
import obligatoriofinalddacliente.libreria.IVista;

/**
 *
 * @author Camila
 */
public class ClienteController extends UnicastRemoteObject implements IObserverRemoto{
    private IVista vista;
    
    public ClienteController(IVista vista) throws RemoteException{
        try {
            this.vista = vista;
            AppCliente.getInstancia().getFachadaRemota().agregarObservador(this);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Evento e, Object o) throws RemoteException {
        int idPartida = vista.getIdPartida();
        if(e == Evento.InicioPartida && (int)o == idPartida){
            empezarPartida(idPartida);
        } else if (e == Evento.SiguienteTurno && (int)o == idPartida){
            colocarTablero(idPartida);
            cambiarTurno(idPartida);
        } else if (e == Evento.FinalizarPartida && (int)o == idPartida){
            finalizarPartida(idPartida);
        }
    }
    
    public void ingresarJugador(String usuario){
        try {
            vista.setIdPartida(AppCliente.getInstancia().getFachadaRemota().obtenerIdPartidaActual());
            AppCliente.getInstancia().getFachadaRemota().ingresarJugador(usuario);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void colocarTablero(int id){
        try {
            Casillero[][] casilleros = AppCliente.getInstancia().getFachadaRemota().obtenerTableroPorId(id);
            vista.actualizarTablero(casilleros);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void destaparCasillero(int id, int row, int col, int jugador){
        try {
            AppCliente.getInstancia().getFachadaRemota().destaparCasillero(id, row, col, jugador);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiarTurno(int idPartida){
        try {
            colocarTablero(idPartida);
            if(AppCliente.getInstancia().getFachadaRemota().obtenerTurnoPorId(idPartida) == vista.getJugador()){
                vista.setMensaje("Tu turno!");
            } else {
                vista.setMensaje("Esperando movimiento...");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void empezarPartida(int idPartida){
        try {
            System.out.println("Iniciando Partida");
            String jugador1 = AppCliente.getInstancia().getFachadaRemota().obtenerJugador1PorId(idPartida);
            String jugador2 = AppCliente.getInstancia().getFachadaRemota().obtenerJugador2PorId(idPartida);
            vista.setUsuario1(jugador1);
            vista.setUsuario2(jugador2);
            if(vista.getUsuario() == null ? jugador1 == null : vista.getUsuario().equals(jugador1)){
                vista.setJugador(1);
                System.out.println("Se asigno jugador 1");
            } else {
                vista.setJugador(2);
                System.out.println("Se asigno jugador 2");
            }
            vista.empezarPartida();
            cambiarTurno(idPartida);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void finalizarPartida(int idPartida){
        try {
            cambiarTurno(idPartida);
            if(AppCliente.getInstancia().getFachadaRemota().obtenerTurnoPorId(idPartida) == vista.getJugador()){
                vista.setMensaje("Perdiste...");
            } else {
                vista.setMensaje("Ganaste!");
            }
            vista.activarVolverAJugar();
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void volverAJugar(){
        vista.volverAlInicio();
    }
}
