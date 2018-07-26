package br.edu.tasima.aw.talg.instaritter.service.business.services;

import br.edu.tasima.aw.talg.instaritter.service.core.entities.Photo;
import br.edu.tasima.aw.talg.instaritter.service.dataproviders.repositories.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class service the photo.
 */
@Service
public class PhotoService {

    private PhotoRepository repository;

    public PhotoService(PhotoRepository repository) {
        this.repository = repository;
    }

    /**
     * Return one photo.
     *
     * @param id id from {@link Photo}
     * @return {@link Photo}
     */
    public Photo findOne(Integer id){
        return repository.getOne(id);
    }

    /**
     * Return a Optiona Photo.
     *
     * @param id id from {@link Photo}
     * @return return a Optiona Photo.
     */
    public Optional<Photo> findById(int id) {
        return repository.findById(id);
    }

    /**
     * Return list of photos.
     *
     * @return list of {@link Photo}
     */
    public List<Photo> findAll(){
        return repository.findAll();
    }

    /**
     * Delete photo by id.
     *
     * @param id id of photo.
     */
    public void delete(Integer id){
        repository.deleteById(id);
    }

    /**
     * Save a new photo.
     *
     * @param photo new object {@link Photo}
     * @return Object {@link Photo}
     */
    public Photo save(Photo photo){
        return repository.save(photo);
    }
}
