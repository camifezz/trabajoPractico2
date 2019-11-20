package algochess.Ubicacion;

import algochess.Equipos.Equipo;
import algochess.Piezas.Pieza;
import algochess.Ubicacion.StrategyDisponibilidad.StrategyDisponibilidad;
import algochess.Ubicacion.StrategyDisponibilidad.StrategyLibre;
import algochess.Ubicacion.StrategyDisponibilidad.StrategyOcupado;
import algochess.Ubicacion.StrategyQuemarse.StrategyEstado;
import algochess.Ubicacion.StrategyQuemarse.StrategyNoQuemado;
import algochess.Ubicacion.StrategyQuemarse.StrategyQuemado;

import java.util.ArrayList;

public class Casillero { //TODO :falta  --- incompatibilidad posicion-casillero

    private Posicion posicion;
    private Equipo equipo;
    private StrategyDisponibilidad disponibilidad;
    private Pieza pieza;
    private Tablero tablero;
    private StrategyEstado estado;

    public Casillero(Posicion posicion,Equipo equipo  ){
        this.posicion = posicion;
        this.equipo = equipo;
        this.desocupar();
        this.noQuemado();
    }

    public Casillero(Posicion posicion, Tablero tablero){
        this.tablero = tablero;
        this.posicion = posicion;
        this.desocupar();
        this.noQuemado();
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

    public void noQuemado(){
        this.estado = new StrategyNoQuemado();
    }

    public void quemado(){
        this.estado = new StrategyQuemado();
    }

    public void prenderFuego(double danio){
        this.estado.prenderFuego(danio,this);
    }

    public void quemar(double danio){
        this.disponibilidad.quemar(danio,this.pieza);
        this.quemado();
        this.propagarDanio(danio);

    }

    public void propagarDanio(double danio) {
        ArrayList<Casillero>vecinos = this.vecinos();
        for(Casillero casilleroVecino:vecinos){
            casilleroVecino.prenderFuego(danio);
        }
    }

    public Pieza getPieza(){
        return this.pieza;
    }

    //Te trae los vecinos en todas las direcciones
    public ArrayList<Casillero> vecinos(){
        ArrayList<Casillero>vecinos = new ArrayList<Casillero>();
       vecinos.add(this.siguiente(Direccion.norte()));
       vecinos.add(this.siguiente(Direccion.sur()));
       vecinos.add(this.siguiente(Direccion.este()));
       vecinos.add(this.siguiente(Direccion.surOeste()));
       vecinos.add(this.siguiente(Direccion.norOeste()));
       vecinos.add(this.siguiente(Direccion.norEste()));
       vecinos.add(this.siguiente(Direccion.oeste()));
       vecinos.add(this.siguiente(Direccion.surEste()));
       return vecinos;
    }

    //Te trae las piezas vecinas en las direcciones este y oeste es para batallon
    public ArrayList<Pieza> vecinas(){
        ArrayList<Pieza>vecinas = new ArrayList<Pieza>();
        Casillero vecino1 = this.siguiente(Direccion.este());
        Casillero vecino2 = this.siguiente(Direccion.oeste());
        vecinas.add(vecino1.getPieza());
        vecinas.add(vecino2.getPieza());
        return vecinas;
    }

    public void terminoElAtaque(){
        this.noQuemado();
        this.propagarFinDelAtaque();
    }

    public void propagarFinDelAtaque() {
        ArrayList<Casillero>vecinos = this.vecinos();
        for(Casillero casilleroVecino:vecinos){
            casilleroVecino.terminoElAtaque();
        }
    }
}
