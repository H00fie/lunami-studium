package bm.app.lunamistudium;

import bm.app.lunamistudium.technology.techshorts.application.port.TechshortsUseCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ApplicationStartup implements CommandLineRunner {

    private final TechshortsUseCase techshortsUseCase;

    public ApplicationStartup(TechshortsUseCase techshortsUseCase) {
        this.techshortsUseCase = techshortsUseCase;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();
    }

    private void initData() {
        techshortsUseCase.addTechshort(new TechshortsUseCase.CreateTechshortCommand(
                "SYBASE vs HANA.",
                "ABAP",
                "SYBASE is a database system that operates on the application server. Whenever I am using SE11 or SE16N transactions to access the database tables, I am accessing SYBASE. HANA works on an external server.",
                LocalDateTime.now()));
    }

}
