package homework.homework07.competition;

public class Barrier extends Obstacle {
    public Barrier(String name, int complexity) {
        super(name, complexity);
    }

    @Override
    public Result overcome(Participant participant) {
        return participant.jump(complexity);
    }
}
