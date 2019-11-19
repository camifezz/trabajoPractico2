package algochess.Ubicacion.StrategyQuemarse;

import algochess.Ubicacion.Casillero;

public class StrategyNoQuemado implements StrategyEstado {
    @Override
    public void prenderFuego(double danio, Casillero casillero) {
        casillero.quemar(danio);

    }
}
