package edu.uab.cis;

import java.io.Serializable;

public class BankAccount implements Serializable
{
  private int accountno;
  private Double balance;
  private String owner;

  public BankAccount(int no, double bal, String own)
  {
    accountno = no;
    balance = bal;
    owner = own;
  }

  public String toString()
  {
    return accountno + " " + owner.toString() + " = " + balance;
  }
}
