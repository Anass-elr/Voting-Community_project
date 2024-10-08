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
@EqualsAndHashCode

public class CampagneDTO implements Serializable {
    private String id;
    private Date dateDebut;
    private Date dateFin;
    private String gameName;
    private String countryName;
    private List<String> articlesSelectedId= new ArrayList<>();
}
