package geradorpdf.construirpdf;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

public class GerarPdf {
	final static String CAMINHO = "C:\\Users\\fabio\\Downloads\\arquivo.pdf";
	final static String LOGOPDF = "imagens\\Logo_IFSC.png";
	
	public static void gerarPdf() throws Exception {
		PdfWriter pdfWriter = new PdfWriter(CAMINHO);
		PdfDocument pdfDocumento = new PdfDocument(pdfWriter);
		pdfDocumento.setDefaultPageSize(PageSize.A4.rotate());
		Document documento = new Document(pdfDocumento);
		
		documento.add(logoPdf(LOGOPDF, 0, 500, 100));
		documento.add(new Paragraph("Batata").setFixedPosition(150, 550, 400));

		documento.close();
	}
	
	public static Image logoPdf(String path, int posicaoLeft, int posicaoBottom, int width) throws Exception {
		ImageData data = ImageDataFactory.create(path);
		Image img = new Image(data, posicaoLeft, posicaoBottom, width);
		return img;
	}
	
}



