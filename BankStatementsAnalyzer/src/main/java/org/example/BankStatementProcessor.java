package org.example;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = (double)0.0F;

        for(BankTransaction bankTransaction : this.bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    public double calculateTotalInMonth(Month month) {
        double total = (double)0.0F;

        for(BankTransaction bankTransaction : this.bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }

    public double calculateTotalForCategory(String category) {
        double total = (double)0.0F;

        for(BankTransaction bankTransaction : this.bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }
}

