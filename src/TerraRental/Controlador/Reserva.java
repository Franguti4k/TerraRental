package TerraRental.Controlador;

/**
 * Clase reserva que encapsula las reservas que se realizan
 */
public class Reserva {
    private Vehiculo vehiculoReserva;
    private Fecha fechaInicio;
    private Fecha fechaFinal;

    public Reserva(Vehiculo vehiculoReserva, Fecha fechaInicio, Fecha fechaFinal) {
        this.vehiculoReserva = vehiculoReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Vehiculo getVehiculoReserva() {
        return vehiculoReserva;
    }

    public void setVehiculoReserva(Vehiculo vehiculoReserva) {
        this.vehiculoReserva = vehiculoReserva;
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Fecha getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Fecha fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
