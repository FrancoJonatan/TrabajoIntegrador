/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unju.tpi.poo.cardozofarfantorrez.View;


import controlador.EmpleadosJpaController;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empleados;

/**
 *
 * @author Cardozo Franco
 *         Farfan Yamil
 *         Torrez Miguel
 */
public class Menu {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();

    }

    public static void menuPrincipal() {
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("________________________________");
            System.out.println("+   Municipalidad de La Quiaca +");
            System.out.println("+==============================+");
            System.out.println("+==== Menu de Admistración ====+");
            System.out.println("+==============================+");
            System.out.println("+   1. Empleados               +");
            System.out.println("+   2. Proyectos               +");
            System.out.println("+   3. Salir                   +");
            System.out.println("+   Ingrese Opcion             +");
            System.out.println("+==============================+");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Debe ingresar un numero");
            }
            switch (opcion) {
                case 1:
                    empleados();
                    break;
                case 2:
                    proyectos();
                    break;
                case 3:
                    System.out.println("Saliendo del Programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;

            }
        }
    }

    public static void empleados() {
        Empleados empleado = new Empleados();
        EmpleadosJpaController emp = new EmpleadosJpaController();
        int opcion = 0;
       
        while (opcion != 8) {
            System.out.println("____________________________________");
            System.out.println("+    Municipalidad de La Quiaca    +");
            System.out.println("+==================================+");
            System.out.println("+    Menu opciones de Empleados    +");
            System.out.println("+==================================+");
            System.out.println("+   1. Agregar un Empleado         +");
            System.out.println("+   2. Eliminar un Empleado        +");
            System.out.println("+   3. Modificar un Empleado       +");
            System.out.println("+   4. Listar Empleados            +");
            System.out.println("+   5. Empleado de Mayor Edad      +");
            System.out.println("+   6. Empleados con sueldo Basico +");
            System.out.println("+   7. Buscar Empleado             +");
            System.out.println("+   8. Volver                      +");
            System.out.println("+   Ingrese Opcion                 +");
            System.out.println("+==================================+");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Debe ingresar un numero");
            }
            switch (opcion) {
                case 1:
                    Date fecha = new Date(02 / 12 / 1998);
                    empleado.setNroLegajo(1);
                    empleado.setApellido("Torrez");
                    empleado.setNombre("Yamil");
                    empleado.setFechaNacimiento(fecha);
                    empleado.setSueldoBasico(0);
                    try {
                        emp.create(empleado);
                    } catch (Exception ex) {
                        System.out.println("error" + ex);
                    }
                    
                    break;
                case 2:
                    try {
                        emp.destroy(1);
                    } catch (Exception ex) {
                        System.out.println("error" + ex);
                    }
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Volviendo al Menu Admistracion");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;

            }
        }
    }

    public static void proyectos() {
        int opcion = 0;

        while (opcion != 10) {
            System.out.println("________________________________________");
            System.out.println("+      Municipalidad de La Quiaca      +");
            System.out.println("+======================================+");
            System.out.println("+===== Menu opciones de Proyectos =====+");
            System.out.println("+======================================+");
            System.out.println("+   1. Agregar nuevo Proyecto          +");
            System.out.println("+   2. Eliminar un Proyecto            +");
            System.out.println("+   3. Listar Proyectos                +");
            System.out.println("+   4. Agregar empleado a un Proyecto  +");
            System.out.println("+   5. Quitar empleado de un Proyecto  +");
            System.out.println("+   6. Listar empleados de un Proyecto +");
            System.out.println("+   7. Monto total de proyectos        +");
            System.out.println("+   8. Calcular sueldo empleado        +");
            System.out.println("+   9. Listar proyectos por fecha      +");
            System.out.println("+   10. Volver                         +");
            System.out.println("+   Ingrese Opcion                     +");
            System.out.println("+======================================+");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Debe ingresar un numero");
            }
            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:
                    System.out.println("Volviendo al Menu Admistracion");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;

            }
        }
    }
}
