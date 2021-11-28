package com.fab365.recruit.test.model;

import java.util.Arrays;

public enum Fee {
	FEE_29900(29900, 300),
	FEE_34900(34900, 3000),
	FEE_69900(69900, Integer.MAX_VALUE);

	private static final String ERROR_NOTHING_MATCH_FEE = "알맞은 요금제가 없습니다.";

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

	public static String recommendFee(TotalUserAmount minimumTotal) {
		return Arrays.stream(values())
			.filter(fee -> isSameOrLessThan(minimumTotal, fee))
			.map(fee -> String.valueOf(fee.getAmount()))
			.reduce((firstFee, secondFee) -> secondFee)
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOTHING_MATCH_FEE));
	}

	private static boolean isSameOrLessThan(TotalUserAmount minimumTotal, Fee fee) {
		return fee.getAmount() <= minimumTotal.getTotalAmount();
	}
}
