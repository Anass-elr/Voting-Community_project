package ma.elrhazi.votingservice.repositories;


import ma.elrhazi.votingservice.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreRepository  extends JpaRepository<Membre,String>{
    List<Membre> findMembresByName(String name);
}
