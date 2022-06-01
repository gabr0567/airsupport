package application;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javafx.collections.ObservableList;
//Gabriel
public class PDFCreate {
	@SuppressWarnings("deprecation")
	public static void sendPDF(List<Rprodukter> listProd, List<Billetter> listBillet) throws IOException, SQLException {
		int height = 370;
		int height2 = 0;
		int fontSize = 14;
		float total = 0;
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		for (int i = 0; i < listProd.size()+1; i++) {
			height2 = height2 + 20;
		}
		
		height = height + height2;
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
		String chkdate = "1970-01-01";
		System.out.println(chkdate.equals(listBillet.get(0).getDato2().get()));
		if (chkdate.equals(listBillet.get(0).getDato2().get()) != true) {
			//Afgang retur
			content.setFont(font2, 14);
			content.moveTextPositionByAmount(0,-20);
			content.drawString("Afgang retur: " + listBillet.get(0).getDato2().get() + " " + listBillet.get(0).getTid2().get());
		}
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
		
		//Tillægsprodukter
		boolean ran = false;
		for (int i = 1; i < listProd.size()+1; i++) {
			int x = 0;
			String stk = listProd.get(i-1).getAntal().get();
			String VB = listProd.get(i-1).getNavn().get();
			String pris = listProd.get(i-1).getPris().get();
			if (ran == true) x = - 535;
			content.setFont(font2, fontSize);
			content.moveTextPositionByAmount(x+0, -20);
			content.drawString(stk);
			content.setFont(font2, fontSize);
			content.moveTextPositionByAmount(210, 0);
			content.drawString(VB);
			content.setFont(font2, fontSize);
			content.moveTextPositionByAmount(325, 0);
			content.drawString(pris);
			ran = true;
			total = total + Float.parseFloat(pris); 
		}
		
		//Afsnit
		content.setFont(font, 14);
		content.moveTextPositionByAmount(-535,-20);
		content.drawString("_________________________________________________________________________");
		total = total + Float.parseFloat(listBillet.get(0).getPris().get());
		df.format(total);
		//Pris for tur
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("Pris for tur:  " + listBillet.get(0).getPris().get() + " DKK");
		//At betale
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("At betale:  " + total + " DKK");
		//Heraf moms
		content.setFont(font2, 14);
		content.moveTextPositionByAmount(0,-20);
		content.drawString("Heraf moms: " + df.format(total * 0.2) + " DKK");
		
		content.endText();
		content.close();
		
		//path where the PDF file will be store  
		String home = System.getProperty("user.home");
		pdfdoc.save(home + "\\Downloads\\Sample.pdf");  
		//prints the message if the PDF is created successfully   
		System.out.println("PDF created");  
		//closes the document  
		pdfdoc.close(); 
	}
}
