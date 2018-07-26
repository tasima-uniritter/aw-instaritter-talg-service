package br.edu.tasima.aw.talg.instaritter.service.entrypoints.converters;

import br.edu.tasima.aw.talg.instaritter.service.core.entities.Photo;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.dto.PhotoDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoDTOConverter implements Converter<Photo, PhotoDTO> {

    @Override
    public PhotoDTO convert(Photo source) {
        return new PhotoDTO(source.getId(), source.getImage(), source.getDateTime(), source.getDescription());
    }

    public List<PhotoDTO> convertList(List<Photo> sourceList) {
        List<PhotoDTO> photoDTOList = new ArrayList<>();

        sourceList.forEach(photo -> photoDTOList.add(convert(photo)));

        return photoDTOList;
    }
}
