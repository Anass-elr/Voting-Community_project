package ma.elrhazi.votingservice.service;

import ma.elrhazi.votingservice.Exeption.ArticleNotFoundException;
import ma.elrhazi.votingservice.entities.Article;

import java.util.List;

public interface IArticleService<T,A>{
   List<T> getArticles();
   T getArticleById(A id);
   T deleteById(A id);
}
