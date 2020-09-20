package com.github.artcousan.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_TIPO_POST")
public class TipoPost implements Serializable {

    private static final long serialVersionUID = 7758637812000758045L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPO_POST_ID")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @ManyToMany(mappedBy = "tipos")
    private List<Post> posts;

}
