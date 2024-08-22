package ma.elrhazi.votingservice.repositories;

import ma.elrhazi.votingservice.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,String> {
    Country findCountryByName(String name);
}
