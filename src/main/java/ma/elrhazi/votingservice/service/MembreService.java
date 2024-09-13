package ma.elrhazi.votingservice.service;

import lombok.AllArgsConstructor;
import ma.elrhazi.votingservice.Exeption.MembreNotFoundExeption;
import ma.elrhazi.votingservice.dto.CampagneDTO;
import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.CampagneVote;
import ma.elrhazi.votingservice.entities.Membre;
import ma.elrhazi.votingservice.entities.Vote;
import ma.elrhazi.votingservice.mapper.cdeMapper.CampagneMapper;
import ma.elrhazi.votingservice.repositories.ArticleRepository;
import ma.elrhazi.votingservice.repositories.CampagneRepository;
import ma.elrhazi.votingservice.repositories.MembreRepository;
import ma.elrhazi.votingservice.repositories.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor

@Service
public class MembreService implements IMembreService{


    private MembreRepository membreRepository;
    private VoteRepository voteRepository;
    private CampagneRepository campagneRepository;
    private ArticleRepository articleRepository;
    private CampagneMapper campagneMapper;

    @Override
    public List<Membre> getMembres(){
        return membreRepository.findAll();
    }

    @Override
    public Membre getMembreById(String idMembre) throws MembreNotFoundExeption {
        return  membreRepository.findById(idMembre)
                .orElseThrow(() -> new MembreNotFoundExeption("Not Found"));
    }

    @Override
    public List<Membre> getMembresByName(String name) throws MembreNotFoundExeption {
        List<Membre> membres=  membreRepository.findMembresByName(name);

        if(membres == null)  throw new MembreNotFoundExeption("Not Found");

        return membres;
    }

    @Override
    public Map<CampagneDTO, Article> getCampagneVotedByMembreId(String id) {
        Membre membre = getMembreById(id);

        List<Vote> votes = voteRepository.findVotesByMembre(membre);

        Map<CampagneDTO,Article> map = new HashMap<>();
        votes.forEach(vote -> {
            Article article = articleRepository.findById(vote.getIdArticleDeVote())
                    .orElse(null);

            CampagneDTO campagneDTO = campagneMapper.toDto(campagneRepository.findById(vote.getCampagneVote().getId())
                    .orElse(null));

            map.put(campagneDTO,article);
        });

        return map;
    }

    @Override
    public Vote vote(String idMembre, String idCampagne, String idArticleDeVote){

        Optional<CampagneVote> campagneVote = campagneRepository.findById(idCampagne);
        Optional<Article>      article = articleRepository.findById(idArticleDeVote);
        Optional<Membre>       membre = membreRepository.findById(idMembre);

        Vote vote = Vote.builder().dateVote(new Date())
                .idArticleDeVote(idArticleDeVote)
                .membre(membre.get())
                .campagneVote(campagneVote.get()).build();


        return voteRepository.save(vote);

    }




    @Override
    public Membre createMembre(String name, String prenom, Date date){
        Membre membre = Membre.builder().name(name)
                .prenom(prenom)
                .dateNaissance(date).build();

        return membreRepository.save(membre);
    }

    @Override
    public Membre updatMembre(String id, String name, String prenom, Date date){
        Membre membre = getMembreById(id);

        membre.setName(name);
        membre.setPrenom(prenom);
        membre.setDateNaissance(date);

        return membreRepository.save(membre);
    }

    @Override
    public Membre deleteMembre(String id){
        Membre membre= getMembreById(id);
        membreRepository.delete(membre);
        return membre;
    }
}
