package ma.elrhazi.votingservice.dto;

import lombok.*;
import ma.elrhazi.votingservice.entities.CampagneVote;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder

public class GameDTO {
    private String id;

    private String name;

   // private List<CampagneVote> campagneVotes=new ArrayList<>();

}
