package algochess.Ubicacion;

import algochess.Equipos.Equipo;
import algochess.Piezas.Pieza;
import algochess.Ubicacion.StrategyDisponibilidad.StrategyDisponibilidad;
import algochess.Ubicacion.StrategyDisponibilidad.StrategyLibre;
import algochess.Ubicacion.StrategyDisponibilidad.StrategyOcupado;

import java.util.ArrayList;

public class Casillero { //TODO :falta  --- incompatibilidad posicion-casillero

    private Posicion posicion;
    private Equipo equipo;
    private StrategyDisponibilidad disponibilidad;
    private Pieza pieza;
    private Tablero tablero;

    public Casillero(Posicion posicion,Equipo equipo  ){
        this.posicion = posicion;
        this.equipo = equipo;
        this.desocupar();
    }

    public Casillero(Posicion posicion, Tablero tablero){
        this.tablero = tablero;
        this.posicion = posicion;
        this.desocupar();
    }

    public double calcularDanio(Equipo equipo){
        return this.equipo.atacar(equipo);
    }

    // Ubicar pieza en casillero, chequea equipos
    public void ubicar(Pieza pieza){
        this.agregarPieza(pieza.ubicarCon(this.equipo));
    }

    /// Agrega Pieza delega en strategyDisponibilidad
    public void agregarPieza(Pieza pieza){
        this.disponibilidad.agregarPieza(pieza,this);
    }

    // asigna pieza y desocupa
    public void asignarPieza(Pieza pieza){
        this.pieza = pieza;
        this.disponibilidad = new StrategyOcupado();
        this.pieza.ocuparCasillero(this);
    }

    public void desocupar(){
        this.pieza = null;
        this.disponibilidad = new StrategyLibre();
    }

    //// Agregar Tablero, ver si se hace en el constructor
    public void agregarTablero(Tablero tablero){
        this.tablero = tablero;
    }

    ///// Delegacion en posicion y direccion
    public Casillero siguiente(Direccion enDireccion){
        return this.tablero.casilleroEn(this.posicion.siguiente(enDireccion));
    }
    public int distanciaA(Casillero casillero){
       return casillero.distanciaA(this.posicion);
    }
    public int distanciaA(Posicion posicion){
        return posicion.distanciaA(this.posicion);
    }
    public Posicion posicion(){return this.posicion;}

    public Pieza getPieza(){
        return this.pieza;
    }
    //Te trae los casilleros vecinos en las direcciones este y oeste
    public ArrayList<Casillero> vecinos(){
        ArrayList<Casillero>vecinos = new ArrayList<Casillero>();
        Direccion este = new Direccion(1,0);
        Direccion oeste = new Direccion(-1,0);
        Casillero vecino1 = this.siguiente(este);
        Casillero vecino2 = this.siguiente(oeste);
        vecinos.add(vecino1);
        vecinos.add(vecino2);
        return vecinos;

    }


}
