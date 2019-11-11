package algoChess.ArmasTest;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCurandero;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCuranderoTest {
    private Tablero tablero;
    private Posicion posicionRojo;
    private Casillero casillero;
    private Pieza soldado;
    private Arma armaCurandero;

    @BeforeEach
    public void init() {
        tablero = new Tablero();
        posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        casillero = tablero.casilleroEn(posicionRojo);
        soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        armaCurandero = new ArmaCurandero();
    }

    @Test
    public void testAtacarAPiezaADistanciaMayorNoAumentaVida(){
        soldado.hacerseDanio(30);

        armaCurandero.atacarA(soldado,3);
        assertEquals(70,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaConTodaLaVidaNoAumentaVida(){
        armaCurandero.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaSinVidaNoAumentaVida(){
        soldado.hacerseDanio(200);

        armaCurandero.atacarA(soldado,1);
        assertEquals(0,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaConPocaVidaADistanciaCorrectaAumentaVida(){
        soldado.hacerseDanio(70);

        armaCurandero.atacarA(soldado,1);
        assertEquals(45,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaAumentaVidaComoMaximo100(){
        soldado.hacerseDanio(20);

        armaCurandero.atacarA(soldado,1);
        armaCurandero.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }
}
