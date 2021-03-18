package bo.edu.uagrm.ficct.inf310.pesados;

import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaYaExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionNroVerticesInvalido;

import java.util.Collections;
import java.util.List;

public class DigrafoPesado extends GrafoPesado {

    public DigrafoPesado() {
    }

    public DigrafoPesado(int nroDeVercitesInicial) throws ExcepcionNroVerticesInvalido {
        super(nroDeVercitesInicial);
    }

    @Override
    public void insertarArista(int posVerticeOrigen, int posVerticeDestino, double costo) throws ExcepcionAristaYaExiste {
        super.validarVertice(posVerticeOrigen);
        super.validarVertice(posVerticeDestino);
        if (super.existeAdyacencia(posVerticeOrigen, posVerticeDestino)) {
            throw new ExcepcionAristaYaExiste();
        }

        List<AdyacenteConPeso> adyacenciasDelOrigen = super.listaDeAydacencias.get(posVerticeOrigen);
        adyacenciasDelOrigen.add(new AdyacenteConPeso(posVerticeDestino, costo));
        Collections.sort(adyacenciasDelOrigen);
    }

    @Override
    public int gradoDeVertice(int posDeVertice) {
        throw new UnsupportedOperationException("No soportado en grafos dirigidos");
    }

    public int gradoDeSalida(int posDeVertice){
        return super.gradoDeVertice(posDeVertice);
    }

    @Override
    public int cantidadDeAristas() {
        return 0;
    }

    @Override
    public void eliminarArista(int posVerticeOrigen, int posVerticeDestino) {
    }
}
