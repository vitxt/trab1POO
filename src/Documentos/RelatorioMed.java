package Documentos;

/**
 * Classe responsável por representar um relatório médico.
 * 
 * O relatório pode conter:
 * - receita médica
 * - atestado
 * - declaração de acompanhamento
 * - nome do paciente
 */
public class RelatorioMed {
    private String receita;
    private String atestado;
    private String acompanhamento;
    private String cliente;
    //construtor da classe RelatorioMed, pede receita, atestado, aompanhamento e o cliente.
    public RelatorioMed(String receita, String atestado, String acompanhamento, String cliente) {
        this.receita = receita;
        this.atestado = atestado;
        this.acompanhamento = acompanhamento;
        this.cliente = cliente;
    }    
    
}
