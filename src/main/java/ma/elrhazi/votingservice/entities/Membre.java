package ma.elrhazi.votingservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Builder

@Entity
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idMembre;
    private String name;
    private String prenom ;

    private Date dateNaissance;


}
