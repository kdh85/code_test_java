package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalUserAmountTest {

	@DisplayName("초과비용과 요금제를 주입받아 해당 요금제 기준 총 요금액을 반환 검증.")
	@Test
	void createTotalAmountTest() {
		assertThat(TotalUserAmount.from(30000).getTotalAmount()).isEqualTo(30000);
	}

	@DisplayName("발생한 총 요금액중 가장 작은 것을 반환하는지 검증.")
	@Test
	void compareTest() {

		assertAll(
			() -> assertThat(TotalUserAmount.from(2000).compareTotalAmount(TotalUserAmount.from(1000))).isEqualTo(
				TotalUserAmount.from(1000)),

			() -> assertThat(TotalUserAmount.from(2000).compareTotalAmount(TotalUserAmount.from(100000))).isEqualTo(
				TotalUserAmount.from(2000))
		);
	}
}