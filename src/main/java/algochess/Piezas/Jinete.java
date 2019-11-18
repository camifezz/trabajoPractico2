package algochess.Piezas;

import algochess.Armas.ArmaArcoJinete;
import algochess.Armas.ArmaEspadaJinete;
import algochess.Batallon;
import algochess.Equipos.Equipo;
import algochess.FactoryConstantes;
import algochess.Ubicacion.Direccion;

public class Jinete extends Pieza implements Movible{
    private static int costo = 3;

    public Jinete(Equipo equipo) {
        super(FactoryConstantes.vidaJinete(), equipo);
        this.agregarArma(new ArmaArcoJinete());
    }

    public static int getCosto() { return costo; }

    // Cambiar arma
    public void equiparArco(){
        this.agregarArma(new ArmaArcoJinete());
    }
    public void equiparEspada(){
        this.agregarArma(new ArmaEspadaJinete());
    }

    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

    @Override
    public void unirseABatallon(Batallon batallon){}
}
