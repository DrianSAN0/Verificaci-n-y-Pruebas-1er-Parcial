package examen3.p3;

public class ServicioPrestamo {
    public String prestamoCelular(String modelo, String marca, String usuario) {
        if (ServicioCelulares.estaDisponible(modelo, marca)) {
            ServicioCelulares.registrarPrestamo(modelo, marca, usuario);
            return "El celular '" + modelo + "' de " + marca + " ha sido prestado a " + usuario;
        } else {
            return "El celular '" + modelo + "' de " + marca + " no está disponible";
        }
    }
}
