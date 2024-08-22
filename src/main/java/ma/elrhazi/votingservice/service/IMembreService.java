package ma.elrhazi.votingservice.service;

import ma.elrhazi.votingservice.Exeption.MembreNotFoundExeption;
import ma.elrhazi.votingservice.dto.CampagneDTO;
import ma.elrhazi.votingservice.entities.Article;
import ma.elrhazi.votingservice.entities.Membre;
import ma.elrhazi.votingservice.entities.Vote;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IMembreService {
    List<Membre> getMembres();

    Membre getMembreById(String idMembre) throws MembreNotFoundExeption;

    List<Membre> getMembresByName(String name) throws MembreNotFoundExeption;

    Map<CampagneDTO, Article> getCampagneVotedByMembreId(String id);

    Vote vote(String idMembre, String idCampagne, String idArticleDeVote);

    Membre createMembre(String name, String prenom, Date date);

    Membre updatMembre(String id, String name, String prenom, Date date);

    Membre deleteMembre(String id);
}
