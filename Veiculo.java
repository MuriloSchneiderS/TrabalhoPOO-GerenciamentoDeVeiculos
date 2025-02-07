abstract class Veiculo {
    protected String modelo, placa;
    protected double tara;//peso sem carga
    protected double consumo;//km/L
    protected double quilometragem;//km
    abstract protected double calcularConsumo();
    abstract protected void cadastrarViagem();
}
