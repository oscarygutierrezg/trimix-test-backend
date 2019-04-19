package ar.com.trimix.backendtest.persistence.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name="persona")
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7814882535743315962L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	private String nombre;
	private String apellido; 
	@Column(name="numero_documento")
	private long numeroDocumento;
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	public Persona() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + (int) (numeroDocumento ^ (numeroDocumento >>> 32));
		result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroDocumento != other.numeroDocumento)
			return false;
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null)
				return false;
		} else if (!tipoDocumento.equals(other.tipoDocumento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		final StringBuilder builder = new StringBuilder();
		builder.append("Persona ");
		builder.append(" [id=").append(id).append("]");
		builder.append(" [nombre=").append(nombre).append("]");
		builder.append(" [nombre=").append(apellido).append("]");
		builder.append(" [numeroDocumento=").append(numeroDocumento).append("]");
		builder.append(" [tipoDocumento=").append(tipoDocumento).append("]");
		builder.append(" [fechaNacimiento=").append(simpleDateFormat.format(fechaNacimiento)).append("]");
		return builder.toString();
	}



}
