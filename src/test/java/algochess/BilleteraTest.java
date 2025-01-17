package algochess;

import algochess.Equipos.Equipo;
import algochess.Equipos.EquipoRojo;
import excepciones.NoAlcanzanLasMonedasException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilleteraTest {

    @Test
    void testNoSePuedeComprarUnaPiezaSinPuntosLanzaExcepcion() {
        Billetera billetera = new Billetera(2);
        Equipo equipo = new EquipoRojo();
        assertThrows(NoAlcanzanLasMonedasException.class,()->billetera.comprarJinete(equipo));
    }
}