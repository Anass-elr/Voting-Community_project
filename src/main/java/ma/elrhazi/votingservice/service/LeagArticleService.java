package ma.elrhazi.votingservice.service;

import lombok.AllArgsConstructor;
import ma.elrhazi.votingservice.Exeption.ArticleNotFoundException;
import ma.elrhazi.votingservice.Exeption.CampagneNotFoundException;
import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.CampagneVote;
import ma.elrhazi.votingservice.entities.Game;
import ma.elrhazi.votingservice.entities.LeagArticle;
import ma.elrhazi.votingservice.repositories.ArticleLeagRepository;
import ma.elrhazi.votingservice.repositories.ArticleRepository;
import ma.elrhazi.votingservice.repositories.CampagneRepository;
import ma.elrhazi.votingservice.repositories.GameRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class LeagArticleService implements ILeagArticleService{


    ArticleLeagRepository articleLeagRepository;
    ArticleRepository  articleRepository;
    GameRepository gameRepository;
    CampagneRepository campagneRepository;

    @Override
    public List<LeagArticle> getArticles() {
        return articleLeagRepository.findAll();
    }

    @Override
    public LeagArticle getArticleById(String id) throws ArticleNotFoundException {
        return articleLeagRepository.findById(id).orElseThrow(
                ()-> new ArticleNotFoundException("ANFE")
        );
    }

    @Override
    public LeagArticle deleteById(String id) {
        LeagArticle lg = getArticleById(id);
         articleRepository.delete(lg);
         return  lg;
    }

    @Override
    public List<LeagArticle> getArticlesByGameName(String id) {
        return null;
    }



    @Override
    public List<Article> getArticleByCampagneId(String id) {
        CampagneVote campagneVote =campagneRepository.findById(id).orElseThrow(()-> new CampagneNotFoundException(""));
        return campagneVote.getArticles();
    }

    @Override
    public LeagArticle save(LeagArticle leagArticle){
        Game  gm = gameRepository.findGameByName("LeagueOL");
        leagArticle.setGame(gm);
        List<CampagneVote> campagneVotes = campagneRepository
                                    .findCampagneByGameName("LeagueOL");

      LeagArticle  lg= articleLeagRepository.save(leagArticle);

        for (CampagneVote campagneVote : campagneVotes) {
            campagneVote.getArticles().add(lg);
        }
        campagneRepository.saveAll(campagneVotes);
        return  lg;
    }

    @Override
    public LeagArticle updateArticle(String Id, LeagArticle leagArticle){
        LeagArticle lg = getArticleById(Id);
        leagArticle.setId(Id);
        return articleLeagRepository.save(leagArticle);
    }



}
