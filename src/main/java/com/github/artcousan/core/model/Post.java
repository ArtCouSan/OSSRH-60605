package com.github.artcousan.core.model;

import com.github.artcousan.core.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_POST")
public class Post implements Serializable {

    private static final long serialVersionUID = -4872984373994741968L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID", nullable = false)
    private Long id;

    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Column(name = "DESCRICAO", nullable = false, length = 255)
    private String descricao;

    @Column(name = "DT_CRIACAO", nullable = false)
    private LocalDateTime dtCriacao;

    @Column(name = "STATUS", nullable = false)
    private StatusEnum status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="USUARIO_ID")
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_RELACAO_POST_TIPO",
            joinColumns = @JoinColumn(name = "POST_ID", referencedColumnName = "POST_ID"),
            inverseJoinColumns = @JoinColumn(name = "TIPO_POST_ID",
                    referencedColumnName = "TIPO_POST_ID"))
    private List<TipoPost> tipos;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

    @OneToMany(mappedBy = "post")
    private List<ContatoPost> contatoPosts;

}
