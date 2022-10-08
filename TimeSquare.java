public class TimeSquare implements IAggregable<TimeSquare, Integer>, IDeeplyCloneable<TimeSquare> {

    private int height;
    protected int current_height = height;


    public TimeSquare() {
    }

    public TimeSquare(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public Integer aggregate(Integer add_height) {
        if  (add_height == null) {
            return add_height;
        }
        current_height = current_height + add_height;
        return height + add_height;
    }

    public TimeSquare deepClone() {
        TimeSquare clone = new TimeSquare();
        clone.height = height;
        return clone;
    }


}