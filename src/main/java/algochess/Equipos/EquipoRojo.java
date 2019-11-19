package algochess.Equipos;

import algochess.Piezas.Pieza;
import excepciones.CasilleroEnemigoException;

public class EquipoRojo implements Equipo {

    public double  atacar(Equipo equipo){
        return equipo.atacar(this);
    }
    public double  atacar(EquipoRojo equipo){
        return 1.00;
    }
    public double  atacar(EquipoAzul equipo){
        return 1.05;
    }

    public Pieza ubicarCon(Equipo equipo, Pieza pieza){
        return equipo.ubicarCon(this,pieza);
    }
    public Pieza ubicarCon(EquipoRojo equipo, Pieza pieza){ return pieza;}
    public Pieza ubicarCon(EquipoAzul equipo, Pieza pieza){
        throw new CasilleroEnemigoException("Casillero diferente equipo");
    }

    public boolean soyAliado(Equipo equipo) {
        return equipo.soyAliado(this);
    }
    public boolean soyAliado(EquipoAzul equipo){
        return false;
    }
    public boolean soyAliado(EquipoRojo equipo){
        return true;
    }




}
