package io.faluche.cantum.model;

import io.faluche.cantum.entity.VersionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class VersionDto {
    private String nom;
    public static VersionDto entityToDto(VersionEntity versionEntity) {
        return VersionDto.builder()
                .nom(versionEntity.getNom())
                .build();
    }
}
