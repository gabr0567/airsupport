package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javafx.collections.ObservableList;

public class PDFCreate {
	private static DataAccessLayer db;
	@SuppressWarnings("deprecation")
	public static void sendPDF(List listProd, List<Billetter> listBillet) throws IOException, SQLException {
		int height = 370;
		PDDocument pdfdoc= new PDDocument(); 
		PDRectangle pageSize = new PDRectangle(615, height);
		PDPage page = new PDPage(pageSize);
		pdfdoc.addPage(page); 
		
		PDPageContentStream content = new PDPageContentStream(pdfdoc, page);
		
		PDFont font = PDType1Font.HELVETICA_BOLD;
		PDFont font2 = PDType1Font.HELVETICA;
		
		content.beginText();
		//Overskrift
		content.setFont(font, 22);
		content.moveTextPositionByAmount(150,height-50);
		content.drawString("BILLUND LUFTHAVN FAKTURA");
		//Understreg
		content.setFont(font, 22);
		content.moveTextPositionByAmount(2,-3);
		content.drawString("___________________________");
		//BilletID
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(-130,-50);
		content.drawString("BilletID: " + listBillet.get(0).getBilletID().get());
		//Navn
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("Navn: " + listBillet.get(0).getNavn().get());
		//Telefon
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("Telefon: " + listBillet.get(0).getTlf().get());
		//CVR
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("CVR: " + listBillet.get(0).getCVR().get());
		//Til
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("Til: " + listBillet.get(0).getTil().get());
		//Fly
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("Fly: " + listBillet.get(0).getFly().get());
		//Afgang
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("Afgang: " + listBillet.get(0).getDato().get() + " " + listBillet.get(0).getTid().get());
		//Email
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("Email: " + listBillet.get(0).getEmail().get());
		//Afsnit
		content.setFont(font, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("_________________________________________________________________________");
		//Stk/Varebeskrivelse/Pris
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("STK                                               VAREBESKRIVELSE                                                 PRIS");
		
		//TODO Varer her
		
		//Afsnit
		content.setFont(font, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("_________________________________________________________________________");
		//At betale
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("At betale: ");
		//Heraf moms
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("Heraf moms: ");		
		
		content.endText();
		content.close();
		  
		//path where the PDF file will be store  
		pdfdoc.save("C:\\Users\\gabri\\Downloads\\Sample.pdf");  
		//prints the message if the PDF is created successfully   
		System.out.println("PDF created");  
		//closes the document  
		pdfdoc.close(); 
	}
}
