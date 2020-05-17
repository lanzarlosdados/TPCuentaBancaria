package ar.edu.unlam.pb2.cuenta;

public class Cliente {
    
	private Integer dni;
	private String nombre;
	private String apellido;
	
	

	public Cliente(Integer dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
}
