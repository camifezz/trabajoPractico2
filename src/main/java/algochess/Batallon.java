package algochess;

import algochess.Equipos.Equipo;
import algochess.Piezas.Movible;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Direccion;
import algochess.Ubicacion.Posicion;

import java.util.ArrayList;
import java.util.TreeMap;

public class Batallon implements Movible {
    Equipo equipo;
    //Casillero casilleroLider;
    private TreeMap<Integer,Soldado> soldados;

    //El Batallon se crea con el equipo del soldado que decide crearlo
    public Batallon(Equipo equipo){
        this.equipo = equipo;
    }

    @Override
    public void mover(Direccion direccion) {
    }

    public void unirse(int distanciaADireccion, Soldado soldado){
        soldados.put(distanciaADireccion,soldado);
    }
    public boolean hayEspacio(){
        return soldados.size() < 3;
    }

    public void filtrarParticipantes(ArrayList<Casillero> vecinos){
        for(Casillero casillero:vecinos){
            Pieza piezaVecina = casillero.getPieza();
            if(piezaVecina.soyAliado(this.equipo) && this.hayEspacio()){
                piezaVecina.unirseABatallon(this);
            }
        }
    }
}
