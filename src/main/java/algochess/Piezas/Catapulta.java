package algochess.Piezas;

import algochess.Armas.ArmaCatapulta;
import algochess.Batallon;
import algochess.Equipos.Equipo;
import algochess.FactoryConstantes;

public class Catapulta extends Pieza {
    private static int costo = 5;

    public Catapulta(Equipo equipo) {
        super(FactoryConstantes.vidaCatapulta(), equipo);
        this.agregarArma(new ArmaCatapulta());
    }

    public static int getCosto() { return costo; }


    @Override
    public void curarse(float vida){

    }
    @Override
    public void unirseABatallon(Batallon batallon){}

    @Override
    public boolean soyAliado(Equipo equipo) {
        return this.equipo.soyAliado(equipo);
    }
}

