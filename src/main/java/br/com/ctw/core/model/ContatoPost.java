package br.com.ctw.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_CONTATO_POST")
public class ContatoPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTATO_POST_ID")
    private Long id;

    @Column(name = "CELULAR")
    private String celular;

    @ManyToOne
    @JoinColumn(name="POST_ID")
    private Post post;

}
