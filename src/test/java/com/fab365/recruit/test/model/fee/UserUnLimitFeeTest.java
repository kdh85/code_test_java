package com.fab365.recruit.test.model.fee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserUnLimitFeeTest {

  private UserUnLimitFee unLimitFee;

  @BeforeEach
  void setUp() {
    unLimitFee = UserUnLimitFee.of(BasicUnLimitFeeType.BASIC_UN_LIMIT_FEE_TYPE01);
  }

  @DisplayName("요금제 금액을 주입하여 무제한 사용자 요금객체를 반환한다.")
  @Test
  void createUserUnLimitFeeTest() {
    assertThat(unLimitFee).isEqualTo(new UserUnLimitFee(69900, "69900"));
  }

  @DisplayName("사용자가 사용한 용량을 주입하여 발생한 총 요금을 반환한다.")
  @Test
  void calculateTotalAmountTest() {
    assertThat(unLimitFee.resultFee()).isEqualTo(new UserUnLimitFee(69900, "69900"));
  }
}