public class Main {

    public static void main(String[] args) throws Exception {

        VariableCompartida variableCompartida = new VariableCompartida();

        HebraSet escritor = new HebraSet(variableCompartida);

        HebraGet lector = new HebraGet(variableCompartida);

        lector.start();
        escritor.start();

        escritor.join();
        lector.join();


    }
}