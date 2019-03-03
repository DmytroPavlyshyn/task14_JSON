package model;

import java.util.Comparator;

public class BankComparator implements Comparator<Bank> {
    @Override
    public int compare(Bank o1, Bank o2) {
        if(o1.getAmountOnDeposit()>o2.getAmountOnDeposit()){
            return 1;
        }
        else if(o1.getAmountOnDeposit()==o2.getAmountOnDeposit()){
             if(o1.getProfitability()>o2.getProfitability()){
                 return 1;
             }
             return 0;
        }
        else {
            return -1;
        }
    }
}
