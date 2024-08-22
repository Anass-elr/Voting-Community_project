package ma.elrhazi.votingservice.mapper;


import ma.elrhazi.votingservice.dto.CampagneDTO;
import ma.elrhazi.votingservice.entities.CampagneVote;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;


@Service
@Mapper(componentModel = "spring")
public interface CampagneMapper {

    CampagneVote toEntity(CampagneDTO campagneDTO);

    CampagneDTO toDto(CampagneVote campagneVote);
}
