package bo.edu.uagrm.ficct.inf310.noPesados.conexo;

import bo.edu.uagrm.ficct.inf310.noPesados.DFS;
import bo.edu.uagrm.ficct.inf310.noPesados.Digrafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DebilmenteConexo {
    private DFS recorrido;
    private Digrafo digrafo;

    private int SIN_VERTICE_NO_MARCADO = -1;
    public DebilmenteConexo(Digrafo unDigrafo) {
        this.digrafo = unDigrafo;
    }

    public boolean esDebilmenteConexo() {
        recorrido = new DFS(digrafo, 0);
        int proximoVerticeNoMarcado = 0;
        while (proximoVerticeNoMarcado != SIN_VERTICE_NO_MARCADO) {
            proximoVerticeNoMarcado = verticeNoMarcadoConAdyacenteMarcado();
            if(proximoVerticeNoMarcado != SIN_VERTICE_NO_MARCADO)
                recorrido.continuarDFS(proximoVerticeNoMarcado);
        }

        return recorrido.hayCaminoATodos();
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

}
