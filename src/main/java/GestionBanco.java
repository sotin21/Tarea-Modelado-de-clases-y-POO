import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionBanco {
    private List<Cliente> clientes;
    private List<CuentaBancaria> cuentasBancarias;
    private List<SucursalBancaria> sucursales;
    private Map<Cliente, List<CuentaBancaria>> cuentasPorCliente;
    private Map<SucursalBancaria, List<CuentaAhorro>> cuentasAhorroPorSucursal;
    private Map<SucursalBancaria, List<CuentaCorriente>> cuentasCorrientePorSucursal;

    public GestionBanco() {
        clientes = new ArrayList<>();
        cuentasBancarias = new ArrayList<>();
        sucursales = new ArrayList<>();
        cuentasPorCliente = new HashMap<>();
        cuentasAhorroPorSucursal = new HashMap<>();
        cuentasCorrientePorSucursal = new HashMap<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarCuentaBancaria(CuentaBancaria cuenta) {
        cuentasBancarias.add(cuenta);
        asociarCuentaACliente(cuenta);
    }

    private void asociarCuentaACliente(CuentaBancaria cuenta) {
        Cliente cliente = cuenta.getCliente();
        if (!cuentasPorCliente.containsKey(cliente)) {
            cuentasPorCliente.put(cliente, new ArrayList<>());
        }
        cuentasPorCliente.get(cliente).add(cuenta);
    }

    public void agregarSucursal(SucursalBancaria sucursal) {
        sucursales.add(sucursal);
    }

    public List<CuentaBancaria> getCuentasCliente(Cliente cliente) {
        return cuentasPorCliente.getOrDefault(cliente, new ArrayList<>());
    }

    public List<CuentaAhorro> getCuentasAhorroPorSucursal(SucursalBancaria sucursal) {
        return cuentasAhorroPorSucursal.getOrDefault(sucursal, new ArrayList<>());
    }

    public List<CuentaCorriente> getCuentasCorrientePorSucursal(SucursalBancaria sucursal) {
        return cuentasCorrientePorSucursal.getOrDefault(sucursal, new ArrayList<>());
    }

    public static void main(String[] args) {
        GestionBanco banco = new GestionBanco();

        Cliente cliente1 = new Cliente("Juanito Perez", "210867862", "Calle Falsa 123");
        Cliente cliente2 = new Cliente("Mariana Maria Mortero", "142176334", "Avenida siempre viva 46");

        banco.agregarCliente(cliente1);
        banco.agregarCliente(cliente2);

        CuentaAhorro cuentaAhorro1 = new CuentaAhorro(1023401, "11/01/2007", 5000, cliente1, 0.5f);
        CuentaAhorro cuentaAhorro2 = new CuentaAhorro(1023402, "08/01/2014", 8000, cliente2, 0.6f);
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(2021301, "03/02/2008", 10000, cliente1, 2000.0);
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente(2002342, "01/03/2014", 15000, cliente2, 2500.0);

        banco.agregarCuentaBancaria(cuentaAhorro1);
        banco.agregarCuentaBancaria(cuentaAhorro2);
        banco.agregarCuentaBancaria(cuentaCorriente1);
        banco.agregarCuentaBancaria(cuentaCorriente2);

        SucursalBancaria sucursal1 = new SucursalBancaria(1, 10001);
        SucursalBancaria sucursal2 = new SucursalBancaria(2, 20002);

        banco.agregarSucursal(sucursal1);
        banco.agregarSucursal(sucursal2);

        List<CuentaBancaria> cuentasCliente1 = banco.getCuentasCliente(cliente1);
        System.out.println("Cuentas de " + cliente1.getNombre() + ":");
        for (CuentaBancaria cuenta : cuentasCliente1) {
            System.out.println(cuenta.getNumeroCuenta());
        }

        List<CuentaAhorro> cuentasAhorroSucursal1 = banco.getCuentasAhorroPorSucursal(sucursal1);
        System.out.println("Cuentas de Ahorro de Sucursal 1:");
        for (CuentaAhorro cuenta : cuentasAhorroSucursal1) {
            System.out.println(cuenta.getNumeroCuenta());
        }

        List<CuentaCorriente> cuentasCorrienteSucursal2 = banco.getCuentasCorrientePorSucursal(sucursal2);
        System.out.println("Cuentas Corrientes de Sucursal 2:");
        for (CuentaCorriente cuenta : cuentasCorrienteSucursal2) {
            System.out.println(cuenta.getNumeroCuenta());
        }
    }
}