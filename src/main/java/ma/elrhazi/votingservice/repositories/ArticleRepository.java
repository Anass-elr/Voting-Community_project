package ma.elrhazi.votingservice.repositories;


import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,String> {
    List<Article> findArticlesByGame(Game game);
    List<Article> findArticlesByGame_Name(String gameName);
}
