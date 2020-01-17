package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Controller.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Main extends Application {

    static Stage dialogStage  ;
    private BorderPane rootLayout;
    public Main() {    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        start();
    }

    public void start() throws FileNotFoundException {
        dialogStage =  new Stage();
        this.dialogStage.setTitle("Outil de Recherche");
        initRootLayout();
    }


    public void initRootLayout() {

        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("View/sample.fxml"));
            rootLayout = (BorderPane) loader.load();
            // Show the scene containing the root layout.

            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);


            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.setResizable(false);
            dialogStage.initModality(Modality.APPLICATION_MODAL);

            Scene scene = new Scene(rootLayout);
            //   Scene scene = new Scene(hb,714,400);
            dialogStage.setScene(scene);
            dialogStage.show();
            //    Toolkit kit = Toolkit.getDefaultToolkit();
            // kit.getImage(getClass().getResource("icon.png"));

            // dialogStage.getIcons().add(new Image("file:icon.png"));
        } catch (IOException e) {

        } catch (Exception e) {

        }
    }



    public static Stage getDialogStage() {
        return dialogStage;
    }










    public static void main(String[] args) {
        launch(args);
    }








}







