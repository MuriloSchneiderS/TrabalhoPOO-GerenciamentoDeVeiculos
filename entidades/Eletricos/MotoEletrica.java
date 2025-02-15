package entidades.Eletricos;

import entidades.Moto;

public class MotoEletrica extends Moto implements Eletricos {
    int carga;//0%-100%
    double consumo;
    public MotoEletrica(String marca, String modelo, int ano, double quilometragem, double totalCombustivel,
                        int cilindradas) {
        super(marca, modelo, ano, quilometragem, totalCombustivel, cilindradas);
    }
    
    @Override
    public void pilotoAutomatico() {
        
    }

    @Override
    public void carregar(int carga) {
        
    }
    
}
