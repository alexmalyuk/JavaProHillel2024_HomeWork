package homework.homework07.competition;

public class Main {
    public static void main(String[] args) {
        Participant human = new Participant("Людина", 2000, 2);
        Participant cat = new Participant("Кіт", 1500, 4);
        Participant robot = new Participant("Робот", 5000, 10);
        Participant[] participants = {human, cat, robot};

        Track track1000 = new Track("Доріжка 1км", 1000);
        Track track3000 = new Track("Доріжка 3км", 3000);
        Barrier barrier3 = new Barrier("Стінка 3м", 3);
        Barrier barrier2 = new Barrier("Стінка 2м", 2);
        Obstacle[] obstacles = {track1000, barrier2, track3000, barrier3};

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                Result result = obstacle.overcome(participant);
                if (result.isTaken()) {
                    System.out.println("Учасник " + participant.getName()
                            + " пройшов перешкоду " + obstacle.getName());
                } else {
                    System.out.println("Учасник " + participant.getName()
                            + " не пройшов перешкоду " + obstacle.getName()
                            + " пройдено " + result.takenDistance() + "м");
                    break;
                }
            }
        }
    }
}
