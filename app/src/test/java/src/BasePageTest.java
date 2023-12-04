package src;

import javax.swing.*;
import java.awt.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//This class tests the BasePage class
//NOTE:: since the BasePage acts as a template, the RentPage class is also used to test BasePage methods
public class BasePageTest {

    private NodeModel nodeModel; //stores page data
    private BasePage basePage; //primary page being tested
    private BasePage mockBasePage; //mocked base page
    private BasePage samplePage; //secondary page being tested
    private RentPage rentPage; //a sample subclass
    private JPanel panel; //panel which is added to

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
        panel = new JPanel();
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

    //tests the handle method
    @Test
    void handleTest() {
        //calls the real method to make sure interior methods are called
        when(mockBasePage.handle()).thenCallRealMethod();
        //calls the method
        mockBasePage.handle();

        //ensurs handle is run
        verify(mockBasePage).handle();

        //ensures the interior methods are called
        verify(mockBasePage).firstQuestion(); 
        verify(mockBasePage).secondQuestion();
        verify(mockBasePage).addImage();
        verify(mockBasePage).nextButton();
    }

    //tests the getQQuestion method
    @Test
    void firstQuestionTest() {
        assertEquals("How much do you currently pay in rent?", rentPage.getQuestion());

       JTextField testVar = new JTextField();
       testVar.setText("12");
        rentPage.setRanking(testVar);
       assertEquals("12", rentPage.getRanking().getText()); 
    }

    //tests the getName method
    @Test
    void getNameTest() {
        assertEquals("Rent", rentPage.getName());
    }

    //tests the second queston method
    @Test
    public void secondQuestionTest() {
        rentPage.setPanel(panel);
  //      rentPage.handle();
        rentPage.secondQuestion();
        Component[] componentArray = rentPage.getPanel().getComponents();
        JTextField question = (JTextField) componentArray[1];
        assertEquals("", question.getText());
    //    assertEquals("How important is this to you? (1 - 5).\n", question.getText());
    }

}
