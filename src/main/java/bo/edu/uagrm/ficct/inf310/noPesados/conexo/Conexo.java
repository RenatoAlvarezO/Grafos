package bo.edu.uagrm.ficct.inf310.noPesados.conexo;

import bo.edu.uagrm.ficct.inf310.noPesados.DFS;
import bo.edu.uagrm.ficct.inf310.noPesados.Grafo;

public class Conexo {
    private DFS dfsGrafo;

    public Conexo(Grafo unGrafo) {
        dfsGrafo = new DFS(unGrafo, 0);
    }

    public boolean esConexo() {
        return dfsGrafo.hayCaminoATodos();
    }
}
