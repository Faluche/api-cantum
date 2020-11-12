package io.faluche.cantum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public abstract class AbstractEntity {

    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    protected Date dateCreation;

    @Column(name = "date_modification")
    @Temporal(TemporalType.DATE)
    protected Date dateModification;

    @Column(name = "creer_par")
    protected String creerPar;

    @Column(name = "modifier_par")
    protected String modifierPar;
}
