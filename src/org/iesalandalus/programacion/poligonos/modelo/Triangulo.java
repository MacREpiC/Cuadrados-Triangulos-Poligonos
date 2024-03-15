package org.iesalandalus.programacion.poligonos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Triangulo extends Poligono {

    public Triangulo(Punto centro, float lado) {
        super(centro, lado);
    }

    @Override
    public List<Punto> getVertices() {
        List<Punto> vertices = new ArrayList<>();
        vertices.add(new Punto(getCentro().getX(), (float) (getCentro().getY() + (getLado() / Math.sqrt(3)))));
        vertices.add(new Punto(getCentro().getX() - (getLado() / 2), (float) (getCentro().getY() - ((Math.sqrt(3) / 6) * getLado()))));
        vertices.add(new Punto(getCentro().getX() + (getLado() / 2), (float) (getCentro().getY() - ((Math.sqrt(3) / 6) * getLado()))));
        return vertices;
    }

    @Override
    public float getArea() {
        return (float) (Math.sqrt(3) / 4 * Math.pow(getLado(), 2));
    }

    @Override
    public float getPerimetro() {
        return 3 * getLado();
    }
}
