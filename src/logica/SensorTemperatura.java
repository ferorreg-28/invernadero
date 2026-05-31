package logica;


public class SensorTemperatura extends Sensor {

    public SensorTemperatura(int id, String nombre, float ultimaLectura) {
        super(id, nombre, ultimaLectura);
    }

    @Override
    public float leerValor() {
        return this.ultimaLectura;
    }

    
    
}
