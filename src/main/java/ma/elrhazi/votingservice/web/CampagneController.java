package ma.elrhazi.votingservice.web;

import ma.elrhazi.votingservice.Exeption.CampagneNotFoundException;
import ma.elrhazi.votingservice.Exeption.GameNotFoundExeption;
import ma.elrhazi.votingservice.dto.CampagneDTO;
import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.CampagneVote;
import ma.elrhazi.votingservice.service.ICampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CampagneController {

    @Autowired
    private ICampagneService service;

    @GetMapping("/campagnes")
    public List<CampagneDTO> getAll(){
        return service.getAll();
    }


    @GetMapping("/campagnes/byGame/{name}")
    public ResponseEntity<Object> getByGameName(@PathVariable(value="name") String name){
        List<CampagneDTO> cp = service.getCampagneByGame(name);
        if(cp == null){
            ResponseEntity<Object> body = ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Campagne with name : " + name + " doesn't exist");
            return body;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }


    @GetMapping("/campagnes/byCountry/{country}")
    public ResponseEntity<Object> getByCountryName(@PathVariable(value="country") String country){
        List<CampagneDTO> cp = service.getCampagneByCountry(country);
        if(cp == null){
            ResponseEntity<Object> body = ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Campagne with Country name : " + country + " doesn't exist");
            return body;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }




    @GetMapping("/campagnes/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value="id") String id){
        Object cp = service.getById(id);
        if(cp == null){
            ResponseEntity<Object> body = ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Campagne with id= " + id + " doesn't exist");
            return body;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }

    @GetMapping("/campagnes/ResultatVote/{id}")
    public ResponseEntity<Object> getResultatVoteByCampagne(@PathVariable(value="id") String idCampagne){
        List<Article> cp = service.getSortedArticleByVote(idCampagne);
        if(cp == null){
            ResponseEntity<Object> body = ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("");
            return body;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }

    @PostMapping("/campagnes")
    public ResponseEntity<Object> createCampagne(@RequestBody CampagneDTO campagneDTO) throws GameNotFoundExeption {
        CampagneDTO cp= service.create(campagneDTO.getDateDebut()
                                        ,campagneDTO.getDateFin(),
                                         campagneDTO.getGameName()
                                        ,campagneDTO.getCountryName()
                                        ,campagneDTO.getArticlesSelectedId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Campagne Ajouté avec succes");
    }

    @DeleteMapping("/campagnes/{id}")
    public ResponseEntity<Object> deleteCampagne(@PathVariable(name = "id") String id) throws CampagneNotFoundException {
        CampagneDTO cp = service.deleteById(id);

        return ResponseEntity.
                status(HttpStatus.OK)
                .body(cp);
    }

    @PutMapping("/campagnes/{id}")
    public ResponseEntity<Object> updateCampagne(@PathVariable(name = "id") String id,@RequestBody CampagneDTO campagneDTO)
      throws GameNotFoundExeption{
         CampagneDTO cp = service.getById(id);
            if(cp == null) {
                return ResponseEntity.
                      status(HttpStatus.NOT_FOUND)
                        .body("Pas de Compagne");
            }
           cp= service.updateCampagne(id,campagneDTO);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Campagne Modifié");
    }




}
