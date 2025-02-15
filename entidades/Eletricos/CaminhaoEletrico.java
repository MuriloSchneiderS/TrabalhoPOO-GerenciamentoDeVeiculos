package entidades.Eletricos;

import entidades.Caminhao;

public class CaminhaoEletrico extends Caminhao implements Eletricos {
    int carga;//0%-100%
    double consumo;
    public CaminhaoEletrico(String marca, String modelo, int ano, double quilometragem, double totalCombustivel,
                            double capacidadeCarga) {
        super(marca, modelo, ano, quilometragem, totalCombustivel, capacidadeCarga);
    }
    
    @Override
    public void pilotoAutomatico() {
        
    }

    @Override
    public void carregar(int carga) {
        
    }
    
}
