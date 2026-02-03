package bettapiac.exu2w1d1;

import bettapiac.exu2w1d1.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Exu2w1d1Application {


    public static void main(String[] args) {

        SpringApplication.run(Exu2w1d1Application.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Exu2w1d1Application.class);

        Menu menu = ctx.getBean(Menu.class);
        menu.printMenu();
    }
}



