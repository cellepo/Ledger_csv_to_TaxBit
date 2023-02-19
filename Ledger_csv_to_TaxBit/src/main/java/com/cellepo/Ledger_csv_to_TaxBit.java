package com.cellepo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ledger_csv_to_TaxBit {

    static final String IN_CSV_FILENAME = "in.csv";
    static final String OUT_CSV_FILENAME = "out.csv";
    static final String[] OUT_HEADER_NAMES = {"outA", "outB"};

    public static void main(String[] args) {
        // without a try-with-resources (which automatically closes), must printer.close()
        try(
            CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter(OUT_CSV_FILENAME),
                CSVFormat.Builder.create().setHeader(OUT_HEADER_NAMES).build()
            )
        ){
            Iterable<CSVRecord> rowsIn = CSVFormat.Builder.create().setHeader().build()
                .parse(new FileReader(IN_CSV_FILENAME));
            for(CSVRecord row: rowsIn){
                csvPrinter.printRecord((Object[]) row.values());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
