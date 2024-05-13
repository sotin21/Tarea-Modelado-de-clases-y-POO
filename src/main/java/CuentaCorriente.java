class CuentaCorriente extends CuentaBancaria {
    private double lineaSobregiro;

    public CuentaCorriente(int numeroCuenta, String fechaApertura, int saldo, Cliente cliente, double lineaSobregiro) {
        super(numeroCuenta, fechaApertura, saldo, cliente);
        this.lineaSobregiro = lineaSobregiro;
    }

    public double getLineaSobregiro() {
        return lineaSobregiro;
    }

    public void setLineaSobregiro(double lineaSobregiro) {
        this.lineaSobregiro = lineaSobregiro;
    }
}