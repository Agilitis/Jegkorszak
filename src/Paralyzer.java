import java.util.HashMap;

public class Paralyzer extends Thread{

    private static Paralyzer instance=null;
    private HashMap<Player, Integer> paraylzedPlayers;

    void addPlayer(Player player, int paralyzeTime){
        paraylzedPlayers.put(player, paralyzeTime);
    }

    private Paralyzer(){
        paraylzedPlayers = new HashMap<>();
    }

    static Paralyzer getInstance(){
        if(instance == null){
            instance = new Paralyzer();
        }
        return instance;
    }

    public void run() {
        tick();
    }


    public void tick() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!paraylzedPlayers.isEmpty()){
                checkForFreePlayers();
            }

        }


    }

    private synchronized void checkForFreePlayers() {
        paraylzedPlayers.forEach((player,count)->{
            System.out.println(count);
            paraylzedPlayers.put(player, --count);
            if(count <= 0){
                player.deParalyze();
            }
        });
    }

    synchronized void removePlayer(Player player) {
        paraylzedPlayers.remove(player);
    }
}
