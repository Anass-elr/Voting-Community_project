package ma.elrhazi.votingservice.service;

import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.LeagArticle;

import java.util.List;

public interface ILeagArticleService extends IArticleService<LeagArticle,String>{
    LeagArticle save(LeagArticle leagArticle);

    LeagArticle updateArticle(String Id, LeagArticle leagArticle);

    List<Article> getArticleByCampagneId(String id);
}
