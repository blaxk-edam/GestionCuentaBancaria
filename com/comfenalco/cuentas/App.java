package com.comfenalco.cuentas;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ServiceCuenta service = new ServiceCuenta();

        int opcion;

        do {
            System.out.println("\n--- MENU BANCO ---");
            System.out.println("1. Listar cuentas Ahorro");
            System.out.println("2. Listar cuentas Corriente");
            System.out.println("3. Crear cuenta Ahorro");
            System.out.println("4. Crear cuenta Corriente");
            System.out.println("5. Obtener cuenta por numero");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    boolean hayAhorro = false;

                    for (Cuenta c : service.listarCuentas()) {
                        if (c instanceof Ahorro) {
                            System.out.println(c);
                            hayAhorro = true;
                        }
                    }

                    if (!hayAhorro) {
                        System.out.println("No encontrado");
                    }
                    break;

                case 2:
                    boolean hayCorriente = false;

                    for (Cuenta c : service.listarCuentas()) {
                        if (c instanceof Corriente) {
                            System.out.println(c);
                            hayCorriente = true;
                        }
                    }

                    if (!hayCorriente) {
                        System.out.println("No encontrado");
                    }
                    break;

                case 3:
                    System.out.println("Numero Cuenta:");
                    String numA = sc.nextLine();
                    System.out.println("DNI:");
                    long dniA = sc.nextLong();
                    System.out.println("Saldo:");
                    double saldoA = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Fecha Creacion:");
                    String fecha = sc.nextLine();

                    Ahorro ahorro = new Ahorro(numA, dniA, saldoA, fecha);
                    service.crearCuenta(ahorro);
                    System.out.println("Cuenta creada correctamente");
                    break;

                case 4:
                    System.out.println("Numero Cuenta:");
                    String numC = sc.nextLine();
                    System.out.println("DNI:");
                    long dniC = sc.nextLong();
                    System.out.println("Saldo:");
                    double saldoC = sc.nextDouble();
                    System.out.println("Impuesto:");
                    double impuesto = sc.nextDouble();
                    sc.nextLine();

                    Corriente corriente = new Corriente(numC, dniC, saldoC, impuesto);
                    service.crearCuenta(corriente);
                    System.out.println("Cuenta creada correctamente");
                    break;

                case 5:
                    System.out.println("Ingrese numero de cuenta:");
                    String buscar = sc.nextLine();

                    Cuenta cuenta = service.obtenerCuenta(buscar);

                    if (cuenta != null) {
                        System.out.println(cuenta);
                    } else {
                        System.out.println("No encontrado");
                    }
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}


    

