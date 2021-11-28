package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalUserAmountTest {

	@DisplayName("초과비용과 요금제를 주입받아 해당 요금제 기준 총 요금액을 반환 검증.")
	@Test
	void createTotalAmountTest() {
		assertThat(new TotalUserAmount(30000).getTotalAmount()).isEqualTo(30000);
	}

	@DisplayName("발생한 총 요금액중 가장 작은 것을 반환하는지 검증.")
	@Test
	void compareTest() {
		TotalUserAmount testTotal = new TotalUserAmount(2000);

		assertAll(
			() -> assertThat(testTotal.compareTotalAmount(new TotalUserAmount(1000))).isEqualTo(
				new TotalUserAmount(1000)),
			() -> assertThat(testTotal.compareTotalAmount(new TotalUserAmount(100000))).isEqualTo(testTotal)
		);
	}
}