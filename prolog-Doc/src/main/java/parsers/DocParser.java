package src.main.java.parsers;

import java.util.*;

import node.*;
import analysis.*;

public class DocParser extends DepthFirstAdapter{
	

	
	public List<DocInformation>	 DocInfo;
	
	private int currentPredicate;
	
	
	
	public DocParser(){
		
		DocInfo = new LinkedList<DocInformation>();
	}
	
	@Override
	public void caseAStartAst( AStartAst docs){
		
		int docs_size = docs.getAst().size();
		currentPredicate = 0;

		
		
		for(int i = 0; i < docs_size; i++){
	
			DocInformation DocEntry = new DocInformation();
			DocInfo.add(DocEntry);
			
			docs.getAst().get(i).apply(this);
			currentPredicate ++;
		}
	}
	
	@Override
	public void caseAEntriesAst( AEntriesAst entries){
		
		int entries_size = entries.getAst().size();
		for(int i = 0; i < entries_size; i ++){
			
			entries.getAst().get(i).apply(this);
		}
	}
	
	@Override
	public void caseAAuthorAst( AAuthorAst entries){
		
		int entries_size = entries.getAst().size();
		String returnAuthor = "";
		for (int i = 0; i < entries_size; i ++) {
			
			String currentAuthor = entries.getAst().get(i).toString();
			returnAuthor += currentAuthor;
			entries.getAst().get(i).apply(this);
		}
		
		//returnAuthor = returnAuthor.replaceFirst("\\*+", "");
		DocInfo.get(currentPredicate).setAuthor(returnAuthor);
		
	}
	
	@Override
	public void caseADateAst( ADateAst entries){
		
		int entries_size = entries.getAst().size();
		String returnDate = "";
		for (int i = 0; i < entries_size; i ++) {
			
			String currentDate = entries.getAst().get(i).toString();
			//System.out.println( currentDate );
			returnDate += currentDate;
			entries.getAst().get(i).apply(this);
		}
		//returnDate = returnDate.replaceFirst("\\*+", "");
		DocInfo.get(currentPredicate).setDate(returnDate);
		
	}
	
	@Override
	public void caseAModeAst( AModeAst entries){
		
		int entries_size = entries.getAst().size();
		String returnMode = "";
		for (int i = 0; i < entries_size; i ++) {
			
			String currentMode = entries.getAst().get(i).toString();
			//System.out.println( currentDate );
			if (i>=entries_size-1 && !currentMode.contains("*") || i<entries_size-1)
				returnMode += currentMode;
			entries.getAst().get(i).apply(this);
		}
		
		//returnMode = returnMode.replaceFirst("\\*+", "");
		DocInfo.get(currentPredicate).setMode(returnMode);
		
	}
	
	@Override
	public void caseADescrAst( ADescrAst entries){
		
		int entries_size = entries.getAst().size();
		String returnDescr = "<br>";
		for (int i = 0; i < entries_size; i ++) {
			
			String currentDescr = entries.getAst().get(i).toString();
			currentDescr = currentDescr.substring(0, currentDescr.length()-1);
			currentDescr = currentDescr.replaceAll("@@", "@");
			returnDescr += currentDescr;
			entries.getAst().get(i).apply(this);
			
		}
		if(returnDescr.charAt(returnDescr.length()-1) == ' ') returnDescr = returnDescr.substring(0, returnDescr.length()-1);
		if(returnDescr.charAt(returnDescr.length()-1) == '*') returnDescr = returnDescr.substring(0, returnDescr.length()-1);
		returnDescr = returnDescr.replaceAll("\n", "\n<br>");
		returnDescr = returnDescr.replaceFirst("\\*+", "");
		
		if(DocInfo.get(currentPredicate).getDescription()!=null) returnDescr = DocInfo.get(currentPredicate).getDescription() + returnDescr;
		DocInfo.get(currentPredicate).setDescription(returnDescr);
		
	}
	
	@Override
	public void caseAAtDocAst(AAtDocAst entry){
		
		String entryKey = entry.getIdentifier().toString().replaceAll("@", "");
		
		String returnDescr = "";
		for (int i = 0; i < entry.getDescription().size(); i ++) {
			
			String currentDescr = entry.getDescription().get(i).toString();
			currentDescr = currentDescr.replaceAll("@@", "@");
			returnDescr += currentDescr;
			entry.getDescription().get(i).apply(this);
			
		}
		if(returnDescr.charAt(returnDescr.length()-1) == ' ') returnDescr = returnDescr.substring(0, returnDescr.length()-1);
		if(returnDescr.charAt(returnDescr.length()-1) == '*') returnDescr = returnDescr.substring(0, returnDescr.length()-1);
		returnDescr = returnDescr.replaceAll("\n", "\n<br>");
		
		DocInfo.get(currentPredicate).addAdditionalEntry(entryKey, returnDescr); 
		

	}
	
	@Override
	public void caseASingleAtDocAst(ASingleAtDocAst entry){
		
		String entryKey = entry.getIdentifier().toString().replaceAll("@", "");
		String returnDescr = "";
		for (int i = 0; i < entry.getDescription().size(); i ++) {
			
			String currentDescr = entry.getDescription().get(i).toString();
			currentDescr = currentDescr.replaceAll("@@", "@");
			returnDescr += currentDescr;
			entry.getDescription().get(i).apply(this);
			
		}
		if(returnDescr.charAt(returnDescr.length()-1) == ' ') returnDescr = returnDescr.substring(0, returnDescr.length()-1);
		if(returnDescr.charAt(returnDescr.length()-1) == '*') returnDescr = returnDescr.substring(0, returnDescr.length()-1);
		returnDescr = returnDescr.replaceAll("\n", "\n<br>");
		
		DocInfo.get(currentPredicate).addAdditionalEntry(entryKey, returnDescr); 
		

	}
	
	
	
	@Override
	public void caseAStringBAst(AStringBAst token){
		
		DocInfo.get(currentPredicate).setLine(token.getStringDocStar().getLine());
	}
	
	@Override
	public void caseAStringFAst(AStringFAst token){
		
		DocInfo.get(currentPredicate).setLine(token.getDocSingleString().getLine());
	}
	
	@Override
	public void caseAStringGAst(AStringGAst token){
		
		DocInfo.get(currentPredicate).setLine(token.getSingleDocMail().getLine());
	}
	
	
}
