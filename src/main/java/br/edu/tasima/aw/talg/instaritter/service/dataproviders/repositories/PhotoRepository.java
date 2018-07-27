package br.edu.tasima.aw.talg.instaritter.service.dataproviders.repositories;

import br.edu.tasima.aw.talg.instaritter.service.core.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
