package com.cellepo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Ledger_csv_to_TaxBitTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Ledger_csv_to_TaxBitTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Ledger_csv_to_TaxBitTest.class );
    }

}
