package src.curr_programmes.tenth_of_april.SeaBattle.ru.mai.sea.battle;

public class Battle {
    
    public static void main(String[] args) {
        if(args.length != 2) {
            System.exit(10);
        }
        if(!args[0].equals("--size")) {
            System.exit(9);
        }
        int size = Integer.parseInt(args[1]);
        Battlefield player = new Battlefield(size);
        player.fillRandom();
        player.show();
    }
}
