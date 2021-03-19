package bo.edu.uagrm.ficct.inf310.pesados;

import bo.edu.uagrm.ficct.inf310.noPesados.Digrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Floyd {

    private double INFINITO = (1.0 / 0.0);
    DigrafoPesado grafo;
    int cantidadVertices;
    List<List<Double>> matrizDeCaminos;


    /**
     *  (8.) Para un grafo dirigido usando la implementación del algoritmo de Floyd-Wharsall encontrar
     * los caminos de costo mínimo entre un vértice a y el resto. Mostrar los costos y cuáles son
     * los caminos
     *
     *
     * @param: Digrafo unDigrafo
     * @return: Lista de Dobles, en si, el metodo que devuelve el valor es
     * listaDeCostos(int verticeABuscar)
     *
     * */
    public Floyd(DigrafoPesado unDigrafo) {
        cantidadVertices = unDigrafo.cantidadVertices();
        this.grafo = unDigrafo;
        matrizDeCaminos = new LinkedList<>();
        for (int i = 0; i < cantidadVertices; i++) {
            matrizDeCaminos.add(new LinkedList<Double>());
        }
        actualizarMatriz();
    }

    public void actualizarMatriz() {

        for (int i = 0; i < cantidadVertices; i++) {

            List<Integer> listaDeAdyacentes = (List<Integer>) grafo.adyacentesDeVertice(i);
            for (int j = 0; j < cantidadVertices; j++) {
                if (i == j) matrizDeCaminos.get(i).add(0.0);
                else if (listaDeAdyacentes.contains(j)) {
                    double costoAInsertar = grafo.getPeso(i, j);
                    matrizDeCaminos.get(i).add(costoAInsertar);
                } else {
                    matrizDeCaminos.get(i).add(INFINITO);
                }
            }
        }


        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                for (int k = 0; k < cantidadVertices; k++) {
                    double costoCandidato = matrizDeCaminos.get(j).get(i) + matrizDeCaminos.get(i).get(k);
                    double jk = matrizDeCaminos.get(j).get(k);
                    if(costoCandidato < jk)
                        matrizDeCaminos.get(j).set(k,costoCandidato);
                }
            }
        }
    }

    public List<List<Double>> getMatrizDeCaminos() {
        return this.matrizDeCaminos;
    }

    public List<Double> listaDeCostos(int verticeABuscar)
    {
        return this.matrizDeCaminos.get(verticeABuscar);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < matrizDeCaminos.size(); i++) {
            buffer.append(matrizDeCaminos.get(i).toString());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
