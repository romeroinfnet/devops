package com.infnet.entrega.devops.vo;

import com.infnet.entrega.devops.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteVO implements Serializable {

    private String nome;

    private String cpf;

    private String gr;

    private Integer idade;

    public ClienteVO(Cliente cliente) {
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.idade = usuario.getIdade();
        this.rg = usuario.getRg();
    }

    public static List<ClienteVO> valueOf(List<Cliente> cliente) {
        return (List<ClienteVO>) CollectionUtils.collect(users, new Transformer<Cliente, ClienteVO>() {
            @Override
            public ClienteVO transform(Cliente cliente) {
                return new ClienteVO(cliente);
            }
        });
    }
}