public class Battler {
    //initialise la bataille
    public String name;
    public float hp;
    public float atk;
    public void attack(Battler enemyBattler,Battler playingBattler) {
        enemyBattler.hp-=playingBattler.atk;
    }
}