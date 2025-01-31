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

    public void analyse(String fileName, BankStatementParser bankStatementParser,
                        final Exporter exporter) throws IOException {
        Path path = Paths.get("src/main/resources/" + fileName);
        List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankStatementParser.parseFromLines(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeTransactions();
        System.out.println(exporter.export(summaryStatistics));
    }

}
