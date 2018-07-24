package br.edu.tasima.aw.talg.instaritter.service.entrypoints.converters;

import br.edu.tasima.aw.talg.instaritter.service.core.entities.Photo;
import br.edu.tasima.aw.talg.instaritter.service.entrypoints.dto.PhotoDto;

import java.util.ArrayList;
import java.util.List;

public class PhotoConverter {

    /**
     * Converter {@link Photo} to {@link PhotoDto}
     * @param photo object {@link Photo}
     * @return object {@link PhotoDto}
     */
    public static PhotoDto photoToDto(Photo photo){
        return new PhotoDto(photo.getId(), photo.getImage(), photo.getDateTime(), photo.getDescription());
    }

    /**
     * Converter list of {@link Photo} to list of {@link PhotoDto}
     * @param photos list of object {@link Photo}
     * @return list of object {@link PhotoDto}
     */
    public static List<PhotoDto> listPhotoToListPhotoDto(List<Photo> photos){

        List<PhotoDto> photosDtos = new ArrayList<>();
        photos.forEach(photo -> photosDtos.add(photoToDto(photo)));

        return photosDtos;
    }
}
