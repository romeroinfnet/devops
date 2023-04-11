package com.infnet.entrega.devops.service;

import com.infnet.entrega.devops.dao.Impl.ClienteDAOImpl;
import com.infnet.entrega.devops.entity.Cliente;
import com.infnet.entrega.devops.vo.IMC;
import com.infnet.entrega.devops.vo.ClienteVO;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClienteDAOImpl clienteDAOImpl;

    @Operation(summary = "Cadastrar de cliente")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Cliente>cadastrar(@RequestBody ClienteVO clienteVO) {
        validarCliente(clienteVO);

        Cliente cliente = clienteDAOImpl.incluir(clienteVO);
        log.info("Novo cliente: " + cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @Operation(summary = "Altualizar Cliente")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente>atualizar(@PathVariable("id") Long id, @RequestBody ClienteVO clienteVO) {
        Cliente cliente = clienteDAOImpl.atualizar(id, clienteVO);
        log.info("Atualizar cliente: " + cliente);

        return ResponseEntity.ok().body(cliente);
    }
 
    @Operation(summary = "Listar Cliente")
    @GetMapping(value = "/listar")
    public ResponseEntity<List<Usuario>>listar() {
        List<Cliente> cliente = clienteDAOImpl.listar();
        log.info("Lista de clientes: " + cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @Operation(summary = "Deletar cliente")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity remover(@PathVariable("id") Long id) {
        clienteDAOImpl.remover(id);
        log.info("Removendo cliente: " + id);

        return ResponseEntity.noContent().build();
    }

    void validação(ClienteVO clienteVO){

        if (clienteVO == null){
            throw new ObjectNotFoundException("Cliente não encontrado!!", cliente.class.getName());
        }

        if(clienteVO.getCpf() == null){
            throw new ArithmeticException("CPF inválido!");
        }

        if(clienteVO.getRg() == null){
            throw new ArithmeticException("RG inválido!");
        }

    }

}