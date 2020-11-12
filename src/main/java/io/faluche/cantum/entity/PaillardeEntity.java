package io.faluche.cantum.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="paillardes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaillardeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "intitule")
    private String intitule;

    @Column(name = "texte")
    private String texte;

    @Column(name = "popularite")
    private Long popularite;

    @Column(name = "commentaire")
    private String commentaire;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "titre_id")
    private TitreEntity titre;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_modification")
    private Date dateModification;

    @Column(name = "creer_par")
    private String creerPar;

    @Column(name = "modifier_par")
    private String modifierPar;
}
