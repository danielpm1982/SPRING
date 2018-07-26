package spring4;

public enum DifficultyType {
	ULTRA(1.2f), 
	HARD(1.5f), 
	MEDIUM(1.8f), 
	EASY(2.0f), 
	VERY_EASY(3.0f);
	private final float weight;
	private DifficultyType(float difficultWeightFactor) {
		this.weight=difficultWeightFactor;
	}
	public float getWeight() {
		return weight;
	}
}
