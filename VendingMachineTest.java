public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.selectItem("A1");
        vm.insertCoin(5);
        vm.insertCoin(5);

        vm.selectItem("B2");
        vm.setOutOfOrder();
        vm.insertCoin(10);
    }
}
