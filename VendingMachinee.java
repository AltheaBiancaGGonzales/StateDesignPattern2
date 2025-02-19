import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Integer> prices = new HashMap<>();
    private int balance;
    private String selectedItem;

    private VendingMachineState idleState;
    private VendingMachineState itemSelectedState;
    private VendingMachineState dispensingState;
    private VendingMachineState outOfOrderState;
    private VendingMachineState currentState;

    public VendingMachine() {
        idleState = new IdleState(this);
        itemSelectedState = new ItemSelectedState(this);
        dispensingState = new DispensingState(this);
        outOfOrderState = new OutOfOrderState(this);

        currentState = idleState;

        // Initialize inventory and prices
        inventory.put("A1", 5);
        prices.put("A1", 10);

        inventory.put("B2", 3);
        prices.put("B2", 15);
    }

    public void selectItem(String itemCode) {
        currentState.selectItem(itemCode);
    }

    public void insertCoin(int amount) {
        currentState.insertCoin(amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem();
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder();
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getItemSelectedState() {
        return itemSelectedState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    public VendingMachineState getOutOfOrderState() {
        return outOfOrderState;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public Map<String, Integer> getPrices() {
        return prices;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
}
