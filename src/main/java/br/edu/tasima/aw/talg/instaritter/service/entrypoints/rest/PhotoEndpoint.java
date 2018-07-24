package br.edu.tasima.aw.talg.instaritter.service.entrypoints.rest;

import br.edu.tasima.aw.talg.instaritter.service.business.services.PhotoService;
import br.edu.tasima.aw.talg.instaritter.service.core.entities.Photo;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.converters.PhotoConverter;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.dto.PhotoDto;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController("/photos")
public class PhotoEndpoint {

    private PhotoService service;

    public PhotoEndpoint(PhotoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
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

    @GetMapping("/")
    public List<PhotoDto> findAll(){
        List<Photo> all = service.findAll();

        List<PhotoDto> photoDtos = new ArrayList<>();

        if(!all.isEmpty()){
            photoDtos = PhotoConverter.listPhotoToListPhotoDto(all);
        }

        return photoDtos;
    }
}
