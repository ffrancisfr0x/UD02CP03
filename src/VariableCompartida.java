public class VariableCompartida {
    // SOLUCIÓN (3/3): con volatile el lector siempre ve el último valor escrito.
    // private volatile int v;
    private int v;

    public int get() {
        return v;
    }

    public void set(int valor) {
        v = valor;
    }

    public void increment() {
        v++;
    }
}