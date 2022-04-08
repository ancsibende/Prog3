import javax.swing.*;
import java.awt.*;

public class Torles extends JPanel {

    JTextField torlendo;
    JButton vissza;
    JButton torol;

    public Torles(ReceptKonyv rk){
        this.setBackground(new Color(212,185,166));
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(layout);
        this.setSize(1280,780);

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel del=new JLabel("Írd be a törölni kívánt recept nevét: ");
        del.setFont(new Font("Courier", Font.BOLD, 14));
        this.add(del, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        torlendo=new JTextField("", 30);
        this.add(torlendo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        vissza=new JButton("Vissza");
        vissza.setFont(new Font("Courier", Font.BOLD, 14));
        vissza.setBackground(new Color(252, 247, 253));
        this.add (vissza,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        torol=new JButton("Törlés");
        torol.setFont(new Font("Courier", Font.BOLD, 14));
        torol.setBackground(new Color(252, 247, 253));
        this.add (torol,gbc);

        this.setVisible(true);

        vissza.addActionListener(e -> {
            removeAll();
            JPanel f = new Fomenu(rk);
            add(f);
            f.repaint();
            f.revalidate();
            f.setVisible(true);
        });

        torol.addActionListener(e -> {
                rk.torol(rk, torlendo.getText().trim(), this);
        });
    }
}
