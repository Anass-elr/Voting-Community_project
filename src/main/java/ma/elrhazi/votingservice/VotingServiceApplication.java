package ma.elrhazi.votingservice;

import lombok.AllArgsConstructor;
import ma.elrhazi.votingservice.entities.CampagneVote;
import ma.elrhazi.votingservice.entities.Game;
import ma.elrhazi.votingservice.entities.LeagArticle;
import ma.elrhazi.votingservice.repositories.ArticleLeagRepository;
import ma.elrhazi.votingservice.repositories.CampagneRepository;
import ma.elrhazi.votingservice.repositories.GameRepository;
import ma.elrhazi.votingservice.service.ICampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;
import java.util.stream.Stream;



@SpringBootApplication
public class VotingServiceApplication implements CommandLineRunner {

    @Autowired
    ICampagneService service;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    CampagneRepository campagneRepository;

    @Autowired
    ArticleLeagRepository articleLeagRepository;

    public static void main(String[] args) {
        SpringApplication.run(VotingServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       CampagneVote cp= CampagneVote.builder().id(String.valueOf(UUID.randomUUID()))
                                                .dateDebut(new Date())
                                                .dateFin(new Date()).build(),
                    cp1 =  CampagneVote.builder()
                                .id(String.valueOf(UUID.randomUUID()))
                                .dateDebut(new Date())
                            .dateFin(new Date()).build();

        Stream.of("Valorant","LeagueOL")
                .forEach(name -> service.saveGame(name,null));

        Game gm = gameRepository.findGameByName("LeagueOL");
        LeagArticle ar1 = LeagArticle.builder().gameName("Player1").level(10).wins(80).losses(30).build(),
         ar2 =LeagArticle.builder().gameName("Player2").level(10).wins(80).losses(30).build();

        ar1.setGame(gm);
        ar2.setGame(gm);

        articleLeagRepository.save(ar1);
        articleLeagRepository.save(ar2);


        Stream.of("Maroc","Algeria","Egypt").forEach(
                country -> service.saveCountry(country,country.substring(0,2)));

        gameRepository.findAll().forEach( game -> {
            Date d1= new Date(2024,8,18),
                 d2 = new Date(2024,8,d1.getDay()+10);

            Date d21= new Date(2024,9,18),
                    d22 = new Date(2024,9,d21.getDay()+10);


        });


    }


}
