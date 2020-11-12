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
    private String intitule;
    private String texte;
    private TitreDto titrePrincipal;
    private String commentaire;
    private Long popularite;

    public static PaillardeDto entityToDto(PaillardeEntity paillardeEntity) {
        return PaillardeDto.builder()
                .texte(paillardeEntity.getTexte())
                .intitule(paillardeEntity.getIntitule())
                .titrePrincipal(TitreDto.entityToDto(paillardeEntity.getTitre()))
                .commentaire(paillardeEntity.getCommentaire())
                .popularite(paillardeEntity.getPopularite())
                .build();
    }
}
