/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.EmpleadosJpaController;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MI PC
 */
@Entity
@Table(name = "empleados", catalog = "municipalidad_lq", schema = "")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByNroLegajo", query = "SELECT e FROM Empleados e WHERE e.nroLegajo = :nroLegajo")
    , @NamedQuery(name = "Empleados.findByApellido", query = "SELECT e FROM Empleados e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleados.findByDni", query = "SELECT e FROM Empleados e WHERE e.dni = :dni")
    , @NamedQuery(name = "Empleados.findByFechaNacimiento", query = "SELECT e FROM Empleados e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Empleados.findBySueldoBasico", query = "SELECT e FROM Empleados e WHERE e.sueldoBasico = :sueldoBasico")
    , @NamedQuery(name = "Empleados.findByCodProyecto", query = "SELECT e FROM Empleados e WHERE e.codProyecto = :codProyecto")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nro_legajo", nullable = false)
    private Integer nroLegajo;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "dni", nullable = false)
    private int dni;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "sueldo_basico", nullable = false)
    private float sueldoBasico;
    @Column(name = "cod_proyecto")
    private Integer codProyecto;

    public Empleados() {
    }

    public Empleados(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public Empleados(Integer nroLegajo, String apellido, String nombre, int dni, Date fechaNacimiento, float sueldoBasico) {
        this.nroLegajo = nroLegajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoBasico = sueldoBasico;
    }

    public Integer getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(float sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public Integer getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(Integer codProyecto) {
        this.codProyecto = codProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroLegajo != null ? nroLegajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.nroLegajo == null && other.nroLegajo != null) || (this.nroLegajo != null && !this.nroLegajo.equals(other.nroLegajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleados[ nroLegajo=" + nroLegajo + " ]";
    }
    
    public void mostrarEmpleados() {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("+                                      Lista de Empleados                        +");
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|N° Legajo|    Apellido   |    Nombre      |   DNI    | FecNacimiento |  sueldo  |");
        System.out.println("+--------------------------------------------------------------------------------+");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            int dia = listaEmpleados.get(i).getFechaNacimiento().getDate();
            int mes = listaEmpleados.get(i).getFechaNacimiento().getMonth();
            int anio = listaEmpleados.get(i).getFechaNacimiento().getYear();
            String fecha = dia + "-" + mes + "-" + anio;
            System.out.printf("|   %-3s   | %-13s | %-14s | %-8s | %-13s | %-8s  \n",
                    listaEmpleados.get(i).getNroLegajo(),
                    listaEmpleados.get(i).getApellido(),
                    listaEmpleados.get(i).getNombre(),
                    listaEmpleados.get(i).getDni(),
                    fecha,
                    listaEmpleados.get(i).getSueldoBasico() + " |");
        }
        System.out.println("+--------------------------------------------------------------------------------+");

    }
    
    public int calcularEdad(Date fechaNac) {
        int dia = fechaNac.getDate();
        int mes = fechaNac.getMonth();
        int anio = fechaNac.getYear();
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaNacimiento, fechaHoy);
        return periodo.getYears();
    }
    
    public void mayorEdad() {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        Empleados empleado = new Empleados();
        int mayorEmp = 0;
        int edad = 0;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            edad = calcularEdad(listaEmpleados.get(i).getFechaNacimiento());
            if (mayorEmp < edad) {
                mayorEmp = edad;
                empleado = listaEmpleados.get(i);
            }
        }
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|N° Legajo|    Apellido   |    Nombre      |   DNI    | FecNacimiento |  sueldo  |");
        System.out.println("+--------------------------------------------------------------------------------+");
        int dia = empleado.getFechaNacimiento().getDate();
        int mes = empleado.getFechaNacimiento().getMonth();
        int anio = empleado.getFechaNacimiento().getYear();
        String fecha = dia + "-" + mes + "-" + anio;
        System.out.printf("|   %-3s   | %-13s | %-14s | %-8s | %-13s | %-8s  \n",
                empleado.getNroLegajo(),
                empleado.getApellido(),
                empleado.getNombre(),
                empleado.getDni(),
                fecha,
                empleado.getSueldoBasico() + " |");
        System.out.println("+--------------------------------------------------------------------------------+");
    }
    
    public void sueldoBasico(float suelBasico) {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|N° Legajo|    Apellido   |    Nombre      |   DNI    | FecNacimiento |  sueldo  |");
        System.out.println("+--------------------------------------------------------------------------------+");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (suelBasico < listaEmpleados.get(i).getSueldoBasico()) {
                int dia = listaEmpleados.get(i).getFechaNacimiento().getDate();
                int mes = listaEmpleados.get(i).getFechaNacimiento().getMonth();
                int anio = listaEmpleados.get(i).getFechaNacimiento().getYear();
                String fecha = dia + "-" + mes + "-" + anio;
                System.out.printf("|   %-3s   | %-13s | %-14s | %-8s | %-13s | %-8s  \n",
                        listaEmpleados.get(i).getNroLegajo(),
                        listaEmpleados.get(i).getApellido(),
                        listaEmpleados.get(i).getNombre(),
                        listaEmpleados.get(i).getDni(),
                        fecha,
                        listaEmpleados.get(i).getSueldoBasico() + " |");
            }
        }
        System.out.println("+--------------------------------------------------------------------------------+");
    }
}
