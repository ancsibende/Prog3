import org.junit.Test;

import javax.swing.*;
import java.io.*;
import static org.junit.Assert.*;

public class NevCompareTest {
    @Test
    public void NevComparatorTest(){
        ReceptKonyv r=new ReceptKonyv();
        Recept rec1= new Recept();
        rec1.setNev("Paradicsomleves");
        Recept rec2= new Recept();
        rec2.setNev("Palacsintatorta");
        r.add(rec1);
        r.add(rec2);
        r.sort(new NevComparator());
        assertEquals("Palacsintatorta",r.get(0).getNev());
    }
}
