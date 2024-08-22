package ma.elrhazi.votingservice.repositories;

import ma.elrhazi.votingservice.entities.Membre;
import ma.elrhazi.votingservice.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote,String> {

    List<Vote> findVotesByMembre(Membre membre);
}
