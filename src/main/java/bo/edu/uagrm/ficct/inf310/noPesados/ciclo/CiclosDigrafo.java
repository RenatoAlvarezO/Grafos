package bo.edu.uagrm.ficct.inf310.noPesados.ciclo;

import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310.noPesados.Digrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.Warshall;
import bo.edu.uagrm.ficct.inf310.noPesados.utils.UtilRecorridos;

import java.util.List;

public class CiclosDigrafo {

    Digrafo digrafo;
    int cantidadVertices;
    List<UtilRecorridos> matrizDeCaminos;
    Warshall warshall;
    public CiclosDigrafo(Digrafo unDigrafo) throws ExcepcionNroVerticesInvalido {
        cantidadVertices = unDigrafo.cantidadVertices();
        this.digrafo = unDigrafo;
        warshall = new Warshall(unDigrafo);
    }
    /*
    * (2.) Para un grafo dirigido implementar un algoritmo para encontrar
    * si el grafo dirigido tiene ciclos
    * @param:
    * @return: retorna TRUE si existen ciclos, si no, FALSE
    *
    * */
    public boolean existenCiclos() {
        boolean existeCiclo = false;
        int indiceDiagonal = 0;
        matrizDeCaminos = warshall.getMatrizDeCaminos();
        while (!existeCiclo && indiceDiagonal < cantidadVertices)
        {
            existeCiclo = matrizDeCaminos.get(indiceDiagonal).estaMarcado(indiceDiagonal);
            indiceDiagonal++;
        }
        return existeCiclo;
    }




}
