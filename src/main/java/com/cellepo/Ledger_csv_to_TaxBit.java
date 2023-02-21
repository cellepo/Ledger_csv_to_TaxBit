package com.cellepo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ledger_csv_to_TaxBit {

    static final String[] OUT_HEADER_NAMES = {"outA", "outB"};

    public static void main(String[] args) {
        String inFilename = args[0];
        String outFilename = args[1];
        // without a try-with-resources (which automatically closes), must printer.close()
        try(
            CSVPrinter csvPrinter = new CSVPrinter(
                new FileWriter(outFilename),
                CSVFormat.Builder.create().setHeader(OUT_HEADER_NAMES).build()
            )
        ){
            Iterable<CSVRecord> rowsIn;
            try {
                rowsIn = CSVFormat.Builder.create().setHeader().build().parse(new FileReader(inFilename));

            } catch(FileNotFoundException fnfe){
                System.out.println("inFilename arg not found: \"" + inFilename + "\"");
                return;
            }
            for(CSVRecord row: rowsIn){
                csvPrinter.printRecord((Object[]) row.values());
            }

        } catch (IOException ioe) {
            System.out.println("Error creating either FileWriter, CSVPrinter, or FileReader");
            ioe.printStackTrace();
        }
    }

}
