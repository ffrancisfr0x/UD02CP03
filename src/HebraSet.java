public class Hebra extends Thread {
    private final VariableCompartida variableCompartida;
    private final int veces;

    public Hebra(VariableCompartida variableCompartida, int veces) {
        this.variableCompartida = variableCompartida;
        this.veces = veces;
    }

    public void run(){
        for (int i = 0; i < veces; i++) {
            variableCompartida.increment();
        }
    }
}