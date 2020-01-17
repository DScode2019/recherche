package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import sample.Main;

import java.io.*;

public class Controller {
Main logoApp;
    @FXML
    Button click;
    @FXML
    TextField pathe;
    @FXML
    TextField mot;

    public void setMainApp(Main logoApp1) throws Exception {
        this.logoApp = logoApp1;
    }


@FXML
 public void directory(){
    final DirectoryChooser directoryChooser = new DirectoryChooser();
    File dir = directoryChooser.showDialog(logoApp.getDialogStage());
    if (dir != null) {
        pathe.setText(dir.getAbsolutePath());
    } else {
        pathe.setText(null);
    }
}
    @FXML
    public void recherche(){
        String dossier=pathe.getText();
        String motrech=mot.getText();
        File repertoire = new File(dossier);
        String liste[] = repertoire.list();
        String msg="";

        if (liste != null) {
            for (int i = 0; i < liste.length; i++) {
                if(liste[i].endsWith(".txt")||liste[i].endsWith(".TXT")){
                    try{
                        InputStream ips=new FileInputStream(dossier+"/"+liste[i]);
                        InputStreamReader ipsr=new InputStreamReader(ips);
                        BufferedReader br=new BufferedReader(ipsr);
                        String ligne="";
                        int ctr = 0;
                        while ((ligne = br.readLine()) != null) {
                            ctr++;
                            if (ligne.contains(motrech)){

                                msg+="Ligne "+ctr+" fichier "+liste[i];
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information Dialog");
            alert.setContentText(msg);
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Nom de repertoire invalide");
            alert.showAndWait();
        }
    }
}
