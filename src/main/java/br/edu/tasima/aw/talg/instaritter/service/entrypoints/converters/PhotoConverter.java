package br.edu.tasima.aw.talg.instaritter.service.entrypoints.converters;

import br.edu.tasima.aw.talg.instaritter.service.core.entities.Photo;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.dto.PhotoDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class PhotoConverter implements Converter<PhotoDTO, Photo> {

    @Override
    public Photo convert(PhotoDTO source) {
        return new Photo(source.getId(), source.getImage(), source.getDateTime(), source.getDescription());
    }
}
