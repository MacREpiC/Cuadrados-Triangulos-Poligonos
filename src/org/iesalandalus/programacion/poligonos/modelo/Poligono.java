package org.iesalandalus.programacion.poligonos.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Poligono implements Desplazable, Trazable {
    private Punto centro;
    private List<Punto> trayectoria;
    private float lado;

    protected Poligono(Punto centro, float lado) {
        Objects.requireNonNull(centro, "El centro no puede ser nulo.");
        this.centro = new Punto(centro); // Evitar el aliasing
        this.lado = lado;
        this.trayectoria = new ArrayList<>();
        this.trayectoria.add(new Punto(centro));
    }

    public Punto getCentro(){
        return new Punto(centro);
    }

    public float getLado(){
        return lado;
    }

    @Override
    public void desplazar(float incrementoX, float incrementoY) {
        this.centro.desplazar(incrementoX, incrementoY);
        this.trayectoria.add(new Punto(this.centro));
    }

    @Override
    public List<Punto> getTrayectoria(){
        return new ArrayList<>(trayectoria);
    }

    @Override
    public String toString() {
        StringBuilder sbPoligono = new StringBuilder();
        sbPoligono.append("Centro: ");
        sbPoligono.append("(").append(String.format("%.2f", centro.getX())).append(", ").append(String.format("%.2f", centro.getY())).append(")");
        sbPoligono.append(", Lado: ").append(String.format("%.2f", lado));
        sbPoligono.append(", Área: ").append(String.format("%.2f", getArea()));
        sbPoligono.append(", Perímetro: ").append(String.format("%.2f", getPerimetro()));
        sbPoligono.append(", Vértices: ").append(getVertices());
        sbPoligono.append("\n\t\tTrayectoria -> ").append(trayectoria);
        return sbPoligono.toString();
    }

    public abstract List<Punto> getVertices();

    public abstract float getArea();

    public abstract float getPerimetro();
}
