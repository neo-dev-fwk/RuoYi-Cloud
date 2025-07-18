package com.ruoyi.test1;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统模块
 *
 * @author ruoyi
 */
@SpringBootApplication
@RefreshScope
@RestController
@EnableRyFeignClients
@EnableCustomConfig
@EnableCustomSwagger2
public class RuoYiTest1Application {
    public static void main(String[] args) {
        SpringApplication.run(RuoYiTest1Application.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Test1模块   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }


    @Value("${aa}")
    private String aa;


    @GetMapping("/test2")
    public void test() {
        System.out.println(aa);
    }


}
