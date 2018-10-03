package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier{

	/*public static void main(String [ ] args){
		
			SUDOKU #1:

				9 8 4 5 7 6 2 1 3
				5 1 3 4 8 2 9 6 7
				7 2 6 1 3 9 5 4 8
				6 3 1 9 4 7 8 5 2
				4 9 5 2 6 8 3 7 1
				8 7 2 3 5 1 6 9 4
				2 5 7 6 1 3 4 8 9
				3 6 8 7 9 4 1 2 5
				1 4 9 8 2 5 7 3 6

			s1String:

				984576213513482967726139548631947852495268371872351694257613489368794125149825736	
		 * */

		/*System.out.println("Leyenda Resultados :");
		System.out.println("    0 = Sudoku OK");
		System.out.println("    -1 = ERROR: NON positive");
		System.out.println("    -2 = ERROR: Sub-grid repetido");
		System.out.println("    -3 = ERROR: Fila repetido");
		System.out.println("    -4 = ERROR: Columna repetido");
		System.out.println("    -5 = ERROR: length");
		System.out.println("--------------------------------------");

		String pruebaOK = new String("984576213513482967726139548631947852495268371872351694257613489368794125149825736");
		String pruebaE1 = new String("980576213513482967726139548631947852495268371872351694257613489368794125149825736");
		String pruebaE2 = new String("984976213413482967726139948631947852495268371872351694257613489368794125149825736");
		String pruebaE3 = new String("984976213513482567726135948631947852495268371872351694257613489368794125149825736");
		String pruebaE4 = new String("984576213513482967726139548631947852495268371872351694257613489368794125941825736");
		String pruebaE5 = new String("99984576213513482967726139548631947852495268371872351694257613489368794125149825736");

		System.out.println("Resultado de verificar OK: "+ verify(pruebaOK));
		System.out.println("Resultado de verificar E1: "+ verify(pruebaE1));
		System.out.println("Resultado de verificar E2: "+ verify(pruebaE2));
		System.out.println("Resultado de verificar E3: "+ verify(pruebaE3));
		System.out.println("Resultado de verificar E4: "+ verify(pruebaE4));
		System.out.println("Resultado de verificar E5: "+ verify(pruebaE5));

	}*/

		public int verify(String candidateSolution){

			//Comprobar que el String tiene longitud = 81
			if(candidateSolution != null){
				if(candidateSolution.length() != 81){
					return -5;	}
			}


			/*Comprobar que el formato es correcto:
			- Primeros nueve numeros = primera fila
			- Segundos nueve numeros = segunda fila


		Comprobamos las 4 reglas:
		  	R1: A cell in a Sudoku game can only store positive digits, i.e. 1…9.
		 	R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
			R3: A digit can appear only once in the rows of the global grid.
			R4: A digit can appear only once in the columns of the global grid.

			 * */

			//REGLA 2:
			if (!positivo(candidateSolution)){
				//En caso de no serlo devuelve -1
				return -1;}	

			//Obtenemos las 9 filas de 9 numeros
			String fila1 = new String("");
			String fila2 = new String("");
			String fila3 = new String("");
			String fila4 = new String("");
			String fila5 = new String("");
			String fila6 = new String("");
			String fila7 = new String("");
			String fila8 = new String("");
			String fila9 = new String("");

			fila1 += candidateSolution.substring(0,9);
			fila2 += candidateSolution.substring(9,18);
			fila3 += candidateSolution.substring(18,27);
			fila4 += candidateSolution.substring(27,36);
			fila5 += candidateSolution.substring(36,45);
			fila6 += candidateSolution.substring(45,54);
			fila7 += candidateSolution.substring(54,63);
			fila8 += candidateSolution.substring(63,72);
			fila9 += candidateSolution.substring(72,81);

			//Separamos el sudoku en 9 subgrids
			String sg1 = new String("");
			String sg2 = new String("");
			String sg3 = new String("");
			String sg4 = new String("");
			String sg5 = new String("");
			String sg6 = new String("");
			String sg7 = new String("");
			String sg8 = new String("");
			String sg9 = new String("");

			sg1 += fila1.substring(0,3)+fila2.substring(0,3)+fila3.substring(0,3);
			sg4 += fila4.substring(0,3)+fila5.substring(0,3)+fila6.substring(0,3);
			sg7 += fila7.substring(0,3)+fila8.substring(0,3)+fila9.substring(0,3);

			sg2 += fila1.substring(3,6)+fila2.substring(3,6)+fila3.substring(3,6);
			sg5 += fila4.substring(3,6)+fila5.substring(3,6)+fila6.substring(3,6);
			sg8 += fila7.substring(3,6)+fila8.substring(3,6)+fila9.substring(3,6);

			sg3 += fila1.substring(6,9)+fila2.substring(6,9)+fila3.substring(6,9);
			sg6 += fila4.substring(6,9)+fila5.substring(6,9)+fila6.substring(6,9);
			sg9 += fila7.substring(6,9)+fila8.substring(6,9)+fila9.substring(6,9);

			//Obtenemos las 9 columnas de 9 numeros

			String col1 = new String("");
			String col2 = new String("");
			String col3 = new String("");
			String col4 = new String("");
			String col5 = new String("");
			String col6 = new String("");
			String col7 = new String("");
			String col8 = new String("");
			String col9 = new String("");

			col1 += fila1.substring(0,1)+fila2.substring(0,1)+fila3.substring(0,1)+fila4.substring(0,1)+fila5.substring(0,1)+fila6.substring(0,1)+fila7.substring(0,1)+fila8.substring(0,1)+fila9.substring(0,1);
			col2 += fila1.substring(1,2)+fila2.substring(1,2)+fila3.substring(1,2)+fila4.substring(1,2)+fila5.substring(1,2)+fila6.substring(1,2)+fila7.substring(1,2)+fila8.substring(1,2)+fila9.substring(1,2);
			col3 += fila1.substring(2,3)+fila2.substring(2,3)+fila3.substring(2,3)+fila4.substring(2,3)+fila5.substring(2,3)+fila6.substring(2,3)+fila7.substring(2,3)+fila8.substring(2,3)+fila9.substring(2,3);
			col4 += fila1.substring(3,4)+fila2.substring(3,4)+fila3.substring(3,4)+fila4.substring(3,4)+fila5.substring(3,4)+fila6.substring(3,4)+fila7.substring(3,4)+fila8.substring(3,4)+fila9.substring(3,4);
			col5 += fila1.substring(4,5)+fila2.substring(4,5)+fila3.substring(4,5)+fila4.substring(4,5)+fila5.substring(4,5)+fila6.substring(4,5)+fila7.substring(4,5)+fila8.substring(4,5)+fila9.substring(4,5);
			col6 += fila1.substring(5,6)+fila2.substring(5,6)+fila3.substring(5,6)+fila4.substring(5,6)+fila5.substring(5,6)+fila6.substring(5,6)+fila7.substring(5,6)+fila8.substring(5,6)+fila9.substring(5,6);
			col7 += fila1.substring(6,7)+fila2.substring(6,7)+fila3.substring(6,7)+fila4.substring(6,7)+fila5.substring(6,7)+fila6.substring(6,7)+fila7.substring(6,7)+fila8.substring(6,7)+fila9.substring(6,7);
			col8 += fila1.substring(7,8)+fila2.substring(7,8)+fila3.substring(7,8)+fila4.substring(7,8)+fila5.substring(7,8)+fila6.substring(7,8)+fila7.substring(7,8)+fila8.substring(7,8)+fila9.substring(7,8);
			col9 += fila1.substring(8,9)+fila2.substring(8,9)+fila3.substring(8,9)+fila4.substring(8,9)+fila5.substring(8,9)+fila6.substring(8,9)+fila7.substring(8,9)+fila8.substring(8,9)+fila9.substring(8,9);


			//REGLA 2:
			if (!repetido(sg1))
				return -2;
			else{
				if (!repetido(sg2))
					return -2;
				else{
					if (!repetido(sg3))
						return -2;
					else{
						if (!repetido(sg4))
							return -2;
						else{
							if (!repetido(sg5))
								return -2;
							else{
								if (!repetido(sg6))
									return -2;
								else{
									if (!repetido(sg7))
										return -2;
									else{
										if (!repetido(sg8))
											return -2;
										else{
											if (!repetido(sg9))
												return -2;
										}
									}
								}
							}
						}
					}
				}
			}

			//REGLA 3:
			if (!repetido(fila1) || !repetido(fila2) ||	!repetido(fila3) || !repetido(fila4) || !repetido(fila5) || !repetido(fila6) ||	!repetido(fila7) || !repetido(fila8) || !repetido(fila9)){
				return -3;}

			//REGLA 4:
			if (!repetido(col1) || !repetido(col2) || !repetido(col3) || !repetido(col4) || !repetido(col5) || !repetido(col6) || !repetido(col7) || !repetido(col8) || !repetido(col9)){
				return -4;}

			return 0;
		}

		//Comprueba que 9 números no aparezcan repetidos en una serie de 9
		public static boolean repetido(String serie9){

			//Guardamos la serie9 en un array para mejor manejo

			int[] mi_array = new int[9];

			for(int i = 0; i < serie9.length(); i++ ){
				mi_array[i] = Integer.parseInt(serie9.substring(i, i+1));
			}


			for (int i = 0; i < mi_array.length-1; i++)
			{
				for (int j = i+1; j < mi_array.length; j++)
				{
					//System.out.println("Check equals:"+mi_array[j]+" - "+mi_array[i]);

					if ((mi_array[i] == mi_array[j]) && (i != j))
					{
						//Tenemos una coincidencia
						//System.out.println("Error: Existe al menos una coincidencia");
						return false;
					}
				}
			}

			//Si no hay repetidos en una serie9 devuelve true
			//System.out.println("Todo OK");
			return true;
		}	


		//Comprueba si los numeros son poitivos

		public static boolean positivo(String sudoku){
			//Guardamos el sudoku en un array para mejor manejo	
			char [] sChar = new char [81];
			sChar = sudoku.toCharArray();

			for (int i = 0; i < sChar.length; i++){
				if(!Character.isDigit(sChar[i]) || Character.getNumericValue(sChar[i])<=0){
					return false;
				}
			}
			return true;
		}
	
	}