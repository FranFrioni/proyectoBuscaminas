/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddainterfaz;

import java.io.Serializable;

/**
 *
 * @author Camila
 */
public class Casillero implements Serializable{
    private boolean mina;
    private boolean destapado;
    private int jugadorDestapador;

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isDestapado() {
        return destapado;
    }

    public void setDestapado(boolean destapado) {
        this.destapado = destapado;
    }

    public int getJugadorDestapador() {
        return jugadorDestapador;
    }

    public void setJugadorDestapador(int jugadorDestapador) {
        this.jugadorDestapador = jugadorDestapador;
    }
    
    
}
