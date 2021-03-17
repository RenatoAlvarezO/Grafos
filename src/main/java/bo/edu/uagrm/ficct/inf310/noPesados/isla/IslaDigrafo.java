package bo.edu.uagrm.ficct.inf310.noPesados.isla;

import bo.edu.uagrm.ficct.inf310.noPesados.DFS;
import bo.edu.uagrm.ficct.inf310.noPesados.Digrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IslaDigrafo {

    private Digrafo digrafo;
    private DFS recorrido;

    private int SIN_VERTICE_NO_MARCADO = -1;

    public IslaDigrafo(Digrafo digrafo) {
        this.digrafo = digrafo;
    }

    private int contarIslas() {
        recorrido = new DFS(digrafo, 0);
        int cantidadIslas = 0;

        while (!recorrido.hayCaminoATodos()) {
            int proximoVerticeNoMarcado = verticeNoMarcadoConAdyacenteMarcado();

            if (proximoVerticeNoMarcado == SIN_VERTICE_NO_MARCADO) {
                cantidadIslas++;
                proximoVerticeNoMarcado = siguienteNoMarcado();
            }
            recorrido.continuarDFS(proximoVerticeNoMarcado);
        }

        return cantidadIslas + 1;
    }

    private int verticeNoMarcadoConAdyacenteMarcado() {
        boolean existeVertice = false;

        int proximoVerticeNoMarcado = 0;
        while (proximoVerticeNoMarcado < digrafo.cantidadVertices() && !existeVertice) {
            if (!recorrido.hayCaminoA(proximoVerticeNoMarcado)) {
                Iterator<Integer> adyacentesVertice = digrafo.adyacentesDeVertice(proximoVerticeNoMarcado).iterator();
                while (adyacentesVertice.hasNext() && !existeVertice) {
                    existeVertice = recorrido.hayCaminoA(adyacentesVertice.next());
                }
                if (!existeVertice)
                    proximoVerticeNoMarcado++;
            } else
                proximoVerticeNoMarcado++;
        }
        if (proximoVerticeNoMarcado >= digrafo.cantidadVertices())
            return SIN_VERTICE_NO_MARCADO;
        else return proximoVerticeNoMarcado;
    }

    private int siguienteNoMarcado() {
        int proximoVerticeNoMarcado = 0;
        while (recorrido.hayCaminoA(proximoVerticeNoMarcado) && proximoVerticeNoMarcado < digrafo.cantidadVertices()) {
            proximoVerticeNoMarcado++;
        }
        return proximoVerticeNoMarcado;
    }

    public List<List<Integer>> componentesIslas() {
        List<List<Integer>> listaDeComponentes = new LinkedList<>();
        int cantidadDeIslas = contarIslas();
        recorrido = new DFS(digrafo, 0);

        UtilRecorridos marcaGlobal = new UtilRecorridos(digrafo.cantidadVertices());
        marcaGlobal.desmarcarTodos();
        int indiceIsla = 0;


        for (int i = 0; i < cantidadDeIslas; i++) {
            listaDeComponentes.add(new LinkedList<Integer>());
        }

        Iterable<Integer> verticesRecorridos = recorrido.elRecorrido();
        for (int verticePrimerRecorrido : verticesRecorridos) {
            listaDeComponentes.get(0).add(verticePrimerRecorrido);
            marcaGlobal.marcarVertice(verticePrimerRecorrido);
        }


        while (!recorrido.hayCaminoATodos()) {
            int proximoVerticeNoMarcado = verticeNoMarcadoConAdyacenteMarcado();

            if (!listaDeComponentes.get(indiceIsla).contains(proximoVerticeNoMarcado) && proximoVerticeNoMarcado != SIN_VERTICE_NO_MARCADO) {
                listaDeComponentes.get(indiceIsla).add(proximoVerticeNoMarcado);
                marcaGlobal.marcarVertice(proximoVerticeNoMarcado);
            }

            if (proximoVerticeNoMarcado == SIN_VERTICE_NO_MARCADO) {
                indiceIsla++;
                proximoVerticeNoMarcado = siguienteNoMarcado();
                recorrido.continuarDFS(proximoVerticeNoMarcado);
                for (Integer verticeABuscar : verticesRecorridos) {
                    if (!marcaGlobal.estaMarcado(verticeABuscar)) {
                        listaDeComponentes.get(indiceIsla).add(verticeABuscar);
                        marcaGlobal.marcarVertice(verticeABuscar);
                    }
                }
            } else recorrido.continuarDFS(proximoVerticeNoMarcado);
        }

        for (int i = 0; i < listaDeComponentes.size(); i++) {
            Collections.sort(listaDeComponentes.get(i));
        }

        return listaDeComponentes;
    }

    public int cantidadDeIslas() {
        return contarIslas();
    }
}

