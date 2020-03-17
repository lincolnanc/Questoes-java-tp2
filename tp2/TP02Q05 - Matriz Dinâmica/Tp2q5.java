class Celula {
	public int elemento;
	public Celula inf, sup, esq, dir;

	public Celula(){
		this(0, null, null, null, null);
	}

	public Celula(int elemento){
		this(elemento, null, null, null, null);
	}

	public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
		this.elemento = elemento;
		this.inf = inf;
		this.sup = sup;
		this.esq = esq;
		this.dir = dir;
	}
}

class Matriz {
	private Celula inicio;
	private int linha, coluna;

	public Matriz (){
		this(3, 3);
	}

	public Matriz (int linha, int coluna){
		Celula i = new Celula();
		this.linha=linha;
		this.coluna=coluna;
		inicio=i;
                	for(int x=0; x<linha; x++){
                                if(x==0){
                                        for(int y=1; y<coluna; y++){
                                                Celula j = new Celula();
						j.esq=i;
						i.dir=j;
                                                i=i.dir;
                                        }//fim for
                                        i=inicio;
                                }else{
                                        Celula j = new Celula();
                                        j.sup = i;
                                        j.sup.inf = j;
                                        for(int y=1; y<coluna; y++){
                                                Celula z= new Celula();
                                                j.dir = z;
                                                j.dir.esq = j;
                                               	z.sup = z.esq.sup.dir;
                                                z.sup.inf = z;
                                                j=j.dir;
                                        }//fim for
                                        i=i.inf;
                                }//fim else
                        }//fim for
        }//fim constutor()  
	public Matriz soma (Matriz m) {
		Matriz resp = null;
		int x,y;
		if(this.linha == m.linha && this.coluna == m.coluna){
			resp=new Matriz(m.linha,m.coluna);
			Celula v=resp.inicio;
			v.elemento = m.inicio.elemento + this.inicio.elemento;
			Celula i = this.inicio;
			Celula k = m.inicio;
			for(x=0; x<linha; x++){
				if(x==0){
					for(y=1; y<coluna; y++){
						i=i.dir;
						k=k.dir;
						v=v.dir;
						v.elemento  = i.elemento+k.elemento;
					}//fim for
					i=this.inicio;
					k=m.inicio;
					v=resp.inicio;
				}else{
					i=i.inf;
					k=k.inf;
					v=v.inf;
					v.elemento=i.elemento+k.elemento;
					Celula w= v.dir;
					Celula j=i.dir;
					Celula n=k.dir;
					for(y=1; y<coluna; y++){
						w.elemento=j.elemento+n.elemento;
						w=w.dir;
						j=j.dir;
						n=n.dir;										     }//fim for
				}//fim else
			}//fim for
		}//fim if
		return resp;
	}//fim soma()
	public Matriz multiplicacao (Matriz m) {
		int x,y;
		Matriz resp=null;
		if(this.coluna==m.linha){
			resp = new Matriz(this.linha,m.coluna);
			Celula i = this.inicio;
			Celula k = m.inicio;
			Celula v = resp.inicio;
			Celula j=i;
			Celula n=k;
			Celula z=v;
			for(x=0; x<resp.linha*resp.coluna; x++){
				while(j!=null && n!=null){
					z.elemento+= (j.elemento*n.elemento);
					//MyIO.println("i:"+i.elemento+" j:"+j.elemento+ " n:"+n.elemento+" k:"+k.elemento+" z:" +z.elemento);
					j=j.dir;
					n=n.inf;
				}//fim while
				if(z.dir!=null){
					z=z.dir;
					j=i;
					n=k.dir;
				}else{
					z=v.inf;
					v=v.inf;
					j=i.inf;
					i=i.inf;
					n=k;
				}//fim else
			}//fim for
		}//fim if
		return resp;
	}//fim multiplicacao()	

	public boolean isQuadrada(){
		return (this.linha == this.coluna);
	}
	 
		public void inserir(int x){
			Celula i=inicio;
			Celula j=i;
			int contador=1;
			while(i.elemento!=0){
				if(contador<this.coluna){
					i=i.dir;
					contador++;
				}//fim if
				else{
					i=j.inf;
					j=i;
					contador=1;
				}//fim else			
			}//fim while
			i.elemento=x;		
		}//fim inserir()
		public void mostrarDiagonalPrincipal (){
			Celula i;
			if(isQuadrada() == true){
				for(i = inicio; i.inf!= null; i = i.inf.dir){
					Sop(i.elemento);
				}
				Sop(i.elemento);
				MyIO.print("\n");
			}
		}
		public void Sop(int x){
			MyIO.print(x+" ");
		}//fim Sop

		public void mostrarDiagonalSecundaria (){
			Celula i;
			Celula j;
			if(isQuadrada() == true){
				for(i=inicio; i.dir!= null ; i=i.dir );
					j=i;
					while(j.inf!=null){
						Sop(j.elemento);
						j=j.esq.inf;
					}
					Sop(j.elemento);
					MyIO.print("\n");
			}//fim if
		}//fim mostrarDiagonalSecundaria()
		public void mostrar(){
			Celula i=inicio;
			for(int x=0;x<linha;x++){
				if(x==0){
					for(i = inicio; i != null; i = i.dir){
						MyIO.print(i.elemento+" "); 
					}//fim for
					MyIO.print("\n");
					i=inicio;
				}//fim if
				else{
					while (i.inf != null){
						for(Celula j = i.inf; j!= null; j=j.dir){
							MyIO.print(j.elemento+" ");
						}//fim for
						MyIO.print("\n");
						i=i.inf;
					}//fim while
				}//fim else
			}//fim for
		}//fim mostrar()
	}//fim class
	public class Tp2q5 {
	 
	   public static void main(String[] args){
		Matriz m1, m2, soma, m3, m4, multiplicao, m5,m6,m7;
		MyIO.readInt();
		m1 = new Matriz(MyIO.readInt(), MyIO.readInt());
		for(int i=0; i<4;i++){
			m1.inserir(MyIO.readInt());
		}//fim for
		m2 = new Matriz(MyIO.readInt(), MyIO.readInt());
		for(int i=0;i<4;i++){
			m2.inserir(MyIO.readInt());
		}//fim for
		m3 = new Matriz(MyIO.readInt(), MyIO.readInt());
		for(int i=0;i<9;i++){
			m3.inserir(MyIO.readInt());
		}//fim for
		m4 = new Matriz(MyIO.readInt(), MyIO.readInt());
		for(int i=0;i<9;i++){
			m4.inserir(MyIO.readInt());
		}//fim for
		m5 = new Matriz(MyIO.readInt(), MyIO.readInt());
		for(int i=0;i<16;i++){
			m5.inserir(MyIO.readInt());
		}//fim for
		m6 = new Matriz(MyIO.readInt(), MyIO.readInt());
		for(int i=0;i<16;i++){
			m6.inserir(MyIO.readInt());
		}//fim for	
		m1.mostrarDiagonalPrincipal();
		m1.mostrarDiagonalSecundaria();
		m7 = m1.soma(m2);
		m7.mostrar();
		m7 = m1.multiplicacao(m2);
 		m7.mostrar();
		m3.mostrarDiagonalPrincipal();
		m3.mostrarDiagonalSecundaria();
		m7 = m3.soma(m4);
		m7.mostrar();
		m7 = m3.multiplicacao(m4);
 		m7.mostrar();
		m5.mostrarDiagonalPrincipal();
		m5.mostrarDiagonalSecundaria();
		m7 = m5.soma(m6);
		m7.mostrar();
		m7 = m5.multiplicacao(m6);
 		m7.mostrar();



      	//m1.mostrar();
      	//m2.mostrar();
      	//m3.mostrar();
      	//m4.mostrar();
 
      	//Somar as duas matrizes e salvar o resultado na matriz soma
      	//soma = m1.soma(m2); //verifique se eh possivel somar
 
      	//Imprimir a matriz 1
      	//soma.print();
 
      	//Multiplicar duas matrizes e salvar o resultado na matriz multiplicacao
      	//multiplicacao = m3.multiplicacao(m4); //verifique se eh possivel multiplicar
 
      	//Imprimir a matriz 1
      	//multiplicacao.print();
 
   }
}
