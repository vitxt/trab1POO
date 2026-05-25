/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Documentos;

import java.util.ArrayList;

/**
 *
 * @author guest-kt6far
 */
public class Prontuario {
    private ArrayList<String> sintomas = new ArrayList<>();
    private String diagnostico;
    private String prescricao;

    public Prontuario(String diagnostico, String prescricao) {
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }
    public Prontuario() {
    }
    public void addSintoma (String s){
        this.sintomas.add(s);
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }


    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }
}
