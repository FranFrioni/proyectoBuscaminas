/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddacliente.libreria;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import obligatoriofinalddainterfaz.*;

/**
 *
 * @author Camila
 */
public class CasilleroCellRenderer extends JLabel implements TableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        MatteBorder border;
        this.setHorizontalAlignment(JLabel.CENTER);
        if(isSelected){
            border = new MatteBorder(2,2,2,2,Color.black);
        } else {
            border = new MatteBorder(1,1,1,1,Color.GRAY);
        }
        this.setBorder(border);
        if(value instanceof Casillero){
            Casillero c = (Casillero)value;
            this.setOpaque(true);
            if (c.isDestapado() && c.isMina()){
                this.setBackground(Color.black);
            } else if (c.isDestapado() && c.getJugadorDestapador() == 1){
                this.setBackground(Color.blue);
            } else if (c.isDestapado() && c.getJugadorDestapador() == 2){
                this.setBackground(Color.red);
            } else {
                this.setBackground(Color.white);
            }
        }
        return this;
    }
}