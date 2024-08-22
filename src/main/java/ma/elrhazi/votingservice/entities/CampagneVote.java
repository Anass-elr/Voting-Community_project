package ma.elrhazi.votingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


@Entity
public class CampagneVote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private Date dateDebut;

    private Date dateFin;

    @ManyToOne
    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    private Game game;

    @ManyToOne
    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    private Country country;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Article> articles;


}
