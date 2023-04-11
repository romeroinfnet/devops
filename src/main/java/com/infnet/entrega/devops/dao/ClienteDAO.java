package com.infnet.entrega.devops.dao.entity;

import com.infnet.entrega.devops.dao.ClienteDAO;
import com.infnet.entrega.devops.entity.Cliente;
import com.infnet.entrega.devops.vo.ClienteVO;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteDAO {

    @Autowired
    ClienteDAO ClienteDAO;

    public Cliente salvar(ClienteVO clienteVO) {
        return clienteDAO.save(new Cliente (clienteVO));
    }

    public Cliente buscar(int id){

        Optional<Cliente> ClienteTemp = clienteDAO.findById(id);

        if(clienteTemp.isEmpty()){
            throw new ObjectNotFoundException("Cliente Não Encontrado", cliente.class.getName());
        }

        return clienteTemp.get();
    }

    public List<Cliente>listar() {
        return clienteDAO.findAll();
    }

    public void remover(Long id) {
        usuarioDAO.deleteById(buscar(id).getId());
    }

    public Cliente atualizar(Long id, UsuarioVO cliente) {
        Cliente cliente = buscarPorId(id);
        this.cliente.setAltura(cliente.getAltura());
        this.cliente.setPeso(cliente.getPeso());
        this.cliente.setIdade(cliente.getIdade());

        return clienteDAO.save(clienteTemp);
    }

}