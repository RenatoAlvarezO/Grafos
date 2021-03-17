package bo.edu.uagrm.ficct.inf310.noPesados;

import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    private List<Integer> recorrido;
    private Grafo grafo;
    protected UtilRecorridos controlMarcados;

    public DFS(Grafo unGrafo, int posVerticePartida) {
        this.grafo = unGrafo;
        grafo.validarVertice(posVerticePartida);
        recorrido = new ArrayList<>();
        controlMarcados = new UtilRecorridos(grafo.cantidadVertices());
        controlMarcados.desmarcarTodos();
        continuarDFS(posVerticePartida);
    }


    public void continuarDFS(int posVertice){
        controlMarcados.marcarVertice(posVertice);
        recorrido.add(posVertice);
        Iterable<Integer> adyacenteEnTurno = grafo.adyacentesDeVertice(posVertice);
        for(Integer posVerticeAdyacente : adyacenteEnTurno){
            if(!controlMarcados.estaMarcado(posVerticeAdyacente)){
                continuarDFS(posVerticeAdyacente);
            }
        }
    }


    public boolean hayCaminoA(int posVertice) {
        grafo.validarVertice(posVertice);
        return controlMarcados.estaMarcado(posVertice);
    }

    public boolean hayCaminoATodos(){
        return controlMarcados.estanTodosMarcados();
    }

    public Iterable<Integer> elRecorrido(){
        return recorrido;
    }
}
