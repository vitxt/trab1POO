package Documentos;

import java.util.ArrayList;


public class Prontuario {
    // Lista de sintomas registrados no prontuário
    private ArrayList<String> sintomas = new ArrayList<>(); 
     // Diagnóstico médico do paciente
    private String diagnostico;
    // Prescrição médica recomendada
    private String prescricao;
     /**
     * Construtor que inicializa o prontuário com diagnóstico e prescrição.
     */
    public Prontuario(String diagnostico, String prescricao) {
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }
    //construtor vazio da classe prontuario
    public Prontuario() {
    }
    // Adiciona um sintoma ao prontuário do paciente.
    public void addSintoma (String s){
        this.sintomas.add(s);
    }
    //métodos gets e sets dos atributos
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }
    //getter da lista de sintomas
    public ArrayList<String> getSintomas() {
        return sintomas;
    }


    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }
}
