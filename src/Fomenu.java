import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Fomenu extends JPanel {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    public Fomenu(ReceptKonyv rk) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.setBackground(new Color(212,185,166));

        b1=new JButton("Keresés");
        b1.setFont(new Font("Courier", Font.BOLD, 14));
        b1.setBackground(new Color(252, 247, 253));
        b2 = new JButton("Új recept hozzáadása");
        b2.setFont(new Font("Courier",  Font.BOLD, 14));
        b2.setBackground(new Color(252, 247, 253));
        b3 = new JButton("Recept törlése");
        b3.setFont(new Font("Courier", Font.BOLD, 14));
        b3.setBackground(new Color(252, 247, 253));
        b4 = new JButton("Receptek listázása");
        b4.setFont(new Font("Courier", Font.BOLD, 14));
        b4.setBackground(new Color(252, 247, 253));
        b5 = new JButton("Kilépés");
        b5.setFont(new Font("Courier", Font.BOLD, 14));
        b5.setBackground(new Color(252, 247, 253));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(10, 20, 10, 20);
        this.add(b1, gbc);
        gbc.gridy = 1;
        this.add(b2, gbc);
        gbc.gridy = 2;
        this.add(b3, gbc);
        gbc.gridy = 3;
        this.add(b4, gbc);
        gbc.gridy = 4;
        this.add(b5, gbc);

        b1.addActionListener(e -> {
            removeAll();
            JPanel k = new Kereses(rk);
            add(k);
            k.repaint();
            k.revalidate();
            k.setVisible(true);
        });

        b2.addActionListener(e -> {
            removeAll();
            JPanel h = new Hozzaad(rk);
            add(h);
            h.repaint();
            h.revalidate();
            h.setVisible(true);
        });

        b3.addActionListener(e -> {
            removeAll();
            JPanel t = new Torles(rk);
            add(t);
            t.repaint();
            t.revalidate();
            t.setVisible(true);
        });

        b4.addActionListener(e -> {
            removeAll();
            JPanel l = new Listazas(rk);
            add(l);
            l.repaint();
            l.revalidate();
            l.setVisible(true);
        });

        b5.addActionListener(e -> {
            JFrame f = new JFrame("Kilépés");
            Object[] valasztas = {"Igen", "Mégse"};
            Object alap = valasztas[0];
            if (JOptionPane.showOptionDialog(f, "Biztosan bezárod a programot?", "Kilépés",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, valasztas, alap) == JOptionPane.YES_OPTION) {
                rk.kiir_fajlba("receptek.ser", rk);
                System.exit(0);
            }
        });
    }
}
