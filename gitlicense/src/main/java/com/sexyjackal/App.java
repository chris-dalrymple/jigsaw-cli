package com.sexyjackal;

import org.apache.commons.cli.Options;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Options initOptions()
    {
        final Options options = new Options();

        return options;
    }

    public static void main( String[] args )
    {
        Options options = initOptions();
        System.out.println( "Hello World!" );
    }
}
