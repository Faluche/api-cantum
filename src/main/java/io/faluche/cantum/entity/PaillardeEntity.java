package io.faluche.cantum.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paillardes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaillardeEntity {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "titre")
    private String title;

    @Column(name = "texte")
    private String text;
}
