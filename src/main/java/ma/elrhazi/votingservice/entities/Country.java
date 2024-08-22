package ma.elrhazi.votingservice.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Builder

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
    private String name;



}
