package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FeeTest {

	@DisplayName("각 요금제의 요금을 검증한다.")
	@Test
	void feeAmountTest() {
		assertAll(
			() -> assertThat(Fee.FEE_29900.getAmount()).isEqualTo(29900),
			() -> assertThat(Fee.FEE_34900.getAmount()).isEqualTo(34900),
			() -> assertThat(Fee.FEE_69900.getAmount()).isEqualTo(69900)
		);
	}

	@DisplayName("각 요금제의 기본 제공 데이터용량을 검증한다.")
	@Test
	void feeBasicCapacityTest() {
		assertAll(
			() -> assertThat(Fee.FEE_29900.getBasicFreeCapacity()).isEqualTo(300),
			() -> assertThat(Fee.FEE_34900.getBasicFreeCapacity()).isEqualTo(3000),
			() -> assertThat(Fee.FEE_69900.getBasicFreeCapacity()).isEqualTo(Integer.MAX_VALUE)
		);
	}
}