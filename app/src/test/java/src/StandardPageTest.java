package src;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//THis class tests the basic standardized pges
public class StandardPageTest {

    private NodeModel nodeModel; //shared node model
    private RentPage rentPage; 
    private TransitPage transitPage; 
    private FunPage funPage; 
    private FoodPage foodPage;
    private OtherPage otherPage;

   //creates fresh instances each time
    @BeforeEach
    public void init() {
        nodeModel = new NodeModel();
        rentPage = new RentPage(nodeModel);
        transitPage = new TransitPage(nodeModel);
        funPage = new FunPage(nodeModel);
        foodPage = new FoodPage(nodeModel);
        otherPage = new OtherPage(nodeModel);
    }

    //tests if each class shares the same node modele
    @Test
    public void nodeModelTest() {
        assertSame(rentPage.getNodeModel(), nodeModel);
        assertSame(transitPage.getNodeModel(), nodeModel);
       assertSame(funPage.getNodeModel(), nodeModel);
       assertSame(foodPage.getNodeModel(), nodeModel);
       assertSame(otherPage.getNodeModel(), nodeModel);
    }

    //tests if each class properly sets the name field
    @Test
    public void nameTest() {
        assertEquals("Rent", rentPage.getName());
        assertEquals("Transit", transitPage.getName());
        assertEquals("Entertainment", funPage.getName());
        assertEquals("Groceries & Restaurants", foodPage.getName());
        assertEquals("Other", otherPage.getName());
    }

}
