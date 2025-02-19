public class IdleState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(String itemCode) {
        if (vendingMachine.getInventory().containsKey(itemCode) && 
            vendingMachine.getInventory().get(itemCode) > 0) {
            vendingMachine.setSelectedItem(itemCode);
            System.out.println("Item " + itemCode + " selected.");
            vendingMachine.setState(vendingMachine.getItemSelectedState());
        } else {
            System.out.println("Item unavailable.");
        }
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Cannot insert coins. Please select an item first.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("No item selected.");
    }

    @Override
    public void setOutOfOrder() {
        vendingMachine.setState(vendingMachine.getOutOfOrderState());
        System.out.println("Machine set to Out Of Order.");
    }
}
