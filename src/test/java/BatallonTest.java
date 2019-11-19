import algochess.Batallon;
import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Catapulta;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Direccion;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BatallonTest {
    @Test
    public void testBatallonSeCreaCorrectamente(){
        Soldado s2 = new Soldado(new EquipoAzul());
        Batallon batallon = new Batallon(new EquipoAzul(),s2);
        assertEquals(1,batallon.cantidadDeSoldadosUnidos());
    }

    @Test
    public void testSeFiltranBienLosParticipantes(){
        Soldado s2 = new Soldado(new EquipoAzul());
        Soldado s1 = new Soldado(new EquipoAzul());
        Catapulta c1 = new Catapulta(new EquipoAzul());
        Batallon batallon = new Batallon(new EquipoAzul(),s2);
        ArrayList<Pieza>vecinos = new ArrayList<Pieza>();
        vecinos.add(s1);
        vecinos.add(c1);
        batallon.filtrarParticipantes(vecinos);
        assertEquals(2,batallon.cantidadDeSoldadosUnidos());
    }

//    @Test
//    public void testSeMueveBatallonCorrectamente(){
//        Tablero tablero = new Tablero();
//        Casillero casillero1 = new Casillero(new Posicion(2,4),new EquipoAzul());
//        Casillero casillero2 = new Casillero(new Posicion(2,3),new EquipoAzul());
//        Casillero casillero3 = new Casillero(new Posicion(2,5),new EquipoAzul());
//        Soldado s2 = new Soldado(new EquipoAzul());
//        casillero1.agregarPieza(new Soldado(new EquipoAzul()));
//        casillero2.agregarPieza(s2);
//        casillero3.agregarPieza(new Soldado(new EquipoAzul()));
//        Batallon batallon = new Batallon(new EquipoAzul(),s2);
//        batallon.mover(new Direccion(0,1));
//        assertEquals(2,s2.posicion().getHorizontal());
//    }

}
