import org.junit.*;
import javax.swing.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ReceptTest {
    String[] hozz={"mák","cukor","kifli","fahéj","tej"};
    Recept r1=new Recept("Mákosguba",hozz,45,"Könnyű","Egyszerű, mint az egyszer egy.");

    @Test
    public void testReceptgetHozzavalok(){
        String hozz1= Arrays.toString(r1.getHozzavalok());
        assertEquals(hozz1, Arrays.toString(r1.getHozzavalok()));
    }
    @Test
    public void testReceptsetNev(){
        Recept r2=new Recept();
        r2.setNev("Aranygaluska");
        assertEquals("Aranygaluska",r2.getNev());
    }
    @Test
    public void testReceptsetElkido(){
        Recept r3=new Recept();
        r3.setElk_ido(24);
        assertEquals(24,r3.getElk_ido());

    }

    @Test
    public void testReceptkiir(){
        JTextArea t1=new JTextArea();
        r1.kiir(t1,r1);
        assertEquals("Név:\nMákosguba\n\nHozzávalók:\n[mák, cukor, kifli, fahéj, tej]\n\nElkészítési idő:\n45 perc\n\nNehézség:\nKönnyű\n\nElkészítés menete:\nEgyszerű, mint az egyszer egy.\n------------------------------------------------------------------\n",t1.getText());

    }
}
