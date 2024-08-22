package ma.elrhazi.votingservice.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.elrhazi.votingservice.Exeption.CampagneNotFoundException;
import ma.elrhazi.votingservice.Exeption.CountryNotFoundException;
import ma.elrhazi.votingservice.Exeption.GameNotFoundExeption;
import ma.elrhazi.votingservice.dto.CampagneDTO;
import ma.elrhazi.votingservice.dto.GameDTO;
import ma.elrhazi.votingservice.entities.*;
import ma.elrhazi.votingservice.mapper.cdeMapper.CampagneMapper;
import ma.elrhazi.votingservice.mapper.cdeMapper.GameMapper;
import ma.elrhazi.votingservice.repositories.ArticleRepository;
import ma.elrhazi.votingservice.repositories.CampagneRepository;
import ma.elrhazi.votingservice.repositories.CountryRepository;
import ma.elrhazi.votingservice.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Transactional
@Slf4j

@Service
public class CampagneService implements ICampagneService {

    private CampagneMapper campagneMapper;
    private GameMapper    gameMapper;
    private CampagneRepository campagneRepository;
    private ArticleRepository articleRepository;
    private GameRepository gameRepository;
    private CountryRepository countryRepository;

    @Override
    public List<CampagneDTO> getAll() {

       List<CampagneDTO> list =
               campagneRepository
                       .findAll()
                       .stream()
                       .map(cp -> campagneMapper.toDto(cp)).toList();
        return list;
    }



    @Override
    public CampagneDTO getById(String id)  {
        return  campagneMapper.toDto(campagneRepository.findById(id)
                            .orElse(null));
    }

    @Override
    public List<CampagneDTO> getCampagneByGame(String gameName){
        Game game = gameRepository.findGameByName(gameName);

        if(game == null) return null;

        //Verifié existance game
        return campagneRepository.findCampagneByGameName(gameName).stream()
                                                                    .map(cp -> campagneMapper.toDto(cp))
                                                                    .toList();
    }

    @Override
    public List<CampagneDTO> getCampagneByCountry(String countryName){
        Country country = countryRepository.findCountryByName(countryName);
        if(country == null){ return null;}

        return campagneRepository
                .findCampagneVoteByCountry(country).stream()
                .map(cp -> campagneMapper.toDto(cp))
                .toList();
    }

    @Override
    public CampagneDTO create(Date dateDebut, Date dateFin, String name, String country) throws GameNotFoundExeption ,CountryNotFoundException{

        Game game = gameRepository.findGameByName(name);
        Country ct = countryRepository.findCountryByName(country);

        if( game == null ) {
            throw new GameNotFoundExeption("Game with  name=" +
                    name + " doesn t exist in database");
        } if(ct == null) {
            throw  new CountryNotFoundException("CNFE");
        }

        List<Article>  articles = articleRepository.findArticlesByGame(game);
        CampagneVote cp = CampagneVote.builder().dateDebut(dateDebut)
                                                .dateFin(dateFin)
                                                .game(game)
                                                .country(ct)
                                                .articles(articles)
                                                .build();

         cp= campagneRepository.save(cp);

        return campagneMapper.toDto(cp);
    }


    @Override
    public CampagneDTO updateCampagne(String id, CampagneDTO campagneDTO) throws GameNotFoundExeption {
        campagneDTO.setId(id);
        Game game = gameRepository.findGameByName(campagneDTO.getGameName());
        if( game == null ) {
            throw new GameNotFoundExeption("Game with  name=" +
                    campagneDTO.getGameName() + " doesn t exist in database");
        }

        CampagneVote cp = campagneMapper.toEntity(campagneDTO);
        cp.setGame(game);

       // List<Article>  articles = articleRepository.findArticlesByGame(campagneVote.getGame());
      //  campagneVote.setArticles(articles);
        cp= campagneRepository.save(cp);
        return campagneMapper.toDto(cp);
    }

    @Override
    public CampagneDTO deleteById(String id) throws CampagneNotFoundException{
         CampagneVote cp = campagneRepository.findById(id)
                 .orElseThrow( ()->new CampagneNotFoundException("Campagne Not found id : "+id));
         campagneRepository.deleteById(id);
         campagneRepository.delete(cp);
         return campagneMapper.toDto(cp);
    }

    @Override
    public List<GameDTO> getAllGame() {
        return gameRepository.findAll().stream()
                                        .map(game -> gameMapper.toDto(game))
                                        .toList();
    }


    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
    @Override
    public GameDTO getGameById(String id){
        return  gameMapper.toDto(gameRepository.findById(id)
                                .orElseThrow(() -> new GameNotFoundExeption("Game Not Found with id : "+id)));
    }

    @Override
    public GameDTO saveGame(String name, List<Role> roles){
        Game game = Game.builder()
                        .name(name)
                        .roles(roles)
                        .build();
       return gameMapper.toDto(gameRepository.save(game));
    }


    @Override
    public GameDTO updateGame(String id,String name, List<Role> roles){
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundExeption("Game Not Found with id : "+id));
            game.setName(name);
            game.setRoles(roles);
            gameRepository.save(game);
        return gameMapper.toDto(gameRepository.save(game));
    }

    @Override
    public GameDTO deleteGameById(String id){
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundExeption("Game Not Found with id : "+id));

        List<Article> articles= articleRepository.findArticlesByGame(game);
        articleRepository.deleteAll(articles);
        List<CampagneVote> campagneVotes =  campagneRepository.findCampagneVoteByGame(game);
        campagneRepository.deleteAll(campagneVotes);

        gameRepository.delete(game);
        return gameMapper.toDto(game);
    }

    @Override
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(String Id) throws CountryNotFoundException{
        return  countryRepository.findById(Id).orElseThrow(
                        () -> new CountryNotFoundException("Country Not Found"));
    }

    @Override
    public Country deleteCountryById(String Id)  throws CountryNotFoundException {
        Country ct = getCountryById(Id);
        List<CampagneVote>  campagneVotes=campagneRepository.findCampagneVoteByCountry(ct);
        campagneRepository.deleteAll(campagneVotes);
        campagneRepository.deleteCampagneVoteByCountry(ct);
        countryRepository.delete(ct);
        return ct;
    }

    @Override
    public Country saveCountry(String name, String code){
        Country ct = Country.builder().name(name).code(code).build();
        return countryRepository.save(ct);
    }

    @Override
    public Country updateCountry(String id, String name, String code) throws CountryNotFoundException{
        Country ct = getCountryById(id);
        ct.setName(name);
        ct.setCode(code);
        return countryRepository.save(ct);
    }


}
