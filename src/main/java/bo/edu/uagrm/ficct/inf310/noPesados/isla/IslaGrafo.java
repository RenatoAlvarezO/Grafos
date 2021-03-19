package bo.edu.uagrm.ficct.inf310.noPesados.isla;

import bo.edu.uagrm.ficct.inf310.noPesados.DFS;
import bo.edu.uagrm.ficct.inf310.noPesados.Grafo;
import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

public class IslaGrafo {
    private Grafo grafo;
    private int cantidadIslas;
    private UtilRecorridos controlMarcados;

    public IslaGrafo(Grafo grafo) {
        this.grafo = grafo;
        this.controlMarcados = new UtilRecorridos(grafo.cantidadVertices());
        this.controlMarcados.desmarcarTodos();
        this.cantidadIslas = contarIslas(0, 0);

    }
    /**
     *  (5.)  Para un grafo no dirigido implementar un algoritmo para encontrar el número de islas que
     * hay en el grafo
     *     *
     * @param:
     * @return: retorna la cantidad de islas en el digrafo
     *
     * */
    private int contarIslas(int posVertice, int cantidadIslas) {
        if (controlMarcados.estanTodosMarcados())
            return cantidadIslas;

        cantidadIslas++;
        Iterable<Integer> recorridoIsla = new DFS(grafo, posVertice).elRecorrido();
        for (Integer verticeAMarcar : recorridoIsla) {
            controlMarcados.marcarVertice(verticeAMarcar);
        }

        for (int posVerticeNoMarcado = 0; posVerticeNoMarcado < grafo.cantidadVertices(); posVerticeNoMarcado++) {
            if (!controlMarcados.estaMarcado(posVerticeNoMarcado))
                cantidadIslas = contarIslas(posVerticeNoMarcado, cantidadIslas);
        }
        return cantidadIslas;
    }

    public int cantidadDeIslas() {
        return this.cantidadIslas;
    }

}