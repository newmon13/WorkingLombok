package dev.jlipka.workinglombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class WorkingLombokApplication {
    @Autowired
    AuditoriumRepository auditoriumRepository;

    public static void main(String[] args) {
        SpringApplication.run(WorkingLombokApplication.class, args);
    }


    @EventListener(ApplicationStartedEvent.class)
    public void onStartup() {
        Auditorium auditorium = Auditorium.builder()
                .name("Sala 1")
                .capacity(12)
                .screenType(ScreenType.TYPE_2D)
                .auditoriumType(AuditoriumType.REGULAR)
                .build();

        auditoriumRepository.save(auditorium);
    }
}
