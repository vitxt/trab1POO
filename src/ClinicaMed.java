/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import Documentos.Consulta;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Secretaria;
import Services.GerenciadorMensagens;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author guest-kt6far
 */

public class ClinicaMed {
    // * @param args the command line arguments
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        GerenciadorMensagens mensageiro = new GerenciadorMensagens();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("1 - Menu da Secretária");
            System.out.println("2 - Menu do Médico");
            System.out.println("3 - Enviar mensagens");
            System.out.println("0 - Sair do Sistema");
            opcao = sc.nextInt();
            sc.nextLine(); // CORREÇÃO: Consome o "Enter"

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da secretaria: ");
                    Secretaria secretaria = new Secretaria(sc.nextLine());
                    menuSecretaria(secretaria,consultas,medicos,pacientes);
                    break;
                case 2:
                    menuMedico(medicos, pacientes);
                    break;
                case 3:
                    System.out.print("Digite a data para enviar os avisos (dd/mm/aaaa): ");
                    String data = sc.nextLine();
                    mensageiro.dispararLembretesDeConsulta(consultas, data);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
            }
        }
    }

    private static void menuSecretaria(Secretaria sec, ArrayList<Consulta> consultas, ArrayList<Medico> medicos, ArrayList<Paciente> pacientes) {
        Scanner sc = new Scanner(System.in);
        int opt = -1;
        while (opt != 0) {
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Atualizar Paciente");
            System.out.println("3 - Remover Paciente");
            System.out.println("4 - Agendar Consulta");
            System.out.println("5 - Atualizar Consulta");
            System.out.println("6 - Remover Consulta");
            System.out.println("7 - Relatório de Consultas do dia Seguinte");
            System.out.println("0 - Voltar");
            opt = sc.nextInt();
            switch (opt) {
                case 1: sec.CriaPaciente(pacientes); break;
                case 2: sec.AtualizaPaciente(pacientes); break;
                case 3: sec.RemovePaciente(pacientes); break;
                case 4: sec.CriaConsulta(pacientes, medicos, consultas); break;
                case 5: sec.AtualizaConsulta(consultas, pacientes, medicos); break;
                case 6: sec.remConsulta(consultas); break;
                case 7: sec.ConsultasDiaSeguinte(consultas); break;
                case 0: break;
            }
        }
    }

    private static void menuMedico(ArrayList<Medico> medicos, ArrayList<Paciente> pacientes) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nDigite o nome do Médico para acessar o sistema: ");
        String nomeMedico = sc.nextLine();
        Medico login = null;
        for (Medico m : medicos) {
            if (m.getNome().equals(nomeMedico)) {
                login = m;
                break;
            }
        }
        if (login == null) {
            Medico m = new Medico(nomeMedico);
            login = m;
            medicos.add(m);
        }


        int opt = -1;
        while (opt != 0) {
            System.out.println("1 - Gerenciar Dados Adicionais de Saúde");
            System.out.println("2 - Cadastrar Prontuário");
            System.out.println("3 - Atualizar Prontuário");
            System.out.println("4 - Remover Prontuário");
            System.out.println("5 - Gerar Relatório Médico");
            System.out.println("0 - Voltar");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1: login.gerenciarRelatorioAdicional(pacientes); break;
                case 2: login.cadastraProtuario(pacientes); break;
                case 3: login.attProntuario(pacientes); break;
                case 4: login.remProntuario(pacientes); break;
                case 5: login.gerarRelatorioMedico(pacientes); break;
                case 0: break;
            }
        }
    }
}
