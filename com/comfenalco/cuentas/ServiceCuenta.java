package com.comfenalco.cuentas;

import java.util.ArrayList;
import java.util.List;

public class ServiceCuenta implements IServiceCuenta {

    private List<Cuenta> cuentas = new ArrayList<>();

    @Override
    public List<Cuenta> listarCuentas() {
        return cuentas;
    }

    @Override
    public Cuenta obtenerCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    @Override
    public void crearCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}
