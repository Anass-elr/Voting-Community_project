package ma.elrhazi.votingservice.web;

import ma.elrhazi.votingservice.dto.GameDTO;
import ma.elrhazi.votingservice.entities.Game;
import ma.elrhazi.votingservice.service.ICampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameRestController {

    @Autowired
    private ICampagneService service;

    @GetMapping("/games")
    public List<GameDTO> getAll(){ return service.getAllGame();}

    @GetMapping("/games/{id}")
    public ResponseEntity<Object> getGameById(@PathVariable(value="id") String id){
        GameDTO cp = service.getGameById(id);
        if(cp == null){
            ResponseEntity<Object> body = ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Game with id= " + id + " doesn't exist");
            return body;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }

    @PostMapping("/games")
    public ResponseEntity<Object> saveGame(@RequestBody GameDTO gameDTO){
        GameDTO cp = service.saveGame(gameDTO.getName(),null);
        if(cp == null){
            ResponseEntity<Object> body = ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Error game creation");
            return body;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }

    @PutMapping("/games/{id}")
    public ResponseEntity<Object> updateGame(@PathVariable(value="id") String id ,@RequestBody  GameDTO gameDTO){
        GameDTO cp = service.updateGame(id,gameDTO.getName(),null);
        if(cp == null){
            ResponseEntity<Object> body = ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Error game creation");
            return body;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }

    @DeleteMapping("/games/{id}")
    public ResponseEntity<Object> deleteGame(@PathVariable(value="id") String id){
        GameDTO cp = service.deleteGameById(id);
        if(cp == null){
            ResponseEntity<Object> body = ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Error game creation");
            return body;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }

}
