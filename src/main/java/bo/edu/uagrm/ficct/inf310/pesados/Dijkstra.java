package bo.edu.uagrm.ficct.inf310.pesados;

import bo.edu.uagrm.ficct.inf310.noPesados.Digrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Dijkstra {

    private double INFINITO = (1.0 / 0.0);
    DigrafoPesado digrafo;
    Stack<Integer> pilaDeVertices;
    List<Integer> listaDePredecesores;
    List<Double> listaDeCostos;
    UtilRecorridos marcaDeVertices;
    int cantidadDeVertices;
    double costoMinimo;
    public Dijkstra(DigrafoPesado unDigrafo) {
        this.digrafo = unDigrafo;
        costoMinimo = INFINITO;
        cantidadDeVertices = this.digrafo.cantidadVertices();
        this.pilaDeVertices = new Stack<>();
        this.listaDePredecesores = new LinkedList<>();
        this.listaDeCostos = new LinkedList<>();
        marcaDeVertices = new UtilRecorridos(cantidadDeVertices);
        marcaDeVertices.desmarcarTodos();
        for (int i = 0; i < cantidadDeVertices; i++) {
            listaDePredecesores.add(-1);
            listaDeCostos.add(INFINITO);
        }
    }

    private void limpiarEstructura() {
        this.pilaDeVertices = new Stack<>();
        marcaDeVertices.desmarcarTodos();
        for (int i = 0; i < cantidadDeVertices; i++) {
            listaDePredecesores.set(i, -1);
            listaDeCostos.set(i, INFINITO);
        }
    }

    private void caminoMinimo(int verticeOrigen, int verticeDestino) {

        limpiarEstructura();
        int verticeActual = verticeOrigen;
        listaDeCostos.set(verticeActual, 0.0);
        marcaDeVertices.marcarVertice(verticeActual);
        pilaDeVertices.push(verticeActual);
        double valorMenor = 0.0;
        while (verticeActual != verticeDestino && !marcaDeVertices.estanTodosMarcados()) {
            double nuevoMenor = INFINITO;
            int posicionMenor = verticeActual;
            List<Integer> listaDeAdyacentes = (List<Integer>) digrafo.adyacentesDeVertice(verticeActual);
            for (int i = 0; i < listaDeAdyacentes.size(); i++) {
                int posicionActual = listaDeAdyacentes.get(i);
                double nuevoCosto = valorMenor + digrafo.getPeso(verticeActual,posicionActual);
                listaDeCostos.set(posicionActual,nuevoCosto);
                if(nuevoCosto < valorMenor){
                    valorMenor = nuevoMenor;
                    posicionMenor = posicionActual;
                }
            }
            pilaDeVertices.push(posicionMenor);
            marcaDeVertices.marcarVertice(posicionMenor);
        }
        costoMinimo = listaDeCostos.get(verticeDestino);
    }

    public double getCostoMinimo(int verticeOrigen, int verticeDestino)
    {
        caminoMinimo(verticeOrigen,verticeDestino);
        return costoMinimo;
    }
}
