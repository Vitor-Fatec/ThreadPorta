package controller;

import java.util.concurrent.Semaphore;

public class ThreadPorta extends Thread {
	
	private int idPorta;
	private Semaphore semaforo;
	private int corredor = 200;
	
	
	public ThreadPorta(int idPorta, Semaphore semaforo) {
		this.idPorta = idPorta;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		corredores();
		porta();
	}

	private void corredores() {
		
			while(corredor >= 0) {
				int andar = (int) (Math.random() * 3) + 4 ;
				corredor -= andar;
				if(corredor <= 0) {
					System.out.println("Você chegou  ao final do corredor");
				} else {
				System.out.println("Pessoa "+idPorta + " andou "+ andar+ "m ainda restam" +corredor+ "m" );
				andar = 0;
				}	
			}
	}

	private void porta() {
		int abrir = (int) (Math.random() * 3000) + 1000;
		
		try {
			semaforo.acquire();
			System.out.println("Pessoa" + idPorta + " está abrindo a porta. Aguarde um momento....");
			sleep(abrir);
			System.out.println("Pessoa" + idPorta + " cruzou a porta, próximo a atravessar");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}

}
