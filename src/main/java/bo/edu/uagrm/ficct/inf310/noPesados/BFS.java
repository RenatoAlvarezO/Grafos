package bo.edu.uagrm.ficct.inf310.noPesados;

import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private List<Integer> recorrido;
    private Grafo grafo;
    private UtilRecorridos controlMarcados;

    public BFS(Grafo unGrafo, int posVerticePartida) {
        this.grafo = unGrafo;
        grafo.validarVertice(posVerticePartida);
        controlMarcados.desmarcarTodos();
        ejecutarBFS(posVerticePartida);
    }


    private void ejecutarBFS(int posVertice) {
        Queue<Integer> cola = new LinkedList<>();
        cola.offer(posVertice);
        controlMarcados.marcarVertice(posVertice);
        do {
            int posVerticeEnTurno = cola.poll();
            recorrido.add(posVerticeEnTurno);
            Iterable<Integer> adyacentesEnTurno = grafo.adyacentesDeVertice(posVerticeEnTurno);
            for(Integer posVerticeAdyacente : adyacentesEnTurno){
                if(!controlMarcados.estaMarcado(posVerticeAdyacente)){
                    cola.add(posVerticeAdyacente);
                    controlMarcados.marcarVertice(posVerticeAdyacente);
                }
            }
        } while (!cola.isEmpty());
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
