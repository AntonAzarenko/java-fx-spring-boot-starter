package com.azarenka.javafx.load;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@Component
public class PropertiesLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesLoader.class);
    private Resource resource;

    public String getProperties(String alias) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(Objects.requireNonNull(resource.getFilename())));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            if (Objects.isNull(resource)) {
                LOGGER.error("Resource shouldn't be NULL");
            }
        }
        return properties.getProperty(alias);
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
