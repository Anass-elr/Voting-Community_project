package ma.elrhazi.votingservice.repositories;

import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.CampagneVote;
import ma.elrhazi.votingservice.entities.Country;
import ma.elrhazi.votingservice.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

public interface CampagneRepository extends JpaRepository<CampagneVote,String> {

    List<CampagneVote> findCampagneVoteByGame(Game game);
    List<CampagneVote> findCampagneByGameName(String gameName);
    List<CampagneVote> findCampagneVoteByCountry(Country country);

    List<CampagneVote> deleteCampagneVoteByCountry_Id(String Id);

    List<CampagneVote> deleteCampagneVoteByCountry(Country country);

    List<CampagneVote> findCampagneVoteByGame_Id(String id);
}
