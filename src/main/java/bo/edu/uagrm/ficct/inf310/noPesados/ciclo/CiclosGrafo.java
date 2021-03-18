package bo.edu.uagrm.ficct.inf310.noPesados.ciclo;

import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaYaExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310.noPesados.Grafo;
import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

import java.util.LinkedList;
import java.util.List;

public class CiclosGrafo {

    Grafo grafoAuxilar;
    Grafo grafo;
    UtilRecorridos recorrido;

    public CiclosGrafo(Grafo unGrafo) throws ExcepcionNroVerticesInvalido {
        int cantidadVertices = unGrafo.cantidadVertices();
        this.grafo = unGrafo;
        this.grafoAuxilar = new Grafo(cantidadVertices);
        recorrido = new UtilRecorridos(cantidadVertices);
        recorrido.desmarcarTodos();
    }

    public boolean existenCiclos() throws ExcepcionAristaYaExiste {
        boolean existeUnCiclo = false;

        int verticeActual = 0;
        recorrido.marcarVertice(verticeActual);
        List<Integer> listaDeAdyacentes = (List<Integer>) grafo.adyacentesDeVertice(verticeActual);
        while (!recorrido.estanTodosMarcados() && !existeUnCiclo) {

            if (listaDeAdyacentes.size() == 0) {
                verticeActual = recorrido.siguienteNoMarcado();
            } else {
                int verticeSiguiente = listaDeAdyacentes.get(0);
                if (recorrido.estaMarcado(verticeSiguiente)) {
                    if (listaDeAdyacentes.size() < 2)
                        verticeActual = recorrido.siguienteNoMarcado();
                    else {
                        verticeSiguiente = listaDeAdyacentes.get(1);
                        if (recorrido.estaMarcado(verticeSiguiente)) {
                            existeUnCiclo = true;
                        } else {
                            verticeActual = verticeSiguiente;
                        }
                    }
                } else {
                    verticeActual = verticeSiguiente;
                }
            }

            listaDeAdyacentes = (List<Integer>) grafo.adyacentesDeVertice(verticeActual);
            recorrido.marcarVertice(verticeActual);
        }
        return existeUnCiclo;
    }

    public List<Integer> verticesConCiclos() throws ExcepcionAristaYaExiste {

        List<Integer> listaDeVertices = new LinkedList<>();
        boolean nuevoVertice = false;
        int verticeActual = 0;
        recorrido.marcarVertice(verticeActual);
        List<Integer> listaDeAdyacentes = (List<Integer>) grafo.adyacentesDeVertice(verticeActual);
        while (!recorrido.estanTodosMarcados()) {

            if (listaDeAdyacentes.size() == 0) {
                verticeActual = recorrido.siguienteNoMarcado();
            } else {
                int verticeSiguiente = listaDeAdyacentes.get(0);
                if (recorrido.estaMarcado(verticeSiguiente)) {
                    if (listaDeAdyacentes.size() < 2) {
                        grafoAuxilar.insertarArista(verticeActual, verticeSiguiente);
                        verticeActual = recorrido.siguienteNoMarcado();
                    }
                    else {
                        verticeSiguiente = listaDeAdyacentes.get(1);
                        if (recorrido.estaMarcado(verticeSiguiente)) {
                            listaDeVertices.add(verticeActual);

                            verticeActual = recorrido.siguienteNoMarcado();
                        } else {
                            grafoAuxilar.insertarArista(verticeActual, verticeSiguiente);
                            verticeActual = verticeSiguiente;
                        }
                    }
                } else {
                    grafoAuxilar.insertarArista(verticeActual, verticeSiguiente);
                    verticeActual = verticeSiguiente;
                }
            }

            listaDeAdyacentes = (List<Integer>) grafo.adyacentesDeVertice(verticeActual);
            recorrido.marcarVertice(verticeActual);
        }
        return listaDeVertices;
    }

}
