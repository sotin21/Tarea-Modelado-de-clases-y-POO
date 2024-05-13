class CuentaAhorro extends CuentaBancaria {
    private float porcentajeReajuste;

    public CuentaAhorro(int numeroCuenta, String fechaApertura, int saldo, Cliente cliente, float porcentajeReajuste) {
        super(numeroCuenta, fechaApertura, saldo, cliente);
        this.porcentajeReajuste = porcentajeReajuste;
    }

    public float getPorcentajeReajuste() {
        return porcentajeReajuste;
    }

    public void setPorcentajeReajuste(float porcentajeReajuste) {
        this.porcentajeReajuste = porcentajeReajuste;
    }
}