package algoChess.Piezas;

import algoChess.Armas.*;
import algoChess.Ubicacion.*;
import algoChess.Equipos.*;

public abstract class Pieza { //TODO :falta

   private static int costo;
    private float vida;
    protected Equipo equipo;
    protected Casillero ubicacion;
    protected Arma arma;

    public static int getCosto(){
        return Pieza.costo;
    }

    public Pieza(int costo, float vida, Equipo equipo){
        this.costo = costo;
        this.vida = vida;
        this.equipo = equipo;
        //this.arma = new Arma(danio,danioADistacia);
       // this.arma = arma;
    }

    public boolean ubicar(Equipo bando){
       return this.equipo.ubicar(bando);
    }

    public void ocupar(Casillero esteCasillero){
        this.ubicacion = esteCasillero;
    }

    protected void desocupar(){
        this.ubicacion.desocupar();
    }

    public int distanciaA(Casillero unCasillero){
       return unCasillero.distanciaA(ubicacion);
    }

    public void mover(Casillero destino){
       destino.agregarPieza(this);
    }

   /* protected void atacar(Pieza objetivo){
        objetivo.atacadaDesde(this.ubicacion, this.arma);
    }*/
   protected abstract void  atacar(Pieza objetivo);

    protected void atacadaDesde(Casillero unCasillero, Arma unArma){
       quitarVida(unArma.atacar(this, unCasillero.distanciaA(this.ubicacion)));
    }

    protected void quitarVida(float danio){
        this.hacerseDanio(this.ubicacion.calcularDanio(equipo) * danio);
    }

    protected void hacerseDanio(float danio){
        if(this.vida < danio) {
            this.vida = 0;


        } else {
            this.vida -= danio;
        };
    }
    public float vidaRestante(){
        return vida;
    }

    protected void curadaDesde(Casillero unCasillero, Arma unArma){
        agregarVida(unArma.atacar(this,unCasillero.distanciaA(this.ubicacion)));
    }

    protected void agregarVida(float vida){
        this.vida += vida;
    }
    protected Equipo getBando(){
        return this.equipo;
    }

    protected abstract void agregarArma(int danio,int danioADistancia);

    public abstract void puedoCurarme(Casillero ubicacion,Arma arma);

}


