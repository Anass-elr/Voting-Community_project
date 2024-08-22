package ma.elrhazi.votingservice.web;

import lombok.AllArgsConstructor;
import ma.elrhazi.votingservice.dto.CampagneDTO;
import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.Membre;

import ma.elrhazi.votingservice.entities.Vote;
import ma.elrhazi.votingservice.service.IMembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MembreRestController {

    @Autowired
    private IMembreService membreService;

    @GetMapping("/membres")
    public List<Membre> memberList(){ return membreService.getMembres();}

    @GetMapping("/membres/{id}")
    public Membre memberById(@PathVariable String id) {
        return membreService.getMembreById(id);
    }

    @GetMapping("/membres/byName")
    public List<Membre> memberByName(@RequestParam(name = "name") String name) {
        return membreService.getMembresByName(name);
    }


    @GetMapping("/membresCampagne/{id}")
    public ResponseEntity<Object> getCampagneVotedByMembre(@PathVariable String id) {
         Map<CampagneDTO,Article> map= membreService.getCampagneVotedByMembreId(id);

        return  ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @PostMapping("/membres/vote")
    public Vote voteMembre(@RequestParam(name = "id")          String id,
                           @RequestParam(name = "idCampagne")  String idCamp,
                           @RequestParam(name = "idArticle")   String idArticle){
        return membreService.vote(id,idCamp,idArticle);
    }


    @PostMapping("/membres")
    public Membre addMembre(@RequestBody Membre membre){
        return membreService.createMembre(membre.getName(),membre.getPrenom()
                            ,membre.getDateNaissance());
    }

    @PutMapping("membres/{id}")
    public Membre updateMembre(@PathVariable(name = "id") String Id, Membre updateMembre){
            return membreService.updatMembre(Id,updateMembre.getName(),
                                      updateMembre.getPrenom(),
                                      updateMembre.getDateNaissance());
    }

    @DeleteMapping("membres/{id}")
    public Membre deleteMembre(@PathVariable(name = "id") String Id){
        return membreService.deleteMembre(Id);
    }








}

