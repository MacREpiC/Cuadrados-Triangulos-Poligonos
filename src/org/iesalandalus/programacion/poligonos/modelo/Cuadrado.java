package org.iesalandalus.programacion.poligonos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cuadrado extends Poligono{
    public Cuadrado(Punto centro, float lado) {
        super(centro, lado);
    }

    @Override
    public List<Punto> getVertices() {
        List<Punto> vertices = new ArrayList<>();
        vertices.add(new Punto(getCentro().getX() - getLado() / 2, getCentro().getY() - getLado() / 2));
        vertices.add(new Punto(getCentro().getX() + getLado() / 2, getCentro().getY() - getLado() / 2));
        vertices.add(new Punto(getCentro().getX() + getLado() / 2, getCentro().getY() + getLado() / 2));
        vertices.add(new Punto(getCentro().getX() - getLado() / 2, getCentro().getY() + getLado() / 2));
        return vertices;
    }

    @Override
    public float getArea() {
        return getLado() * getLado();
    }

    @Override
    public float getPerimetro() {
        return 4 * getLado();
    }
}
