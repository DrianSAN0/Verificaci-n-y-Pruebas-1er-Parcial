package examen2.p2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
public class ServicioPrestamoTest {
    @Test
    public void testPrestamoCelular_Disponible() {

        ServicioCelulares servicioCelularesMock = Mockito.mock(ServicioCelulares.class);
        ServicioPrestamo servicioPrestamo = new ServicioPrestamo(servicioCelularesMock);

        String modelo = "iPhone 13";
        String marca = "Apple";
        String usuario = "María López";

        when(servicioCelularesMock.estaDisponible(modelo, marca)).thenReturn(true);
        when(servicioCelularesMock.registrarPrestamo(modelo, marca, usuario)).thenReturn(true);

        String resultado = servicioPrestamo.prestamoCelular(modelo, marca, usuario);

        assertEquals("El celular 'iPhone 13' de Apple ha sido prestado a María López", resultado);
    }

    @Test
    public void testPrestamoCelular_NoDisponible() {
        // Arrange
        ServicioCelulares servicioCelularesMock = Mockito.mock(ServicioCelulares.class);
        ServicioPrestamo servicioPrestamo = new ServicioPrestamo(servicioCelularesMock);

        String modelo = "iPhone 13";
        String marca = "Apple";
        String usuario = "María López";

        when(servicioCelularesMock.estaDisponible(modelo, marca)).thenReturn(false);


        String resultado = servicioPrestamo.prestamoCelular(modelo, marca, usuario);


        assertEquals("El celular 'iPhone 13' de Apple no está disponible", resultado);
    }

    @Test
    public void testPrestamoCelular_FalloRegistro() {

        ServicioCelulares servicioCelularesMock = Mockito.mock(ServicioCelulares.class);
        ServicioPrestamo servicioPrestamo = new ServicioPrestamo(servicioCelularesMock);

        String modelo = "iPhone 13";
        String marca = "Apple";
        String usuario = "María López";

        when(servicioCelularesMock.estaDisponible(modelo, marca)).thenReturn(true);
        when(servicioCelularesMock.registrarPrestamo(modelo, marca, usuario)).thenReturn(false);


        String resultado = servicioPrestamo.prestamoCelular(modelo, marca, usuario);


        assertEquals("No se pudo registrar el préstamo del celular 'iPhone 13' de Apple", resultado);
    }

}
