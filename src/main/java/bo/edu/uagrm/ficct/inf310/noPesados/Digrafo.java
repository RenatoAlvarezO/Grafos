package bo.edu.uagrm.ficct.inf310.noPesados;

import java.util.Collections;
import java.util.List;

import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionAristaYaExiste;
import bo.edu.uagrm.ficct.inf310.excepciones.ExcepcionNroVerticesInvalido;

public class Digrafo extends Grafo{

    public Digrafo() {
    }
    
    public Digrafo(int nroDeVerticesInicial) throws ExcepcionNroVerticesInvalido{
        super(nroDeVerticesInicial);
    }
    
    @Override
    public void insertarArista(int posVerticeOrigen, int posVerticeDestino) throws ExcepcionAristaYaExiste{
        super.validarVertice(posVerticeOrigen);
        super.validarVertice(posVerticeDestino);
        if (super.existeAdyacencia(posVerticeOrigen, posVerticeDestino)) {
            throw new ExcepcionAristaYaExiste();
        }

        List<Integer> adyacenciasDelOrigen = super.listaDeAydacencias.get(posVerticeOrigen);
        adyacenciasDelOrigen.add(posVerticeDestino);
        Collections.sort(adyacenciasDelOrigen);
//        if (posVerticeOrigen == posVerticeDestino) {
//            List<Integer> adyacenciasDelDestino = this.listaDeAydacencias.get(posVerticeDestino);
//            adyacenciasDelDestino.add(posVerticeOrigen);
//        }
    }

    @Override
    public int gradoDeVertice(int posDeVertice){
        throw new UnsupportedOperationException("No soportado en grafos dirigidos");
    }

    public int gradoDeSalida(int posDeVertice){
        return super.gradoDeVertice(posDeVertice);
    }

    public int gradoDeEntrada(int posDeVertice){
        super.validarVertice(posDeVertice);
        int entradaDeVertice = 0;
        for(List<Integer> adyacentesDeUnVertice : super.listaDeAydacencias){
            for(Integer posAdyacente:adyacentesDeUnVertice)
            {
                if(posAdyacente == posDeVertice)
                {
                    entradaDeVertice++;
                }
            }
        }
        return entradaDeVertice;
    }

    @Override
    public int cantidadDeAristas() {
        return 0;
    }

    @Override
    public void eliminarArista(int posVerticeOrigen, int posVerticeDestino) {
    }
}
