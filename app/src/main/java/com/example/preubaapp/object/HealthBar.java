package com.example.preubaapp.object;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;

import com.example.preubaapp.R;

public class HealthBar {

    private Player player;
    private int width, height, margin;
    private Paint borderPaint,healthPaint;


    public HealthBar(Context context, Player player) {
        this.player = player;
        this.width = 100;
        this.height = 20;
        this.margin = 2;

        this.borderPaint = new Paint();
        int borderColor = ContextCompat.getColor(context, R.color.healthBarBorder);
        borderPaint.setColor(borderColor);

        this.healthPaint = new Paint();
        int healthColor = ContextCompat.getColor(context, R.color.healthBarHealth);
        healthPaint.setColor(healthColor);
    }


    public void draw(Canvas canvas) {
        float x = (float) player.getPosotionX();
        float y = (float) player.getPosotionY();
        float distanceToPlayer = 40;
        float healthPointPercentage =(float) Player.getHealthPoints() / Player.MAX_HEALTH_POINTS;

        float borderLeft, borderTop, borderRight, borderBottom;

        borderLeft = x - width / 2;
        borderRight = x + width / 2;
        borderBottom = y - distanceToPlayer;
        borderTop = borderBottom - height;
        canvas.drawRect(borderLeft, borderTop, borderRight, borderBottom, borderPaint);
        float healthLeft, healthTop, healthRight, healthBottom, healthWidth,healthHeight;
        healthWidth= width-2*margin;
        healthHeight=height -2*margin;
        healthLeft= borderLeft+margin;
        healthRight=healthLeft+healthWidth*healthPointPercentage;
        healthBottom=borderBottom -margin;
        healthTop=borderBottom -healthHeight;

        canvas.drawRect(healthLeft,healthTop,healthRight,healthBottom,healthPaint);

    }

}
