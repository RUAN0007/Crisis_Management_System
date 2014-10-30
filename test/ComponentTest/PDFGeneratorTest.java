package ComponentTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import models.Event;

import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import broadcaster.PDFGenerator;


public class PDFGeneratorTest {

    private static PDFGenerator pdfGenerator;
    private static File file, erFile;
    private static List<Event> events;
    private static List<Event> noEvents;
    private static Event event;
    private static Event noEvent;
    private static String repDir = "C:\\Users\\USER\\Documents\\NetBeansProjects\\Report Generator\\Test\\";
    private static String eRepDir = "C:\\Users\\USER\\Documents\\NetBeansProjects\\Report Generator\\Test\\";

    public PDFGeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        pdfGenerator = new PDFGenerator(eRepDir, repDir);
        
        
        events = new ArrayList<Event>();
        events.add(new Event());
        events.add(new Event());

        noEvents.clear();

        event = new Event();

    }

    @After
    public void tearDown() {
    }

    /**
     * Report-1
     */

    @Test
    public void testGenerateReport() {

        assertNotNull("Unsuccessful in file creation for List of Events", file = pdfGenerator.generateReport(events, "Report.pdf"));
        assertTrue(file.exists());
        file.delete();

        assertNotNull("Unsuccessful in file creation for Empty list of Events", file = pdfGenerator.generateReport(noEvents, "EmptyReport.pdf"));
        assertTrue(file.exists());
        file.delete();
    }
    /**
     * Report -2
     */
    @Test
    public void testGenerateEmergencyReport() {

        assertNotNull("Unsuccessful in file creation for a single Event", erFile = pdfGenerator.generateEmergencyReport(event, "EReport.pdf"));
        assertTrue(erFile.exists());
        erFile.delete();
    }
    

}
