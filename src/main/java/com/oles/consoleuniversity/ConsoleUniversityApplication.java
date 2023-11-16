package com.oles.consoleuniversity;

import com.oles.consoleuniversity.service.impl.CommandRunnerImpl;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.oles.consoleuniversity.utils.UtilsString.CONSOLE_UNIVERSITY_LOGO;

@SpringBootApplication
public class ConsoleUniversityApplication implements CommandLineRunner {

    @Autowired
    private CommandRunnerImpl commandRunnerImpl;

    public static void main(String[] args) {
        SpringApplication.run(ConsoleUniversityApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CONSOLE_UNIVERSITY_LOGO);
        commandRunnerImpl.runCommand("info");
        while (true) {
            String s = scanner.nextLine();
            commandRunnerImpl.runCommand(s);
        }
    }
}
