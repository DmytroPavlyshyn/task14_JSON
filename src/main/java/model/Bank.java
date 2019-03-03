package model;

import java.time.LocalDate;
import java.util.EnumSet;

public class Bank {
    private int bankId;
    private String name;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private EnumSet<DepositType> depositTypes;
    private String depositor;
    private int accountId;
    private int amountOnDeposit;
    private int profitability;
    private LocalDate duration;

    public Bank() {
    }

    public Bank(int bankId, String name, String country, EnumSet<DepositType> depositTypes, String depositor, int accountId, int amountOnDeposit, int profitability, LocalDate duration) {
        this.bankId = bankId;
        this.name = name;
        this.country = country;
        this.depositTypes = depositTypes;
        this.depositor = depositor;
        this.accountId = accountId;
        this.amountOnDeposit = amountOnDeposit;
        this.profitability = profitability;
        this.duration = duration;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumSet<DepositType> getDepositTypes() {
        return depositTypes;
    }

    public void setDepositTypes(EnumSet<DepositType> depositTypes) {
        this.depositTypes = depositTypes;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAmountOnDeposit() {
        return amountOnDeposit;
    }

    public void setAmountOnDeposit(int amountOnDeposit) {
        this.amountOnDeposit = amountOnDeposit;
    }

    public int getProfitability() {
        return profitability;
    }

    public void setProfitability(int profitability) {
        this.profitability = profitability;
    }

    public LocalDate getDuration() {
        return duration;
    }

    public void setTimeConstraints(LocalDate duration) {
        this.duration = duration;
    }

    public void setDuration(LocalDate duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankId=" + bankId +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", depositTypes=" + depositTypes +
                ", depositor='" + depositor + '\'' +
                ", accountId=" + accountId +
                ", amountOnDeposit=" + amountOnDeposit +
                ", profitability=" + profitability +
                ", duration='" + duration + '\'' +
                '}';
    }
}
