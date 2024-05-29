package proyectoalgoritmos;

/**
 *
 * @author sergi
 */
public class Calculator {

    // Método para sumar dos números
    public int sumar(int a, int b) {
        return a + b;
    }

    // Método para restar dos números
    public int restar(int a, int b) {
        return a - b;
    }

    // Método para multiplicar dos números
    public int multiplicar(int a, int b) {
        return a * b;
    }

    // Método para dividir dos números
    public int dividir(int a, int b) {
        // Manejar división por cero
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return a / b;
    }

    
}

