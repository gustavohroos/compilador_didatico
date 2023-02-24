import java.io.*;

enum TokenType{ NUM,SOMA, MULT, DIV, SUB, APar,FPar, EOF}

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		int eof = -1;
		char currchar;
		int currchar1;
		String numero = "";

			do{
				currchar1 = arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
				if (currchar >= '0' && currchar <= '9'){
					arquivo.mark(0);
					while (currchar >= '0' && currchar <= '9'){
						arquivo.mark(0);
						numero = numero + currchar;
						currchar = (char) arquivo.read();
					}
					arquivo.reset();
					return (new Token (numero, TokenType.NUM));
				}
				else
					switch (currchar){
						case '(':
							return (new Token (Character.toString(currchar),TokenType.APar));
						case ')':
							return (new Token (Character.toString(currchar),TokenType.FPar));
						case '+':
							return (new Token (Character.toString(currchar),TokenType.SOMA));
						case '*':
							return (new Token (Character.toString(currchar),TokenType.MULT));
						case '/':
							return (new Token (Character.toString(currchar),TokenType.DIV));
						case '-':
							return (new Token (Character.toString(currchar),TokenType.SUB));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();
			
		return (new Token(Character.toString(currchar),TokenType.EOF));
		
	}
}
