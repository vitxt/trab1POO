package Entidades;

import Documentos.Prontuario;
import java.util.ArrayList;
import java.util.Scanner;


public class Paciente {
    private String nome;
    private String nascimento;
    private String endereco;
    private String email;
    private String telefone;
    private String convenio;
    private Prontuario prontuario;
    private ArrayList<String> mensagens = new ArrayList<>();
    private ArrayList<String> enfermidades = new ArrayList();
    private Scanner sc = new Scanner(System.in);
    //construtor da classe paciente com os parametros: nome, data de nascimento, endereço, email, telefone e convenio
    public Paciente (String nome, String nascimento, String endereco,String email, String telefone, String convenio) {
        this.nome = nome;
        this.convenio =convenio;
        this.endereco = endereco;
        this.nascimento = nascimento;
        this.email = email;
        this.telefone = telefone;
    }
    // remove o paciente do prontuario
    public void resetProntuario (){
        this.prontuario = null;
    }
    //metodos gets e sets da classe Paciente
    public Prontuario getProntuario() {
        return prontuario;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public void setPontuario(Prontuario pontuario) {
        this.prontuario = pontuario;
    }

    public void addEnfermidade (String e){
        this.enfermidades.add(e);
    }

    public ArrayList<String> getEnfermidades(){
        return this.enfermidades;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
