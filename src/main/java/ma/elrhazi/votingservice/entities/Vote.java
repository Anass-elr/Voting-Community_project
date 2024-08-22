package ma.elrhazi.votingservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Builder

public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String idVote;

    private Date dateVote;

    private String idArticleDeVote;

    @ManyToOne
    private Membre membre;

    @ManyToOne
    private CampagneVote campagneVote;

}
