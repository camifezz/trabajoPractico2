package algochess.Ubicacion.StrategyQuemarse;

import algochess.Ubicacion.Casillero;

public interface StrategyEstado {
    void prenderFuego(double danio, Casillero casillero);
}
