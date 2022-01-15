/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddaservidor;

import obligatoriofinalddainterfaz.*;
import obligatoriofinalddaservidor.fachada.*;
import java.rmi.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;

/**
 *
 * @author Camila
 */
public class ObligatorioFinalDDAServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {  
            IFachadaRemota ifr = (IFachadaRemota) UnicastRemoteObject.exportObject(new FachadaRemota(),0);
            LocateRegistry.createRegistry(1099);
            Naming.rebind("fachadaRemota", ifr);
            System.out.println("Servidor iniciado");
        } catch (RemoteException ex) {
            Logger.getLogger(ObligatorioFinalDDAServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ObligatorioFinalDDAServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
