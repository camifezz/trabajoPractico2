package algochess.Ubicacion.StrategyDisponibilidad;

import algochess.Piezas.Pieza;
import algochess.Ubicacion.Casillero;

public interface StrategyDisponibilidad {

    void agregarPieza(Pieza pieza, Casillero casillero);
    void quemar(double danio,Pieza pieza);
}
