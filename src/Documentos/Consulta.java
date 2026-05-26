/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Documentos;

import Entidades.Medico;
import Entidades.Paciente;
import java.util.Scanner;

/**
 *
 * @author guest-kt6far
 */
public class Consulta {
    public Scanner sc = new Scanner(System.in);
    private Paciente p;
    private String data;
    private String horario;
    private Medico m;
    private String tipo; //(consulta normal: duração de 1 hora, retorno: duração de 30 minutos.)

    public Consulta(Paciente p, String data, String horario, Medico m, String tipo) {
        this.p = p;
        this.data = data;
        this.horario = horario;
        this.m = m;
        this.tipo = tipo;
    }

    public String getHorario (){
        return horario;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Consulta -> Data: " + data + " | Horário: " + horario + " | Paciente: " + p.getNome() + " | Médico: " + m.getNome();
    }

    public void setData(String data) {
        this.data = data;
    }

    public Paciente getP() {
        return p;
    }

    public void setP(Paciente p) {
        this.p = p;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Medico getM() {
        return m;
    }

    public void setM(Medico m) {
        this.m = m;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
