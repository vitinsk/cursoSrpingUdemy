package com.example.demo.model.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int GetCod() {
		return cod;
	}
	
	public String GetDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(EstadoPagamento x: EstadoPagamento.values()) {
			if(cod.equals(x.GetCod())) {
				return x;
			}
		}
	throw new IllegalArgumentException("ID Inválido: "+ cod);
	}
	
}
