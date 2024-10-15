// serviceImpl/CanchaServiceImpl.java
package serviceImpl;

import domain.Cancha;
import repository.CanchaRepository;
import service.CanchaService;

import java.util.List;

public class CanchaServiceImpl implements CanchaService {
    private CanchaRepository repository;
    private List<Cancha> canchas;

    public CanchaServiceImpl() {
        this.repository = new CanchaRepository();
        this.canchas = repository.cargarCanchas(); // Cargar las canchas al iniciar el servicio
    }

    @Override
    public void registrarCancha(Cancha cancha) {
        canchas.add(cancha);
        repository.guardarCanchas(canchas); // Actualizar el archivo
        System.out.println("Cancha registrada exitosamente.");
    }

    @Override
    public void actualizarCancha(String nombre, Cancha canchaActualizada) {
        Cancha cancha = buscarCancha(nombre);
        if (cancha != null) {
            cancha.setNombre(canchaActualizada.getNombre());
            cancha.setTipo(canchaActualizada.getTipo());
            cancha.setUbicacion(canchaActualizada.getUbicacion());
            cancha.setDisponible(canchaActualizada.isDisponible());
            repository.guardarCanchas(canchas); // Actualizar el archivo
            System.out.println("Cancha actualizada exitosamente.");
        } else {
            System.out.println("Cancha no encontrada.");
        }
    }

    @Override
    public void eliminarCancha(String nombre) {
        Cancha cancha = buscarCancha(nombre);
        if (cancha != null) {
            canchas.remove(cancha);
            repository.guardarCanchas(canchas); // Actualizar el archivo
            System.out.println("Cancha eliminada exitosamente.");
        } else {
            System.out.println("Cancha no encontrada.");
        }
    }

    @Override
    public List<Cancha> listarCanchas() {
        return canchas;
    }

    @Override
    public Cancha buscarCancha(String nombre) {
        return canchas.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
