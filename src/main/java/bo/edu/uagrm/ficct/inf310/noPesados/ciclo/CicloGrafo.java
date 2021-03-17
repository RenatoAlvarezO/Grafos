package bo.edu.uagrm.ficct.inf310.noPesados.ciclo;

import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaYaExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310.noPesados.Grafo;
import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

import java.util.List;

public class CicloGrafo {

    Grafo grafo;
    Grafo GrafoAuxiliar;
    UtilRecorridos recorrido;

    public CicloGrafo(Grafo unGrafo) throws ExcepcionNroVerticesInvalido {
        int cantidadVertices = unGrafo.cantidadVertices();
        this.grafo = unGrafo;
        this.GrafoAuxiliar = new Grafo(cantidadVertices);
        recorrido = new UtilRecorridos(cantidadVertices);
        recorrido.desmarcarTodos();
    }

    public boolean existenCiclos() throws ExcepcionAristaYaExiste {
        boolean existeUnCiclo = false;

        int verticeActual = 0;
        recorrido.marcarVertice(verticeActual);
        List<Integer> listaDeAdyacentes = (List<Integer>) grafo.adyacentesDeVertice(verticeActual);
        while (!recorrido.estanTodosMarcados() && !existeUnCiclo) {

            int verticeSiguiente = listaDeAdyacentes.get(0);
            if (!recorrido.estaMarcado(verticeSiguiente)) {
                recorrido.marcarVertice(verticeSiguiente);
                GrafoAuxiliar.insertarArista(verticeActual, verticeSiguiente);
                verticeActual = verticeSiguiente;
            } else
                existeUnCiclo = true;
            listaDeAdyacentes = (List<Integer>) grafo.adyacentesDeVertice(verticeActual);
            while(listaDeAdyacentes.size() == 0 && !recorrido.estanTodosMarcados()) {
                verticeActual = recorrido.siguienteNoMarcado();
                listaDeAdyacentes = (List<Integer>) grafo.adyacentesDeVertice(verticeActual);
                recorrido.marcarVertice(verticeActual);
            }
        }
        return existeUnCiclo;
    }
}
