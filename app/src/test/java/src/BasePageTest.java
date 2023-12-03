package src;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//This class tests the BasePage class
public class BasePageTest {

    private NodeModel nodeModel; //stores page data
    private BasePage basePage; //primary page being tested
    private BasePage mockBasePage; //mocked base page
    private BasePage samplePage; //secondary page being tested
    private RentPage rentPage; //a sample subclass

    //inits fields
    @BeforeEach
    void init() {
        nodeModel = mock(NodeModel.class);
        basePage = new BasePage(
                nodeModel,
                "testName",
                "testQuestion",
                "/housing.jpg");
        samplePage = new BasePage();
        rentPage = new RentPage(nodeModel);
        mockBasePage = mock(BasePage.class);
    }

   //tests the setNext and getNext methods
    @Test
    void nexttTest() {
        basePage.setNext(samplePage);
        assertEquals(samplePage, basePage.getNext()); 
    }

    //tests if the panel is created
    @Test
    void panelTest() {
        //panel is given data in the subclasses, so this returns null
        assertEquals(null, basePage.getPanel());

       //subclasses should only recieve data from the handle method
        assertEquals(null, rentPage.getPanel());

        //adds data to the panel
        rentPage.handle();
        assertNotNull(rentPage.getPanel());
    }

    @Test
    void handleTest() {
        mockBasePage.handle();
        verify(mockBasePage).handle();
        //execute real method and see if others are auto called
    }

}
