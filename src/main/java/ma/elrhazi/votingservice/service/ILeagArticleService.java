package ma.elrhazi.votingservice.service;

import ma.elrhazi.votingservice.entities.LeagArticle;

public interface ILeagArticleService extends IArticleService<LeagArticle,String>{
    LeagArticle save(LeagArticle leagArticle);

    LeagArticle updateArticle(String Id, LeagArticle leagArticle);
}
