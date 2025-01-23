package org.example;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String var1);

    List<BankTransaction> parseFromLines(List<String> var1);
}
