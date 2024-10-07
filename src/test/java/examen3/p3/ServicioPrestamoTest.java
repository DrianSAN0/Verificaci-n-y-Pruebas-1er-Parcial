package examen3.p3;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioPrestamoTest {
    @Test
    public void testPrestamoCelular_CelularDisponible() {
        try (MockedStatic<ServicioCelulares> mocked = Mockito.mockStatic(ServicioCelulares.class)) {
            mocked.when(() -> ServicioCelulares.estaDisponible("iPhone 13", "Apple")).thenReturn(true);
            mocked.when(() -> ServicioCelulares.registrarPrestamo("iPhone 13", "Apple", "María López")).thenReturn(true);

            ServicioPrestamo servicioPrestamo = new ServicioPrestamo();
            String resultado = servicioPrestamo.prestamoCelular("iPhone 13", "Apple", "María López");

            assertEquals("El celular 'iPhone 13' de Apple ha sido prestado a María López", resultado);
        }
    }

    @Test
    public void testPrestamoCelular_CelularNoDisponible() {
        try (MockedStatic<ServicioCelulares> mocked = Mockito.mockStatic(ServicioCelulares.class)) {
            mocked.when(() -> ServicioCelulares.estaDisponible("iPhone 13", "Apple")).thenReturn(false);

            ServicioPrestamo servicioPrestamo = new ServicioPrestamo();
            String resultado = servicioPrestamo.prestamoCelular("iPhone 13", "Apple", "María López");

            assertEquals("El celular 'iPhone 13' de Apple no está disponible", resultado);
        }
    }

}
