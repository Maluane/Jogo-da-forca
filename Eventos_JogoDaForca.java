package teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JOptionPane;

class Eventos_JogoDaForca implements ActionListener, ItemListener {

    private String Palavra_Misteriosa, Palavra_Certa;
    int Tamanho_da_Palavra_Misteriosa, Letras_Encontradas, Numeros_de_Erros, Campos_Nao_Preenchidos;
    int Exibir_Messagem = 0;
    String[] Palavra = {"heranca", "encapsulamento", "metodo", "instancia", "objeto", "pacotes",
                "interface", "atributos", "execoes", "boolean", "void", "float",
                "primitivo", "byte", "null", "true", "false", "this",
                "break", "default", "switch", "return", "import", "construtor",
                "getters", "setters", "else", "private", "public"};
    private JogoDaForca jogo;

    public Eventos_JogoDaForca(JogoDaForca jogo) {
        this.jogo = jogo;

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        // Inicializando um novo Jogo
        if (event.getSource() == jogo.getNovo_Jogo()) {

            Exibir_Messagem = 0;
            Numeros_de_Erros = 0;

            Habilitando_Desabilitando_Componentes(false);

            for (int i = 0; i < Tamanho_da_Palavra_Misteriosa; ++i) {
                jogo.Letra[i].setVisible(false);
            }

            Palavra_Misteriosa = "nulo";
            Random sorteio = new Random();
            int indice = sorteio.nextInt(Palavra.length);
            this.Palavra_Misteriosa = Palavra[indice];

            Habilitando_Desabilitando_Componentes(true);
            Tamanho_da_Palavra_Misteriosa = Palavra_Misteriosa.length();

            for (int i = 0; i < Tamanho_da_Palavra_Misteriosa; ++i) {
                jogo.Letra[i].setVisible(true);
                jogo.Letra[i].setText("__");
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {

            // Exibindo a última letra selecionada
            jogo.getText_Letra().setText("" + jogo.getOpcao().getSelectedItem());

            Letras_Encontradas = 0;
            // Verificando se a letra selecionada é existente na palavra misteriosa
            for (int i = 0; i < Tamanho_da_Palavra_Misteriosa; ++i) {
                if (jogo.getText_Letra().getText().charAt(0) == Palavra_Misteriosa.toUpperCase().charAt(i)) {
                    jogo.Letra[i].setText("" + jogo.getText_Letra().getText().charAt(0));
                    Letras_Encontradas++;
                }
            }

            Campos_Nao_Preenchidos = 0;
            for (int i = 0; i < Tamanho_da_Palavra_Misteriosa; ++i) {
                if (jogo.Letra[i].getText() != "__") {
                    Campos_Nao_Preenchidos++;
                }
            }

            if ((Campos_Nao_Preenchidos == Tamanho_da_Palavra_Misteriosa) && (Exibir_Messagem == 0)) {

                Habilitando_Desabilitando_Componentes(false);
                Exibir_Messagem = 1;
                Vencer();

            } else {

                /* Caso a letra selecionada pelo Jogador não faça parte da 
                 palavra misteriosa será contabilizado erro*/
                if ((Letras_Encontradas == 0) && (Exibir_Messagem == 0)) {

                    Numeros_de_Erros++; // Incrementando variável
                    // Desenhando animação
                    jogo.Painel_da_Animacao.setErro(Numeros_de_Erros);
                    // Atualizando o número de erros
                    jogo.getBarra_de_Status().setText(" Numero de Letra(s) errada(s): " + Numeros_de_Erros);

                    if (Numeros_de_Erros == 7) {
                        Habilitando_Desabilitando_Componentes(false);
                        Perder();
                    }
                }
            }
        }
    }

    public void Habilitando_Desabilitando_Componentes(boolean parametro) {
        /* Quando parâmetro for verdadeiro os componetes abaixo 
         estaram ativados, ao contrário desativados*/
        jogo.getPainel_da_Animacao().setEnabled(false);
        jogo.getPainel_da_Animacao().setEnabled(true);
        jogo.getOpcao().setEnabled(parametro);
        jogo.getText_Letra().setEnabled(parametro);

    }

    public void Vencer() {
        JOptionPane.showMessageDialog(null, "Parabéns!!!");
        Atualizar();
    }

    public void Perder() {
        JOptionPane.showMessageDialog(null, "Você falhou! \n Tente Novamete!");
        JOptionPane.showMessageDialog(null, "Palavra misteriosa: \n " + Palavra_Misteriosa);
        Atualizar();

    }

    public void Atualizar() {

        jogo.getText_Letra().setText("");
        jogo.getOpcao().setSelectedIndex(0);
        jogo.getBarra_de_Status().setText(" Numero de Letra(s) errada(s): 0");
    }

}
