package src.main.java;

import java.io.*;
import java.util.*;

public class HTML_Generator {

	private String code = "";
	private String moduleLinks ="";
	public HTML_Generator(){
		
	}
	
	public void generateDoc( List<Module> modules){
		
		this.setModuleLinks(modules);
		for(int i = 0; i < modules.size(); i++){
			try {
				this.generateSinglePage(modules.get(i));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}
	
	
	private void generateSinglePage(Module m) throws IOException{
		BufferedReader br;
			br = new BufferedReader(new FileReader("src/main/resources/beginning_to_Modules.x"));
		
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null && !line.equalsIgnoreCase("null") ) {
		            sb.append(line);
		            sb.append("\n");
		            line = br.readLine();
		        }
		        code+= sb.toString();
		    } finally {
		        br.close();
		    }
		    code += m.getName().replaceAll("\"", "")+".html";
		    code += "\" name=\""+m.getName().replaceAll("\"", "")+"\">"+m.getName().replaceAll("\"", "")+"</a></h1> \n	<br><br><br>\n  </div> \n <div id=\"b2\" class=\"box\" style=\"font-family:verdana;padding:40px;border-radius:10px;border:2px solid #a7bec6; background-color:#ffffff;\">\n<h3>Modules</h3>\n";
		    code += moduleLinks;
		    
		    code += "<h3>Predicates of "+m.getName()+"</h3>\n";

		    for(int i = 0; i < m.getPredicates().size(); i++){
		    	code += "<h4><a href=\"#"+ m.getPredicates().get(i).getName().replaceAll("\"", "")+m.getPredicates().get(i).getArity()+"\">"+ m.getPredicates().get(i).getName().replaceAll("\"", "")+"/"+ m.getPredicates().get(i).getArity() +"</a></h4>\n";
		    }
		    code += "</div>\n";
		    
		    code += "  <div id=\"b3\" class=\"box\" style=\"font-family:verdana;padding:40px;border-radius:10px;border:2px solid #a7bec6; background-color:#ffffff;\"><div style=\"font-family:verdana;padding:40px;border-radius:10px;border:2px solid #a7bec6; background-color:#ffffff;\">\n";
		    
		    for(int i = 0; i < m.getPredicates().size(); i++){
		    	code += "<h4><a href=\"#"+ m.getPredicates().get(i).getName().replaceAll("\"", "")+m.getPredicates().get(i).getArity()+"\">"+ m.getPredicates().get(i).getName().replaceAll("\"", "")+"/"+ m.getPredicates().get(i).getArity() +"</a></h4>\n";
		    }
		    
		    code += "</div><br><br>";
		    
		    for(int i = 0; i < m.getPredicates().size(); i++){
		    	Predicate p = m.getPredicates().get(i);
		    	code += "<div id=\"inner\" style=\"font-family:verdana;padding:40px;border-radius:10px;border:2px solid #a7bec6;\">\n";
				code +=	"<h2><a name=\""+p.getName().replaceAll("\"", "")+p.getArity()+"\">"+p.getName().replaceAll("\"", "")+"/" +p.getArity()+"</a></h2>";
				if(p.getAuthor() != null)	code += "<p>"+"Author"+": "+p.getAuthor()+"</p>";
				if(p.getDate() != null)	code += "<p>"+"Date"+": "+p.getDate()+"</p>";
				if(p.getDescription() != null)	code += "<p>"+"Description"+": "+p.getDescription()+"</p>";
				
				for(int k = 0; k < p.getAdditionalEntries().size(); k++){
					code += "<p>"+p.getAdditionalEntries().get(k).getIdentifier()+": "+p.getAdditionalEntries().get(k).getDescription()+"</p>\n";
				}
				code += "<p>"+"Arity"+": "+p.getArity()+"</p>\n";
				code += "<p>"+"Dynamic"+": "+p.isDynamic()+"</p>\n";
				code += "<p>"+"Meta"+": "+p.isMeta()+"</p>\n";
				
				if(p.getCallsNames().size() > 0) code += "<p>"+"Calls:"+"</p>\n";
				
				for(int k = 0; k < p.getCallsNames().size(); k ++){
					Call call = p.getCallsNames().get(k);
					String callName = call.getName().replaceAll("\"", "");
					String callModule = call.getModule().replaceAll("\"", "");
					int callArity = call.getArity();
					code += "<div style=\"text-indent:30px;\">\n";
					
					if(callModule.equalsIgnoreCase("built_in")){
						code += "<p>"+"Module"+": \t"+callModule+"</p>\n";
						code += "<p>"+"Name"+": \t"+callName+"</p>\n";
					}else{
						code += "<h4><a href=\""+callModule+".html#"+callName+callArity+"\">"+"Name"+": \t"+callName+"</a></h4>\n";
						code += "<h4><a href=\""+callModule+".html\">"+"Module"+": \t"+callModule+"</a></h4>\n";
					}
					
					code += "<p>"+"Arity"+": \t"+callArity+"</p></div><br>";
				}
				code += "<div class=\"box\" style=\"font-family:verdana;padding:40px;border-radius:10px;border:2px solid #a7bec6; background-color:#fffffa;\">\n";
				code += "<p>"+ p.getCodeString() + "</p>\n";
				code += "</div>\n";
				code += "</div><br><br>\n\n\n";
		     }
		    code += "</div>";
		    code += "	</body>\n</html>";
		    this.writeToFile(m);
		    code = "";
		    
	}
	
	
	private void writeToFile(Module m){
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter( new FileWriter( m.getName().replaceAll("\"", "")+".html"));
			writer.write(code);

		}
		catch ( IOException e)
		{
		}
		finally
		{
			try
			{
				if ( writer != null)
					writer.close( );
			}
			catch ( IOException e)
			{
			}
	     }
	}
	
	private void setModuleLinks(List<Module> modules){
		for(int i = 0; i < modules.size(); i++){
			moduleLinks +=	"<h4><a href=\""+ modules.get(i).getName().replaceAll("\"", "")+".html\">"+ modules.get(i).getName()+"</a></h4>";
		}
	}
}
