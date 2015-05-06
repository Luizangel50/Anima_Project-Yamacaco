package animacao;

class FishAnimation extends Thread {

	Fish peixes;

	public FishAnimation(Fish fishes) {
		peixes = fishes;
	}

	public void run() {
		for(int t = 0; t>-1; t++){
			for (int i = 0; i < peixes.fishes1.size(); i++) {
				peixes.fishes1.get(i).setLayoutX(peixes.fishes1.get(i).getLayoutX()-0.1*t);
				peixes.fishes1.get(i).setLayoutY(peixes.fishes1.get(i).getLayoutY()+10*Math.sin(t*i*0.1));
				
				peixes.fishes2.get(i).setLayoutX(peixes.fishes2.get(i).getLayoutX()+0.1*t);
				peixes.fishes2.get(i).setLayoutY(peixes.fishes2.get(i).getLayoutY()-10*Math.sin(t*i*0.1));
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	};
    
}

