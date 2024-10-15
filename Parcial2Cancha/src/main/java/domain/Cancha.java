// domain/Cancha.java
package domain;

import java.io.Serializable;

public class Cancha implements Serializable {
    private String nombre;
    private String tipo; // Ejemplo: Fútbol, Tenis, etc.
    private String ubicacion;
    private boolean disponible;

    public Cancha(String nombre, String tipo, String ubicacion, boolean disponible) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Cancha{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
