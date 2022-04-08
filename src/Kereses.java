import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Kereses extends JPanel {

    JComboBox<String> mitkeres;
    String mit;
    JTextField feltetel;
    JTextArea talalatok;
    String[] k_lehetoseg = {"Név szerint", "Összetevők alapján", "Elkészitési idő szerint"};
    JButton keres;
    JButton vissza;

    public Kereses(ReceptKonyv rk) {
        this.setBackground(new Color(212,185,166));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel label1=new JLabel("Mi alapján szeretnél keresni?");
        label1.setFont(new Font("Courier", Font.BOLD, 14));
        this.add(label1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mitkeres=new JComboBox<>(k_lehetoseg);
        mitkeres.setFont(new Font("Courier", Font.ITALIC, 14));
        this.add(mitkeres, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel label2=new JLabel("Írja be a keresni kívánt szöveget: ");
        label2.setFont(new Font("Courier", Font.BOLD, 14));
        label2.setBackground(new Color(252, 247, 253));
        this.add(label2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        feltetel=new JTextField("",30);
        this.add(feltetel,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel label3=new JLabel("Találatok: ");
        label3.setFont(new Font("Courier", Font.BOLD, 14));
        this.add(label3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        talalatok=new  JTextArea();
        talalatok.setLineWrap(true);
        talalatok.setWrapStyleWord(true);
        talalatok.setEditable(false);
        talalatok.setFont(new Font("Courier", Font.ITALIC, 14));
        JScrollPane scrollPane = new JScrollPane(talalatok);
        scrollPane.setPreferredSize(new Dimension(300, 400));
        this.add(scrollPane,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        vissza = new JButton("Vissza");
        vissza.setFont(new Font("Courier", Font.BOLD, 14));
        vissza.setBackground(new Color(252, 247, 253));
        this.add(vissza, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        keres = new JButton("Keres�s");
        keres.setFont(new Font("Courier", Font.BOLD, 14));
        keres.setBackground(new Color(252, 247, 253));
        this.add(keres, gbc);

        this.setVisible(true);

        keres.addActionListener(e -> {
            mit = Objects.requireNonNull(mitkeres.getSelectedItem()).toString();
            talalatok.selectAll();
            talalatok.replaceSelection("");
            switch (mit) {
            
                case "Név szerint": {
                	rk.keres_nev(rk, feltetel.getText(), talalatok);
                }
                case "Összetevők alapján" :{
                	rk.keres_osszetevok(rk, feltetel.getText(), talalatok);
                }
                case "Elkészitési idő szerint" : {
                	rk.keres_elkido(rk, feltetel.getText(), talalatok);
                }
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