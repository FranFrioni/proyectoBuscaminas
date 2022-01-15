/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddainterfaz;

import java.rmi.*;

/**
 *
 * @author Camila
 */
public interface IFachadaRemota extends Remote{
    void agregarObservador(IObserverRemoto observer) throws RemoteException;
    int obtenerIdPartidaActual() throws RemoteException;
    void ingresarJugador(String usuario) throws RemoteException;
    String obtenerJugador1PorId(int id) throws RemoteException;
    String obtenerJugador2PorId(int id) throws RemoteException;
    Casillero[][] obtenerTableroPorId(int id) throws RemoteException;
    void destaparCasillero(int id, int row, int col, int jugador) throws RemoteException;
    int obtenerTurnoPorId(int id) throws RemoteException;
}
