
// Класс, представляющий игрушку
public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double frequency; // Частота выпадения игрушки

    // Конструктор
    public Toy(int id, String name, int quantity, double frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    // Геттеры для свойств игрушки
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getFrequency() {
        return frequency;
    }

    // Метод для уменьшения количества игрушек
    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
