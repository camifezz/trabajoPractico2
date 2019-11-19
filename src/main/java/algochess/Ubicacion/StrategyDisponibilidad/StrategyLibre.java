package algochess.Ubicacion.StrategyDisponibilidad;

import algochess.Piezas.Pieza;
import algochess.Ubicacion.Casillero;

public class StrategyLibre implements StrategyDisponibilidad {

    public void agregarPieza(Pieza pieza, Casillero casillero){
        casillero.asignarPieza(pieza);
    }

    @Override
    public void quemar(double danio, Pieza pieza) {

    }

}
