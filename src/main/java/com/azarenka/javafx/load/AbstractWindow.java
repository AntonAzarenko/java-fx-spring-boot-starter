package com.azarenka.javafx.load;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractWindow {

    private String title;
    private double width = 640d;
    private double height = 420d;
    private String image;

    public void setSize(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public void setIcon(String image) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    protected double getWidth() {
        return width;
    }

    protected double getHeight() {
        return height;
    }
}
