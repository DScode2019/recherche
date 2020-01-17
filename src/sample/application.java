package sample;


import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class application {
    private File di;
    private File fl[];
    private Vector v;
    private static Pattern pattern;
    private static Matcher matcher;



    public static void main(String[] args) {
        File repertoire = new File("C:/test");
        String liste[] = repertoire.list();
        String msg="";
        if (liste != null) {
            for (int i = 0; i < liste.length; i++) {
                if(liste[i].endsWith(".txt")||liste[i].endsWith(".TXT")){
                    try{
                        InputStream ips=new FileInputStream("C:/test/"+liste[i]);
                        InputStreamReader ipsr=new InputStreamReader(ips);
                        BufferedReader br=new BufferedReader(ipsr);
                        String ligne="",S="hh";
                        int ctr = 0;

                        while ((ligne = br.readLine()) != null) {
                            ctr++;

                            if (ligne.contains(S)){
                                if (ligne.contains(S)){

                                    msg+="Ligne"+ctr+" fichier"+liste[i];
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

System.out.println(msg);
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }
    }

}
