package com.azarenka.javafx;

import com.azarenka.javafx.FxApplication.StageEvent;
import com.azarenka.javafx.load.CommonWidget;
import com.azarenka.javafx.load.WindowsLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public abstract class StageInitializer implements ApplicationListener<StageEvent> {

    @Autowired
    private WindowsLoader windowsLoader;
    private CommonWidget commonWidget;
    private static Stage stage;
    private String icon;

    @Override
    public void onApplicationEvent(StageEvent stageEvent) {
        stage = stageEvent.getStage();
        windowsLoader.initializeWindows();
        if (Objects.nonNull(commonWidget)) {
            commonWidget.load();
            Scene scene = commonWidget.getScene();
            setUpScene(scene);
        } else {

        }
        stage.setIconified(false);
        stage.show();
    }

    public void setCommonWidget(CommonWidget commonWidget) {
        this.commonWidget = commonWidget;
    }

    Stage getStage() {
        return stage;
    }

    protected void setIcon(String icon) {
        this.icon = icon;
    }

    protected String getIcon() {
        return icon;
    }

    private void setUpScene(Scene scene) {
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.getIcons().add(new Image(icon));
        stage.setTitle(commonWidget.getTitle());
    }
}