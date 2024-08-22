package ma.elrhazi.votingservice.web;

import ma.elrhazi.votingservice.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public class ArticleRestController {
/*
    @Autowired
    private IArticleService articleService;

    @GetMapping("/all")
    public List<Article> articleList(){
        return articleService.getAll();
    }

    /*
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> articleById(@PathVariable(value = "id") String id){

        Article ar = articleService.getById(id);

        if(ar == null) { return ResponseEntity
                              .status(HttpStatus.NOT_FOUND)
                              .body("Pas d'article");}

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ar);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Article article){
        Article ar  = articleService.create(article);
        if(ar == null){}
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ar);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") String id,@RequestBody Article article){
        Article ar = articleService.getById(id);
        if(ar == null) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pas d'article");
        }
        articleService.update(id,article);
        return  ResponseEntity.
                status(HttpStatus.OK)
                .body("Article Modifié");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") String id){
        Article ar = articleService.getById(id);
        if(ar == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).body(null);
        }
        articleService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Article Suprimé");
    }

    */

}
