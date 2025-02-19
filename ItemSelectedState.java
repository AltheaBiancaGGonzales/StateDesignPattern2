public class ItemSelectedState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public ItemSelectedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Item already selected. Please insert coins or cancel.");
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.addBalance(amount);
        String itemCode = vendingMachine.getSelectedItem();
        int price = vendingMachine.getPrices().get(itemCode);

        System.out.println("Inserted $" + amount + ". Current balance: $" + vendingMachine.getBalance());
        
        if (vendingMachine.getBalance() >= price) {
            vendingMachine.setState(vendingMachine.getDispensingState());
            vendingMachine.dispenseItem();
        }
    }

    @Override
    public void dispenseItem() {
        System.out.println("Insert enough coins first.");
    }

    @Override
    public void setOutOfOrder() {
        vendingMachine.setState(vendingMachine.getOutOfOrderState());
        System.out.println("Machine set to Out Of Order.");
    }
}
