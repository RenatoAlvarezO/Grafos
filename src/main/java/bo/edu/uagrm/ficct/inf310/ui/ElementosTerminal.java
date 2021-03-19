package bo.edu.uagrm.ficct.inf310.ui;

public class ElementosTerminal {

    public ElementosTerminal() {
    }

    public void imprimirOrdenEnFormato(String orden) {
        StringBuilder margen = new StringBuilder();

        margen.append("\n╔");
        for (int i = 0; i < (orden.length() + 6); i++)
            margen.append("═");
        margen.append("╗\n");

        margen.append("║");

        for (int i = 0; i < (orden.length() + 6); i++)
            margen.append(" ");

        margen.append("║\n");

        margen.append("║   " + orden + "   ║\n");

        margen.append("║");

        for (int i = 0; i < (orden.length() + 6); i++)
            margen.append(" ");

        margen.append("║\n");

        margen.append("╚");

        for (int i = 0; i < (orden.length() + 6); i++)
            margen.append("═");
        margen.append("╝\n");

        System.out.println(margen.toString());
    }
}
