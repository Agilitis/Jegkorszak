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
            paraylzedPlayers.forEach((player,count)->{
                count--;
                if(count == 0){
                    player.deParalyze();
                    paraylzedPlayers.remove(player);
                }
            });
        }


    }
}
