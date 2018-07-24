package br.edu.tasima.aw.talg.instaritter.service.core.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Photo {

    @Id
    @GeneratedValue
    private Integer id;

    @Lob
    private byte[] image;

    private LocalDateTime dateTime;

    @Size(min = 255, message = "Description not be more 255 characters")
    private String description;
}
