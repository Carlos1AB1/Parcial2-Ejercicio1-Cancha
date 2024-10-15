// service/CanchaService.java
package service;

import domain.Cancha;
import java.util.List;

public interface CanchaService {
    void registrarCancha(Cancha cancha);
    void actualizarCancha(String nombre, Cancha canchaActualizada);
    void eliminarCancha(String nombre);
    List<Cancha> listarCanchas();
    Cancha buscarCancha(String nombre);
}
