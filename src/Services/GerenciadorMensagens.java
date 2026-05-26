package Services;

import Documentos.Consulta;
import java.util.ArrayList;
/**
 * Classe responsável pelo gerenciamento de mensagens do sistema.
 * 
 * O gerenciador envia lembretes automáticos de consultas
 * para pacientes cadastrados.
 */

public class GerenciadorMensagens {
    /**
     * Dispara lembretes de consultas para os pacientes.
     * 
     * O método verifica:
     * - se a consulta pertence à data informada
     * - se o paciente possui telefone ou email cadastrado
     */
    public void dispararLembretesDeConsulta(ArrayList<Consulta> consultas, String data) {
        System.out.println("Enviando mensagens...\n");
        //Percorre todas as consultas
        for (Consulta c : consultas) {
            // Verifica se a consulta é da data informada
            // e se o paciente possui telefone ou email
            if (c.getData().equals(data) && (c.getP().getTelefone() != null || c.getP().getEmail() == null)) {
                // exibe o lembrete
                System.out.println("Olá " + c.getP().getNome() +
                        ", lembrete da sua consulta amanhã (" + c.getData() + ") as " +
                        c.getHorario() + " com o " + c.getM().getNome());
            }
        }
    }

}
