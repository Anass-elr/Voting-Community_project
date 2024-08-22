package ma.elrhazi.votingservice.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ma.elrhazi.votingservice.Exeption.ArticleNotFoundException;
import ma.elrhazi.votingservice.Exeption.GameNotFoundExeption;
import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.Game;
import ma.elrhazi.votingservice.repositories.ArticleRepository;
import ma.elrhazi.votingservice.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

@Service
public class ArticleService{

    private ArticleRepository articleRepository;
    private GameRepository gameRepository;

/*
    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article getById(String id) throws  ArticleNotFoundException{
        return articleRepository.findById(id).orElseThrow( () -> new ArticleNotFoundException(""));
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article createValoArticle(Article article){
         return articleRepository.save(article);
    }



    @Override
    public Article createLoFLArticle(Article article) {
        return articleRepository.save(article);

    }

    @Override
    public Article updateArticle(String id, Article article) {
        article.setId(id);
      return articleRepository.save(article);
    }

    @Override
    public Article deleteById(String id) throws ArticleNotFoundException{
        Article ar =getById(id);
        articleRepository.deleteById(id);
        return ar;
    }


    public List<Article> getArticleByGameName(String gameName) {
        Game game = gameRepository.findGameByName(gameName);
        if( game ==null ) throw  new GameNotFoundExeption("GMNFEX");

        return  articleRepository.findArticlesByGame(game);
    }


/*
    public List<ValoArticle> getAllValoArticles() {
        return  getArticleRepository().findAll().stream()
                .filter(ar -> (ar instanceof ValoArticle))
                .map(ar -> (ValoArticle) ar)
                .toList();


*/

}
