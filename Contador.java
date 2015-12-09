import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Contador{
	String nameFile;
	Integer count;
	HashMap<String,Integer> dictionary;
	HashMap<String,Integer> dictionaryAux;
	HashMap<String,String> dictionaryWords;
	List<String> wordsRepeat = new ArrayList<String>();
	
	Contador(String name){
		this.nameFile = name;
	}
	
	public void contar(){
		dictionary = new HashMap<String,Integer>();
		dictionaryAux = new HashMap<String,Integer>();
		count=0;
		Scanner sc = null;		
		this.loadWords();
		try{
			sc = new Scanner(new File(nameFile));
			//Agrega un delimitador en este caso
			sc.useDelimiter(",|\\p{javaWhitespace}+|\\,|\\.|\\[|\\]|\\(|\\)|\\«|\\»|\"|\\/|\\:|\\>|\\<|\\\\|\\!|\\¡|\\#|\\$|\\%|\\&|\\=|\\?|\\¿|\\'|\\;|\\+|\\*|\\-|\\_|\\{|\\}|\\@|\\^|\\°");		
			String cad = "" ;
			while(sc.hasNext()){
				cad = sc.next();
				cad = cad.trim();
				if(!(cad.compareTo("")==0)){
					count++;
					cad = cad.toLowerCase();
					if(dictionary.get(cad)==null){
						dictionary.put(cad, 1);						
					}else{
						int cont = dictionary.get(cad);
						cont++;
						dictionary.put(cad, cont);
					}
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("Archivo no Encontrado");
		}		
		//Ordena las palabras por el mumero de veces que aparece
		for(String cad : dictionary.keySet()){
			if(wordsRepeat.size()==0){
				wordsRepeat.add(cad);
			}else{
				int cont=0;
				while(cont<wordsRepeat.size() && dictionary.get(wordsRepeat.get(cont))>dictionary.get(cad)){
					cont++;
				}
				wordsRepeat.add(cont,cad);
			}
		}
		System.out.println("Total de Palabras = "+count);
		System.out.println("Total de Palabras sin auxiliares = "+(dictionary.size()-dictionaryAux.size()));
		System.out.println("\n<-- Top 10 Palabras Repetidas -->");
		int index=0;
		int top=0;
		while(index<wordsRepeat.size() && top<10){
			if(dictionaryWords.get(wordsRepeat.get(index))==null){
				System.out.println(wordsRepeat.get(index)+"= "+dictionary.get(wordsRepeat.get(index)));
				top++;
			}
			index++;
		}
		
		this.saveFile(nameFile.substring(0,nameFile.length()-4)+"Report.txt");
	}
	
	public void loadWords(){
		dictionaryWords = new HashMap<String,String>();
		Scanner scc=null;
		try{
			scc = new Scanner(new File("stopwords.txt"));
			String cad = "" ;
			while(scc.hasNextLine()){
				cad = scc.nextLine();
				cad = cad.trim();
				if(!(cad.compareTo("")==0)){
					dictionaryWords.put(cad,"");						
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("Archivo no Encontrado..");
		}
	}
	
	public void saveFile(String nameReport){
		File file = new File(nameReport);
		
		try{
			FileWriter w = new FileWriter(file); 
			BufferedWriter bw = new BufferedWriter(w);
			bw.write("Total de Palabras = "+count+"\r");
			bw.write("Total de Palabras sin auxiliares = "+(dictionary.size()-dictionaryAux.size())+"\r");
			bw.write("\r<-- Palabras Repetidas Por Numero de Aparición-->\r");
			for(int i=0;i<wordsRepeat.size();i++){
				bw.write(wordsRepeat.get(i)+" = "+dictionary.get(wordsRepeat.get(i))+"\r");
			}
			bw.close();
		}catch(IOException e){
			System.out.println("Error Al crear Archivo");
		}
	}
	
	public static void main(String[] args) {
		Contador file = new Contador(args[0]);
		file.contar();
	}

}
