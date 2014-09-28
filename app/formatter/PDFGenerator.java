package formatter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;


import models.*;
public class PDFGenerator {

   

	private String emergyReportDirectory;
    private String summaryReportDirectory;
	
  
    
    public PDFGenerator(String emergyReportDirectory,
			String summaryReportDirectory) {
		super();
		this.emergyReportDirectory = emergyReportDirectory;
		this.summaryReportDirectory = summaryReportDirectory;
	}

	public String getEmergyReportDirectory() {
		return emergyReportDirectory;
	}

	public String getSummaryReportDirectory() {
		return summaryReportDirectory;
	}

	public File generateReport(List<Event> event,String reportName) {
    		File file = null;
        Document document = new Document();

        DateFormat readFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;

        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream(emergyReportDirectory + File.separator + reportName));

            if (Config.debugOn) {
                System.out.println("Opening Document to prepare for writing");
            }
            document.open();

            Font font = new Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255));
            Font endTextFont = new Font(FontFamily.HELVETICA, 16, Font.BOLDITALIC, new BaseColor(100, 50, 50));

            Paragraph title = new Paragraph("Incidents Report for PMO", font);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Chunk("=========================================================================="));

            for (int i = 0; i < event.size(); i++) {
                try {
                    date = readFormat.parse(event.get(i).getCallingTime().toString());
                } catch (ParseException ex) {
                    if (Config.debugOn) {
                        System.out.println("Error Converting String to Date in PDFGenerator.java for event " + i);
                    }
                    continue;
                }
                document.add(new Chunk("Date             : " + writeFormat.format(date)));
                document.add(Chunk.NEWLINE);
                document.add(new Chunk("Time             : " + event.get(i).getCallingTime().toString().substring(11, 16)));
                document.add(Chunk.NEWLINE);
                document.add(new Chunk("Event Type   : " + event.get(i).getEventType()));
                document.add(Chunk.NEWLINE);
                document.add(new Chunk("Description   : " + event.get(i).getDescription()));
                document.add(Chunk.NEWLINE);
                document.add(new Chunk("Location       : " + event.get(i).getLocation()));
                document.add(Chunk.NEWLINE);
                document.add(new Chunk("Postal Code : " + event.get(i).getPostalCode()));
                document.add(Chunk.NEWLINE);
                document.add(new Chunk("=========================================================================="));
            }

            Paragraph endText = new Paragraph("End of Report", endTextFont);
            endText.setAlignment(Element.ALIGN_CENTER);
            document.add(endText);

            document.close();
            if (Config.debugOn) {
                System.out.println("Finish writing document \"Report.pdf\"");
            }

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }

        if (Config.dirDebug) {
            file = new File(Config.repDir);
        } else {
            file = new File(emergyReportDirectory + "Report.pdf");
        }

        if (Config.debugOn) {
            System.out.println("Saving to : " + file.getAbsolutePath());
        }
        return file;
    }

    public File generateEmergencyReport(Event event,String reportName) {
		File file = null;

        Document document = new Document();

        DateFormat readFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;

        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream(summaryReportDirectory + File.separator + reportName));

            if (Config.debugOn) {
                System.out.println("Opening Document to prepare for writing");
            }
            document.open();

            Font font = new Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255));
            Font endTextFont = new Font(FontFamily.HELVETICA, 16, Font.BOLDITALIC, new BaseColor(100, 50, 50));

            Paragraph title = new Paragraph("Emergency Incident Report for PMO", font);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Chunk("=========================================================================="));

            try {
                date = readFormat.parse(event.getCallingTime().toString());
            } catch (ParseException ex) {
                if (Config.debugOn) {
                    System.out.println("Error Converting String to Date in PDFGenerator.java for event");
                }
            }
            document.add(new Chunk("Date             : " + writeFormat.format(date)));
            document.add(Chunk.NEWLINE);
            document.add(new Chunk("Time             : " + event.getCallingTime().toString().substring(11, 16)));
            document.add(Chunk.NEWLINE);
            document.add(new Chunk("Event Type   : " + event.getEventType()));
            document.add(Chunk.NEWLINE);
            document.add(new Chunk("Description   : " + event.getDescription()));
            document.add(Chunk.NEWLINE);
            document.add(new Chunk("Location       : " + event.getLocation()));
            document.add(Chunk.NEWLINE);
            document.add(new Chunk("Postal Code : " + event.getPostalCode()));
            document.add(Chunk.NEWLINE);
            document.add(new Chunk("=========================================================================="));

            Paragraph endText = new Paragraph("End of Report", endTextFont);
            endText.setAlignment(Element.ALIGN_CENTER);
            document.add(endText);

            document.close();
            if (Config.debugOn) {
                System.out.println("Finish writing document \"EmergencyReport.pdf\"");
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (Config.dirDebug) {
            file = new File(Config.emergencyRepDir);
        } else {
            file = new File(emergyReportDirectory + "EmergencyReport.pdf");
        }

        if (Config.debugOn) {
            System.out.println("Saving to : " + file.getAbsolutePath());
        }
        return file;
    }
}
