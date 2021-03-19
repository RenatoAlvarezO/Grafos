package bo.edu.uagrm.ficct.inf310.ui;

import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaNoExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaYaExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310.noPesados.*;
import bo.edu.uagrm.ficct.inf310.noPesados.ciclo.CiclosDigrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.ciclo.CiclosGrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.Warshall;
import bo.edu.uagrm.ficct.inf310.noPesados.conexo.DebilmenteConexo;
import bo.edu.uagrm.ficct.inf310.noPesados.isla.IslaDigrafo;
import bo.edu.uagrm.ficct.inf310.noPesados.isla.IslaGrafo;
import bo.edu.uagrm.ficct.inf310.pesados.DigrafoPesado;
import bo.edu.uagrm.ficct.inf310.pesados.Floyd;
import bo.edu.uagrm.ficct.inf310.pesados.GrafoPesado;

public class AppPrincipal {

    static public void main(String args[]) throws ExcepcionAristaYaExiste, ExcepcionNroVerticesInvalido, ExcepcionAristaNoExiste {

        ElementosTerminal terminal = new ElementosTerminal();
        Digrafo diGrafo = new Digrafo(8);

        /*  Creacion del Digrafo    */

        terminal.imprimirOrdenEnFormato("Digrafo no Pesado");
        diGrafo.insertarArista(0, 1);
        diGrafo.insertarArista(0, 2);
        diGrafo.insertarArista(1, 3);
        diGrafo.insertarArista(2, 1);
        diGrafo.insertarArista(3, 2);
        diGrafo.insertarArista(4, 5);
        diGrafo.insertarArista(5, 7);
        diGrafo.insertarArista(7, 6);
        diGrafo.insertarArista(6, 4);

        System.out.println(diGrafo);

        terminal.imprimirOrdenEnFormato("1. Componentes de las Islas");
        System.out.println(new IslaDigrafo(diGrafo).componentesIslas());

        /*  El arbol tiene dos ciclos   */
        terminal.imprimirOrdenEnFormato("2. Digrafo tiene ciclos?");
        System.out.println(new CiclosDigrafo(diGrafo).existenCiclos());

        terminal.imprimirOrdenEnFormato("3. Es debilmente conexo?");
        System.out.println(new DebilmenteConexo(diGrafo).esDebilmenteConexo());

        Grafo grafo = new Grafo(7);

        grafo.insertarArista(0, 1);
        grafo.insertarArista(1, 2);
        grafo.insertarArista(2, 0);
        grafo.insertarArista(3, 1);
        grafo.insertarArista(3, 4);
        grafo.insertarArista(4, 2);
        grafo.insertarArista(4, 5);
        grafo.insertarArista(5, 6);

        terminal.imprimirOrdenEnFormato("Grafo no Pesado");
        System.out.println(grafo);

        terminal.imprimirOrdenEnFormato("4. Vertices que tienen ciclos en grafo no pesado");
        System.out.println(new CiclosGrafo(grafo).verticesConCiclos());


        terminal.imprimirOrdenEnFormato("5. Numero de islas en grafo no pesado");
        System.out.println(new IslaGrafo(grafo).cantidadDeIslas());

        terminal.imprimirOrdenEnFormato("6. Numero de islas en digrafo no pesado");
        System.out.println(new IslaDigrafo(diGrafo).cantidadDeIslas());


    }
}
