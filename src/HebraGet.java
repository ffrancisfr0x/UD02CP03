public class HebraGet extends Thread {
    private VariableCompartida variableCompartida;

    public HebraGet(VariableCompartida variableCompartida) {
        this.variableCompartida = variableCompartida;
    }

    @Override
    public void run() {

        int anterior = -1;
        int leidos = 0;

        while (leidos < 100) {

            int actual = variableCompartida.get();

            if (actual != anterior) {
                System.out.println(actual);
                anterior = actual;
                leidos++;
            }
        }
    }
}
