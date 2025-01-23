package org.example;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementsCSVParser implements BankStatementParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankStatementsCSVParser() {
    }

    public BankTransaction parseFrom(String line) {
        String[] columns = line.split(",");
        LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        double amount = Double.parseDouble(columns[1]);
        String description = columns[2];
        return new BankTransaction(date, amount, description);
    }

    public List<BankTransaction> parseFromLines(List<String> lines) {
        List<BankTransaction> bankTransactions = new ArrayList();

        for(String line : lines) {
            bankTransactions.add(this.parseFrom(line));
        }

        return bankTransactions;
    }
}

