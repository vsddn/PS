package com.week5.ps;

class TicToc {
	
	synchronized void tic(boolean isRunning) {
		if(!isRunning) {
			notify();
			return;
		}
		System.out.print("Tic");
		notify();
		
		try {
			wait();
		}
		catch(InterruptedException exception){
			System.out.println("Interruption");
		}
	}
	synchronized void toc(boolean isRunning) {
		if(!isRunning) {
			notify();
			return;
		}
		System.out.print("-Toc");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("Interruption");
		}
	}
	
	
};

 class Multithreading implements Runnable  {
	
	TicToc t;
	Thread thread;
	Multithreading(TicToc t,String name){
	
		thread = new Thread(this,name);
		this.t = t;
		thread.start();
	}
	public void run() {
				if(thread.getName().compareTo("Tic")==0)
				{
					for(int i=0;i<10;i++)
						t.tic(true);
					t.tic(false);
				}
				else {
					for(int i=0;i<10;i++)
						t.toc(true);
					t.toc(false);
				}		
	}
}

public class RunnerClass {
	public static void main(String[] args) {
		TicToc t;
		Multithreading tic,toc;
		t = new TicToc();
		tic = new Multithreading(t,"Tic");
		toc = new Multithreading(t,"Toc");
		try {
			tic.thread.join();
			toc.thread.join();
		}catch(InterruptedException e) {
			System.out.println("Interruption");
			
		}
		
	}
}
