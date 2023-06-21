package com.azarenka.javafx;

import com.github.ulisesbocchio.jar.resources.JarResourceLoader;
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
        applicationContext = new SpringApplicationBuilder(ApplicationStarter.clazz)
                .resourceLoader(new JarResourceLoader("classes")).run();
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
}
