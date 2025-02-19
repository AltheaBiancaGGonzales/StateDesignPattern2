public class DispensingState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Dispensing in progress. Please wait.");
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Dispensing in progress. Cannot insert coins.");
    }

    @Override
    public void dispenseItem() {
        String itemCode = vendingMachine.getSelectedItem();
        int price = vendingMachine.getPrices().get(itemCode);
        
        vendingMachine.getInventory().put(itemCode, 
            vendingMachine.getInventory().get(itemCode) - 1);
        vendingMachine.addBalance(-price);

        System.out.println("Dispensing " + itemCode + ".");
        System.out.println("Remaining balance: $" + vendingMachine.getBalance());

        vendingMachine.setSelectedItem(null);
        vendingMachine.setState(vendingMachine.getIdleState());
    }

    @Override
    public void setOutOfOrder() {
        vendingMachine.setState(vendingMachine.getOutOfOrderState());
        System.out.println("Machine set to Out Of Order.");
    }
}
