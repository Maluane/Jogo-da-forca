package teste;

import javax.swing.JFrame;



public class Main {

    public static void main(String[] args) {

        // Propriedades da Janela
        JogoDaForca Propriedades = new JogoDaForca();
        Propriedades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Propriedades.setSize(1000, 700);
        Propriedades.setVisible(true);
        Propriedades.setResizable(false);
        Propriedades.setLocationRelativeTo(null);
    }

}
