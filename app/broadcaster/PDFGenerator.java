package broadcaster;

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
/**
 * This class generates the pdf file. 
 *
 */
public class PDFGenerator {

   

	private String emergentReportDirectory;
    private String summaryReportDirectory;
	
  
    /**
     * Contructor for PDFGenerator
     * @param emergentReportDirectory the local path of directory storing the emergent reports
     * @param summaryReportDirectory  the local path of directory storing the summary reports
     */
    public PDFGenerator(String emergentReportDirectory,
			String summaryReportDirectory) {
		super();
		this.emergentReportDirectory = emergentReportDirectory;
		this.summaryReportDirectory = summaryReportDirectory;
	}
/**
 * The getter of attribute emergentReportDirectory
 * @return the path of directory storing the emergent report
 */
	public String getEmergentReportDirectory() {
		return emergentReportDirectory;
	}
	
	/**
	 * The getter of attribute getSummaryReportDirectory
	 * @return the path of directory storing the summary report
	 */
	public String getSummaryReportDirectory() {
		return summaryReportDirectory;
	}

	/**
	 * This method generate a summary pdf report from a list of events.
	 * @param event A list event for summary report
	 * @param reportName: the report name
	 * @return File of pdf report
	 */
	public File generateReport(List<Event> event,String reportName) {
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

            Paragraph title = new Paragraph("Routine Summary Report for PMO", font);
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
                document.add(new Chunk("Event Type   : " + event.get(i).getEventType().getEventType()));
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
//
        if (Config.dirDebug) {
            file = new File(Config.repDir);
        } else {
            file = new File(summaryReportDirectory + File.separator + reportName);
        }

        if (Config.debugOn) {
            System.out.println("Saving to : " + file.getAbsolutePath());
        }
        return file;
    }

	/**
	 * This method generate a pdf report for an emergent event.
	 * @param event The event for  report
	 * @param reportName: the report name
	 * @return File of pdf report
	 */
    public File generateEmergencyReport(Event event,String reportName) {
		File file = null;

        Document document = new Document();

        DateFormat readFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;

        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream(emergentReportDirectory + File.separator + reportName));

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
            document.add(new Chunk("Event Type   : " + event.getEventType().getEventType()));
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
            file = new File(emergentReportDirectory + File.separator + reportName);
        }

        if (Config.debugOn) {
            System.out.println("Saving to : " + file.getAbsolutePath());
        }
        return file;
    }
}
