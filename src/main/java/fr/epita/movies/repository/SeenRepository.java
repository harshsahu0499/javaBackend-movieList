package fr.epita.movies.repository;



import fr.epita.movies.domain.SeenMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeenRepository extends JpaRepository<SeenMovie,Integer>{



}
