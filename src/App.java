public class App {
    public static void main(String[] args) throws Exception {
        ToyStore toyStore = new ToyStore();

        // Добавляем игрушки
        toyStore.addToy(new Toy(1, "Кукла", 10, 0.3));
        toyStore.addToy(new Toy(2, "Машинка", 8, 0.2));
        toyStore.addToy(new Toy(3, "Плюшевый мишка", 15, 0.5));

        // Обновляем частоту выпадения одной из игрушек
        toyStore.updateFrequency(1, 0.4);

        // Розыгрыш призовой игрушки
        Toy prizeToy = toyStore.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Призовая игрушка: " + prizeToy.getName());
            toyStore.savePrizeToyToFile(prizeToy);
        } else {
            System.out.println("Не осталось игрушек, которые можно было бы разыграть.");
        }
    }
}