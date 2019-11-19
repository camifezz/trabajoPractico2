package algochess.Piezas;

import algochess.Ubicacion.Direccion;
import excepciones.CasilleroOcupadoException;

import java.util.ArrayList;
import java.util.Iterator;

public class Batallon implements Movible {

    private Soldado capitan;
    private ArrayList<Pieza> tropa;
    private ArrayList<Pieza> esperanOrden;
    private ArrayList<Pieza> yaMovieron;

    public Batallon(Soldado soldado){
        this.capitan = soldado;
        this.romperFilas();
    }

    public void enlistar(Soldado soldado){
        tropa.add(soldado);
    }

    public boolean pertenece(Pieza soldado) {
        return (tropa.contains(soldado));
    }

    public void mover(Direccion enDireccion){
        if(!enMarcha()) {
            romperFilas();
        } else {
           this.esperanOrden = tropa;
           moverRestantes(enDireccion);
        }
    }

    public void moverOtra(Pieza pieza, Pieza soldado, Direccion direccion) {
        if(!pertenece(pieza)) {
            throw new CasilleroOcupadoException("Casillero Ocupado");
        }
        ((Soldado) pieza).mover(direccion, this);
        ((Soldado) soldado).mover(direccion,this);
        yaMovieron.add(pieza);
    }

    private void moverRestantes(Direccion enDireccion){
        Iterator<Pieza> iterador = esperanOrden.iterator();

        while(iterador.hasNext()) {
            Soldado soldado = (Soldado)iterador.next();
            try {
                iterador.remove();
                if(!yaMovieron.contains(soldado)) {
                    soldado.mover(enDireccion, this);
                    yaMovieron.add(soldado);
                }
            } catch (CasilleroOcupadoException ocupado) {
                yaMovieron.add(soldado);
            }

        }
    }

    private boolean enMarcha(){
        tropa.removeIf(soldado -> capitan.casillero().distanciaA(soldado.casillero()) > 1);

        return (tropa.size() > 2);
    }

    private void romperFilas(){
        this.tropa = new ArrayList<>();
        enlistar(capitan);
        this.esperanOrden = tropa;
        this.yaMovieron = new ArrayList<>();
    }
}