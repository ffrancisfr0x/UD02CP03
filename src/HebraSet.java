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

        // SOLUCIÓN (1/3): pausa para que el lector tenga tiempo de leer cada valor.
        // try {
        //     Thread.sleep(50);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
}