public class HebraGet extends Thread {
    private VariableCompartida variableCompartida;

    public HebraGet(VariableCompartida variableCompartida) {
        this.variableCompartida = variableCompartida;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(variableCompartida.get());
        }
    }
}
