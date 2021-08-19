package io.faluche.cantum.repository.domain;

import lombok.*;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name="paillarde")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paillarde {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="text")
    private String text;
}
