package ma.elrhazi.votingservice.entities;


import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Builder

@Entity
public class LeagArticle extends Article{
    private String  gameName;
    private String  tagLine;
    private String  userName;
    private int     level;
    private String  profilIconUrl;
    private int     wins;
    private int     losses;
}
