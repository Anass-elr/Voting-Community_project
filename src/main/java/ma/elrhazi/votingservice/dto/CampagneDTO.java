package ma.elrhazi.votingservice.dto;

import lombok.*;
import ma.elrhazi.votingservice.entities.Article;

import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode

public class CampagneDTO {
    private String id;
    private Date dateDebut;
    private Date dateFin;
    private String gameName;
    private String countryName;

    private List<Article> articles ;

}
