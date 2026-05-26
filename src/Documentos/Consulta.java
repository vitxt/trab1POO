
package Documentos;

import Entidades.Medico;
import Entidades.Paciente;
import java.util.Scanner;

/**
 *
 * Classe responsável por representar uma consulta médica no sistema.
 * 
 * Cada consulta possui:
 * - paciente
 * - médico
 * - data
 * - horário
 * - tipo da consulta
 * 
 * O tipo pode representar:
 * consulta normal ou retorno.
 */
public class Consulta {
    public Scanner sc = new Scanner(System.in);
    private Paciente p;
    private String data;
    private String horario;
    private Medico m;
    private String tipo; //(consulta normal: duração de 1 hora, retorno: duração de 30 minutos.)

    /**
     * Construtor da classe Consulta.
     * 
     * @param p paciente da consulta
     * @param data data da consulta
     * @param horario horário da consulta
     * @param m médico responsável
     * @param tipo tipo da consulta
     */
    public Consulta(Paciente p, String data, String horario, Medico m, String tipo) {
        this.p = p;
        this.data = data;
        this.horario = horario;
        this.m = m;
        this.tipo = tipo;
    }
    // metodos gets e sets dos atributos da classe
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
    //  Define ou altera a data da consulta.
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
