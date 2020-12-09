package com.anpapps.pongtennis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Andres Navarro on 02/03/2016.
 */
public class MainAnimation extends View {

    //other
    private Bitmap[] bitmaps;
    private float speedX = 3F, speedY = 3F;
    private boolean paint = true;

    //ball
    private Rect ballRect;
    private int ballX, ballY;
    private float ballXDir, ballYDir;
    private int ballWidth, ballHeight, ballWidthHalf;
    private boolean ballStart = true;
    private int world = 1;

    //raquet
    private Rect racquetRect;
    public int racquetX, racquetY;
    private int racquetWidth, racquetHeight, racquetWidthHalf;

    public MainAnimation(Context context) {
        super(context);

        bitmaps = new Bitmap[2];
        bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic);
        bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (paint) {
            //ball
            ballWidth = canvas.getWidth() / 7;
            ballHeight = ballWidth;
            ballWidthHalf = ballWidth / 2;
            ballX = canvas.getWidth() / 2 - ballWidthHalf;
            ballY = (canvas.getHeight() / 3 * 2) - ballWidth;
            ballXDir = 0F;
            ballYDir = 3F;

            //raquet
            racquetWidth = canvas.getWidth() / 6 * 2;
            racquetY = canvas.getHeight() / 15 * 13;
            racquetHeight = canvas.getHeight() / 50;
            racquetWidthHalf = racquetWidth / 2;

            paint = false;
        }
        //ball
        ballRect = new Rect(ballX, ballY, ballWidth + ballX, ballY + ballHeight);
        canvas.drawBitmap(bitmaps[0], null, ballRect, null);
        if (ballX + ballXDir > canvas.getWidth() - ballWidth) {
            ballXDir = -speedX;
        } else if (ballX + ballXDir < 0) {
            ballXDir = speedX;
        } else if (ballY + ballYDir > canvas.getHeight() - ballHeight) {
            ballYDir = -speedY;
        } else if (ballY + ballYDir < 0) {
            ballYDir = speedY;
        }
        ballX = ballX + (int) ballXDir;
        ballY = ballY + (int)ballYDir;

        //raquet
        if (ballX + ballWidth > racquetWidth && ballX + ballWidth < canvas.getWidth() - racquetWidthHalf) {
            racquetX = (ballX + ballWidthHalf) - racquetWidthHalf;
        }
        racquetRect = new Rect(racquetX, racquetY, racquetWidth + racquetX, racquetHeight + racquetY);
        canvas.drawBitmap(bitmaps[1], null, racquetRect, null);

        //collision
        if (ballY + ballHeight >= racquetY) {
            if (ballY + ballHeight <= racquetY + ballHeight) {
                if (ballX + ballWidth > racquetX) {
                    if (ballX < racquetX + racquetWidth) {

                        speedX = 4;
                        speedY = 4;
                        if (ballStart) {
                            if (racquetX + (racquetWidth / 2) > ballX + (ballWidth / 2)) {
                                ballXDir = -speedX;
                            } else {
                                ballXDir = speedX;
                            }
                            ballStart = false;
                        }
                        ballYDir = -speedY;
                        ballY = racquetY - ballWidth;
                    }
                }
            }
        }
        invalidate();
    }
}
