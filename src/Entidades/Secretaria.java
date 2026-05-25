/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Documentos.Consulta;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Secretaria {
    private String nome;
    private Scanner sc = new Scanner(System.in);
    
    
    public Secretaria (String nome){
        this.nome = nome;
    }
    
    public void CriaPaciente (ArrayList<Paciente> listaPacientes){
        System.out.print("Digite o nome do paciente\n");
        String nome = sc.nextLine();
        System.out.print("Possui convênio particular/plano de saude\n");
        String convenio = sc.nextLine();
        System.out.print("Digite o endereço do paciente\n");
        String endereco = sc.nextLine();
        System.out.print("Digite a data de nascimento do paciente (dd/mm/aaaa)\n");
        String nascimento = sc.nextLine();
        System.out.print("Digite o telefone do paciente\n");
        String telefone = sc.nextLine();
        System.out.print("Digite o email do paciente\n");
        String email = sc.nextLine();
        
        Paciente p = new Paciente(nome, nascimento, endereco, email, telefone, convenio);

        if (this.RetornaPacientePeloTelefone(listaPacientes, telefone).isEmpty()){
            listaPacientes.add(p);
        }
    }
    
    public void AtualizaPaciente (ArrayList<Paciente> ListaPaciente){
        System.out.print("Digite o telefone do paciente\n");
        String telefone = sc.nextLine();
        
        Optional<Paciente> p = this.RetornaPacientePeloTelefone (ListaPaciente, telefone);
        if (p.isEmpty()){
            System.out.print("Paciente não encontrado!");
            return;
        };

        Paciente paciente = p.get();
        int opt = -1;
        while (opt != 0){
        System.out.print("O que deseja alterar?\n1-nome\n2-convênio\n3-endereço\n4-nascimento\n5-telefone\n0-sair\n");
        opt = sc.nextInt();
        switch (opt){
                case 1:
                    System.out.print("Qual o novo nome?\n");
                    String novo_nome = sc.nextLine();
                    paciente.setNome(novo_nome);
                    break;
                case 2:
                    
                    System.out.print("Qual o novo convenio?\n");
                    String novo_convenio = sc.nextLine();
                    paciente.setConvenio(novo_convenio);
                    break;
                case 3:
                    System.out.print("Qual o novo endereço?\n");
                    String novo_end = sc.nextLine();
                    paciente.setEndereco(novo_end);
                    break;
                case 4:
                    System.out.print("Qual o novo nascimento?\n");
                    String novo_nasc = sc.nextLine();
                    paciente.setNascimento(novo_nasc);
                    break;
                case 5:
                    System.out.print("Qual o novo telefone?\n");
                    String novo = sc.nextLine();
                    paciente.setTelefone(novo);
                    break;
                case 0:
            }                
        }
        return;
    }
    
    public void RemovePaciente (ArrayList<Paciente> ListaPacientes){
        System.out.print("Qual o telefone?\n");
        String telefone = sc.nextLine();
        Optional<Paciente> p = this.RetornaPacientePeloTelefone (ListaPacientes, telefone);
        if (!p.isEmpty()){
                   ListaPacientes.remove(p.get());
        } else {System.out.print("Paciente não existe!");};
    }
     
    private Optional<Paciente> RetornaPacientePeloTelefone (ArrayList<Paciente> ListaPacientes, String telefone) {
    for (Paciente p : ListaPacientes){
            if (p.getTelefone().equals(telefone)){
                 return Optional.ofNullable(p);       
            }
        }
    return null;
    }

    public void CriaConsulta (ArrayList<Paciente> pacientes, ArrayList<Medico> medicos, ArrayList<Consulta> consultas){
       
       System.out.print("Digite o telefone do Paciente:\n");
       String tele = sc.nextLine();

       if (this.RetornaPacientePeloTelefone(pacientes, tele).isEmpty()){
       System.out.print("Paciente nao cadastrado\n");
            this.CriaPaciente(pacientes);
       }

       Paciente p = this.RetornaPacientePeloTelefone(pacientes, tele).get();

       System.out.print("Digite o nome do Medico:\n");
       String nome_m = sc.nextLine();

       if (this.RetornaMedicoPeloNome(medicos, nome_m).isEmpty()) {
           System.out.print("Medico nao cadastrado\n");
           this.CriaMedico(medicos);
       }
       Medico m = this.RetornaMedicoPeloNome(medicos, nome_m).get();
        
       System.out.print("Digite a data (dd/mm/aaaa)");
       String data = sc.nextLine();
       System.out.print("Digite o horário (hh:mm):");
       String horario = sc.nextLine();
       System.out.print("Digite o tipo da consulta(normal/retorno):");
       String tipo = sc.nextLine();
       

       Consulta c = new Consulta(p, data, horario, m, tipo);
       
       if (!consultas.contains(c)) {
           consultas.add(c);
       }
    };

    public void AtualizaConsulta (ArrayList<Consulta> consultas,ArrayList<Paciente> pacientes,  ArrayList<Medico> medicos) {
        System.out.print("Digite o horario da consulta(Ex:13:24)\n");
        String horario = sc.nextLine();
        
        if (this.RetornaConsultaPeloHorario(consultas,horario).isEmpty()){
            System.out.print("Consulta não encontrada!");
            return;
        };
        Consulta c = this.RetornaConsultaPeloHorario(consultas, horario).get();
        int opt = -1;
        while (opt != 0){
        System.out.print("O que deseja alterar?\n1-Paciente\n2-Data\n3-Horario\n4-Medico\n5-Tipo\n0-sair\n");
        opt = sc.nextInt();
        switch (opt){
                case 1:
                    System.out.println("Digite o telefone do Paciente:\n");
                    String telefone = sc.nextLine();
                    if (this.RetornaPacientePeloTelefone(pacientes, telefone).isEmpty()){
                        System.out.print("Paciente nao cadastrado\n");
                        this.CriaPaciente(pacientes);
                    };
                    Paciente paciente = this.RetornaPacientePeloTelefone(pacientes, telefone).get();
                    c.setP(paciente);
                    break;
                case 2:
                    System.out.print("Qual a nova data?\n");
                    String data = sc.nextLine();
                    c.setData(data);
                    break;
                case 3:
                    System.out.print("Qual o novo horario?\n");
                    String novo_horario = sc.nextLine();
                    c.setHorario(novo_horario);
                    break;
                case 4:
                    System.out.println("Digite o nome do Medico:\n");
                    String nome = sc.nextLine();
                    if (this.RetornaMedicoPeloNome(medicos,nome).isEmpty()){
                        System.out.print("Medico nao cadastrado\n");
                        this.CriaMedico(medicos);
                    };
                    Medico medico = this.RetornaMedicoPeloNome(medicos, nome).get();
                    c.setM(medico);
                    break;
                case 5:
                    System.out.print("Qual o novo tipo?\n");
                    String tipo = sc.nextLine();
                    c.setTipo(tipo);
                    break;
                case 0:
            }                
        }
    }

    public void remConsulta (ArrayList<Consulta> consultas) {
        System.out.print("Digite o horario da consulta(Ex:13:24)\n");
        String horario = sc.nextLine();
        if (!this.RetornaConsultaPeloHorario(consultas,horario).isEmpty()){
            System.out.print("Consulta não encontrada!");
            return;
        } else { consultas.remove(this.RetornaConsultaPeloHorario(consultas, horario).get()); };

    }

    public Optional<Consulta> RetornaConsultaPeloHorario(ArrayList<Consulta> consultas, String horario) {
    for (Consulta c : consultas){
            if (c.getHorario().equals(horario)){
                 return Optional.ofNullable(c);       
            }
        }
    return null;
    }

    public void CriaMedico (ArrayList<Medico> listaMedicos){
        System.out.print("Digite o nome do medico:\n");
        String nome = sc.nextLine();

        if (this.RetornaMedicoPeloNome(listaMedicos, nome).isEmpty()){
            Medico medico = new Medico(nome);
            listaMedicos.add(medico);
        }
    }
    
    public Optional<Medico> RetornaMedicoPeloNome(ArrayList<Medico> ListaMedicos, String nome) {
    for (Medico m: ListaMedicos){
            if (m.getNome().equals(nome)){
                 return Optional.ofNullable(m);       
            }
        }
    return null;
    }

    public void ConsultasDiaSeguinte (ArrayList<Consulta> listaConsultas){
        System.out.println("Digite o dia de hoje(dd/mm/aaaa):\n");
        String data = sc.nextLine();
        ArrayList<Consulta> consultas_seguintes = new ArrayList<>();
        for (Consulta c : listaConsultas){
            if (c.getData().equals(data)){
                consultas_seguintes.add(c);
                System.out.println("Pacientes de amanha que possuem email ou telefone cadastrados:\n");
                if (c.getP().getTelefone().length() > 0 || !c.getP().getEmail().equals("")){
                    System.out.println(c.toString()+"\n");
                }
            }
        }
        System.out.println("Pacientes sem dados de contato:\n");
        for  (Consulta c : consultas_seguintes){
            if (c.getP().getTelefone().length()==0 && c.getP().getEmail().equals("")){
                System.out.println(c.toString()+"\n");
            }
        }
    }
}
