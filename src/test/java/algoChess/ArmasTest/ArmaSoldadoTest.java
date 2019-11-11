package algoChess.ArmasTest;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaSoldadoTest {
    private Tablero tablero;
    private Posicion posicionRojo;
    private Casillero casillero;
    private Pieza soldado;
    private Arma arma;

    @BeforeEach
    void init() {
        tablero = new Tablero();
        posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        casillero = tablero.casilleroEn(posicionRojo);
        soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        arma = new ArmaSoldado();
    }

     @Test
     public void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
         arma.atacarA(soldado,3);
         assertEquals(100,soldado.vida());
     }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaDisminuyeVida(){
        arma.atacarA(soldado,1);
        assertEquals(90,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);

        assertEquals(0,soldado.vida());
    }
}
