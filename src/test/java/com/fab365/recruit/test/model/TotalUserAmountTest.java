package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalUserAmountTest {

	private TotalUserAmount totalUserAmount;

	@BeforeEach
	void setUp() {
		totalUserAmount = new TotalUserAmount();
	}

	@DisplayName("초과비용과 요금제를 주입받아 해당 요금제 기준 총 요금액을 반환 검증.")
	@Test
	void createTotalAmountTest() {
		assertThat(totalUserAmount.totalAmountCalculate(100, Fee.FEE_29900).getTotalAmount()).isEqualTo(30000);
		assertThat(totalUserAmount.totalAmountCalculate(100, Fee.FEE_34900).getTotalAmount()).isEqualTo(35000);
		assertThat(totalUserAmount.totalAmountCalculate(100, Fee.FEE_69900).getTotalAmount()).isEqualTo(70000);
	}

	@DisplayName("발생한 총 요금액중 가장 작은 것을 반환하는지 검증.")
	@Test
	void compareTest() {
		totalUserAmount.totalAmountCalculate(200, Fee.FEE_29900);

		assertAll(
			() -> assertThat(totalUserAmount.compareTotalAmount(new TotalUserAmount(100))).isEqualTo(
				new TotalUserAmount(100)),
			() -> assertThat(totalUserAmount.compareTotalAmount(new TotalUserAmount(100000))).isEqualTo(totalUserAmount)
		);
	}
}