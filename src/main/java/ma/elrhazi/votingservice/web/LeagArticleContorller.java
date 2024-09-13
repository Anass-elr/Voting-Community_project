package ma.elrhazi.votingservice.web;


import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.LeagArticle;
import ma.elrhazi.votingservice.service.ILeagArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class LeagArticleContorller {
    @Autowired
    private ILeagArticleService articleService;
    @GetMapping("/leagueArticles")
    public List<LeagArticle> articleList(){
        return articleService.getArticles();
    }

    @GetMapping("/leagueArticles/{id}")
    public ResponseEntity<Object> articleById(@PathVariable(value = "id") String id){
        Article ar = articleService.getArticleById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ar);
    }

    @PostMapping("/leagueArticles")
    public ResponseEntity<Object> create(@RequestBody LeagArticle article){
        Article ar  = articleService.save(article);
        if(ar == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Erreur creation Article");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ar);
    }

    @PutMapping("/leagueArticles/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") String id,@RequestBody LeagArticle article){
        Article ar = articleService.getArticleById(id);
        if(ar == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pas d'article");
        }
        articleService.updateArticle(id,article);
        return  ResponseEntity.
                status(HttpStatus.OK)
                .body("Article Modifié");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") String id){
        Article ar = articleService.getArticleById(id);
        if(ar == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).body(null);
        }
        articleService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Article Suprimé : "+ar);
    }

    @GetMapping("/articles/{Campagneid}")
    public ResponseEntity<Object> articleByCampagneId(@PathVariable(value = "Campagneid") String id){
        List<Article> ar = articleService.getArticleByCampagneId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ar);
    }


}
