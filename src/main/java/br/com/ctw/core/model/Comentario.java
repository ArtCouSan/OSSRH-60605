package br.com.ctw.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_COMENTARIO")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMENTARIO_ID")
    private Long id;

    @Column(name = "DT_CRIACAO", nullable = false)
    private LocalDateTime dtCriacao;

    @Column(name = "DT_ALTERACAO", nullable = false)
    private LocalDateTime dtAlteracao;

    @Column(name = "TEXTO", nullable = false, length = 255)
    private String texto;

    @ManyToOne
    @JoinColumn(name="POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name="USUARIO_ID")
    private Usuario usuario;

}
