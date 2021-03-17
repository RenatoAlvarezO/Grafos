package bo.edu.uagrm.ficct.inf310.noPesados.conexo;

import bo.edu.uagrm.ficct.inf310.noPesados.DFS;
import bo.edu.uagrm.ficct.inf310.noPesados.Digrafo;

public class FuertementeConexo {
    private Conexo grafoConexo;

    private boolean esFuertementeConexo;

    public FuertementeConexo(Digrafo unDigrafo) {
        esFuertementeConexo = true;
        for (int i = 0; i < unDigrafo.cantidadVertices() && esFuertementeConexo; i++) {
            DFS dfs = new DFS(unDigrafo,i);
            esFuertementeConexo = dfs.hayCaminoATodos();
        }
    }

    public boolean esFuertementeConexo() {
        return this.esFuertementeConexo;
    }
}
