/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddacliente.libreria;

import obligatoriofinalddainterfaz.*;

/**
 *
 * @author Camila
 */
public class AppCliente {
    private static AppCliente instancia;
    private IFachadaRemota fachadaRemota;
    
    private AppCliente(){
        
    }
    
    public static AppCliente getInstancia(){
        if(instancia == null){
            instancia = new AppCliente();
        }
        return instancia;
    }

    public IFachadaRemota getFachadaRemota() {
        return fachadaRemota;
    }

    public void setFachadaRemota(IFachadaRemota fachadaRemota) {
        this.fachadaRemota = fachadaRemota;
    }
}
