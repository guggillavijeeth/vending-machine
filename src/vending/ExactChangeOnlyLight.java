package vending;

public class ExactChangeOnlyLight {
	
	public ExactChangeOnlyLight(ChangeBox c, Stockpile s) {
		nativeChangeBox = c;
		light = false;
		maxMoneyInserted = (s.getMostExpensive()+0.95)-s.getLeastExpensive();
	}
	
	public boolean isLit() {
		return light;
	}
	public void switchLightOn() {
		light = true;
	}
	public void switchLightOff() {
		light = false;
	}
	
	public void showLight() {
		System.out.println("EXACT CHANGE ONLY!\n");
	}
	
	public boolean isExactChangeAvailable() {
		if (nativeChangeBox.ableToGiveChange(maxMoneyInserted)) {
			Integer availableNickels = nativeChangeBox.getNickels();
			Integer availableDimes = nativeChangeBox.getDimes();
			if (availableNickels>=1) {
				if (availableDimes>=2) {
					return true;
				}
				else if (((availableDimes>=1) && (availableNickels>=3)) ||
						((availableNickels>=5))){
					return true;
				}
				else
					return false;
			}
			return false;
		}
		return false;
	}

	private boolean light;
	private ChangeBox nativeChangeBox;
	private Double maxMoneyInserted;
}
