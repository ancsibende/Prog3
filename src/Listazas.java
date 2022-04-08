import javax.swing.*;
import java.awt.*;

public class Listazas extends JPanel {
    JList<String> lista;
    JTextArea akt;
    JButton vissza;
    JButton kivalaszt;

    public Listazas(ReceptKonyv rk){
        this.setBackground(new Color(212,185,166));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        lista = new JList<>(listModel);
        lista.setFont(new Font("Courier", Font.BOLD, 14));
        JScrollPane listScroller = new JScrollPane(lista);
        listScroller.setPreferredSize(new Dimension(180, 400));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(10,20,10,20);
        this.add(listScroller,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        kivalaszt=new JButton("Kiválaszt");
        kivalaszt.setFont(new Font("Courier", Font.BOLD, 14));
        kivalaszt.setBackground(new Color(252, 247, 253));
        this.add(kivalaszt,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        akt=new JTextArea();
        akt.setLineWrap(true);
        akt.setWrapStyleWord(true);
        akt.setEditable(false);
        akt.setFont(new Font("Courier", Font.ITALIC, 13));
        JScrollPane scrollPane = new JScrollPane(akt);
        scrollPane.setPreferredSize(new Dimension(300, 400));
        this.add(scrollPane,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        vissza=new JButton("Vissza");
        vissza.setFont(new Font("Courier", Font.BOLD, 14));
        vissza.setBackground(new Color(252, 247, 253));
        this.add(vissza,gbc);

        for (Recept recept : rk) {
            listModel.addElement(recept.getNev());
        }

        this.setVisible(true);

        vissza.addActionListener(e -> {
            removeAll();
            JPanel f=new Fomenu(rk);
            add(f);
            f.repaint();
            f.revalidate();
            f.setVisible(true);
        });

        kivalaszt.addActionListener(e -> {
            rk.kiir(rk,lista,akt,kivalaszt);
        });
    }
}
