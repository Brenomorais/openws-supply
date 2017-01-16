package br.com.myabastecimentos.rest.model;

import java.util.Date;

public class Abastecimento {

	private String _id;
	private String posto;
	private String veiculo;
	private Date   dataAbastecimento;
	private String combustivel;
	private Double precoLitro;
	private Double valorAbastecido;
	private Double totalListros;
	private String pagamento;	
	
	public String getId() {
		return _id;
	}
	public void setId(String _id) {
		this._id = _id;
	}
	public String getPosto() {
		return posto;
	}
	public void setPosto(String posto) {
		this.posto = posto;
	}
	public Date getDataAbastecimento() {
		return dataAbastecimento;
	}
	public void setDataAbastecimento(Date dataAbastecimento) {
		this.dataAbastecimento = dataAbastecimento;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public Double getPrecoLitro() {
		return precoLitro;
	}
	public void setPrecoLitro(Double precoLitro) {
		this.precoLitro = precoLitro;
	}
	public Double getValorAbastecido() {
		return valorAbastecido;
	}
	public void setValorAbastecido(Double valorAbastecido) {
		this.valorAbastecido = valorAbastecido;
	}
	public Double getTotalListros() {
		return totalListros;
	}
	public void setTotalListros(Double totalListros) {
		this.totalListros = totalListros;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}	
}
