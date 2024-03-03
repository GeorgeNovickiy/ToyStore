import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Класс, управляющий магазином игрушек

public class ToyStore {
    private List<Toy> toys; // Список игрушек в магазине

    // Конструктор
    public ToyStore() {
        toys = new ArrayList<>();
    }

    // Метод для добавления новой игрушки в магазин
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    // Метод для обновления частоты выпадения игрушки
    public void updateFrequency(int id, double newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setFrequency(newFrequency);
                return;
            }
        }
    }

    // Метод для выбора призовой игрушки в зависимости от частоты выпадения
    public Toy chooseToy() {
        // Вычисляем общую частоту выпадения игрушек
        double totalFrequency = toys.stream().mapToDouble(Toy::getFrequency).sum();
        // Генерируем случайное число в диапазоне от 0 до totalFrequency
        double randomNumber = Math.random() * totalFrequency;

        // Проходим по списку игрушек и выбираем игрушку в соответствии с частотой выпадения
        double sum = 0;
        for (Toy toy : toys) {
            sum += toy.getFrequency();
            if (randomNumber <= sum) {
                return toy;
            }
        }
        return null; // Не должно произойти, если частоты установлены корректно
    }

    // Метод для получения призовой игрушки
    public Toy getPrizeToy() {
        Toy prizeToy = chooseToy();
        if (prizeToy != null) {
            prizeToy.decreaseQuantity(); // Уменьшаем количество призовой игрушки
            return prizeToy;
        }
        return null;
    }

    // Метод для сохранения призовой игрушки в файл
    public void savePrizeToyToFile(Toy prizeToy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize.txt", true))) {
            writer.write("Prize Toy: " + prizeToy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
