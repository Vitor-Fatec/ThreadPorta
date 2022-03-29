package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPorta;

public class main {

	public static void main(String[] args) {
	int permissoes = 1;
	Semaphore semaforo = new Semaphore(permissoes);
	
	
	for(int idPorta = 1; idPorta <= 4; idPorta++) {
		Thread porta = new ThreadPorta(idPorta, semaforo);
		porta.start();
	}

	}

}
