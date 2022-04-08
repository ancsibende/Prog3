import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Hozzaad extends JPanel {

    JTextField tf_nev;
    JTextField tf_osszetevok;
    JTextField tf_ei;
    JComboBox<String> nehezseg;
    JTextArea elkeszites;
    JButton vissza;
    JButton mentes;

    public Hozzaad(ReceptKonyv rk){
        this.setBackground(new Color(212,185,166));
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        String[] fokozatok = {"Könnyű", "Közepes", "Nehéz"};
        this.setLayout(layout);

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel nev_l=new JLabel("Név: ");
        nev_l.setFont(new Font("Courier", Font.BOLD, 14));
        this.add(nev_l, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        tf_nev=new JTextField("", 30);
        this.add(tf_nev, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel ot_l=new JLabel("Összetevők: ");
        ot_l.setFont(new Font("Courier", Font.BOLD, 14));
        this.add(ot_l, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        tf_osszetevok = new JTextField("", 30);
        this.add(tf_osszetevok, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel ei_l=new JLabel("Elkészítési idő: ");
        ei_l.setFont(new Font("Courier", Font.BOLD, 14));
        this.add(ei_l, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        tf_ei=new JTextField("", 5);
        this.add(tf_ei,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel nf_l=new JLabel("Nehézségi fokozat: ");
        nf_l.setFont(new Font("Courier", Font.BOLD, 14));
        this.add(nf_l, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        nehezseg= new JComboBox<>(fokozatok);

        this.add(nehezseg, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel em_l=new JLabel("Elkészítés menete: ");
        em_l.setFont(new Font("Courier", Font.BOLD, 14));
        this.add(em_l, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        elkeszites = new JTextArea(15, 20);
        JScrollPane scrollPane = new JScrollPane(elkeszites);
        elkeszites.setLineWrap(true);
        elkeszites.setWrapStyleWord(true);
        this.add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        vissza=new JButton("Vissza");
        vissza.setFont(new Font("Courier", Font.BOLD, 14));
        vissza.setBackground(new Color(252, 247, 253));
        this.add(vissza,gbc);
        gbc.gridx = 2;
        gbc.gridy = 7;
        mentes=new JButton("Mentés");
        mentes.setFont(new Font("Courier", Font.BOLD, 14));
        mentes.setBackground(new Color(252, 247, 253));
        this.add(mentes,gbc);

       this.setVisible(true);

        mentes.addActionListener(e -> {
            String[] ot = tf_osszetevok.getText().trim().split("\\s*,\\s*");
            String nhz= Objects.requireNonNull(nehezseg.getSelectedItem()).toString();
            try {
                if(tf_nev.getText().trim().equals("") || tf_ei.getText().trim().equals("")|| ot.length==1 || elkeszites.getText().equals("")){
                    throw new NullPointerException();
                }
                rk.hozzaad(rk,tf_nev.getText(),ot,nhz,tf_ei.getText(),elkeszites.getText(),this);
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(this, "Az elkészítési idő csak számot tartalmazhat!");
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(this, "Hiányos mező(k)!");
            }

        });

        vissza.addActionListener(e -> {
            removeAll();
            JPanel f=new Fomenu(rk);
            add(f);
            f.repaint();
            f.revalidate();
            f.setVisible(true);
        });
    }
}