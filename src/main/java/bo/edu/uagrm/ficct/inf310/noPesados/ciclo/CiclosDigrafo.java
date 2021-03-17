package bo.edu.uagrm.ficct.inf310.noPesados.ciclo;

import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310.noPesados.Digrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

import java.util.ArrayList;
import java.util.List;

public class CiclosDigrafo {

    Digrafo digrafo;
    UtilRecorridos recorrido;
    int cantidadVertices;
    List<UtilRecorridos> matrizDeCaminos;
    public CiclosDigrafo(Digrafo unDigrafo) throws ExcepcionNroVerticesInvalido {
        cantidadVertices = unDigrafo.cantidadVertices();
        this.digrafo = unDigrafo;
        matrizDeCaminos = new ArrayList<>();
        for (int i = 0; i < cantidadVertices; i++) {
            matrizDeCaminos.add(new UtilRecorridos(cantidadVertices));
            matrizDeCaminos.get(i).desmarcarTodos();
        }

    }

    public boolean existenCiclos() {
        boolean existeCiclo = false;
        for (int i = 0; i < cantidadVertices; i++) {
            List<Integer> adyacentes = (List<Integer>) digrafo.adyacentesDeVertice(i);
            for (int j = 0; j < adyacentes.size() ; j++) {
                int verticeAMarcar = adyacentes.get(j);
                matrizDeCaminos.get(i).marcarVertice(verticeAMarcar);
            }
        }

        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                for (int k = 0; k < cantidadVertices; k++) {
                    if(matrizDeCaminos.get(j).estaMarcado(i) && matrizDeCaminos.get(i).estaMarcado(k))
                        matrizDeCaminos.get(j).marcarVertice(k);
                }
            }
        }
        int indiceDiagonal = 0;
        while (!existeCiclo && indiceDiagonal < cantidadVertices)
        {
            existeCiclo = matrizDeCaminos.get(indiceDiagonal).estaMarcado(indiceDiagonal);
            indiceDiagonal++;
        }
        return existeCiclo;
    }




}
