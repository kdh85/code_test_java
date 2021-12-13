package com.fab365.recruit.test.model.fee;

import java.util.Objects;

public class FeeName {

  private static final String ERROR_FEE_NAME = "요금제명은 빈값일 수 없습니다.";
  private final String feeName;

  public FeeName(final String feeName) {
    validationFeeName(feeName);
    this.feeName = feeName;
  }

  private void validationFeeName(final String feeName) {
    if(isBlank(feeName)){
      throw new IllegalArgumentException(ERROR_FEE_NAME);
    }
  }

  private boolean isBlank(final String feeName) {
    return feeName == null || feeName.isEmpty();
  }

  public String getFeeName() {
    return feeName;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final FeeName feeName1 = (FeeName) o;
    return Objects.equals(feeName, feeName1.feeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feeName);
  }

  @Override
  public String toString() {
    return "FeeName{" +
        "feeName='" + feeName + '\'' +
        '}';
  }
}
