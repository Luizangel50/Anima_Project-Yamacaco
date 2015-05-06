package animacao;

import java.util.Random;

class FishAnimation extends Thread {

	private static final int SCENE_WIDTH = 800;
    private Random gerador = new Random();
	Fish peixes;

	
	public FishAnimation(Fish fishes) {
		peixes = fishes;
	}

	public void run() {
		for(int t = 0; ; t++){
			for (int i = 0; i < peixes.fishes1.size(); i++) {
				peixes.fishes1.get(i).setLayoutX(peixes.fishes1.get(i).getLayoutX()-0.1*t);
				peixes.fishes1.get(i).setLayoutY(peixes.fishes1.get(i).getLayoutY()+10*Math.sin(t*i*0.1));
				
				peixes.fishes2.get(i).setLayoutX(peixes.fishes2.get(i).getLayoutX()+0.1*t);
				peixes.fishes2.get(i).setLayoutY(peixes.fishes2.get(i).getLayoutY()-10*Math.sin(t*i*0.1));
				
				if (peixes.fishes1.get(i).getLayoutX() < -SCENE_WIDTH) peixes.fishes1.get(i).setLayoutX(gerador.nextInt(SCENE_WIDTH));
				if (peixes.fishes2.get(i).getLayoutX() > SCENE_WIDTH) peixes.fishes2.get(i).setLayoutX(-gerador.nextInt(SCENE_WIDTH));
				if (t > 300) t = 100;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	};
    
}

