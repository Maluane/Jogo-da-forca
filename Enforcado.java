package teste;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



class Enforcado extends JPanel {

    private int Erros;
    ImageIcon icon0 = new ImageIcon("c:/imagens/Forca1.png");
    ImageIcon icon1 = new ImageIcon("c:/imagens/Forca2.png");
    ImageIcon icon2 = new ImageIcon("c:/imagens/Forca3.png");
    ImageIcon icon3 = new ImageIcon("c:/imagens/Forca4.png");
    ImageIcon icon4 = new ImageIcon("c:/imagens/Forca5.png");
    ImageIcon icon5 = new ImageIcon("c:/imagens/Forca6.png");
    ImageIcon icon6 = new ImageIcon("c:/imagens/Forca7.png");

    void setErro(int Numeros_de_Erros) {
        Erros = Numeros_de_Erros;

        atualizaImagem();
    }

    private void atualizaImagem() {
        removeAll();
        JLabel lbl = new JLabel();
        lbl.setAlignmentX(20.5f);
        if (Erros == 1) {
            lbl.setIcon(icon0);
        }

        if (Erros == 2) {
            lbl.setIcon(icon1);
        }
        if (Erros == 3) {
            lbl.setIcon(icon2);
        }
        if (Erros == 4) {
            lbl.setIcon(icon3);
        }
        if (Erros == 5) {
            lbl.setIcon(icon4);
        }
        if (Erros == 6) {
            lbl.setIcon(icon5);
        }
        if (Erros == 7) {
            lbl.setIcon(icon6);
        }

        add(lbl);
    }
}
