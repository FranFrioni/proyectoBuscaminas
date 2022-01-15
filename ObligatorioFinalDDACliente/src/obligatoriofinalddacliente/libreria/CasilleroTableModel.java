/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddacliente.libreria;

import javax.swing.table.*;
import obligatoriofinalddainterfaz.*;

/**
 *
 * @author Camila
 */
public class CasilleroTableModel extends AbstractTableModel{
    private Casillero[][] casilleros;
    
    public CasilleroTableModel(Casillero[][] casilleros){
        this.casilleros = casilleros;
    }
    
    @Override
    public int getRowCount(){
        return casilleros.length;
    }
    
    @Override
    public int getColumnCount(){
        return casilleros[0].length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        return casilleros[rowIndex][columnIndex];
    }
}
