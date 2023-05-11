package cn.lemon.generator;

import cn.lemon.generator.runner.Runner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JimmerGeneratorApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(JimmerGeneratorApplication.class, args);
        try {
            ctx.getBean(Runner.class).process();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
