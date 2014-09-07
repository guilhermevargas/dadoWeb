package br.com.k19.sesssionBeans;

import java.util.Map;
import java.util.concurrent.Future;

public interface LancadorDeDado {
	int lanca();
	Future<Map<Integer, Integer>> calculaFrequencia();
}
