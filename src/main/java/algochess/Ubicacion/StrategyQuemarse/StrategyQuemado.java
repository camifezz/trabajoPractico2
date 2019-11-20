package algochess.Ubicacion.StrategyQuemarse;

import algochess.Ubicacion.Casillero;

public class StrategyQuemado implements StrategyEstado {
    @Override
    public void prenderFuego(double danio, Casillero casillero) {
        casillero.propagarDanio(danio);
    }
}
