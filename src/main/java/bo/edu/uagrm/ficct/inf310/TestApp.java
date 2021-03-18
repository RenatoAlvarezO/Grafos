package bo.edu.uagrm.ficct.inf310;

import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaNoExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaYaExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310.noPesados.*;
import bo.edu.uagrm.ficct.inf310.noPesados.ciclo.CiclosGrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.Warshall;
import bo.edu.uagrm.ficct.inf310.noPesados.isla.IslaGrafo;
import bo.edu.uagrm.ficct.inf310.pesados.DigrafoPesado;
import bo.edu.uagrm.ficct.inf310.pesados.Floyd;
import bo.edu.uagrm.ficct.inf310.pesados.GrafoPesado;

public class TestApp {

    static public void main(String args[]) throws ExcepcionAristaYaExiste, ExcepcionNroVerticesInvalido, ExcepcionAristaNoExiste {

        Digrafo diGrafo = new Digrafo(5);
        DigrafoPesado grafo = new DigrafoPesado(5);

        diGrafo.insertarArista(0, 4);
        diGrafo.insertarArista(0, 1);
        diGrafo.insertarArista(1, 2);
        diGrafo.insertarArista(1, 3);
        diGrafo.insertarArista(3, 4);

        System.out.println(diGrafo);

        grafo.insertarArista(0, 1, 1.0);
        grafo.insertarArista(0, 4, 4.0);
        grafo.insertarArista(1, 2, 3.0);
        grafo.insertarArista(1, 3, 5.55);
        grafo.insertarArista(3, 4, 7.0);

        System.out.println(grafo);
        System.out.println(new Floyd(grafo));

    }
}
