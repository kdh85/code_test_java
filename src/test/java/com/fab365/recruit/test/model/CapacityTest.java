package com.fab365.recruit.test.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CapacityTest {

  @DisplayName("용량값을 주입 받아 용량 객체를 반환 검증.")
  @Test
  void createCapacityTest() {
    assertThat(new Capacity(100)).isEqualTo(new Capacity(100));
  }

  @DisplayName("주입되는 용량값이 0 미만인 경우 에러를 반환 검증.")
  @Test
  void validationCapacityTest() {
    assertThatThrownBy(
        () -> new Capacity(-1)
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사용량을 주입받아 설정된 용량의 초과 사용분을 반환다. 초과가 없을 경우 0을 반환한다.")
  @Test
  void getOverCapacityTest() {
    assertAll(
        () -> assertThat(new Capacity(100).getOverCapacity(200)).isEqualTo(new Capacity(100)),
        () -> assertThat(new Capacity(100).getOverCapacity(50)).isEqualTo(new Capacity(0))
    );
  }
}