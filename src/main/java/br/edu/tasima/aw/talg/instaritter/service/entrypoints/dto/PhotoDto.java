package br.edu.tasima.aw.talg.instaritter.service.entrypoints.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {

    private Integer id;

    private byte[] image;

    private LocalDateTime dateTime;

    private String description;
}
