package ma.elrhazi.votingservice.web;

import ma.elrhazi.votingservice.Exeption.CountryNotFoundException;
import ma.elrhazi.votingservice.dto.GameDTO;
import ma.elrhazi.votingservice.entities.Country;
import ma.elrhazi.votingservice.service.ICampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CountryRestController {

    @Autowired
    private ICampagneService service;


    @GetMapping("/countries")
    public List<Country> getAll(){
        return service.getAllCountries();
    }


    @GetMapping("/countries/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value="id") String id) throws CountryNotFoundException {
        Object cp = service.getCountryById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }

    @PostMapping("/countries")
    public ResponseEntity<Object> saveCountry(@RequestBody Country country){
        Country cp = service.saveCountry(country.getName(),country.getCode());

        if(cp == null){
            ResponseEntity<Object> body = ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Error Country creation");
            return body;
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }


    @PutMapping("/countries/{id}")
    public ResponseEntity<Object> updateCountry(@PathVariable(name = "id") String id,
                                                @RequestBody Country country) throws CountryNotFoundException{

        Country cp = service.updateCountry(id,country.getName(),country.getCode());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp);
    }

    @DeleteMapping("/countries/{id}")
    public ResponseEntity<Object> deleteCountry(@PathVariable(name = "id") String id) throws CountryNotFoundException{
        Country cp = service.deleteCountryById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cp.getId());
    }
}
