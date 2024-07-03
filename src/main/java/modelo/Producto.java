package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PRODUCTOCL3")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPRODUCTOSCL3")
	private Integer idProd;
	@Column(name = "NOMBRECL3")
	private String nombre;
	@Column(name = "PRECIOVENTACL3")
	private Double precioV;
	@Column(name = "PRECIOCOMPCL3")
	private Double precioC;
	@Column(name = "ESTADOCL3")
	private String estado;
	@Column(name = "DESCRIPCL3")
	private String descripcion;
	
	
	
	public Producto() {
	}

	public Producto(Integer idProd, String nombre, Double precioV, Double precioC, String estado, String descripcion) {
		this.idProd = idProd;
		this.nombre = nombre;
		this.precioV = precioV;
		this.precioC = precioC;
		this.estado = estado;
		this.descripcion = descripcion;
	}
	
	public Integer getIdProd() {
		return idProd;
	}
	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecioV() {
		return precioV;
	}
	public void setPrecioV(Double precioV) {
		this.precioV = precioV;
	}
	public Double getPrecioC() {
		return precioC;
	}
	public void setPrecioC(Double precioC) {
		this.precioC = precioC;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
