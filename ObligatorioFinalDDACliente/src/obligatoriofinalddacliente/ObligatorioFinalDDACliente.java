/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddacliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import obligatoriofinalddacliente.controlador.*;
import obligatoriofinalddacliente.libreria.*;
import obligatoriofinalddacliente.ui.*;
import obligatoriofinalddainterfaz.*;

/**
 *
 * @author Camila
 */
public class ObligatorioFinalDDACliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            IFachadaRemota f = (IFachadaRemota) Naming.lookup("rmi://localhost:1099/fachadaRemota");
            AppCliente.getInstancia().setFachadaRemota(f);
            FrmJuego juego = new FrmJuego();
            ClienteController controlador = new ClienteController(juego);
            juego.setControlador(controlador);
            juego.setVisible(true);
        } catch (NotBoundException ex) {
            Logger.getLogger(ObligatorioFinalDDACliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ObligatorioFinalDDACliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ObligatorioFinalDDACliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
