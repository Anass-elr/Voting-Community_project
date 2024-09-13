package ma.elrhazi.votingservice.service;

import ma.elrhazi.votingservice.Exeption.CountryNotFoundException;
import ma.elrhazi.votingservice.dto.CampagneDTO;
import ma.elrhazi.votingservice.dto.GameDTO;
import ma.elrhazi.votingservice.entities.*;

import java.util.Date;
import java.util.List;

public interface ICampagneService {

    List<CampagneDTO> getAll();

    CampagneDTO getById(String id);

    List<CampagneDTO> getCampagneByGame(String gameName);

    List<CampagneDTO> getCampagneByCountry(String countryName);

    CampagneDTO create(Date dateDebut, Date dateFin, String gameName, String countryName,List<String> articlesId);

    CampagneDTO updateCampagne(String id, CampagneDTO campagneDTO);

    CampagneDTO deleteById(String id);

    List<GameDTO> getAllGame();

    List<Game> getAllGames();

    GameDTO getGameById(String id);

    GameDTO saveGame(String name, List<Role> roles);

    GameDTO updateGame(String id, String name, List<Role> roles);


    GameDTO deleteGameById(String id);

    List<Country> getAllCountries();

    Country getCountryById(String Id) throws CountryNotFoundException;

    Country deleteCountryById(String Id)  throws CountryNotFoundException;

    Country saveCountry(String name, String code);

    Country updateCountry(String id, String name, String code) throws CountryNotFoundException;

    List<Article> getSortedArticleByVote(String idCampagne);
}
