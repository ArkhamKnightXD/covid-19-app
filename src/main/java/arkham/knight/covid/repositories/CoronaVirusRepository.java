package arkham.knight.covid.repositories;

import arkham.knight.covid.models.CoronaVirus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoronaVirusRepository extends JpaRepository<CoronaVirus, Long> {

    CoronaVirus findByCountry(String country);

    List<CoronaVirus> findByCountryLike(String country);

    // De esta forma puedo encontrar todos y ordenar mediante el parametro sort que mande
    @Override
    List<CoronaVirus> findAll(Sort sort);

    // y de esta forma puedo ordenar y hacer paginacion al mismo tiempo
    List<CoronaVirus> findByCountryNotNull(Pageable pageable);

}
