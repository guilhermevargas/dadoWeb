package br.com.k19.sesssionBeans;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.Future;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDeDadoBean implements LancadorDeDado {
	private Random gerador = new Random();
	private static int contador;

	@Asynchronous
	public Future<Map<Integer, Integer>> calculaFrequencia() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 0);
		map.put(2, 0);
		map.put(3, 0);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 0);
		
		for (int i = 0; i < 500; i++) {
			int v = this.gerador.nextInt(6) + 1;
			map.put(v, map.get(v) + 1);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {}
			
			System.out.println(i);
		}
		
		return new AsyncResult<Map<Integer,Integer>>(map);
	}
	
	@PostConstruct
	public void inicializando() {
		synchronized (LancadorDeDadoBean.class) {
			LancadorDeDadoBean.contador++;
			System.out.println("Criando um lan�ador de dados...");
			System.out.println("Total: " + LancadorDeDadoBean.contador);
		}
	}

	@PreDestroy
	public void destruindo() {
		synchronized (LancadorDeDadoBean.class) {
			LancadorDeDadoBean.contador--;
			System.out.println("Destruindo um lan�ador de dados...");
			System.out.println("Total: " + LancadorDeDadoBean.contador);
		}
	}
	
	public int lanca() {
		return this.gerador.nextInt(6) + 1;
	}
}
