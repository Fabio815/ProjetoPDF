package geradorpdf.principal;

import geradorpdf.construirpdf.GerarPdf;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			GerarPdf.gerarPdf();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
