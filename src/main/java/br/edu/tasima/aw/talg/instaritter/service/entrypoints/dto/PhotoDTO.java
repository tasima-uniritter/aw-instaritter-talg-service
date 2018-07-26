package br.edu.tasima.aw.talg.instaritter.service.entrypoints.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDTO {

    private Integer id;
    private String image;
    private LocalDateTime dateTime;
    private String description;
}
