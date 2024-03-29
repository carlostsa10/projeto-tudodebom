package br.com.tudodebom.api.services;

import java.util.ArrayList;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tudodebom.api.model.Cliente;
import br.com.tudodebom.api.repository.ClienteRepository;

@Service
public class ClienteService implements ICliente {

	@Autowired//ingeção direto no banco
	ClienteRepository repository;
	@Override
	public Cliente criarNovo(Cliente novo) {
		// TODO Auto-generated method stub
		
		if(novo.getNome()!=null) {
			return repository.save(novo);
		}
		return null;
	}

	@Override
	public Cliente criarDados(Cliente dados) {
		// TODO Auto-generated method stub
		if(dados.getEmail()!=null) {
			return repository.save(dados);
		}
		else {
			System.out.println("Está faltando dados");
		}
		return null;
	}

	@Override
	public ArrayList<Cliente> buscartodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Cliente>) repository.findAll();
	}

	@Override
	public Cliente buscarPeloId(Integer IDcliente) {
		// TODO Auto-generated method stub
		//auto incremento
		return repository.findById(IDcliente).orElse(null);
	}

	@Override
	public void excluirDepartamento(Integer IDcliente) {
		// TODO Auto-generated method stub
		repository.deleteById(IDcliente);
		
	}

	
	
}
