package ma.elrhazi.votingservice.repositories;

import ma.elrhazi.votingservice.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game,String> {
    Game findGameByName(String name);

}
