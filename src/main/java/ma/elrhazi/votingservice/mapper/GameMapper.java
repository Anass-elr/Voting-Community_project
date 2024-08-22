package ma.elrhazi.votingservice.mapper;

import ma.elrhazi.votingservice.dto.GameDTO;
import ma.elrhazi.votingservice.entities.Game;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;


@Service
@Mapper(componentModel = "spring")
public interface GameMapper {
    Game toEntity(GameDTO gameDTO);

    GameDTO toDto(Game game);
}
