package com.example.preubaapp.object;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.preubaapp.GameLoop;
import com.example.preubaapp.Joystick;
import com.example.preubaapp.R;
import com.example.preubaapp.Utils;
import com.example.preubaapp.object.Circle;

public class Player extends Circle {
    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;


    private Joystick joystick;


    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.joystick = joystick;


    }


    public void update() {

        velocityX = joystick.getActuatorX() * MAX_SPEED;
        velocityY = joystick.getActuatorY() * MAX_SPEED;
        positionX += velocityX;
        positionY += velocityY;

        if (velocityX != 0 || velocityY != 0) {

            double distance = Utils.getDistanceBetweenPoints(0,0,velocityX,velocityY);
            directionX=velocityX/distance;
            directionY=velocityY/distance;

        }

    }

}
