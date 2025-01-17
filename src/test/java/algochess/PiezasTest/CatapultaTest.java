package algochess.PiezasTest;
import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Catapulta;
import algochess.Piezas.Pieza;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatapultaTest {


    @Test
    public void testCatapultaSeCreaConVidaCorrecta() {
        Pieza pieza = new Catapulta(new EquipoAzul());
        assertEquals(50, pieza.vida());
    }

    @Test
    public void testCatapultaHace20DeDañoAOtraPiezaEnRango() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,7);
        Pieza pieza = new Catapulta(new EquipoAzul());
        Pieza pieza2 = new Catapulta(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        pieza2.asignarCasillero(casillero2);

        pieza.atacar(pieza2);
        assertEquals(30,pieza2.vida());
    }
}
