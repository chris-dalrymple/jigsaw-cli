package com.sexyjackal;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

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

        Option opt_e = Option.builder("e")
                        .longOpt("ext")
                        .desc("List of (comma-separated) file extensions to check.")
                        .hasArgs()
                        .required(false)
                        .build();

        Option opt_i = Option.builder("i")
                        .longOpt("include")
                        .desc("List of (comma-separated) folders to include.")
                        .hasArg()
                        .required(false)
                        .build();

        Option opt_x = Option.builder("x")
                        .longOpt("exclude")
                        .desc("List of (comma-separated) folders to exclude.")
                        .hasArg()
                        .required(false)
                        .build();

        options.addOption(opt_h);
        options.addOption(opt_e);
        options.addOption(opt_i);
        options.addOption(opt_x);

        return options;
    }

    private static void printUsage(Options options)
    {
        final HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("gitlicense", options);
        return;
    }

    private static void processCommandLine(CommandLine cmd)
    {
        if (cmd.hasOption("e")) {
            System.out.println("e options: " + cmd.getOptionValue("e"));
        } else if (cmd.hasOption("i")) {
            System.out.println("i options: " + cmd.getOptionValue("i"));
        } else if (cmd.hasOption("x")) {
            System.out.println("x options: " + cmd.getOptionValue("x"));
        } else {
            System.out.println("Unrecognized option.");
        }
        return;
    }

    public static void main( String[] args )
    {
        CommandLineParser parser = new DefaultParser();
        Options options = initOptions();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println(e.getLocalizedMessage());
            printUsage(options);
            return;
        }

        if (cmd.hasOption('h'))
        {
            printUsage(options);
            return;
        } else {
            processCommandLine(cmd);
        }
        
        System.out.println( "Hello World!" );
    }
}
