/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Documentos.Consulta;

import java.util.ArrayList;

/**
 *
 * @author guest-kwgefc
 */
public class GerenciadorMensagens {
    public void dispararLembretesDeConsulta(ArrayList<Consulta> consultas, String data) {
        System.out.println("Enviando mensagens...\n");

        for (Consulta c : consultas) {
            if (c.getData().equals(data) && (c.getP().getTelefone() != null || c.getP().getEmail() == null)) {
                System.out.println("Olá " + c.getP().getNome() +
                        ", lembrete da sua consulta amanhã (" + c.getData() + ") as " +
                        c.getHorario() + " com o " + c.getM().getNome());
            }
        }
    }

}
