package br.edu.tasima.aw.talg.instaritter.service.core.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_photo")
    @SequenceGenerator(name="seq_photo", sequenceName="seq_photo")
    private Long id;

    @Lob
    private String image;

    private LocalDateTime dateTime;

    private String description;
}
