package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        String var10000 = String.valueOf(this.date);
        return "BankTransaction{date=" + var10000 + ", amount=" + this.amount + ", description='" + this.description + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof BankTransaction)) {
            return false;
        } else {
            BankTransaction that = (BankTransaction)o;
            return Double.compare(this.getAmount(), that.getAmount()) == 0 && Objects.equals(this.getDate(), that.getDate()) && Objects.equals(this.getDescription(), that.getDescription());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getDate(), this.getAmount(), this.getDescription()});
    }
}

