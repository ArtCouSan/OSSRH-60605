package br.com.ctw.core.model;

import br.com.ctw.core.enums.GeneroEnum;
import br.com.ctw.core.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    private static final long serialVersionUID = 4803609827469652460L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "DT_NASCIMENTO", nullable = true)
    private LocalDateTime dtNascimento;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "GENERO", nullable = false)
    private GeneroEnum genero;

    @Column(name = "STATUS", nullable = false)
    private StatusEnum status;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Post> post;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;
}
