package com.fab365.recruit.test.model.fee;

public enum OverFeeType {
  BASIC_TYPE(1,20),
  LIGHT_TYPE(1,10);

  private final int capacity;
  private final int cost;

  OverFeeType(final int capacity, final int cost) {
    this.capacity = capacity;
    this.cost = cost;
  }

  public int calculateOverPay(int overCapacity){
    return overCapacity * this.cost / this.capacity;
  }
}
