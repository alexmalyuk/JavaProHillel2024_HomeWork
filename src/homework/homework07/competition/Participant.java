package homework.homework07.competition;

public class Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public Participant(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public Result run(int distance) {
        System.out.println(" * " + name + " біжить на " + distance + " м");
        return new Result(distance <= maxRunDistance, Math.min(distance, maxRunDistance));
    }

    public Result jump(int height) {
        System.out.println(" * " + name + " стрибає на " + height + " м");
        return new Result((height <= maxJumpHeight), Math.min(height, maxJumpHeight));
    }

    @Override
    public String toString() {
        return name;
    }
}
