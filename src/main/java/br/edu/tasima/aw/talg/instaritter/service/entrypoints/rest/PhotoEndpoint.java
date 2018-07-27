package br.edu.tasima.aw.talg.instaritter.service.entrypoints.rest;

import br.edu.tasima.aw.talg.instaritter.service.business.services.PhotoService;
import br.edu.tasima.aw.talg.instaritter.service.core.entities.Photo;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.converters.PhotoConverter;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.converters.PhotoDTOConverter;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.dto.PhotoDTO;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
@RequestMapping("/photos")
public class PhotoEndpoint {

    private PhotoService service;
    private PhotoDTOConverter dtoConverter;
    private PhotoConverter converter;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<PhotoDTO> findOne(@PathVariable Long id) throws Exception {
        Optional<Photo> photo = service.findById(id);

        if (!photo.isPresent()) {
            throw new Exception("Photo not found");
        }

        PhotoDTO photoDTO = dtoConverter.convert(photo.get());

        Resource<PhotoDTO> resource = new Resource<>(photoDTO);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
        resource.add(linkTo.withRel("all-photos"));

        return resource;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhotoDTO> findAll() {
        List<Photo> all = service.findAll();

        List<PhotoDTO> photoDTOList = new ArrayList<>();

        if (!all.isEmpty()) {
            photoDTOList = dtoConverter.convertList(all);
        }

        return photoDTOList;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PhotoDTO save(@RequestBody PhotoDTO photo) {
        Photo photoToSave = converter.convert(photo);
        return dtoConverter.convert(service.save(photoToSave));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) throws Exception {
        if(!service.findById(id).isPresent()){
            throw new Exception("Photo not found");
        }
        service.delete(id);
    }
}
