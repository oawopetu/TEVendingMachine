import com.techelevator.Reader.InventoryBuilder;
import com.techelevator.application.VendingMachine;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
    private VendingMachine vendingMachine;
    private InventoryBuilder inventoryBuilder;

    @Before
    public void setup(){
        vendingMachine = new VendingMachine(inventoryBuilder);
    }

    @Test
    public void testing_purchase_Menu(){
        String choice = "";
    }


}


