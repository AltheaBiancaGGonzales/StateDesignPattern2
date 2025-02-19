public class OutOfOrderState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public OutOfOrderState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(String itemCode) {
        System.out.println("Machine is out of order.");
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Machine is out of order. Cannot accept coins.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Machine is out of order.");
    }

    @Override
    public void setOutOfOrder() {
        System.out.println("Machine is already out of order.");
    }
}
