package ma.elrhazi.votingservice.repositories;

import ma.elrhazi.votingservice.entities.ValoArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleValoRepository extends JpaRepository<ValoArticle, String> {
}
