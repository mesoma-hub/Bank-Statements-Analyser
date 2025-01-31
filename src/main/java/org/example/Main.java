package org.example;

import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        BankStatementsAnalyser bankStatementsAnalyser = new BankStatementsAnalyser();
        BankStatementParser bankStatementParser = new BankStatementsCSVParser();
        final Exporter exporter = new HTMLExporter();
        bankStatementsAnalyser.analyse("bank_transactions.csv",
                bankStatementParser, exporter);
    }
}