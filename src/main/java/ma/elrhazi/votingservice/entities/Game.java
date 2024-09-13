package ma.elrhazi.votingservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @OneToMany( fetch = FetchType.EAGER ,
            cascade = CascadeType.ALL,
            orphanRemoval = true )
    private List<Role> roles ;





}
