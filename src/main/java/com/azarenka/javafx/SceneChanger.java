package com.azarenka.javafx;

import com.azarenka.javafx.load.CommonWidget;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class SceneChanger extends StageInitializer {

    private final List<Stage> stages = new ArrayList<>();

    public void setNewScene(CommonWidget widget) {
        Scene scene = widget.getScene();
        Stage stage = getStage();
        stage.setScene(scene);
        stage.show();
    }

    public void showModalWindow(CommonWidget widget) {
        Stage dialog = new Stage();
        stages.add(dialog);
        dialog.getIcons().addAll(getStage().getIcons());
        dialog.setTitle(widget.getTitle());
        dialog.initOwner(getStage());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setScene(widget.getScene());
        dialog.show();
    }

    public void closeWindow(CommonWidget widget) {
        Scene scene = widget.getScene();
        Optional<Stage> first = stages.stream().filter(s -> Objects.equals(s.getScene(), scene)).findFirst();
        first.ifPresent(Stage::close);
    }
}
