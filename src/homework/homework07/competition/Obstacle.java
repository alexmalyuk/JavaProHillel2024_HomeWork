package homework.homework07.competition;

public abstract class Obstacle {
    private String name;
    protected int complexity;

    public Obstacle(String name, int complexity) {
        this.name = name;
        this.complexity = complexity;
    }

    public String getName() {
        return name;
    }

    public abstract Result overcome(Participant participant);
}
