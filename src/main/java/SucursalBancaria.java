class SucursalBancaria {
    private int codigoSucursal;
    private int codigoPostal;

    public SucursalBancaria(int codigoSucursal, int codigoPostal) {
        this.codigoSucursal = codigoSucursal;
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}