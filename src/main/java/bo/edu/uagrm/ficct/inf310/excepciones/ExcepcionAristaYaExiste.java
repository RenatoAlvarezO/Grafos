package bo.edu.uagrm.ficct.inf310.excepciones;

public class ExcepcionAristaYaExiste extends Exception {

    public ExcepcionAristaYaExiste() {
        super("La Arista ya existe");
    }

    public ExcepcionAristaYaExiste(String message) {
        super(message);
    }
}
