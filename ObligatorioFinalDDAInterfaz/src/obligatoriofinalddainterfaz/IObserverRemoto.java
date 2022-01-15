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
public interface IObserverRemoto extends Remote{
    void update(Evento e, Object o) throws RemoteException;
}
