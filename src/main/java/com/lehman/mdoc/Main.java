package com.lehman.mdoc;

import org.apache.commons.cli.*;


public class Main {
    public static void main(String[] args) {
        // create the command line parser
        CommandLineParser parser = new DefaultParser();

        // create the Options
        Options options = new Options();

        // Help option
        Option help = new Option("h", "help", false, "print this message" );
        options.addOption(help);

        Option index   = OptionBuilder.withArgName( "indexFile" )
                .hasArg()
                .withLongOpt("index")
                .withDescription(  "index given file" )
                .create( "i" );
        options.addOption(index);

        Option search   = OptionBuilder.withArgName( "searchString" )
                .hasArg()
                .withLongOpt("search")
                .withDescription(  "search for string" )
                .create( "s" );
        options.addOption(search);

        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);

            // has the help argument been passed?
            if(line.hasOption("help")) {
                printHelp(options);
            } else if (line.hasOption("i")) {
                System.out.println("index ...");
            } else if (line.hasOption("s")) {
                System.out.println("search ...");
            } else {
                printHelp(options);
            }

        }
        catch( ParseException exp ) {
            System.out.println("CLI parse exception:" + exp.getMessage());
        }
    }

    public static void printHelp(Options options) {
        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        String header = "\nmdoc v1.0 - written by austin lehman\n" +
                "Copyright 2020 Roseville Code Inc.\n" +
                "License: GNU General Public License v3.0\n\n";
        formatter.printHelp("mdoc", header, options, "", true);
    }
}
