import javax.swing.*;
import java.io.*;
import java.util.*;

public class ReceptKonyv extends ArrayList<Recept> implements Serializable {

   // public ReceptKonyv() {
   // }

    public void kiir_fajlba(String utvonal, ReceptKonyv rk) {
        try {
            FileOutputStream file = new FileOutputStream(utvonal);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(rk);
            out.close();
            file.close();
        } catch (IOException ex) {
            System.out.print("IOException is caught");
        }
    }

    public ReceptKonyv betolt_fajlbol(String utvonal) {
        ReceptKonyv lista = new ReceptKonyv();
        try {
            FileInputStream file = new FileInputStream(utvonal);
            ObjectInputStream in = new ObjectInputStream(file);
            lista = (ReceptKonyv) in.readObject();
            in.close();
            file.close();
        } catch (IOException ex) {
            System.out.print("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.print("ClassNotFoundException is caught");
        }
        lista.sort(new NevComparator());
        return lista;
    }

    public void keres_nev(ReceptKonyv k, String felt, JTextArea t) {
        for (Recept recept : k) {
            if (recept.getNev().contains(felt)) {
                recept.kiir(t, recept);
            }
        }
    }

    public void keres_osszetevok(ReceptKonyv k, String felt, JTextArea t) {
        String[] osszetevok = felt.trim().split("\\s*,\\s*");
        for (Recept recept : k) {
            boolean eredmeny = Arrays.asList(recept.getHozzavalok()).containsAll(Arrays.asList(osszetevok));
            if (eredmeny) {
                recept.kiir(t, recept);
            }
        }
    }

    public void keres_elkido(ReceptKonyv k, String felt, JTextArea t) {
        for (Recept recept : k) {
            int ido = Integer.parseInt(felt);
            if (ido >= recept.getElk_ido()) {
                recept.kiir(t, recept);
            }
        }
    }


    public void kiir(ReceptKonyv rk, JList<String> lista, JTextArea akt, JButton kivalaszt) {
        if (lista.getSelectedIndex() == -1) {
            akt.setText("Nem választott ki elemet! :(");
        } else {
            akt.selectAll();
            akt.replaceSelection("");
            kivalaszt.setEnabled(true);
            int index = lista.getSelectedIndex();
            akt.append("Név:\n" + rk.get(index).getNev() + "\n");
            akt.append("\nHozzávalók:\n" + Arrays.toString(rk.get(index).getHozzavalok()) + "\n");
            akt.append("\nElkészítési idő:\n" + rk.get(index).getElk_ido() + " perc\n");
            akt.append("\nNehézség:\n" + rk.get(index).getNehezseg() + "\n");
            akt.append("\nElkészítés menete:\n" + rk.get(index).getElkeszites());
        }
    }

    public void hozzaad(ReceptKonyv rk, String nev, String[] ot, String nehezs, String ei, String elkeszites, JPanel akt) throws NumberFormatException, NullPointerException {
        int i = Integer.parseInt(ei);
        Recept temp = new Recept(nev, ot, i, nehezs, elkeszites);
        rk.add(temp);
        rk.sort(new NevComparator());
        akt.removeAll();
        JPanel f = new Fomenu(rk);
        akt.add(f);
        f.repaint();
        f.revalidate();
        f.setVisible(true);
    }

    public void torol(ReceptKonyv rk, String torlendo, JPanel akt) {
        boolean sikeres_e = false;
        try {
            if(torlendo.equals("")){
                throw new NullPointerException();
            }else {
                for (int l = 0; l < rk.size(); l++) {
                    if (rk.get(l).getNev().equals(torlendo)) {
                        sikeres_e = true;
                        rk.remove(rk.get(l));
                        JOptionPane.showMessageDialog(akt, "Sikeresen törölte a receptet!");
                    }
                }
                    if (!sikeres_e) {
                        JOptionPane.showMessageDialog(akt, "Ilyen recept nincs a könyvben, így nem tudtuk törölni.");
                    }
                    akt.removeAll();
                    JPanel f = new Fomenu(rk);
                    akt.add(f);
                    f.repaint();
                    f.revalidate();
                    f.setVisible(true);
                }
        }catch(NullPointerException npe){
            JOptionPane.showMessageDialog(akt, "Hiányos mező!");
        }
    }
}



class NevComparator implements Comparator<Recept> {
    @Override
    public int compare(Recept r1, Recept r2) {
        return r1.getNev().compareTo(r2.getNev());
    }
}