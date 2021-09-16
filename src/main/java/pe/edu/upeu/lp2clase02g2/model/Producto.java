package pe.edu.upeu.lp2clase02g2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="productos")
public class Producto {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long idproducto;

@Column(name="nombre")
private String nombre;
@Column(name="precio")
private double precio;
@Column(name="cantidad")
private int cantidad;
}
