package com.infnet.entrega.devops.entity;

import com.infnet.entrega.devops.vo.ClienteVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private Double altura;

    @Column(name = "rg", nullable = false)
    private Double peso;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    public Cliente(ClienteVO clienteVO){
        this.nome = clienteVO.getNome();
        this.rg = clienteVO.getAltura();
        this.cpf = clienteVO.getPeso();
        this.idade = clienteVO.getIdade();
    }
}