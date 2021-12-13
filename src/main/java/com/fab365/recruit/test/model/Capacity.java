package com.fab365.recruit.test.model;

import java.util.Objects;

public class Capacity {

  private static final int DEFAULT_CAPACITY = 0;
  private static final String ERROR_DEFAULT_CAPACITY_VALUE = String.format(
      "생성 가능한 최소 용량은 %d 이상입니다.", DEFAULT_CAPACITY);
  private final int capacity;

  public Capacity(final int capacity) {
    if (isLessThanDefault(capacity)) {
      throw new IllegalArgumentException(ERROR_DEFAULT_CAPACITY_VALUE);
    }
    this.capacity = capacity;
  }

  private boolean isLessThanDefault(final int capacity) {
    return capacity < DEFAULT_CAPACITY;
  }

  public Capacity getOverCapacity(final int useCapacity) {
    int remainCapacity = getRemainCapacity(useCapacity);

    if (isLessThanDefault(remainCapacity)) {
      return new Capacity(DEFAULT_CAPACITY);
    }

    return new Capacity(remainCapacity);
  }

  private int getRemainCapacity(final int useCapacity) {
    return useCapacity - this.capacity;
  }

  public int getCapacity() {
    return capacity;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Capacity capacity1 = (Capacity) o;
    return capacity == capacity1.capacity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(capacity);
  }

  @Override
  public String toString() {
    return "Capacity{" +
        "capacity=" + capacity +
        '}';
  }
}
