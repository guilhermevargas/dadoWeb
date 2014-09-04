package br.com.k19.sesssionBeans;

import java.util.Random;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDeDadoBean implements LancadorDeDado{
	private Random gerador = new Random();
	
	public int lanca() {
		return this.gerador.nextInt(6) + 1;
	}
}
