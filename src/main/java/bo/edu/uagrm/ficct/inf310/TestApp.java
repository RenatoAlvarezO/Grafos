package bo.edu.uagrm.ficct.inf310;

import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaNoExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaYaExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310.noPesados.*;
import bo.edu.uagrm.ficct.inf310.noPesados.ciclo.CicloGrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.ciclo.CiclosDigrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.isla.IslaDigrafo;

public class TestApp {

    static public void main(String args[]) throws ExcepcionAristaYaExiste, ExcepcionNroVerticesInvalido, ExcepcionAristaNoExiste {

        Digrafo grafo  = new Digrafo(8);

        grafo.insertarArista(0,2);
        //grafo.insertarArista(1,0);
        grafo.insertarArista(1,3);
        grafo.insertarArista(2,1);
        grafo.insertarArista(2,4);
//        grafo.insertarArista(4,3);

        grafo.insertarArista(5, 6);
        grafo.insertarArista(6, 7);
        grafo.insertarArista(7, 5);


        System.out.println(grafo);

        System.out.println(new CiclosDigrafo(grafo).existenCiclos());

        System.out.println(new IslaDigrafo(grafo).componentesIslas());
    }
}
