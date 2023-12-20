package view;

//bibliotecas usadas
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Janela extends JFrame implements KeyListener {
    // divisao da janela
    private final int tamanho = 400;
    private final int colunas = 20;
    private final int linhas = 20;

    // blocos
    // string que corresponde aos endereços das imagens
    private final String personagem = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\steve.png";
    private final String ceu = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\ceu.png";
    private final String flor = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\flor.png";
    private final String madeira = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\madeira.png";
    private final String folhas = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\folhas.png";
    private final String terra = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\terra.png";
    private final String pedra = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\pedra.png";
    private final String terragrama = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\terragrama.png";
    private final String diamante = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\diamante.png";
    private final String madeiraprocessada = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\madeiraprocessada.png";
    private final String madeira2 = "G:\\Meu Drive\\Files\\Projetos\\Java\\Minecraft2d\\src\\view\\Resource\\madeira2.png";
    private MeuPainel meuPainel[];

    // Instancias das imagensdos blocos
    // vetor que armazena os blocos relacionando eles a um numero
    private int[] tipoBloco;
    // personagem
    private ImageIcon personagem_steve;
    // ceu
    private ImageIcon fundo;
    // flor
    private ImageIcon bloco1;
    // madeira
    private ImageIcon bloco2;
    // folhas
    private ImageIcon bloco3;
    // terra
    private ImageIcon bloco4;
    // pedra
    private ImageIcon bloco5;
    // terragrama
    private ImageIcon bloco6;
    // minerio de diamante
    private ImageIcon bloco7;
    // madeira processada
    private ImageIcon bloco8;
    // madeira2
    private ImageIcon bloco9;

    private int posicaopersonagem;

    public Janela() {

        // definindo o layout da janela
        this.setLayout(new GridLayout(linhas, colunas));
        personagem_steve = new ImageIcon(personagem);

        // instancias dos blocos
        // ligar o ImageIcon com o endereço do bloco
        fundo = new ImageIcon(ceu);
        bloco1 = new ImageIcon(flor);
        bloco2 = new ImageIcon(madeira);
        bloco3 = new ImageIcon(folhas);
        bloco4 = new ImageIcon(terra);
        bloco5 = new ImageIcon(pedra);
        bloco6 = new ImageIcon(terragrama);
        bloco7 = new ImageIcon(diamante);
        bloco8 = new ImageIcon(madeiraprocessada);
        bloco9 = new ImageIcon(madeira2);

        // cria um vetor com o tamanho
        tipoBloco = new int[tamanho];

        meuPainel = new MeuPainel[tamanho];

        for (int i = 0; i < tamanho; i++) {

            // coloca o ceu no fundo dos paineis
            meuPainel[i] = new MeuPainel(fundo);

            // adiciona o painel na posicao ja com o ceu
            this.add(meuPainel[i]);

        }

        posicaopersonagem = 200;
        meuPainel[200].setIcon(personagem_steve);

        this.addKeyListener(this);

        // configuracoes basicas da janela
        this.setTitle("Minecraft2D");
        this.setExtendedState(2);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // torna visivel
        this.setVisible(true);

    }

    private ImageIcon getIcon(int tipo) {

        // retorna um uma imagem dependendo do que é pressionado
        switch (tipoBloco[tipo]) {

            case 1:
                // flor
                return bloco1;

            case 2:
                // madeira
                return bloco2;

            case 3:
                // folhas
                return bloco3;
            case 4:
                // terra
                return bloco4;

            case 5:
                // pedra
                return bloco5;

            case 6:
                // terragrama
                return bloco6;

            case 7:
                // diamante
                return bloco7;

            case 8:
                // madeiraprocessada
                return bloco8;

            case 9:
                // outro tipo de madeira
                return bloco9;

            default:
                return fundo;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent key) {

        // movimentacao do personagem
        if (key.getKeyCode() == KeyEvent.VK_RIGHT) {

            meuPainel[posicaopersonagem].setIcon(getIcon(posicaopersonagem));
            posicaopersonagem++;

            if (posicaopersonagem > tamanho - 1)

                posicaopersonagem = 0;
            meuPainel[posicaopersonagem].setIcon(personagem_steve);

        }

        if (key.getKeyCode() == KeyEvent.VK_LEFT) {

            meuPainel[posicaopersonagem].setIcon(getIcon(posicaopersonagem));
            posicaopersonagem--;

            if (posicaopersonagem < 0)
                posicaopersonagem = tamanho - 1;
            meuPainel[posicaopersonagem].setIcon(personagem_steve);

        }

        if (key.getKeyCode() == KeyEvent.VK_DOWN) {

            meuPainel[posicaopersonagem].setIcon(getIcon(posicaopersonagem));
            posicaopersonagem += 20;

            if (posicaopersonagem > 399)
                posicaopersonagem = posicaopersonagem - 399;
            meuPainel[posicaopersonagem].setIcon(personagem_steve);

        }

        if (key.getKeyCode() == KeyEvent.VK_UP) {

            meuPainel[posicaopersonagem].setIcon(getIcon(posicaopersonagem));
            posicaopersonagem -= 20;
            if (posicaopersonagem < 0)
                posicaopersonagem = 399 - (Math.abs(posicaopersonagem));
            meuPainel[posicaopersonagem].setIcon(personagem_steve);

        }

        // caso os numeros dos blocos sejam precionados
        if (key.getKeyCode() == KeyEvent.VK_1) {

            meuPainel[posicaopersonagem].setIcon(bloco1);
            tipoBloco[posicaopersonagem] = 1;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }

        if (key.getKeyCode() == KeyEvent.VK_2) {

            meuPainel[posicaopersonagem].setIcon(bloco3);
            tipoBloco[posicaopersonagem] = 2;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }

        if (key.getKeyCode() == KeyEvent.VK_3) {

            meuPainel[posicaopersonagem].setIcon(bloco3);
            tipoBloco[posicaopersonagem] = 3;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }

        if (key.getKeyCode() == KeyEvent.VK_4) {

            meuPainel[posicaopersonagem].setIcon(bloco4);
            tipoBloco[posicaopersonagem] = 4;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }

        if (key.getKeyCode() == KeyEvent.VK_5) {

            meuPainel[posicaopersonagem].setIcon(bloco4);
            tipoBloco[posicaopersonagem] = 5;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }

        if (key.getKeyCode() == KeyEvent.VK_6) {

            meuPainel[posicaopersonagem].setIcon(bloco4);
            tipoBloco[posicaopersonagem] = 6;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }

        if (key.getKeyCode() == KeyEvent.VK_7) {

            meuPainel[posicaopersonagem].setIcon(bloco4);
            tipoBloco[posicaopersonagem] = 7;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }

        if (key.getKeyCode() == KeyEvent.VK_8) {

            meuPainel[posicaopersonagem].setIcon(bloco4);
            tipoBloco[posicaopersonagem] = 8;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }

        if (key.getKeyCode() == KeyEvent.VK_9) {

            meuPainel[posicaopersonagem].setIcon(bloco4);
            tipoBloco[posicaopersonagem] = 9;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }

        // espaço apaga o bloco
        if (key.getKeyCode() == KeyEvent.VK_SPACE) {

            meuPainel[posicaopersonagem].setIcon(fundo);
            tipoBloco[posicaopersonagem] = 0;

            key.setKeyCode(KeyEvent.VK_RIGHT);
            keyPressed(key);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}