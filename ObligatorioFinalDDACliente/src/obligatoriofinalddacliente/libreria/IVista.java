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
public interface IVista {
    void setIdPartida(int idPartida);
    int getIdPartida();
    void empezarPartida();
    String getUsuario();
    void setJugador(int jugador);
    int getJugador();
    void actualizarTablero(Casillero[][] casileros);
    void setUsuario1(String usuario1);
    void setUsuario2(String usuario2);
    void setMensaje(String mensaje);
    void activarVolverAJugar();
    void volverAlInicio();
}
