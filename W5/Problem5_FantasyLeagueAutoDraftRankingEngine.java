import java.util.Arrays;

public class Problem5_FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed,
                                   double battingAverage,
                                   boolean injured) {

            return matchesPlayed >= 5
                    && battingAverage >= 30.0
                    && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    static Player[] draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player player : players) {

            boolean draftablePlayer;

            if (player.matchesPlayed >= 10) {
                draftablePlayer =
                    Player.isDraftable(
                        player.matchesPlayed,
                        player.injured
                    );
            } else {
                draftablePlayer =
                    Player.isDraftable(
                        player.matchesPlayed,
                        player.battingAverage,
                        player.injured
                    );
            }

            if (draftablePlayer) {
                draftable[count++] = player;
            }
        }

        Player[] result = Arrays.copyOf(draftable, count);

        Arrays.sort(result);

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        Player[] rankedPlayers = draftAndRank(players);

        for (int i = 0; i < rankedPlayers.length; i++) {
            System.out.print((i + 1) + ". " + rankedPlayers[i].name);

            if (i < rankedPlayers.length - 1) {
                System.out.print(" | ");
            }
        }
    }
}