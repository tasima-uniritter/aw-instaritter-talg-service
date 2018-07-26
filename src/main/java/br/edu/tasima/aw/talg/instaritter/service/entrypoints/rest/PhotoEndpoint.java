package br.edu.tasima.aw.talg.instaritter.service.entrypoints.rest;

import br.edu.tasima.aw.talg.instaritter.service.business.services.PhotoService;
import br.edu.tasima.aw.talg.instaritter.service.core.entities.Photo;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.converters.PhotoConverter;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.dto.PhotoDto;
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
@RequestMapping("/photos")
public class PhotoEndpoint {

    private PhotoService service;

    public PhotoEndpoint(PhotoService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<PhotoDto> findOne(@PathVariable int id) throws Exception {
        Optional<Photo> photo = service.findById(id);

        if(!photo.isPresent()){
            throw new Exception("Photo not found");
        }

        PhotoDto photoDto = PhotoConverter.photoToDto(photo.get());

        Resource<PhotoDto> resource = new Resource<>(photoDto);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
        resource.add(linkTo.withRel("all-photos"));

        return resource;

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhotoDto> findAll(){
        List<Photo> all = service.findAll();

        List<PhotoDto> photoDtos = new ArrayList<>();

        if(!all.isEmpty()){
            photoDtos = PhotoConverter.listPhotoToListPhotoDto(all);
        }

        return photoDtos;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PhotoDto add(@RequestBody PhotoDto dto){
        return PhotoConverter.photoToDto(
                service.save(
                        PhotoConverter.photoDtoToPhoto(dto)));
    }
}
