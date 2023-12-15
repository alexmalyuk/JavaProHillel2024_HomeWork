package homework.homework07.competition;

public class Track extends Obstacle {
    public Track(String name, int complexity) {
        super(name, complexity);
    }

    @Override
    public Result overcome(Participant participant) {
        return participant.run(complexity);
    }
}
