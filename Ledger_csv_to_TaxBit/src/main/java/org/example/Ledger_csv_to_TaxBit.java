package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;

public class Ledger_csv_to_TaxBit {

    public static void main(String[] args) {
        final String[] HEADERS = {"A", "B"};
        // must printer.close() without a try-with-resources (which automatically closes)
        try(
            CSVPrinter printer = new CSVPrinter(
                new FileWriter("out.csv"), CSVFormat.DEFAULT.withHeader(HEADERS)
            )
        ){
            printer.printRecord("a1", "b1");
            printer.printRecord("a2", "b2");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
