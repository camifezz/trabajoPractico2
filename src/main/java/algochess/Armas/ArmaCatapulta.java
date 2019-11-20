package algochess.Armas;


import algochess.FactoryConstantes;
import algochess.Piezas.Pieza;
import algochess.Ubicacion.Casillero;

public class ArmaCatapulta extends Arma {

    public ArmaCatapulta() {
        super(FactoryConstantes.armaCatapulta(), Rango.lejano());
    }

@Override

public void atacarA(Pieza unaPieza, int distancia) {
    if(this.rango.enRango(distancia)){
        Casillero casillero = unaPieza.getCasillero();
        casillero.prenderFuego(FactoryConstantes.armaCatapulta());
        casillero.terminoElAtaque();
    }
}
}
