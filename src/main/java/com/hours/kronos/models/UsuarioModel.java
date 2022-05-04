package com.hours.kronos.models;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario", schema = "kronos_hours_db")
public class UsuarioModel implements UserDetails {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "perfil_id")
    private Integer perfilModel;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<PerfilModel> perfis;

    @JoinColumn(name = "desenvolvedor_id", referencedColumnName = "desenvolvedor_id")
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private DesenvolvedorModel desenvolvedor;

    @JoinColumn(name = "consultoria_id", referencedColumnName = "consultoria_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsultoriaModel consultoria;

    @JoinColumn(name = "cliente_empresa_id", referencedColumnName = "cliente_empresa_id")
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    private ClienteEmpresaModel clienteEmpresa;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
