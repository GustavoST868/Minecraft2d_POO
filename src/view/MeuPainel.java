package view;

//bibliotecas usadas
import javax.swing.*;
import java.awt.*;

public class MeuPainel extends JPanel {

    private ImageIcon icon;

    public MeuPainel() {

        icon = new ImageIcon(

                "G:\\\\Meu Drive\\\\Files\\\\Projetos\\\\Java\\\\Minecraft2d\\\\src\\\\view\\\\Resource\\\\steve.png");

    }

    // no painel em que o personagem esta ele aparece
    public MeuPainel(ImageIcon icon) {

        this.icon = icon;

    }

    public void setIcon(ImageIcon icon) {

        this.icon = icon;

        // redesenha a imagem
        repaint();

    }

    public void paint(Graphics g) {

        // comando de desenho do personagem
        g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);

    }
}
