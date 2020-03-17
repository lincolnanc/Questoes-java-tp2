import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.*;
/*
   @date:19/02/2019
   @author:Lincoln Antunes Nogueira Coutinho
   @param:nenhum
   @return:nenhum
   @Copyright notice:classe que cria varios presidente
 */

class Presidente{
	private int id;
	private String nome;
	private int idade;
	private LocalDateTime dataNascimento;
	private String localNascimento;
	private LocalDateTime inicioMandato;
	private LocalDateTime fimMandato;
	private LocalDateTime dataMorte;
	private String localMorte;
	private String antecessor;
	private String sucessor;
	private String vice;
	private String pagina;
	private long paginaTam;

	public void Presidente(){
		setId(0);
		setNome("");
		setIdade(0);
		setDataNascimento(LocalDateTime.now());
		setLocalNascimento("");
		setInicioMandato(LocalDateTime.now());
		setFimMandato(LocalDateTime.now());
		setDataMorte(LocalDateTime.now());
		setLocalMorte("");
		setAntecessor("");
		setSucessor("");
		setVice("");
		setPagina("");
		setPaginaTam(0);
	}//fim Presidente()	
	public void Presidente(int id, String nome,int idade ){
		setId(id);
		setNome(nome);
		setIdade(idade);
		setDataNascimento(LocalDateTime.now());
		setLocalNascimento("");
		setInicioMandato(LocalDateTime.now());
		setFimMandato(LocalDateTime.now());
		setDataMorte(LocalDateTime.now());
		setLocalMorte("");
		setAntecessor("");
		setSucessor("");
		setVice("");
		setPagina("");
		setPaginaTam(0);
	}//fim Presidente()
	/*   
	     @param: atributos lidos do arquivo
	     @return:nenhum
	     @Copyright notice: sets
	 */
	public void setId(int id){
		this.id=id;
	}//fim setId()

	public void setNome(String nome){
		this.nome=nome;
	}//fim setNome()

	public void setIdade(int idade){
		this.idade=idade;
	}//fim setIdade() 

	public void setDataNascimento(LocalDateTime dataNascimento){
		this.dataNascimento=dataNascimento;
	}//fim setDataNascimento()

	public void setLocalNascimento(String localNascimento){
		this.localNascimento=localNascimento;
	}//fim setLocalNascimento() 

	public void setInicioMandato(LocalDateTime inicioMandato){
		this.inicioMandato=inicioMandato;
	}//fim setInicioMandato() 

	public void setFimMandato(LocalDateTime fimMandato){
		this.fimMandato=fimMandato;
	}//fim setFimMandato()  

	public void setDataMorte(LocalDateTime dataMorte){
		this.dataMorte=dataMorte;
	}//fim setDataMorte()

	public void setLocalMorte(String localMorte){
		this.localMorte=localMorte;
	}//fim setLocalMorte() 

	public void setAntecessor(String antecessor){
		this.antecessor=antecessor;
	}//fim setAntecessor()  

	public void setSucessor(String sucessor){
		this.sucessor=sucessor;
	}//fim setSucessor()  

	public void setVice(String vice){
		this.vice=vice;
	}//fim setVice() 

	public void setPagina(String pagina){
		this.pagina=pagina;
	}//fim setPagina()  

	public void setPaginaTam(long paginaTam){
		this.paginaTam=paginaTam;
	}//fim setPaginaTam() 

	/*   
	     @param: void
	     @return: atributos lidos da classe
	     @Copyright notice: gets
	 */
	public int getId(){
		return this.id;
	}//fim GetId()

	public String getNome(){
		return this.nome;
	}//fim GetNome() 

	public int getIdade(){
		return this.idade;
	}//fim GetIdade() 

	public LocalDateTime getDataNascimento(){
		return this.dataNascimento;
	}//fim GetDataNascimento() 

	public String getLocalNascimento(){
		return this.localNascimento;
	}//fim GetLocalNascimento()

	public LocalDateTime getInicioMandato(){
		return this.inicioMandato;
	}//fim GetInicioMandato()  

	public LocalDateTime getFimMandato(){
		return this.fimMandato;
	}//fim GetFimMandato() 

	public LocalDateTime getDataMorte(){
		return this.dataMorte;
	}//fim GetDataMorte() 

	public String getLocalMorte(){
		return this.localMorte;
	}//fim Getx() 

	public String getAntecessor(){
		return this.antecessor;
	}//fim GetAntecessor() 

	public String getSucessor(){
		return this.sucessor;
	}//fim GetSucessor() 

	public String getVice(){
		return this.vice;
	}//fim getVice()

	public String getPagina(){
		return this.pagina;
	}//fim getPagina()

	public long getPaginaTam(){
		return this.paginaTam;
	}//fim getPaginaTam() 
	/*   
	     @param: void
	     @return: nenhum
	     @Copyright notice: metodo que faz os clones de cada atributo da classe
	 */

	public Presidente clone(){
		Presidente presidente = new Presidente();
		presidente.setId(this.getId());
		presidente.setNome(this.getNome());
		presidente.setIdade(this.getIdade());
		presidente.setDataNascimento(this.getDataNascimento());
		presidente.setLocalNascimento(this.getLocalNascimento());
		presidente.setInicioMandato(this.getInicioMandato());
		presidente.setFimMandato(this.getFimMandato());
		presidente.setDataMorte(this.getDataMorte());
		presidente.setLocalMorte(this.getLocalMorte());
		presidente.setAntecessor(this.getAntecessor());
		presidente.setSucessor(this.getSucessor());
		presidente.setVice(this.getVice());
		presidente.setPagina(this.getPagina());
		presidente.setPaginaTam(this.getPaginaTam());				
		return presidente;
	}//fim clone()
	/*   
	     @param: String nomeArquivo
	     @return: nenhum
	     @Copyright notice: metodo que le os atributos de uma classe a partir de uma String
	 */
	public void readPresidente(String nomeArquivo){
		String linha = "";
		int dia, mes, ano,contador;
		File f = new File(nomeArquivo);
		//Abrir o arquivo para leitura
		try{
			BufferedReader br = new BufferedReader(new FileReader(f));
			//Informacao sobre o arquivo html
			this.pagina = nomeArquivo;
			this.paginaTam = f.length();

			//Ignorar tags iniciais
			String per="Per";
			per+='\u00ED';
			per+="odo";
			for(boolean stop = false; stop == false; stop = br.readLine().contains("background-color:#B0C4DE"));

			for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("Presidente do Brasil"));

			//id
			linha = linha.substring(linha.indexOf(">")+1);
			linha = linha.substring(linha.indexOf(">")+1);
				this.id = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")).replace("\u00BA","").replace("\u00AA",""));

			//Ignorar tags
			for(boolean stop = false; stop == false; stop = br.readLine().contains(per));
			for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
			linha = linha.substring(linha.indexOf(">")+1);
			linha = linha.substring(linha.indexOf(">")+1);

			//Inicio do governo
			dia = Integer.parseInt(linha.substring(0, (linha.charAt(1) == ' ' || linha.charAt(1) == '\u00BA') ? 1 : 2));
			linha = linha.substring(linha.indexOf(" de ")+4);
			mes = getMes(linha.substring(0, linha.indexOf("</a>")));
			linha = linha.substring(linha.indexOf("</a>")+4);
			linha = linha.substring(linha.indexOf(">")+1);
			ano = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")));
			linha = linha.substring(linha.indexOf(">")+1);
			linha = linha.substring(linha.indexOf(">")+1);
			linha = linha.substring(linha.indexOf(">")+1);
			this.inicioMandato = LocalDateTime.of(ano, mes, dia, 0, 0, 0);

			//Fim do governo
			dia = Integer.parseInt(linha.substring(0, (linha.charAt(1) == ' ' || linha.charAt(1) == '\u00BA') ? 1 : 2));
			linha = linha.substring(linha.indexOf(" de ")+4);
			mes = getMes(linha.substring(0, linha.indexOf("</a>")));
			linha = linha.substring(linha.indexOf("</a>")+4);
			linha = linha.substring(linha.indexOf(">")+1);
			ano = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")));
			this.fimMandato = LocalDateTime.of(ano, mes, dia, 0, 0, 0);

			//Vice-presidente
			for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
			if(linha.contains("Vice") == true){
				for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
				this.vice = removeTags(linha);
				for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
			} else {
				this.vice = "";
			}

			//Antecessor
			if(linha.contains("Antecessor") == true){
				for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
				this.antecessor = removeTags(linha);
				for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
			} else {
				this.antecessor = "";
			}

			//Sucessor
			if(linha.contains("Sucessor") == true){
				for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
				this.sucessor = removeTags(linha);
			} else {
				this.sucessor = "";
			}

			//Nome completo do presidente
			for(boolean stop = false; stop == false; stop = br.readLine().contains("Dados pessoais"));
			for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
			if(linha.contains("Nome") == true){
				for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
				nome = removeTags(linha);
				for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
			} else {
				this.nome = "";
			}

			//Data de nascimento
			for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
			linha = linha.substring(linha.indexOf(">")+1);
			linha = linha.substring(linha.indexOf(">")+1);

			dia = Integer.parseInt(linha.substring(0, (linha.charAt(1) == ' ' || linha.charAt(1) == '\u00BA') ? 1 : 2));
			linha = linha.substring(linha.indexOf(" de ")+4);
			mes = getMes(linha.substring(0, linha.indexOf("</a>")));
			linha = linha.substring(linha.indexOf("</a>")+4);
			linha = linha.substring(linha.indexOf(">")+1);
			ano = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")));
			this.dataNascimento = LocalDateTime.of(ano, mes, dia, 0, 0, 0);
			this.idade = 2019 - ano + ((mes == 1 && dia <= 3) ? 1 : 0);
			this.localNascimento = removeTags(linha.substring(linha.indexOf("</a>")+4));

			if(this.localNascimento.contains("anos") == true){
				this.localNascimento = this.localNascimento.substring(this.localNascimento.indexOf(")")+2);
				this.dataMorte = null;
				this.localMorte = null;
			} else {
				for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
				for(boolean stop = false; stop == false; linha = br.readLine(), stop = linha.contains("<td"));
				linha = linha.substring(linha.indexOf(">")+1);
				linha = linha.substring(linha.indexOf(">")+1);
				linha = linha.substring(linha.indexOf(">")+1);
				dia = Integer.parseInt(linha.substring(0, (linha.charAt(1) == ' ' || linha.charAt(1) == '\u00BA') ? 1 : 2));
				linha = linha.substring(linha.indexOf(" de ")+4);
				mes = getMes(linha.substring(0, linha.indexOf("</a>")));
				linha = linha.substring(linha.indexOf("</a>")+4);
				linha = linha.substring(linha.indexOf(">")+1);
				ano = Integer.parseInt(linha.substring(0, linha.indexOf("</a>")));
				this.dataMorte = LocalDateTime.of(ano, mes, dia, 0, 0, 0);
				this.localMorte = removeTags(linha.substring(linha.indexOf("</a>")+4));
				this.localMorte = this.localMorte.substring(this.localMorte.indexOf(")")+2);

			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();		
		}




	}	


	public static String removeTags(String s){
		String resp = "";

		for (int i = 0; i < s.length(); i++){

			/*Perguntas: (1) Pq o while abaixo? Para percorrer a tag
			  (2) Pq as clausulas do while abaixo nao podem ser invertidas? Porque se o i for maior do que o tamanho da string nao se torna necessario fazer a segunda pergunta, se tornando mais eficaz o while*/

			while(i < s.length() && s.charAt(i) == '<'){
				for (i++; s.charAt(i) != '>'; i++);
				i++;

				//Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo? Passar pelas tags que nao terminam em >
				while(i < s.length() && s.charAt(i) == '&'){
					for (i++; s.charAt(i) != ';'; i++);
					i++;
				}
			}

			//Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo? Colocar espaco entre as respostas, assim uma data de nascimento nao seria seguida logo por uma id
			while(i < s.length() && s.charAt(i) == '&'){
				for (i++; s.charAt(i) != ';'; i++);
				i++;
				resp += ' ';
			}

			//Perqunta: Pq nao colocamos apenas resp += s.charAt(i)?
			if(i < s.length()){
				resp += s.charAt(i);
			}
		}

		while(resp.length() > 0 && resp.charAt(0) == ' '){
			resp = resp.substring(1);
		}

		return resp;
	}

	public int getMes(String mes){
		int novoMes=0;
		switch (mes){
			case "janeiro":novoMes=1;
				       break;
			case "fevereiro":novoMes=2;
					 break;
			case "março":novoMes=3;
				     break;
			case "abril":novoMes=4;
				     break;
			case "maio":novoMes=5;
				    break;
			case "junho":novoMes=6;
				     break;
			case "julho":novoMes=7;
				     break;
			case "agosto":novoMes=8;
				      break;
			case "setembro":novoMes=9;
					break;
			case "outubro":novoMes=10;
				       break;
			case "novembro":novoMes=11;
					break;
			case "dezembro":novoMes=12; 
		}//fim switch
		return novoMes;	
	}//fim getMes

	public void printPresidente(){
		MyIO.print(this.getId()+" ## ");
		MyIO.print(this.getNome()+" ## ");
		MyIO.print(this.getInicioMandato().getDayOfMonth()+"/"+this.getInicioMandato().getMonthValue()+"/"+ this.getInicioMandato().getYear()+" (I) ## ");
		MyIO.print(this.getFimMandato().getDayOfMonth()+"/"+this.getFimMandato().getMonthValue()+"/"+ this.getFimMandato().getYear()+" (F) ## ");
		MyIO.print(this.getDataNascimento().getDayOfMonth()+"/"+this.getDataNascimento().getMonthValue()+"/"+ this.getDataNascimento().getYear() + " em ");
		MyIO.print(this.getLocalNascimento()+" (N) ## ");
		MyIO.print(this.getIdade()+" ## ");
		if(getDataMorte()!=null){	
			MyIO.print(this.getDataMorte().getDayOfMonth()+"/"+this.getDataMorte().getMonthValue()+"/"+ this.getDataMorte().getYear()+" em ");
			MyIO.print(this.getLocalMorte()+" (M) ## ");
		}
		MyIO.print(this.getPagina()+" ## ");
		MyIO.print(this.getPaginaTam()+" ## ");
		MyIO.print(this.getAntecessor()+" ## ");
		MyIO.print(this.getSucessor()+" ## ");
		MyIO.println(this.getVice());
	}//fim printPresidente()


}//fim class Presidente
/*
   lista estatica
 */
class Celula{
	public Celula prox;
	public Presidente presidente;
	
	Celula(){
		this(null);
	}//fim Celula()

	Celula(Presidente presidente){
		this.prox=null;
		this.presidente=presidente;
	}//fim Celula()

}//fim Celula
/**
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {
	private Celula primeiro;
	private Celula ultimo;
    	/*
     	* Construtor da classe que cria uma lista sem elementos (somente no cabeca).
     	*/
    	public Lista() {
        	primeiro = new Celula();
        	ultimo = primeiro;
    	}//fim Lista()
    	/*
     	* Insere um elemento na primeira posicao da lista.
    	* @param x int elemento a ser inserido.
     	*/
	public void inserirInicio(Presidente x){
 		Celula tmp=new Celula(x);
		tmp.prox=primeiro.prox;
		primeiro.prox=tmp;
		if(primeiro==ultimo){
			ultimo=tmp;
		}//fim if
		tmp=null;
	}//fim inserirInicio
	public Presidente removerFim()throws Exception{
		if(primeiro==ultimo){
			throw new Exception("erro ao remover");
		}//fim if
		Celula i;
		for(i=primeiro;i.prox!=ultimo;i=i.prox);
		Presidente elemento= ultimo.presidente;
		ultimo=i;
		i=ultimo.prox=null;
		return elemento;
	}//fim removerFim()
	public void inserir(int pos,Presidente x)throws Exception{
		int tamanho=tamanho();
		if(pos<0 || pos>tamanho)throw new Exception("erro ao remover");
		else if(pos==0)inserirInicio(x);
		     else if(pos==tamanho)inserirFim(x);
			  else{
				Celula tmp=new Celula(x);
				Celula i=primeiro;
				for(int j=0;j<pos;j++){
					i=i.prox;
				}//fim for
				tmp.prox=i.prox;
				i.prox=tmp;
				i=tmp=null;
			  }//fim else	
	}//fim inserir()
	public void inserirFim(Presidente x){
		ultimo.prox=new Celula(x);
		ultimo = ultimo.prox;
	}//fim inserirFim()
		
	public Presidente remover(int pos)throws Exception{
		int tamanho=tamanho();
		Presidente elemento;
		if(primeiro==ultimo || pos<0 ||pos>=tamanho) throw new Exception("erro ao remover"); 
		else if (pos==0) elemento=removerInicio();
		     else if(pos==tamanho-1)elemento=removerFim();
			  else{
				Celula i=primeiro;
				for(int x=0;x<pos;x++){
					i=i.prox;
				}//fim for
				Celula tmp=i.prox;
				elemento=tmp.presidente;
				i.prox=tmp.prox;
				tmp=tmp.prox=i=null;
			  }//fim else
			
		return elemento;
	}//fim remover()
	public Presidente removerInicio()throws Exception{
		if(primeiro==ultimo)throw new Exception("erro ao remover");
		Celula tmp=primeiro;
		primeiro=primeiro.prox;
		Presidente resp = primeiro.presidente;
		tmp=tmp.prox=null;
		return resp;
	}//fim removerInicio()	
	public int tamanho(){
		int tamanho=0;
		for(Celula i=primeiro;i!=null;i=i.prox){
			tamanho++;
		}//fim for
		return tamanho;
	}//fim tamanho
    public void mostrar() {
    	int x=0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
	    MyIO.print("["+ x +"] ");
            i.presidente.printPresidente();
	    x++;
        }
        System.out.println("] ");
    }
	public void mostrarRec (){
		mostrarRec(primeiro,0);
	}

	private void mostrarRec(Celula i,int j){
		if(i != ultimo){
			MyIO.print("["+ j+ "] ");
			i.presidente.printPresidente();
			mostrarRec(i.prox,j+1);
		}
	}
}
public class Tp2q1{
	public static void main(String[] args)throws Exception{
		String [] entradaPadrao = new String[1000];
		String[] leituraArquivo= new String[1000];
		Presidente[] presidente = new Presidente[1000];
		BufferedReader br;
		Lista lista = new Lista();

		int j=0;
		// leitura da entrada padrao
		entradaPadrao[j]=MyIO.readLine();
		while(!entradaPadrao[j].contains("FIM")){
			j++;
			entradaPadrao[j]=MyIO.readLine();
		}//fim while
		for(int i=0;i<j;i++){
			String leitura = ISO88591toUTF8(entradaPadrao[i]);
			presidente[i]  = new Presidente();
			presidente[i].readPresidente(leitura);
			lista.inserirFim(presidente[i]);
		}//fim for	
		//quantidade de elementos a serem inseridos/removidos
		int n=MyIO.readInt();
		//String que recebe os elementos que serao inseridos/removidos
		String [] elementos = new String[n];
	
		for(int i=0;i<n;i++){
			elementos[i]=MyIO.readLine();
			String op="";
			//split
			String [] funcao = elementos[i].split(" "); 
			switch(funcao[0]){
				case "II": presidente[i] = new Presidente();
					   presidente[i].readPresidente(op = ISO88591toUTF8(funcao[1]));
					   lista.inserirInicio(presidente[i]);		 	
				break;
				case "I*": presidente[i] = new Presidente();
					   presidente[i].readPresidente(op = ISO88591toUTF8(funcao[2]));
					   lista.inserir(Integer.parseInt(funcao[1]) , presidente[i]);				     
				break;
				case "IF": presidente[i] = new Presidente();
					   presidente[i].readPresidente(op = ISO88591toUTF8(funcao[1]));
					   lista.inserirFim(presidente[i]);
				break;
				case "RI": presidente[i] = lista.removerInicio();
					   MyIO.println("(R) " + presidente[i].getNome());
				break;
				case "R*": presidente[i] = lista.remover(Integer.parseInt(op = ISO88591toUTF8(funcao[1])));
					   MyIO.println ("(R) " + presidente[i].getNome());
				break;
				case "RF": presidente[i] = lista.removerFim();
					   MyIO.println("(R) " + presidente[i].getNome());		
			}//fim switch

		}//fim for
		lista.mostrar();
	}//fim main

	public static String ISO88591toUTF8(String strISO) throws Exception {
		byte[] isoBytes = strISO.getBytes("ISO-8859-1");
		return new String(isoBytes, "UTF-8");
	}
	/*
	   @param: String s1 e String s2
	   @return: boolean 
	   @Copyright notice: Método que verifica se duas palavras sao iguais
	 */
	public static boolean ehIgual(String s1, String s2){
		boolean ehIgual=true;
		if (s1.length() == s2.length()){
			for(int i=0;i<s1.length();i++){
				if(s1.charAt(i) != s2.charAt(i)){
					ehIgual=false;
					i=s1.length();
				}//fim if
			}//fim for      
		}//fim if
		else ehIgual=false;
		return ehIgual;
	}//fim ehIgual    
}//fim class	
