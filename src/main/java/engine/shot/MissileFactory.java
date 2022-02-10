package engine.shot;

public class MissileFactory {

    public Missile create(int x, int y) {
        return new Missile(x, y);
    }


}
