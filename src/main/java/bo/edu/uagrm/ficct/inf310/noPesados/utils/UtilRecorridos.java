package bo.edu.uagrm.ficct.inf310.noPesados.utils;

import java.util.ArrayList;
import java.util.List;

public class UtilRecorridos {

    private List<Boolean> marcados;

    private int nroVertices;

    public UtilRecorridos(int nroVertices) {
        this.nroVertices = nroVertices;
    }

    public void desmarcarTodos() {
        marcados = new ArrayList<>();
        for (int i = 0; i < nroVertices; i++) {
            marcados.add(Boolean.FALSE);
        }
    }

    public void marcarVertice(int posVertice) {
        marcados.set(posVertice, Boolean.TRUE);
    }

    public void desmarcarVertice(int posVertice) { marcados.set(posVertice,Boolean.FALSE);}

    public boolean estaMarcado(int posVertice) {
        return marcados.get(posVertice);
    }

    public boolean estanTodosMarcados() {
        for(Boolean marcado : this.marcados){
            if(!marcado)
                return false;
        }
        return true;
    }

    public int siguienteNoMarcado() {
        int proximoVerticeNoMarcado = 0;
        while (estaMarcado(proximoVerticeNoMarcado) && proximoVerticeNoMarcado < nroVertices) {
            proximoVerticeNoMarcado++;
        }
        return proximoVerticeNoMarcado;
    }
}

