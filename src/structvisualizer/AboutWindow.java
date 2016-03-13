package structvisualizer;

import com.sun.deploy.panel.ExceptionListDialog;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

/**
 * Created by robben1 on 23.02.16.
 */
public class AboutWindow {

    static boolean answer;

    public static boolean display() {
        Stage window  = new Stage(); // пустое окно (stage)

        window.initModality(Modality.APPLICATION_MODAL); // make stage modal (нельзя переключить обратно, не закрыв это)
        window.setTitle("About");
        window.setMinWidth(450);

        Hyperlink githubPage = new Hyperlink();
        githubPage.setText("https://github.com/robben1234/structVisualizer/");
        githubPage.setOnAction(event1 -> {
            try {
                Desktop.getDesktop().browse(new URI(githubPage.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        TextFlow about = new TextFlow(
                new Text("About application\n\nAuthor: Kyrylo Havrylenko\nGithub page of app: "),  githubPage
        );

        Button okay = new Button("Okay");
        okay.setOnAction(event -> window.close());
        okay.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(about, okay);
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // fn+f1 to see documentation | ждет пока окно закроется прежде чем показывать другу сцену

        return answer;
    }


}
