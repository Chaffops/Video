package com.example.preubaapp.object;

import android.graphics.Canvas;

public abstract class GameObject {
    protected double positionX;
    protected double positionY;
    protected double velocityX;
    protected double velocityY;
    protected double directionX=1;
    protected double directionY;


    public GameObject(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;


    }


    public abstract void draw(Canvas canvas);

    public abstract void update();

    protected double getPosotionX() {
        return positionX;
    }

    protected double getPosotionY() {
        return positionY;
    }

    protected static double getDistanceBetweenObjects(GameObject obj1, GameObject obj2) {

        return Math.sqrt(
                Math.pow(obj2.getPosotionX() - obj1.getPosotionX(), 2) +
                        Math.pow(obj2.getPosotionY() - obj1.getPosotionY(), 2)
        );
    }


    protected double getDirectionX() {
        return directionX;
    }

    protected double getDirectionY() {
        return directionY;
    }
}
