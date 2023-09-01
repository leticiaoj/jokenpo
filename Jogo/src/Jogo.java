import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Jogo extends JFrame implements ActionListener {

    private JLabel labelEscolha;
    private JLabel labelComputer;
    private JLabel labelText;
    private JLabel labelResultado;
    private JButton botaoJogar;
    private JComboBox combo;
    int intSelecaoJogador;

    public static void main(String[] args) {
        new Jogo();
    }

    public Jogo() {
        JFrame frame = new JFrame();

        labelComputer = new JLabel("", JLabel.CENTER);
        labelResultado = new JLabel("", JLabel.CENTER);
        labelResultado.setForeground(Color.BLUE);

        labelEscolha = new JLabel("Escolha: ");

        String strItens[] = {"Pedra", "Papel", "Tesoura"};
        combo = new JComboBox(strItens);
        combo.setEditable(false);
        combo.addActionListener(this);

        botaoJogar = new JButton("Jogar");
        botaoJogar.addActionListener(this);

        frame.setLayout(new GridLayout(0, 1));
        frame.add(labelEscolha);
        frame.add(combo);
        frame.add(botaoJogar);
        frame.add(labelComputer);
        frame.add(labelResultado);

        frame.setSize(300, 400);
        frame.setTitle("JokenPô");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoJogar) {
            Jogar();
        } else {
            JComboBox cb = (JComboBox) e.getSource();
            intSelecaoJogador = cb.getSelectedIndex();
        }
    }

    public void Jogar() {
        Random gerador = new Random();
        int intSelecaoComp = gerador.nextInt(3);

        labelComputer.setText("");

        switch (intSelecaoComp) {
            case 0:
                labelComputer.setText("O computador escolheu Pedra.");
                break;
            case 1:
                labelComputer.setText("O computador escolheu Papel.");
                break;
            case 2:
                labelComputer.setText("O computador escolheu Tesoura.");
                break;
        }

        labelResultado.setText("");

        if (intSelecaoComp == intSelecaoJogador) {
            labelResultado.setText("Deu empate.");
        } else if ((intSelecaoJogador == 0 && intSelecaoComp == 2) ||
                   (intSelecaoJogador == 1 && intSelecaoComp == 0) ||
                   (intSelecaoJogador == 2 && intSelecaoComp == 1)) {
            labelResultado.setText("Você venceu!");
        } else if ((intSelecaoJogador == 2 && intSelecaoComp == 0) ||
                   (intSelecaoJogador == 0 && intSelecaoComp == 1) ||
                   (intSelecaoJogador == 1 && intSelecaoComp == 2)) {
            labelResultado.setText("O computador venceu.");
        }
    }
}
