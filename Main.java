package taeprogramaçãoex2;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Pessoa[] pessoa = new Pessoa[3];
        Pessoa PessoaTwo;
        int idadeInt;
        for (int cont = 0; cont < pessoa.length; cont++) {
            PessoaTwo = new Pessoa();
            PessoaTwo.nome = JOptionPane.showInputDialog("Digite o nome");
            PessoaTwo.profissao = JOptionPane.showInputDialog("Digite a profissão ");
            String idade = JOptionPane.showInputDialog("Digite a idade");
            idadeInt = Integer.parseInt(idade);
            PessoaTwo.idade = idadeInt;
            pessoa[cont] = PessoaTwo;
        }
        for (int cont = 0; cont < pessoa.length; cont++) {
            System.out.println(pessoa[cont].nome + " com " + pessoa[cont].idade + " anos, atualmente é " + pessoa[cont].profissao);
            System.out.println("\n");
        }
    }
}