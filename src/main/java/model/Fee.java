package model;

public enum Fee {
	FEE_29900(29900,300),
	FEE_34900(34900,3000),
	FEE_69900(69900,Integer.MAX_VALUE);

	private final int amount;

	private final int basicFreeCapacity;//기본 용량 단위는 Mb로 환산해야 함.

	Fee(int amount, int basicFreeCapacity) {
		this.amount            = amount;
		this.basicFreeCapacity = basicFreeCapacity;
	}

	public int getAmount() {
		return amount;
	}

	public int getBasicFreeCapacity() {
		return basicFreeCapacity;
	}
}
