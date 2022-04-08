import junit.framework.AssertionFailedError;
import org.junit.Test;

import javax.swing.*;
import java.io.*;
import static org.junit.Assert.*;

public class ReceptKonyvTest {
    ReceptKonyv r1=new ReceptKonyv();
    ReceptKonyv r2=new ReceptKonyv();

    @Test
   public void betolt_fajlbolTest1(){
       r1=r1.betolt_fajlbol("file.ser");
        assertEquals("Aranygaluska",r1.get(0).getNev());
        assertEquals("Diós bejgli",r1.get(1).getNev());
    }
     @Test
    public void betolt_fajlbolTest2()throws IOException{
         ByteArrayOutputStream outContent = new ByteArrayOutputStream();
         System.setOut(new PrintStream(outContent));
         r2=r2.betolt_fajlbol("valami.ser");
         String expectedOutput  = "IOException is caught"; // Notice the \n for new line.
         assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void kiirTest(){
        JList<String> l=new JList<>();
        JTextArea ta=new JTextArea();
        JButton klikk=new JButton();
        r1.kiir(r1,l,ta,klikk);
        assertEquals("Nem választott ki elemet! :(",ta.getText());
    }
    @Test
    public void hozzaadTest(){
        r1=r1.betolt_fajlbol("file.ser");
        String[] mit={"kávé","tej", "babapiskóta"};
        JPanel l=new JPanel();
        r1.hozzaad(r1,"Tiramisu",mit,"Közepes","45","Könnyen megy ez.",l);
        assertEquals("Tiramisu",r1.get(2).getNev());
    }
    @Test
    public void torlesTest(){
        r1.betolt_fajlbol("file.ser");
        JPanel l=new JPanel();
        r1.torol(r1,"Aranygaluska",l);
        for (Recept recept : r1) {
            assertNotEquals("Aranygaluska", recept.getNev());
        }
    }
}
