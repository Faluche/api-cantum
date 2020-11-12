package io.faluche.cantum.model;

import io.faluche.cantum.entity.PaillardeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PaillardeDto {
    private String title;
    private String text;

    public static PaillardeDto entityToDto(PaillardeEntity paillardeEntity) {
        return PaillardeDto.builder()
                .text(paillardeEntity.getText())
                .title(paillardeEntity.getTitle())
                .build();
    }
}
