package br.com.ctw.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_LIKE")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIKE_ID")
    private Long id;

    @Column(name = "DT_CRIACAO", nullable = false)
    private LocalDateTime dtCriacao;

    @ManyToOne
    @JoinColumn(name="USUARIO_ID")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="POST_ID")
    private Post post;

}
