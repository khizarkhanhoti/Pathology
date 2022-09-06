package com.example.springjavafx;

import com.example.springjavafx.entities.User;
import com.example.springjavafx.helpers.Helper;
import com.example.springjavafx.repositories.UserRepository;
import com.gluonhq.ignite.spring.SpringContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;

import java.util.List;

@Slf4j
@SpringBootApplication
@ComponentScan({
        "com.gluonhq.ignite.spring",
        "com.example.springjavafx"
})
public class SpringJavaFxApplication extends Application{
    
    @Autowired
    private  FXMLLoader loader;
    @Autowired
    private UserRepository userRepository;
    
    private Helper helper = new Helper();
    
    private final SpringContext context = new SpringContext(this);

    @Value("${loginScene}")
    public Resource loginScene;
   
    
    public static void main(String[] args) {
        Application.launch(SpringJavaFxApplication.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        context.init(() -> SpringApplication.run(SpringJavaFxApplication.class));
        loader.setLocation(loginScene.getURL());
        Parent parent = loader.load();
        stage.setOnCloseRequest(windowEvent -> {
            onClose(stage);
            windowEvent.consume();
        });
        
        helper.initStage(stage, loginScene, parent);
    }
    
    public void onClose(Stage stage){
        List<User> userList = userRepository.findAll();
        for (User user : userList){
            user.setActive(false);
            userRepository.save(user);
        }
        stage.close();
    }
    
}
