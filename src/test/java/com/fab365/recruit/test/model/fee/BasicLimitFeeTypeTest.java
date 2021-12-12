package com.fab365.recruit.test.model.fee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicLimitFeeTypeTest {

  @DisplayName("요금제별 각 요금명을 반환한다.")
  @Test
  void return_fee_nameTest() {
    assertAll(
        () -> assertThat(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01.feeName()).isEqualTo("29900"),
        () -> assertThat(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02.feeName()).isEqualTo("34900")
    );
  }

  @DisplayName("요금제별 각 요금을 반환한다.")
  @Test
  void return_fee_amountTest() {
    assertAll(
        () -> assertThat(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01.feeAmount()).isEqualTo(29900),
        () -> assertThat(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02.feeAmount()).isEqualTo(34900)
    );
  }

  @DisplayName("요금제별 각 기본 용량을 반환한다.")
  @Test
  void return_fee_capacityTest() {
    assertAll(
        () -> assertThat(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01.feeCapacity()).isEqualTo(300),
        () -> assertThat(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02.feeCapacity()).isEqualTo(3000)
    );
  }
}