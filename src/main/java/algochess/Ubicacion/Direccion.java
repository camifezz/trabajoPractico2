package algochess.Ubicacion;

public class Direccion {
    private static Direccion norte;
    private static Direccion sur;
    private static Direccion este;
    private static Direccion oeste;
    private static Direccion norOeste;
    private static Direccion norEste;
    private static Direccion surOeste;
    private static Direccion surEste;

    static {
        norte = new Direccion(0, 1);
        sur = new Direccion(0, -1);
        este = new Direccion(1, 0);
        oeste = new Direccion(-1, 0);
        norOeste = new Direccion(-1,1);
        norEste = new Direccion(1,1);
        surOeste = new Direccion(-1,-1);
        surEste = new Direccion(1,-1);
    }

    private int sentidoHorizontal;
    private int sentidoVertical;

    public Direccion(int sentidoHorizontal, int sentidoVertical) {
        this.sentidoHorizontal = sentidoHorizontal;
        this.sentidoVertical = sentidoVertical;
    }

    public Posicion proximaPosicion(Posicion actual){
        int siguienteHorizontal = actual.getHorizontal()+this.sentidoHorizontal;
        int siguienteVertical = actual.getVertical()+this.sentidoVertical;
        return new Posicion(siguienteHorizontal,siguienteVertical);
    }

    public int getHorizontal() {
        return sentidoHorizontal;
    }
    public int getVertical() {
        return sentidoVertical;
    }

    public static Direccion norte() {
        return norte;
    }
    public static Direccion sur() {
        return sur;
    }
    public static Direccion este() {
        return este;
    }
    public static Direccion norEste() {
        return norEste;
    }
    public static Direccion surEste() {
        return surEste;
    }
    public static Direccion oeste() {
        return oeste;
    }
    public static Direccion norOeste() {
        return norOeste;
    }
    public static Direccion surOeste() {
        return surOeste;
    }

}
