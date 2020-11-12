package io.faluche.cantum.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.faluche.cantum.entity.TitreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TitreDto {
    private String nom;

    public static TitreDto entityToDto(TitreEntity titreEntity) {
        return TitreDto.builder()
                .nom(titreEntity.getNom())
                .build();
    }

    public static TitreEntity dtoToEntity(TitreDto titreDto) {
        return TitreEntity.builder()
                .nom(titreDto.getNom())
                .build();
    }
}
