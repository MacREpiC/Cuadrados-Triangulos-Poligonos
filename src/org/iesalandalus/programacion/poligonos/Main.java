package org.iesalandalus.programacion.poligonos;

import org.iesalandalus.programacion.poligonos.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int LIMITE_PUNTOS = 100;
    private static final int LIMITE_LADOS = 20;
    private static final int LIMITE_INCREMENTOS = 10;

    public static void main(String[] args) {
        List<Poligono> poligonos = generarPoligonos();

        int vecesDesplazar = leerVeces();

        desplazarPoligonos(poligonos, vecesDesplazar);

        mostrarPoligonos(poligonos);
    }

    private static int leerVeces() {
        int veces;
        do {
            System.out.print("¿Cuántas veces quieres desplazar los polígonos? (mínimo 2): ");
            veces = Entrada.entero();
        } while (veces < 2);
        return veces;
    }

    private static Punto generarPunto() {
        float x = (float) (Math.random() * LIMITE_PUNTOS - LIMITE_PUNTOS / 2);
        float y = (float) (Math.random() * LIMITE_PUNTOS - LIMITE_PUNTOS / 2);
        return new Punto(x, y);
    }

    private static float generarLado() {
        return (float) (Math.random() * LIMITE_LADOS);
    }

    private static float generarIncremento() {
        return (float) (Math.random() * LIMITE_INCREMENTOS - LIMITE_INCREMENTOS / 2);
    }

    private static List<Poligono> generarPoligonos() {
        List<Poligono> poligonos = new ArrayList<>();
        Punto centroTriangulo = generarPunto();
        float ladoTriangulo = generarLado();
        Punto centroCuadrado = generarPunto();
        float ladoCuadrado = generarLado();
        poligonos.add(new Triangulo(centroTriangulo, ladoTriangulo));
        poligonos.add(new Cuadrado(centroCuadrado, ladoCuadrado));
        return poligonos;
    }

    private static void desplazarPoligonos(List<Poligono> poligonos, int vecesDesplazar) {
        for (int i = 1; i <= vecesDesplazar; i++) {
            float incrementoX = generarIncremento();
            float incrementoY = generarIncremento();
            for (Poligono poligono : poligonos) {
                poligono.desplazar(incrementoX, incrementoY);
            }
            System.out.println("Desplazamiento " + i + " realizado.");
        }
    }

    private static void mostrarPoligonos(List<Poligono> poligonos) {
        System.out.println("\nPolígonos generados:");
        for (Poligono poligono : poligonos) {
            if (poligono instanceof Triangulo) {
                System.out.println("Triángulo:");
            } else if (poligono instanceof Cuadrado) {
                System.out.println("Cuadrado:");
            }
            System.out.println(poligono);
        }
    }
}
