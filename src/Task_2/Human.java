package Task_2;

public class Human {
    private String name;

    public String getName() {
        return name;
    }

    public void watering(Cactus cactus) {
        System.out.println(this.getName() + " полил кактус");
        cactus.setNeedWater(false);
    }

    public Human(String name) {
        this.name = name;
    }
}
