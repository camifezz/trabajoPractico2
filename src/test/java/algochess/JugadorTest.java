package algochess;

import algochess.Equipos.Equipo;
import algochess.Equipos.EquipoRojo;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    public void compraPiezasYSeGuardanCorrectamente()  {
        Equipo bando = new EquipoRojo();
        Tablero tablero = new Tablero();
        Jugador nuevoJugador = new Jugador("camila",bando,tablero);
        nuevoJugador.comprarSoldado();
        nuevoJugador.comprarJinete();
        assertEquals(nuevoJugador.getCantidadDePiezas(),2);

    }

}