package com.example.demo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.ClienteNewDTO;
import com.example.demo.model.Cliente;
import com.example.demo.model.enums.TipoCliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.resource.exception.FieldMessage;
import com.example.demo.services.validation.br.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Autowired
	private ClienteRepository repo;

	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

		
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getTipoCliente().equals(TipoCliente.PESSOAFISICA.GetCod()) && !BR.isValidCPF(objDto.getCpfCnpj())) {
			list.add(new FieldMessage("CpfCnpj", "CPF inválido"));
		}

		if (objDto.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.GetCod()) && !BR.isValidCNPJ(objDto.getCpfCnpj())) {
			list.add(new FieldMessage("CpfCnpj", "CNPJ inválido"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		
		return list.isEmpty();
	}
}