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

        // SOLUCIÓN (2/3): imprimir solo cuando el valor cambia y parar al recoger 100.
        // int anterior = -1;
        // int leidos = 0;
        //
        // while (leidos < 100) {
        //     int actual = variableCompartida.get();
        //
        //     if (actual != anterior) {
        //         System.out.println(actual);
        //         anterior = actual;
        //         leidos++;
        //     }
        // }
    }
}
