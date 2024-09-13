package ma.elrhazi.votingservice.service;

import lombok.AllArgsConstructor;
import ma.elrhazi.votingservice.Exeption.ArticleNotFoundException;
import ma.elrhazi.votingservice.Exeption.GameNotFoundExeption;
import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.Game;
import ma.elrhazi.votingservice.repositories.ArticleRepository;
import ma.elrhazi.votingservice.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ArticleService implements IArticleService<Article,String>{

    private ArticleRepository articleRepository;
    private GameRepository gameRepository;
    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(String id) {
        return articleRepository.findById(id).orElseThrow( () -> new ArticleNotFoundException(""));
    }

    @Override
    public Article deleteById(String id) {
        Article ar = getArticleById(id);
        articleRepository.delete(ar);
        return ar;
    }

    @Override
    public List<Article> getArticlesByGameName(String name) {
        Game gm = gameRepository.findGameByName(name);
        if(gm == null) throw new GameNotFoundExeption("");
        return  articleRepository.findArticlesByGame_Name(name);
    }




}
