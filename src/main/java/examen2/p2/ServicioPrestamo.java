package examen2.p2;

public class ServicioPrestamo {

    public ServicioPrestamo(ServicioCelulares servicioCelularesMock) {
    }

    public boolean estaDisponible(String modelo, String marca) {

        return false;
    }

    public boolean registrarPrestamo(String modelo, String marca, String usuario) {

        return true;
    }

    public String prestamoCelular(String modelo, String marca, String usuario) {
        return modelo;
    }
}

