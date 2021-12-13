package com.fab365.recruit.test.model.fee;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.fab365.recruit.test.model.Capacity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserLimitFeeTest {

  private UserLimitFee userType1;
  private UserLimitFee userType2;

  @BeforeEach
  void setUp() {
    userType1 = UserLimitFee.of(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01);
    userType2 = UserLimitFee.of(BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02);
  }

  @DisplayName("요금타입을 주입받아 사용자 요금객체를 생성한다.")
  @Test
  void createUserLimitFeeTest() {

    assertAll(
        () -> assertThat(userType1).isEqualTo(
            new UserLimitFee(
                BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01.feeAmount(),
                BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01.feeCapacity(),
                BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE01.feeName()
            )),
        () -> assertThat(userType2).isEqualTo(
            new UserLimitFee(
                BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02.feeAmount(),
                BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02.feeCapacity(),
                BasicLimitFeeType.BASIC_LIMIT_FEE_TYPE02.feeName()
            ))
    );
  }

  @DisplayName("주입받은 사용량에서 초과사용된 용량을 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {"300,3300,0,300", "3000,300,2700,0"})
  void calculateTotalCapacityTest(int useCapacityType1, int useCapacityType2,
                                  int remainCapacityType1, int remainCapacityType2) {
    assertAll(
        () -> assertThat(userType1.calculateTotalCapacity(useCapacityType1)).isEqualTo(
            new Capacity(remainCapacityType1)),
        () -> assertThat(userType2.calculateTotalCapacity(useCapacityType2)).isEqualTo(
            new Capacity(remainCapacityType2))
    );
  }

  @DisplayName("초과용량을 주입하여 총 요금을 반환한다.")
  @Test
  void calculateTotalAmountTest() {
    assertAll(
        () -> assertThat(
            userType1.resultFee(userType1.calculateTotalCapacity(300))).isEqualTo(
            new UserLimitFee(29900, 300, "29900")),
        () -> assertThat(
            userType2.resultFee(userType2.calculateTotalCapacity(3000))).isEqualTo(
            new UserLimitFee(34900, 3000, "34900"))
    );
  }
}