package algoChess.UbicacionTest;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Direccion;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import excepciones.CasilleroOcupadoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CasilleroTest {


/*
    @Test
    public void testUbicarUbicaCorrectamente(){
        Equipo equipo = new Rojo();
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion,equipo);
        Pieza soldado = new Soldado(equipo);
        casillero.ubicar(soldado);
        StrategyDisponibilidad ocupado;

    }*/


// Test en relacion a una posicion
    @Test
    public void testCasilleroDevuelveDistanciaAPosicionCorrectaEnX(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(4,1);
        Casillero casillero = new Casillero(posicion1,equipo);

        assertEquals(casillero.distanciaA(posicion2),3);

    }

    @Test
    public void testCasilleroDevuelveDistanciaAPosicionCorrectaEnY(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,4);
        Casillero casillero = new Casillero(posicion1,equipo);

        assertEquals(casillero.distanciaA(posicion2),3);

    }

    @Test
    public void testCasilleroDevuelveDistanciaAPosicionCorrectaEnAmbasDirecciones(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,6);
        Casillero casillero = new Casillero(posicion1,equipo);

        assertEquals(casillero.distanciaA(posicion2),5);

    }

    // Test en relacion a un casillero
    @Test
    public void testCasilleroDevuelveDistanciaACasilleroCorrectaEnY(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,6);
        Casillero casillero = new Casillero(posicion1,equipo);
        Casillero casillero2 = new Casillero(posicion2,equipo);
        assertEquals(casillero.distanciaA(casillero2),5);

    }

    @Test
    public void testCasilleroDevuelveDistanciaACasilleroCorrectaEnX(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(6,1);
        Casillero casillero = new Casillero(posicion1,equipo);
        Casillero casillero2 = new Casillero(posicion2,equipo);
        assertEquals(casillero.distanciaA(casillero2),5);

    }


    @Test
    public void testCasilleroDevuelveDistanciaACasilleroCorrectaEnAmbasDirecciones(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(6,8);
        Casillero casillero = new Casillero(posicion1,equipo);
        Casillero casillero2 = new Casillero(posicion2,equipo);
        assertEquals(casillero.distanciaA(casillero2),7);

    }

    // Test casillero devuelve casillero en direccion correcta
    @Test
    public void testCasilleroDevuelveCasilleroEnDireccionNorte(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(10,11);
        Casillero casillero = new Casillero(posicion1,equipo);
        Tablero tablero = new Tablero();
        casillero.agregarTablero(tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.norte());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
    public void testCasilleroDevuelveCasilleroEnDireccionSur(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(10,9);
        Casillero casillero = new Casillero(posicion1,equipo);
        Tablero tablero = new Tablero();
        casillero.agregarTablero(tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.sur());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
    public void testCasilleroDevuelveCasilleroEnDireccionEste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(11,10);
        Casillero casillero = new Casillero(posicion1,equipo);
        Tablero tablero = new Tablero();
        casillero.agregarTablero(tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.este());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
    public void testCasilleroDevuelveCasilleroEnDireccionOeste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(9,10);
        Casillero casillero = new Casillero(posicion1,equipo);
        Tablero tablero = new Tablero();
        casillero.agregarTablero(tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.oeste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
    public void testCasilleroDevuelveCasilleroEnDireccionNoreste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(11,11);
        Casillero casillero = new Casillero(posicion1,equipo);
        Tablero tablero = new Tablero();
        casillero.agregarTablero(tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.norEste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
    public void testCasilleroDevuelveCasilleroEnDireccionNoroeste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(9,11);
        Casillero casillero = new Casillero(posicion1,equipo);
        Tablero tablero = new Tablero();
        casillero.agregarTablero(tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.norOeste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
    public void testCasilleroDevuelveCasilleroEnDireccionSurEste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(11,9);
        Casillero casillero = new Casillero(posicion1,equipo);
        Tablero tablero = new Tablero();
        casillero.agregarTablero(tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.surEste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
    public void testCasilleroDevuelveCasilleroEnDireccionSurOeste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(9,9);
        Casillero casillero = new Casillero(posicion1,equipo);
        Tablero tablero = new Tablero();
        casillero.agregarTablero(tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.surOeste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
    public void testCasilleroLanzaExcepcionDeOcupadoSiSeQuiereAgregarOtraPieza(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(20,20);

        Casillero casillero = new Casillero(posicion1,tablero);
        Casillero casillero2 = new Casillero(posicion2,tablero);

        Pieza pieza = new Soldado(new EquipoAzul()) ;
        Pieza pieza2 = new Soldado(new EquipoAzul()) ;
        pieza.asignarCasillero(casillero2);

        casillero.agregarPieza(pieza);


        assertThrows(CasilleroOcupadoException.class, ()-> casillero.agregarPieza(pieza2));

    }


    @Test
    public void testCasilleroSeDesocupaDePiezaYPuedeAgregarOtraSinProblemas(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(20,20);
        Posicion posicion3 = new Posicion(15,15);

        Casillero casillero = new Casillero(posicion1,tablero);
        Casillero casillero2 = new Casillero(posicion2,tablero);
        Casillero casillero3 = new Casillero(posicion2,tablero);

        Pieza pieza = new Soldado(new EquipoAzul()) ;
        Pieza pieza2 = new Soldado(new EquipoAzul()) ;
        Pieza pieza3 = new Soldado(new EquipoAzul()) ;
        pieza.asignarCasillero(casillero2);
        pieza2.asignarCasillero(casillero3);

        casillero.agregarPieza(pieza);
        casillero.desocupado();
        casillero.agregarPieza(pieza2);

        assertThrows(CasilleroOcupadoException.class, ()-> casillero.agregarPieza(pieza3));

    }


}