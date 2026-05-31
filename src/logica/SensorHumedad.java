package logica;

public class SensorHumedad extends Sensor {

    public SensorHumedad(int id, String nombre, float ultimaLectura) {
        super(id, nombre, ultimaLectura);
    }

    @Override
    public float leerValor() {
        return ultimaLectura;
    }
    
}
