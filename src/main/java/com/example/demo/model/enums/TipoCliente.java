package com.example.demo.model.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int GetCod() {
		return cod;
	}
	
	public String GetDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoCliente x: TipoCliente.values()) {
			if(cod.equals(x.GetCod())) {
				return x;
			}
		}
	throw new IllegalArgumentException("ID Inválido: "+ cod);
	}
	
}


