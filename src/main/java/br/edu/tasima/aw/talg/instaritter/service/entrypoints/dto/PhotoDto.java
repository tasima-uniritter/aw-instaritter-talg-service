package br.edu.tasima.aw.talg.instaritter.service.entrypoints.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhotoDto {

    private Integer id;

    private byte[] image;

    private LocalDateTime dateTime;

    private String description;
}
