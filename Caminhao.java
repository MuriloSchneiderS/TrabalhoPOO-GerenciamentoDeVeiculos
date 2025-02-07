public class Caminhao extends Veiculo{
    private double pesoCarga;
    public double lotacao(){//Lotação (L): peso somado de tudo que o caminhão pode transportar, ou seja, a carga útil máxima de transporte (carga em si + condutor + passageiros);
        return tara+pesoCarga;
    }
    @Override
    protected double calcularConsumo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularConsumo'");
    }
    @Override
    protected void cadastrarViagem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarViagem'");
    }
}