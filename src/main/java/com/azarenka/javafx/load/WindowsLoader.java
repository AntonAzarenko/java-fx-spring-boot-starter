package com.azarenka.javafx.load;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class WindowsLoader {

    private ApplicationContext applicationContext;

    public WindowsLoader(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void initializeWindows() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanName);
            if (bean instanceof IFxmlWindow) {
                ((IFxmlWindow) bean).load();
            }
        }
    }
}
