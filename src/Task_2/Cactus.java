package Task_2;

public class Cactus {
    private boolean needWater;

    public boolean getNeedWater() {
        return needWater;
    }

    public void status(boolean needWater) {
        if (needWater == false) {
            System.out.println(Статус кактус не требует полива);
        } else {
            System.out.println(Статус кактус необходимо полить);
        }
    }

    public void setNeedWater(boolean needWater) {
        this.needWater = needWater;
    }
}
