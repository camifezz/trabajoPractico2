package algochess.Piezas;

import algochess.Armas.ArmaSoldado;
import algochess.Batallon;
import algochess.Equipos.Equipo;
import algochess.FactoryConstantes;
import algochess.Ubicacion.Direccion;

public class Soldado extends Pieza implements Movible{
    private static int costo = 1;
    private Batallon batallon;

    public Soldado(Equipo equipo) {

        super(FactoryConstantes.vidaSoldado(), equipo);
        this.agregarArma(new ArmaSoldado());
        //batallon = new Batallon(equipo,this);
    }

    public static int getCosto() { return costo; }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

    //public void crearBatallon(){
    //    this.batallon = new Batallon(this.equipo,this);
    //    this.batallon.filtrarParticipantes(this.casillero.vecinos());
    //}

    @Override
    public void unirseABatallon(Batallon batallon){
        batallon.unirse(this);
    }

    @Override
    //delego al equipo la responsabilidad de ver si dos equipos son iguales.
    public boolean soyAliado(Equipo equipoPieza) {
       return this.equipo.soyAliado(equipoPieza);
    }

    public void moverBatallon(Direccion direccion){
        this.batallon = new Batallon(this.equipo,this);
        this.batallon.filtrarParticipantes(this.casillero.vecinas());
        this.batallon.mover(direccion);

    }
}
