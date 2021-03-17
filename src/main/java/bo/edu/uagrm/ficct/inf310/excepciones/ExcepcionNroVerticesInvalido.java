package bo.edu.uagrm.ficct.inf310.excepciones;

public class ExcepcionNroVerticesInvalido extends Exception{
   
    public ExcepcionNroVerticesInvalido(){
        super("Nro de Vertices Invalido");
    }

    public ExcepcionNroVerticesInvalido(String message){
        super(message);
    }
}
