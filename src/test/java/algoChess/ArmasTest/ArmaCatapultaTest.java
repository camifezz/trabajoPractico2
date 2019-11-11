package algoChess.ArmasTest;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCatapultaTest {
    private Tablero tablero;
    private Posicion posicionRojo;
    private Casillero casillero;
    private Pieza soldado;
    private Arma armaCatapulta;

    @BeforeEach
    public void init() {
        tablero = new Tablero();
        posicionRojo = new Posicion(1, 1); // Posicion de equipo rojo.
        casillero = tablero.casilleroEn(posicionRojo);
        soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        armaCatapulta = new ArmaCatapulta();
    }

    // Atacar Piezas
    @Test
    public void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){
        armaCatapulta.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaMayorDisminuyeVida(){
        armaCatapulta.atacarA(soldado,6);
        assertEquals(80,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        assertEquals(0,soldado.vida());
    }
}
