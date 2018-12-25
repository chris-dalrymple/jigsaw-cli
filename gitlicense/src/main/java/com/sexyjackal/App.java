package com.sexyjackal;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Options initOptions()
    {
        final Options options = new Options();

        Option opt_h = Option.builder("h")
                        .longOpt("help")
                        .desc("Print this text.")
                        .hasArg(false)
                        .required(false)
                        .build();

        Option opt_b = Option.builder("b").build();

        options.addOption(opt_h);
        options.addOption(opt_b);

        return options;
    }

    private static void printUsage(Options options)
    {
        final HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("gitlicense", options);
        return;
    }

    public static void main( String[] args )
    {
        CommandLineParser parser = new DefaultParser();
        Options options = initOptions();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption('h') || cmd.hasOption("help"))
            {
                printUsage(options);
                return;
            }
        } catch (ParseException e) {
            System.err.println(e.getLocalizedMessage());
            printUsage(options);
            return;
        }
        
        System.out.println( "Hello World!" );
    }
}
