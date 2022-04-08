import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Menu extends JFrame {
    public Menu() throws IOException {
        super("Receptkönyv");
        ReceptKonyv rk= new ReceptKonyv();
        rk=rk.betolt_fajlbol("receptek.ser");
        BufferedImage img = ImageIO.read(new File("hatter1.jpg"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JLabel(new ImageIcon(img)));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel fmenu= new Fomenu(rk);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        this.add(fmenu);
        this.setVisible(true);
    }
}
