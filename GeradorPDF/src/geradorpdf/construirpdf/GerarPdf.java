package geradorpdf.construirpdf;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyleConstants.ColorConstants;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

public class GerarPdf {
	final static String CAMINHO = "C:\\Users\\fabio\\Downloads\\arquivo.pdf";
	final static String LOGOPDF = "imagens\\Logo_IFSC.png";
	
	public static void gerarPdf() throws Exception {
	    PdfWriter pdfWriter = new PdfWriter(CAMINHO);
	    PdfDocument pdfDocumento = new PdfDocument(pdfWriter);
	    pdfDocumento.setDefaultPageSize(PageSize.A4.rotate());
	    Document documento = new Document(pdfDocumento);

	    documento.add(logoPdf(LOGOPDF, 15, 500, 100));

	    String instituicao = "Hospital Universitário da USP";
	    String enderecoInstituicao = "Av.Prof. Lineu Prestes - Cidade Universitária São Paulo/SP - CEP 05508-000 - Fone (11) 3091-9200";
	    String sistema = "Sistema Apolo";
	    String protocolo = "Protocolo de Coleta 10/02/2023 15:21:07";

	    documento.add(addTitulo(instituicao, enderecoInstituicao, 180, 520, 300, 200));

	    List<Table> tabelasProtocolo = addProtocolo(sistema, protocolo, 500, 540);
	    
	    for (Table tabela : tabelasProtocolo) {
	        documento.add(tabela);
	    }
	    
	    documento.add(addProtocoloColeta());

	    documento.close();
	}

	
	public static Image logoPdf(String path, int posicaoLeft, int posicaoBottom, int width) throws Exception {
		ImageData data = ImageDataFactory.create(path);
		Image img = new Image(data, posicaoLeft, posicaoBottom, width);
		return img;
	}
	
	public static Table addTitulo(String p, String p2, float x, float y, float width, float largura) {
		float columnWidth[] = {200f};
		Table tabela = new Table(columnWidth);
		tabela.setFixedPosition(x, y, width);
		tabela.addCell(new Cell().add(p).setBorder(Border.NO_BORDER));
		tabela.addCell(new Cell().add(p2).setBorder(Border.NO_BORDER));
		return tabela;
	}
	
	public static Table addProtocoloColeta() {
		float larguraPagina = PageSize.A4.getWidth();
		float margem = 36f; // ou o valor real da sua margem
		float larguraUtil = larguraPagina - 2 * margem;

		float[] columnWidt = {200f}; // Isso vai ser ignorado ao definir largura total
		Table tabela = new Table(1); // Uma coluna só
		tabela.setWidth(UnitValue.createPercentValue(100));
		tabela.setFixedPosition(margem, 470f, larguraUtil);

		Cell celula = new Cell()
		    .add("Protocolo de Coleta")
		    .setTextAlignment(TextAlignment.CENTER)
		    .setBackgroundColor(ItextUtilsPdf.converteHex("6A8E58"));

		tabela.addCell(celula);
		return tabela;
	}
	
	public static List<Table> addProtocolo(String p, String p2, float x, float y) {
	    List<Table> tabelas = new ArrayList<>();

	    Table tabelaPequena = new Table(new float[]{150f});
	    tabelaPequena.setFixedPosition(x, y, 150f);
	    tabelaPequena.addCell(new Cell().add(p).setBorder(Border.NO_BORDER));

	    tabelas.add(tabelaPequena);

	    Table tabelaGrande = new Table(new float[]{300f});
	    tabelaGrande.setFixedPosition(x, y - 20, 300f);
	    tabelaGrande.addCell(new Cell().add(p2).setBorder(Border.NO_BORDER));

	    tabelas.add(tabelaGrande);

	    return tabelas;
	}

}



