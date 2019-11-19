package algochess.Ubicacion.StrategyDisponibilidad;

import algochess.Piezas.Pieza;
import algochess.Ubicacion.Casillero;
import excepciones.CasilleroOcupadoException;

public class StrategyOcupado implements StrategyDisponibilidad {

    public void agregarPieza(Pieza pieza, Casillero casillero){
        throw new CasilleroOcupadoException("Casillero Ocupado");
    }

    @Override
    public void quemar(double danio, Pieza pieza) {
        pieza.quitarVida(danio);

    }

}
