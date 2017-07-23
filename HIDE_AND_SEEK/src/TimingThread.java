
public class TimingThread implements Runnable{
	Timer t;
	public TimingThread(Timer t){
		this.t=t;
	}
	@Override
	public void run() {		
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t.inc();
		}
		
	}

}
