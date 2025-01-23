package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementsAnalyser {
    public static final String RESOURCES = "src/main/resources/";

    public BankStatementsAnalyser() {
    }

    public void analyse(String fileName, BankStatementParser bankStatementParser) throws IOException {
        Path path = Paths.get("src/main/resources/" + fileName);
        List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankStatementParser.parseFromLines(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total transactions in January " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total transactions in February " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received: " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
