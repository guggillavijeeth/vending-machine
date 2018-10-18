package vending;

public class Stockpile {

	Stockpile(int startAmount){

		startStock = startAmount;
		
		cocaColaCount =
				
				cocaColaZeroCount = 
				cocaColaCherryCount = 
				spriteCount = 
				fantaOrangeCount = 
				fantaGrapeCount = 
				barqsCount = 
				melloYelloCount = 

				startStock;
	}

	public Integer getCocaColaCount() {
		return cocaColaCount;
	}
	public void decrementCocaColaCount() {
		cocaColaCount--;
	}
	
	public Integer getCocaColaZeroCount() {
		return cocaColaZeroCount;
	}
	public void decrementCocaColaZeroCount() {
		cocaColaZeroCount--;
	}
	
	public Integer getCocaColaCherryCount() {
		return cocaColaCherryCount;
	}
	public void decrementCocaColaCherryCount() {
		cocaColaCherryCount--;
	}
	
	public Integer getSpriteCount() {
		return spriteCount;
	}
	public void decrementSpriteCount() {
		spriteCount--;
	}
	
	public Integer getFantaOrangeCount() {
		return fantaOrangeCount;
	}
	public void decrementFantaOrangeCount() {
		fantaOrangeCount--;
	}
	
	public Integer getFantaGrapeCount() {
		return fantaGrapeCount;
	}
	public void decrementFantaGrapeCount() {
		fantaGrapeCount--;
	}
	
	public Integer getBarqsCount() {
		return barqsCount;
	}
	public void decrementBarqsCount() {
		barqsCount--;
	}
	
	public Integer getMelloYelloCount() {
		return melloYelloCount;
	}
	public void decrementMelloYelloCount() {
		melloYelloCount--;
	}

	public Double getCocaColaCost() {
		return cocaColaCost;
	}
	
	public Double getCocaColaZeroCost() {
		return cocaColaZeroCost;
	}
	
	public Double getCocaColaCherryCost() {
		return cocaColaCherryCost;
	}
	
	public Double getSpriteCost() {
		return spriteCost;
	}
	
	public Double getFantaOrangeCost() {
		return fantaOrangeCost;
	}
	
	public Double getFantaGrapeCost() {
		return fantaGrapeCost;
	}
	
	public Double getBarqsCost() {
		return barqsCost;
	}
	
	public Double getMelloYelloCost() {
		return melloYelloCost;
	}
	
	public Double getMostExpensive() {
		return mostExpensive;
	}
	
	public Double getLeastExpensive() {
		return leastExpensive;
	}

	private Integer startStock;

	private Integer cocaColaCount;
	private Integer cocaColaZeroCount;
	private Integer cocaColaCherryCount;
	private Integer spriteCount;
	private Integer fantaOrangeCount;
	private Integer fantaGrapeCount;
	private Integer barqsCount;
	private Integer melloYelloCount;
	
	private final Double leastExpensive = 1.00;
	private final Double mostExpensive = 2.00;
	
	private final Double cocaColaCost = leastExpensive;
	private final Double cocaColaZeroCost = 1.25;
	private final Double cocaColaCherryCost = 1.25;
	private final Double spriteCost = 1.50;
	private final Double fantaOrangeCost = 1.75;
	private final Double fantaGrapeCost = 1.75;
	private final Double barqsCost = 1.75;
	private final Double melloYelloCost = mostExpensive;
}
