package com.example.preubaapp.object;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.preubaapp.GameLoop;
import com.example.preubaapp.R;

public class Enemy extends Circle {

    public static final double SPEED_PIXELS_PER_SECOND = Player.SPEED_PIXELS_PER_SECOND * 0.6;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private static double SPAWNS_PER_MINUTE = 20;
    private static double SPAWNS_PER_SECOND = SPAWNS_PER_MINUTE / 60.0;
    private static double UPDATES_PER_SPAWN = GameLoop.MAX_UPS / SPAWNS_PER_SECOND;

    private static double updateUntilNextSpawn = UPDATES_PER_SPAWN;


    private final Player player;

    public Enemy(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.enemy), positionX, positionY, radius);
        this.player = player;

    }

    public Enemy(Context context, Player player) {
        super(context,
                ContextCompat.getColor(context, R.color.enemy),
                Math.random()*1000,
                Math.random()*1000,
                30
        );
        this.player=player;
    }


    public static boolean readyToSpawn() {
        if (updateUntilNextSpawn <= 0) {
            updateUntilNextSpawn += UPDATES_PER_SPAWN;
            return true;
        } else {
            updateUntilNextSpawn--;
            return false;

        }
    }

    @Override
    public void update() {

        double distanceToPlayerX = player.getPosotionX() - positionX;
        double distanceToPlayerY = player.getPosotionY() - positionY;


        double distanceToPlayer = GameObject.getDistanceBetweenObjects(this, player);


        double directionX = distanceToPlayerX / distanceToPlayer;
        double directionY = distanceToPlayerY / distanceToPlayer;

        if (distanceToPlayer > 0) {

            velocityX = directionX * MAX_SPEED;
            velocityY = directionY * MAX_SPEED;
        } else {
            velocityX = 0;
            velocityY = 0;


        }
        positionX += velocityX;
        positionY += velocityY;


    }
}
