class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();

			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);

			Interpretador interpretador = new Interpretador();
			int resultado = interpretador.executa(arv);
			
			System.out.println(
				"------------------------\n" +
				"Código gerado: " + "\n" + codigo
			);

			System.out.println(
				"------------------------\n" +
				"Resultado: " + resultado + "\n" +
				"------------------------\n"
			);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
