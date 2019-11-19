package algochess;

import algochess.Equipos.Equipo;
import algochess.Piezas.Movible;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Direccion;
import algochess.Ubicacion.Posicion;
import excepciones.CasilleroOcupadoException;

import java.util.ArrayList;
import java.util.TreeMap;

public class Batallon implements Movible {
    Equipo equipo;
    private ArrayList<Soldado> soldados;


    //El Batallon se crea con el equipo del soldado que decide crearlo
    public Batallon(Equipo equipo,Soldado soldadoLider){
        this.equipo = equipo;
        this.soldados = new ArrayList<Soldado>();
        soldados.add(soldadoLider);
    }

    @Override
    public void mover(Direccion direccion) {
        while (!this.soldados.isEmpty()) {
            for (Soldado soldado : this.soldados) {
                try {
                    soldado.mover(direccion);
                    soldados.remove(soldado);
                } catch (CasilleroOcupadoException ocupado) {
                }
            }
        }
    }

    public void unirse(Soldado soldado){
        soldados.add(soldado);
    }


    public void filtrarParticipantes(ArrayList<Pieza> vecinos){
        for(Pieza piezaVecina:vecinos){
            if(piezaVecina.soyAliado(this.equipo)){
                piezaVecina.unirseABatallon(this);
            }
        }
    }
    //Metodo solo usado para tests
    public int cantidadDeSoldadosUnidos(){
        return this.soldados.size();
    }
}
