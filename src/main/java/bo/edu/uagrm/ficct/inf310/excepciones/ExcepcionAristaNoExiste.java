package bo.edu.uagrm.ficct.inf310.excepciones;

public class ExcepcionAristaNoExiste extends Exception{
    public ExcepcionAristaNoExiste() {
        super("La arista no existe");
    }

    public ExcepcionAristaNoExiste(String message) {
        super(message);
    }
}
