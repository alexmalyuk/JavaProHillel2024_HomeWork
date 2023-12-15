package homework.homework07.competition;

public abstract class Obstacle {
    private String name;
    protected int complexity;

    public Obstacle(String name, int complexity) {
        this.name = name;
        this.complexity = complexity;
    }

    public abstract Result overcome(Participant participant);

    @Override
    public String toString() {
        return name;
    }
}
