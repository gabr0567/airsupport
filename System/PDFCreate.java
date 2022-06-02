package application;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
		
		//Nilaksan
        //authentication info
        final String username = "noreplyAirFaktura@yahoo.com";
        final String password = "rdryjxnqsfuojihx";
        String fromEmail = username;
        String toEmail = listBillet.get(0).getEmail().get(); //mail den skal sendes til
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
        properties.put("mail.smtp.port", "587");
		
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
		
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
		
		String home = System.getProperty("user.home");
		
		pdfdoc.save(home + "\\Downloads\\Faktura.pdf");  
		//printer at pdf er gemt på pc
		pdfdoc.close(); 
		
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Billund Lufthavn Faktura"); //titel

            Multipart emailContent = new MimeMultipart();

            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Billund Lufthavn Faktura"); //tekst besked

            MimeBodyPart pdfAttachment = new MimeBodyPart();
            pdfAttachment.attachFile(home + "\\Downloads\\Faktura.pdf");
            
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(pdfAttachment);

            msg.setContent(emailContent);

            Transport.send(msg);
            System.out.println("Faktura sendt");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
