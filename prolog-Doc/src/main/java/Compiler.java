package src.main.java;

import parser.*;

import lexer.*;
import node.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.lang.* ;



public class Compiler {
	
	public static String filename;
	public static List<DocInformation> docInfos;
	public static List<Predicate> Predicates;
	
	public static void main(String args[]) throws ParserException, LexerException, InterruptedException
	{
	   try
	   {
		  filename = args[0];
		  File file = new File(filename);
		  PushbackReader reader = new PushbackReader(new FileReader(file)); 
		  Lexer lexer = new Lexer(reader); 
		  Parser parser = new Parser(lexer); 
		  Start tree = parser.parse();
		  ASTPrinter lala = new ASTPrinter();
		  tree.apply(lala);
		 
		  DocParser docCollector = new DocParser();
		  tree.apply( docCollector);
		  
		  
		  debugDocOutput( docCollector.DocInfo );
		  docInfos = docCollector.DocInfo;
		  
		  /*
		   *  [codeq_analyzer], tell('foo.clj'), prolog_flag(redefine_warnings, _, off),on_exception(X,(use_module('test.pl'),write_clj_representation,told, halt),(print('{:error \"'),print(X),print('\"}'),nl,halt(1))).
		   */
	   }
		catch(IOException e)
		{
		 // do something 
		 System.out.println(e.getMessage());
		}

		try
		{
		  String cmd = "	sicstus -l codeq_analyzer --goal \"tell('foo.xml'), prolog_flag(redefine_warnings, _, off),on_exception(X,(use_module('"+filename+"'),write_clj_representation,told, halt),(print('{:error \"'),print(X),print('\"}'),nl,halt(1))).\"" ;
		  
		  Process p = Runtime.getRuntime().exec(new String[] { 
                  "bash", "-c", 
                  cmd });
		  
		  //Process p = Runtime.getRuntime().exec(cmd);
		  p.waitFor();
		  
		  CodeqParser codeqParser = new CodeqParser();
		  codeqParser.parseXML("foo.xml");
		  debugOutput(codeqParser.Predicates);
		  
		  Predicates = codeqParser.Predicates;
		  
		 }catch( Exception e)
		{
			System.out.println( e.getMessage() );
		}
		 
		  
		  InformationMerger merger = new InformationMerger();
		  merger.mergeModuleInformation(Predicates, docInfos);
		  
	}
	
	public static void debugOutput( List<Predicate> predicates){
		
		for(int i = 0; i<predicates.size(); i++){
			
			System.out.println("-------------");
			System.out.println(predicates.get(i).getName());
			System.out.println("\tDynmc: "+predicates.get(i).isDynamic());
			System.out.println("\tMeta: "+predicates.get(i).isMeta());

			List<Call> calls = predicates.get(i).getCallsNames();
			System.out.println("\tCalls:");
			for(int k = 0; k < calls.size(); k++){
				System.out.println("\t\tname: "+calls.get(k).getName());
				System.out.println("\t\tmodule: "+calls.get(k).getModule());
				System.out.println("\t\tarity: "+calls.get(k).getArity() + "\n");
			}
			System.out.println("--------\n");
		}
	}
	
	public static void debugDocOutput( List<DocInformation> info){
		
		System.out.println("_______ DocInfo ___________\n");
		for (int i = 0; i< info.size(); i++) {
			
			System.out.println("--------------");
			System.out.println( "Author: " + info.get(i).getAuthor());
			System.out.println( "Date: " + info.get(i).getDate());
			System.out.println( "Descr: " + info.get(i).getDescription());
			System.out.println( "Line: " + info.get(i).getLine());
			for(int k = 0; k < info.get(i).getAdditionalEntries().size(); k ++){
				System.out.println ( info.get(i).getAdditionalEntries().get(k).getIdentifier()+": "+info.get(i).getAdditionalEntries().get(k).getDescription());
			}
				System.out.println("----------\n");
		}
		System.out.println("\n______________________\n\n");
	}
}