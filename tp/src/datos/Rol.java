package datos;

public class Rol {

	private String nombre;
	private int id_rol;

	public Rol(String nombre, int id_rol) {

		this.nombre = nombre;
		this.id_rol = id_rol;
	}

	public Rol() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	@Override
	public String toString() {
		return "Rol [nombre=" + nombre + ", id_rol=" + id_rol + "]";
	}

}
