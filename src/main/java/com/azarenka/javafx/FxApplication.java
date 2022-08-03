package com.azarenka.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;

public class FxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(ApplicationStarter.clazz).run();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) {
        applicationContext.publishEvent(new StageEvent(primaryStage));
    }

    public class StageEvent extends ApplicationEvent {

        public StageEvent(Stage primaryStage) {
            super(primaryStage);
        }

        public Stage getStage() {
            return (Stage) getSource();
        }
    }
}
