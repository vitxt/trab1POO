/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Documentos.Consulta;
import Documentos.Prontuario;
import Documentos.RelatorioMed;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;


/**
 *
 * @author guest-kt6far
 */
public class Medico {
    private String nome;
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ArrayList<RelatorioMed> relatorios = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private int clientesAtendidos = relatorios.size();

    public Medico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addConsultas(Consulta c) {
        this.consultas.add(c);
    }

    public void gerenciarRelatorioAdicional(ArrayList<Paciente> pacientes) {
        System.out.println("Digite o telefone do Paciente:\n");
        String telefone = sc.nextLine();
        if (this.RetornaPacientePeloTelefone(pacientes, telefone).isEmpty()) {
            System.out.print("Paciente nao cadastrado\n");
            return;
        }
        ;
        Paciente paciente = this.RetornaPacientePeloTelefone(pacientes, telefone).get();
        int opt = -1;
        while (opt != 0) {
            System.out.print("1- Add enfermidades\n2- Remove enfermidades\n3- Atualizar enfermidades\n0- Sair\n");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("Qual a enfermidade?\n");
                    String e = sc.nextLine();
                    paciente.addEnfermidade(e);
                case 2:
                    System.out.print("Qual a enfermidade?\n");
                    String e_rem = sc.nextLine();
                    paciente.getEnfermidades().remove(e_rem);
                case 3:
                    System.out.print("Qual a enfermidade?\n");
                    String e_att = sc.nextLine();
                    for (String enfermidade : paciente.getEnfermidades()) {
                        if (enfermidade.equals(e_att)) {
                            System.out.println(enfermidade + "\n");
                            System.out.println("Digite a nova versao:\n");
                            enfermidade = sc.nextLine();
                        }
                    }
                case 0:
            }
            ;
        }
    }

    public void resetRelatorios() {
        this.relatorios.clear();
    }

    public void attProntuario(ArrayList<Paciente> pacientes) {
        System.out.println("Digite o telefone do Paciente:\n");
        String telefone = sc.nextLine();
        if (this.RetornaPacientePeloTelefone(pacientes, telefone).isEmpty()) {
            System.out.print("Paciente nao cadastrado\n");
            return;
        }
        ;
        Paciente paciente = this.RetornaPacientePeloTelefone(pacientes, telefone).get();
        int opt = -1;
        while (opt != 0) {
            System.out.println("O que deseja alterar?\n1- Diagnostico\n2- Prescricao\n3- Sintomas\n0- Sair\n");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Digite o novo diagnostico:\n");
                    paciente.getProntuario().setDiagnostico(sc.nextLine());
                case 2:
                    System.out.println("Digite a nova prescricao:\n");
                    paciente.getProntuario().setPrescricao(sc.nextLine());
                case 3:
                    int opt2 = -1;
                    while (opt2 != 0) {
                        System.out.println("Deseja:\n1- Remover um sintoma\n2- Adicionar sintoma\n0- Sair\n");
                        opt2 = sc.nextInt();
                        switch (opt2) {
                            case 1:
                                System.out.println("Digite o sintomas a ser removido:\n");
                                paciente.getProntuario().getSintomas().remove(sc.nextLine());
                            case 2:
                                System.out.println("Digite o sintoma a ser adicionada:\n");
                                paciente.getProntuario().addSintoma(sc.nextLine());
                            case 0:
                        }
                    }
            }
        }

    }

    public void cadastraProtuario(ArrayList<Paciente> pacientes) {
        System.out.println("Digite o telefone do Paciente:\n");
        String telefone = sc.nextLine();
        if (this.RetornaPacientePeloTelefone(pacientes, telefone).isEmpty()) {
            System.out.print("Paciente nao cadastrado\n");
            return;
        }
        ;
        Paciente paciente = this.RetornaPacientePeloTelefone(pacientes, telefone).get();
        System.out.print("Digite o diagnostico do paciente\n");
        String diagnostico = sc.nextLine();
        System.out.print("Digite a prescricao\n");
        String prescricao = sc.nextLine();
        paciente.setPontuario(new Prontuario(diagnostico, prescricao));
        int opt = -1;
        while (opt != 0) {
            System.out.print("Deseja add mais sintomas?\nS-1\nN-0");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("Qual o sintomas?\n");
                    paciente.getProntuario().addSintoma(sc.nextLine());
                case 0:
            }
            ;
        }
    }

    public void remProntuario(ArrayList<Paciente> pacientes) {
        System.out.println("Digite o telefone do Paciente:\n");
        String telefone = sc.nextLine();
        if (this.RetornaPacientePeloTelefone(pacientes, telefone).isEmpty()) {
            System.out.print("Paciente nao cadastrado\n");
            return;
        }
        ;
        this.RetornaPacientePeloTelefone(pacientes, telefone).get().resetProntuario();
    }

    public void gerarRelatorioMedico(ArrayList<Paciente> pacientes) {
        System.out.println("Digite a receita da consulta:\n");
        String receita = sc.nextLine();
        System.out.println("Digite o atestado da consulta:\n");
        String atestado = sc.nextLine();
        System.out.println("Digite a declaracao de acompanhamento:\n");
        String acompanhamento = sc.nextLine();
        System.out.println("Digite o telefone do Paciente:\n");
        String telefone = sc.nextLine();
        if (this.RetornaPacientePeloTelefone(pacientes, telefone).isEmpty()) {
            System.out.print("Paciente nao cadastrado\n");
            return;
        }
        Paciente paciente = this.RetornaPacientePeloTelefone(pacientes, telefone).get();
        RelatorioMed relatorioMed = new RelatorioMed(receita, atestado, acompanhamento, paciente.getNome());
    }

    private Optional<Paciente> RetornaPacientePeloTelefone(ArrayList<Paciente> ListaPacientes, String telefone) {
        for (Paciente p : ListaPacientes) {
            if (p.getTelefone().equals(telefone)) {
                return Optional.ofNullable(p);
            }
        }
        return null;
    }

}
