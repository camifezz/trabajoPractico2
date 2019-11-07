package algoChess.Piezas;

import algoChess.Armas.*;
import algoChess.Ubicacion.*;
import algoChess.Equipos.*;

public abstract class Pieza { //TODO :falta

   private static int costo;
    private float vida;
    protected Equipo equipo;
    protected Casillero casillero;
    protected Arma arma;

    public static int getCosto(){
        return Pieza.costo;
    }

    public Pieza(int costo, float vida, Equipo equipo){
        this.costo = costo;
        this.vida = vida;
        this.equipo = equipo;
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

// No usamos este metodo
    public int distanciaA(Casillero unCasillero){
       return unCasillero.distanciaA(casillero);
    }

    public abstract void mover(Casillero destino);

   protected abstract void  atacar(Pieza objetivo);

    public void atacadaDesde(Casillero unCasillero, Arma unArma){
       quitarVida(unArma.atacar(this, unCasillero.distanciaA(this.casillero)));
    }

    public void quitarVida(float danio){
        this.hacerseDanio(this.casillero.calcularDanio(equipo) * danio);
    }

    public void hacerseDanio(float danio){
        if(this.vida < danio) {
            this.vida = 0;
        } else {
            this.vida -= danio;
        }
    }
    public float vidaRestante(){
        return vida;
    }

    public void curadaDesde(Casillero unCasillero, Arma unArma){
        agregarVida(unArma.atacar(this,unCasillero.distanciaA(this.casillero)));
    }
    protected void agregarVida(float vidaRecibida){
        float vidaCurada = this.vida+vidaRecibida;
        if(vidaCurada>this.vida){
            this.vida += (vidaCurada - this.vida);
        }else{
            this.vida += vidaRecibida;
        }
    }
    protected Equipo getBando(){
        return this.equipo;
    }

    protected abstract void agregarArma(int danio,int danioADistancia);

    public abstract void puedoCurarme(Casillero ubicacion,Arma arma);








    // Desocupa casillero
    public void desocuparCasillero(){
        this.casillero.desocupado();
    }

    // Ocupa casillero
    public void ocuparCasillero(Casillero casillero){
        this.desocuparCasillero();
        this.casillero = casillero;
    }


    public void asignarCasillero(Casillero casillero){
        this.casillero = casillero;
    }


    // Posicion

    public Posicion posicion(){
        return this.casillero.posicion();
    }

}


