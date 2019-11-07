package algoChess;

import algoChess.Equipos.Azul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Catapulta;
import algoChess.Piezas.Curandero;
import algoChess.Piezas.Jinete;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuranderoTest {

    @Test
    public void curanderoCuraSoldadoAliadoTest() {
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 2);
        Equipo bando = new Rojo();
        Curandero curandero = new Curandero(bando);
        Soldado soldado = new Soldado(bando);
        Casillero casillero1 = new Casillero(posicion1, bando);
        Casillero casillero2 = new Casillero(posicion2, bando);
        casillero1.ubicar(curandero);
        casillero2.ubicar(soldado);
        curandero.atacar(soldado);
        assertEquals(115, soldado.vidaRestante());
    }

    @Test
    public void curanderoNoCuraSoldadoAliadoPorEstarLejosTest() {
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(5, 5);
        Equipo bando = new Rojo();
        Curandero curandero = new Curandero(bando);
        Soldado soldado = new Soldado(bando);
        Casillero casillero1 = new Casillero(posicion1, bando);
        Casillero casillero2 = new Casillero(posicion2, bando);
        casillero1.ubicar(curandero);
        casillero2.ubicar(soldado);
        curandero.atacar(soldado);
        assertEquals(100, soldado.vidaRestante());

    }

    @Test
    public void curanderoNoCuraACatapultaTest(){
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(7, 5);
        Equipo bando = new Rojo();
        Curandero curandero = new Curandero(bando);
        Catapulta catapulta = new Catapulta(bando);
        Casillero casillero1 = new Casillero(posicion1, bando);
        Casillero casillero2 = new Casillero(posicion2, bando);
        casillero1.ubicar(curandero);
        casillero2.ubicar(catapulta);
        curandero.atacar(catapulta);
        assertEquals(50, catapulta.vidaRestante());

    }
    @Test
    public void curanderoNoCuraASoldadoEnemigoTest(){
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 3);
        Posicion posicion3 = new Posicion(1,2);
        Equipo bando = new Rojo();
        Equipo bando2 = new Azul();
        Curandero curandero = new Curandero(bando);
        Soldado soldado = new Soldado(bando2);
        Jinete jinete = new Jinete (bando);
        Casillero casillero1 = new Casillero(posicion1, bando);
        Casillero casillero2 = new Casillero(posicion2, bando2);
        Casillero casillero3 = new Casillero(posicion3,bando);
        casillero1.ubicar(curandero);
        casillero2.ubicar(soldado);
        casillero3.ubicar(jinete);
        jinete.atacar(soldado);
        curandero.atacar(soldado);
        assertEquals(95, soldado.vidaRestante());

    }
}
