package com.example.preubaapp.object;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.preubaapp.GameLoop;
import com.example.preubaapp.R;

public class Spell extends Circle{
    public static final double SPEED_PIXELS_PER_SECOND = 800.0;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;



    private final Player spellcaster;

    public Spell(Context context, Player spellcaster) {
        super(context,
                ContextCompat.getColor(context, R.color.spell),
                spellcaster.getPosotionX(),
                spellcaster.getPosotionY(),
                15
        );
        this.spellcaster=spellcaster;

        velocityX=spellcaster.getDirectionX()*MAX_SPEED;
        velocityY=spellcaster.getDirectionY()*MAX_SPEED;

    }

    @Override
    public void update() {
        positionX+=velocityX;
        positionY+=velocityY;

    }
}
