package ma.elrhazi.votingservice.dto;
import lombok.*;
import ma.elrhazi.votingservice.entities.Article;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString

public class VoteDTO {
    private String idMembre;
    private String idArticle;
    private  String idCampagne;
}
