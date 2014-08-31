package br.com.k19.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.sessionsbeans.LancadorDadoBean;

@ManagedBean
public class DadoMB {
	@EJB
	private LancadorDadoBean lancadorDadoBean;
	
	private int resultado;
	
	public void lancaDado() {
		this.resultado = this.lancadorDadoBean.lanca();
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	
}
