package src.main.java;

import java.util.*;

public class Predicate {

	private String Name;
	private String Author;
	private String Date;
	private String Description;
	private List<AdditionalEntry> AdditionalEntries;
	
	//private List<String> CallsNames;
	private List<Call> CallsNames;
	private List<Predicate> Calls;
	private boolean dynamic;
	private boolean meta;
	private int Arity;
	private int[] StartLines;
	private int[] EndLines;
		
	
	public Predicate(){
		
		Calls = new LinkedList<Predicate>();
		setCallsNames(new LinkedList<Call>());
		AdditionalEntries = new LinkedList<AdditionalEntry>();
	}
	
	public Predicate(String name){
		
		this.Name = name;
		Calls = new LinkedList<Predicate>();
		setCallsNames(new LinkedList<Call>());
		AdditionalEntries = new LinkedList<AdditionalEntry>();
	}

	public Predicate( String name, int arity ){
		
		this.Name = name;
		this.Arity = arity;
		Calls = new LinkedList<Predicate>();
		setCallsNames(new LinkedList<Call>());
		AdditionalEntries = new LinkedList<AdditionalEntry>();
	}
	

	public void addAdditionalEntry( String key, String entry){
		
		AdditionalEntry newEntry = new AdditionalEntry(key, entry);
		this.AdditionalEntries.add(newEntry);
	}
	
	public void setName(String name) {
		Name = name;
	}


	public String getName() {
		return Name;
	}


	public void setAuthor(String author) {
		Author = author;
	}


	public String getAuthor() {
		return Author;
	}


	public void setDate(String date) {
		Date = date;
	}


	public String getDate() {
		return Date;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getDescription() {
		return Description;
	}


	public void setAdditionalEntries(List<AdditionalEntry> additionalEntries) {
		AdditionalEntries = additionalEntries;
	}


	public List<AdditionalEntry> getAdditionalEntries() {
		return AdditionalEntries;
	}


	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}


	public boolean isDynamic() {
		return dynamic;
	}


	public void setMeta(boolean meta) {
		this.meta = meta;
	}


	public boolean isMeta() {
		return meta;
	}


	public void setArity(int arity) {
		Arity = arity;
	}


	public int getArity() {
		return Arity;
	}

	public void setStartLines(int[] startLines) {
		StartLines = startLines;
	}

	public int[] getStartLines() {
		return StartLines;
	}

	public void setEndLines(int[] endLines) {
		EndLines = endLines;
	}

	public int[] getEndLines() {
		return EndLines;
	}
	
	public void setCalls(List<Predicate> calls) {
		Calls = calls;
	}

	public List<Predicate> getCalls() {
		return Calls;
	}
	
	public void addCall(Predicate call){
		this.Calls.add(call);
	}

	public void setCallsNames(List<Call> callsNames) {
		CallsNames = callsNames;
	}

	public List<Call> getCallsNames() {
		return CallsNames;
	}
	
	public void addCallNames(String name, String module, String arity ){
		Call addCall = new Call(name, module, arity);
		this.CallsNames.add(addCall);
	}

}
