import java.util.Random;
public class Game {
    public void play(){
        //initialise les variables
        Battler a = new Battler();
        Battler b = new Battler();
        a.name = "a";
        b.name = "b";
        Random rand = new Random();
        float minHP = 100,maxHP = 500, minAtk = 10, maxAtk = 30;
        a.hp = rand.nextFloat() * (maxHP - minHP) + minHP;
        b.hp = rand.nextFloat() * (maxHP - minHP) + minHP;
        a.atk = rand.nextFloat() * (maxAtk - minAtk) + minAtk;
        b.atk = rand.nextFloat() * (maxAtk - minAtk) + minAtk;
        Team aTeam = new Team();
        Team bTeam = new Team();
        aTeam.battler.add(a);
        bTeam.battler.add(b);
        Team fisrtTeam;
        Team secondTeam;

        //choisi la première équipe
        int oddEven = rand.nextInt();
        if(oddEven%2==0){
            fisrtTeam = aTeam;
            secondTeam = bTeam;
        }else{
            fisrtTeam = bTeam;
            secondTeam = aTeam;
        }
        System.out.println("Bonne chance");
        Team currentTeam = fisrtTeam;
        Team otherTeam = secondTeam;
        Team waitingTeam;
        Battler currentBattler;
        Battler otherBattler;
        //commence la bataille
        while(true){
            currentBattler = currentTeam.battler.get(0);
            otherBattler = otherTeam.battler.get(0);
            currentBattler.attack(otherBattler,currentBattler);
            if(otherBattler.hp <= 0f){
                otherBattler.hp=0f;
                System.out.println(otherBattler.name+ " a ete vaincu par " + currentBattler.name);
                break;
            }
            System.out.println(otherBattler.name+ " a ete frappe par " + currentBattler.name + " pour " + currentBattler.atk);
            System.out.println("PV restant de "+otherBattler.name+" : "+otherBattler.hp);
            waitingTeam = otherTeam;
            otherTeam = currentTeam;
            currentTeam = waitingTeam;
        }
    }
}