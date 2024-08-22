package ma.elrhazi.votingservice.repositories;

import ma.elrhazi.votingservice.entities.LeagArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleLeagRepository extends JpaRepository<LeagArticle ,String> {
}
