package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Categoria;
import com.example.demo.model.Cidade;
import com.example.demo.model.Cliente;
import com.example.demo.model.Endereco;
import com.example.demo.model.Estado;
import com.example.demo.model.Produto;
import com.example.demo.model.enums.TipoCliente;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.CidadeRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.ProdutoRepository;
import com.mysql.fabric.xmlrpc.base.Array;

@SpringBootApplication
public class UdemyApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UdemyApplication.class, args);
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impresora", 200.00);
		Produto p3 = new Produto(null, "Mouse", 30.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p1.getCategorias().addAll(Arrays.asList(cat1));		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");		
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Vitor", "vitinsk@hotmail.com", "111.111.111-90", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("33563362","993479612"));
		
		Endereco e1 = new Endereco(null, "José Faria", "959", "casa", "Eldorado", "32315-040", cli1, c1);
		Endereco e2 = new Endereco(null, "Joao Cesar", "854", "casa", "Centro", "32315-040", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));		
		
	}
}
