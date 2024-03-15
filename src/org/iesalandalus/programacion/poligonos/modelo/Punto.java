package org.iesalandalus.programacion.poligonos.modelo;

import java.util.Objects;

public class Punto implements Desplazable {
    private float x;
    private float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Punto(Punto punto) {
        Objects.requireNonNull(punto, "El punto no puede ser nulo");
        this.x = punto.getX();
        this.y = punto.getY();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void desplazar(float incrementoX, float incrementoY) {
        this.x += incrementoX;
        this.y += incrementoY;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
