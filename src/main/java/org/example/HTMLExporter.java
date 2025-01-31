package org.example;

public class HTMLExporter implements Exporter {
    @Override
    public String export(SummaryStatistics summaryStatistics) {

        return """
                <!doctype html>"
                <html lang='en'>
                    <head>
                        <title>Bank Transaction Report</title>
                    </head>
                    <body>
                        <ul>
                            <li><strong>The sum is</strong>: $%.2f</li>
                            <li><strong>The average is</strong>: $%.2f</li>
                            <li><strong>The max is</strong>: $%.2f</li>
                            <li><strong>The min is</strong>: $%.2f</li>
                        </ul>
                    </body>
                </html>
                """.formatted(
                    summaryStatistics.getSum(),
                        summaryStatistics.getAverage(),
                        summaryStatistics.getMax(),
                        summaryStatistics.getMin()
                );
    }
}
