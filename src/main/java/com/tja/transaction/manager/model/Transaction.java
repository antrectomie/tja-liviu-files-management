package com.tja.transaction.manager.model;

import java.io.Serializable;

public class Transaction implements Serializable {
  private long id;
  private String fromIban;
  private String toIban;
  private double amount;
  private  String fromBank;
  private  String toBank;

  public static Builder newBuilder() {
    return new Builder();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFromIban() {
    return fromIban;
  }

  public void setFromIban(String fromIban) {
    this.fromIban = fromIban;
  }

  public String getToIban() {
    return toIban;
  }

  public void setToIban(String toIban) {
    this.toIban = toIban;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Transaction{"
        + "id="
        + id
        + ", fromIban='"
        + fromIban
        + '\''
        + ", toIban='"
        + toIban
        + '\''
        + ", amount="
        + amount
        + ", fromBank="
        + fromBank
        + ", toBank="
        + toBank
        + '}';
  }

  public static class Builder {
    private long id;
    private String fromIban;
    private String toIban;
    private double amount;
    private String fromBank;
    private String toBank;

    public Builder id(long id) {
      this.id = id;
      return this;
    }

    public Builder fromIban(String fromIban) {
      this.fromIban = fromIban;
      return this;
    }

    public Builder toIban(String toIban) {
      this.toIban = toIban;
      return this;
    }

    public Builder amount(double amount) {
      this.amount = amount;
      return this;
    }

    public Builder fromBank(String bank) {
      this.fromBank = bank;
      return this;
    }

    public Builder toBank(String bank) {
      this.toBank = bank;
      return this;
    }

    public Transaction build() {
      Transaction transaction = new Transaction();
      transaction.amount = this.amount;
      transaction.id = this.id;
      transaction.fromIban = this.fromIban;
      transaction.toIban = this.toIban;
      transaction.fromBank = this.fromBank;
      transaction.toBank = this.toBank;
      return transaction;
    }
  }
}
