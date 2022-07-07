package com.example.springjavafx;

import com.example.springjavafx.controllers.LoginController;
import com.gluonhq.ignite.spring.SpringContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;

import java.net.URL;

@Slf4j
@SpringBootApplication
@ComponentScan({
        "com.gluonhq.ignite.spring",
        "com.example.springjavafx"
})
public class SpringJavaFxApplication extends Application{

    @Autowired
    private FXMLLoader loader;

    private final SpringContext context = new SpringContext(this);

    @Value("${loginScene}")
    public Resource loginScene;

    public static void main(String[] args) {
        Application.launch(SpringJavaFxApplication.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        context.init(() -> SpringApplication.run(SpringJavaFxApplication.class));
        URL url = loginScene.getURL();
        loader.setLocation(url);
        Parent primaryView = loader.load();
        Scene scene = new Scene(primaryView);
        stage.setTitle("JavaFXSpring");
        stage.setScene(scene);
        stage.show();
    }

//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost/finalproject");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("12345678");
//        return dataSourceBuilder.build();
//    }
}
