package logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestorInvernadero {
    // creamos una lista donde guardaremos los dispositivos a utilizar en el invernadero
    private List<DispositivoInvernadero> dispositivos;
    private List<Sensor> sensores;
    

    public GestorInvernadero() {
        this.dispositivos = new ArrayList<>();
        this.sensores = new ArrayList<>();
    }
 
    public void agregarDispositivos(DispositivoInvernadero dispositivo){
        this.dispositivos.add(dispositivo);
    }
    
    public void agregarSensor(Sensor s){
        sensores.add(s);
    }
    
    //solo agg el get(para visualizar) y sin el set para no mdificarlo
    public List<DispositivoInvernadero> getDispositivos() {
        return this.dispositivos;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }
    
    
    public void monitorear(){
        System.out.println("--- Monitoreando Sensores ---");
        for(Sensor s: sensores){
            System.out.println("Sensor ["+ s.getNombre()+ "]:" + s.leerValor());
        }
    }

    public void ajustarEntorno(){
        System.out.println("---Ajustando Entorno---");
        float temperatura = 0; 
        float humedad = 0;
        
        for(Sensor s: sensores){
            if(s instanceof SensorTemperatura){
                temperatura = s.leerValor();
            } else if (s instanceof SensorHumedad){
                humedad = s.leerValor();
            }
        }
        
        for(DispositivoInvernadero d: dispositivos){
            if(d instanceof Ventilador){
                Ventilador v = (Ventilador) d;
                if(temperatura > v.getTemperaturaUmbral()){
                    d.encender();
                }else{
                    d.apagar();
                }
            }else if (d instanceof BombaDeRiego){
                BombaDeRiego b = (BombaDeRiego) d;
                if(humedad < b.getHumedadUmbral()){
                    d.encender();
                } else{
                    d.apagar();
                }
            }else if(d instanceof LamparaUV){
                // si hace frio prende la lampara
                if(temperatura < 20.0f){
                    d.encender();
                }else{
                    d.apagar();
                }
            }
        }    
    }
    
    public double calcularConsumoTotal(){
        double consumo = 0;
        for(DispositivoInvernadero d: dispositivos){
            if(d.obtenerEstado()){
                consumo += d.getConsumoEnergetico();
            }
        }
        return consumo;
    }
    
    public void guardarRegistroTxt(String ruta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true))) {
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            StringBuilder sb = new StringBuilder();
            sb.append("[").append(ahora.format(formatter)).append("] REGISTRO\n");

            sb.append("Sensores: ");
            for (Sensor s : sensores) {
                sb.append(s.getNombre()).append(": ").append(s.leerValor()).append(" | ");
            }
            sb.append("\n");

            sb.append("Dispositivos: ");
            for (DispositivoInvernadero d : dispositivos) {
                String estado = d.obtenerEstado() ? "ENCENDIDO" : "APAGADO";
                sb.append(d.getNombre()).append(" (").append(estado).append(") | ");
            }
            sb.append("\n");

            sb.append(String.format("Consumo Actual: %.1f W\n", calcularConsumoTotal()));
            sb.append("--------------------------------------------------\n");

            writer.write(sb.toString());
            System.out.println("Registro guardado en: " + ruta);
        } catch (IOException e) {
            System.err.println("Error al guardar registro: " + e.getMessage());
        }
    }

     
    
}
