public class HebraSet extends Thread {
    public final VariableCompartida variableCompartida;

    public HebraSet(VariableCompartida variableCompartida) {
        this.variableCompartida = variableCompartida;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            variableCompartida.set(i);
        }
    }
}