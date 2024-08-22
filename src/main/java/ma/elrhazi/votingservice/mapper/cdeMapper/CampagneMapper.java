package ma.elrhazi.votingservice.mapper.cdeMapper;

import ma.elrhazi.votingservice.dto.CampagneDTO;
import ma.elrhazi.votingservice.entities.CampagneVote;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CampagneMapper {
    public CampagneDTO toDto(CampagneVote campagneVote){
        CampagneDTO cpDTO =new CampagneDTO();
        BeanUtils.copyProperties(campagneVote,cpDTO);
         cpDTO.setGameName(campagneVote.getGame().getName());
        cpDTO.setCountryName(campagneVote.getCountry().getName());
        return cpDTO;
    }

    public CampagneVote toEntity(CampagneDTO campagneDTO){
        CampagneVote cp = new CampagneVote();
        BeanUtils.copyProperties(campagneDTO,cp);
        return cp;

    }
}
