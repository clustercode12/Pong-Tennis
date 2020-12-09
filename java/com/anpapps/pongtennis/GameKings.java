package com.anpapps.pongtennis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Random;

/**
 * Created by Andres Navarro on 12/03/2016.
 */
public class GameKings extends Activity {

    //Variables
    private Bitmap[] bitmaps;
    private boolean dead = false;
    private boolean win = false;
    private int character = 1, level = 1;
    private boolean pause = false;
    private boolean congratualation = false;

    //Ball Variables
    private Rect ballRect;
    private int ballX, ballY;
    private float ballXDir, ballYDir;
    private int ballWidth, ballHeight, ballWidthHalf;
    private boolean ballStart = true;
    private float speedX = 5F, speedY = 5F;
    private float addSpeed = 1F;

    //Racquet Variables
    private Rect racquetRect;
    private int racquetX, racquetY;
    private int racquetWidth, racquetHeight, racquetWidthHalf;

    //Racquet Enemy Variables
    private Rect racquetEnemyRect;
    private int racquetEnemyX, racquetEnemyY;
    private int racquetEnemyWidth, racquetEnemyHeight, racquetEnemyWidthHalf;
    private int addSpeedEnemy;

    //Character Variables
    private Rect characterRect;
    private int characterX, characterY;
    private int characterWidth, characterHeight;

    //Character Enemy Variables
    private Rect characterEnemyRect;
    private int characterEnemyX, characterEnemyY;
    private int characterEnemyWidth, characterEnemyHeight;

    //Screen Variables
    private boolean touch = false;
    private boolean paint = true;
    private int canvasWidthHalf;
    private int canvasWidth;

    //Music Variables
    private MediaPlayer mpMusicWorld1, mpCollision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final gameView gameView = new gameView(this);
        setContentView(gameView);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //Racquet Movement
        gameView.setOnTouchListener(new gameView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                racquetX = (int) event.getX() - racquetWidthHalf;
                touch = true;
                if (racquetX < 0) {
                    racquetX = 10;
                } else if (racquetX + racquetWidth > canvasWidth) {
                    racquetX = (canvasWidth - 10) - racquetWidth;
                }
                return true;

            }
        });
        //Music Variables
        mpMusicWorld1 = MediaPlayer.create(this, R.raw.music_world_2);
        mpMusicWorld1.start();
        mpCollision = MediaPlayer.create(this, R.raw.collision);
    }
    public class gameView extends View {

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public gameView(Context context) {
            super(context);

            //Shared Preferences
            SharedPreferences sharedPreferencesLoadCharacter = GameKings.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
            character = sharedPreferencesLoadCharacter.getInt(getString(R.string.character), character);

            //Intent
            Intent getLevelPopUp = getIntent();
            level = getLevelPopUp.getIntExtra("level", 1);

            //Window
            Window window = getWindow();

            //Charcters
            bitmaps = new Bitmap[5];

            //Balls Background
            if (character == 10) {
                if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                    window.setStatusBarColor(getResources().getColor(R.color.orange_dark));
                }
                setBackgroundResource(R.color.orange);

                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic);
                bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
                bitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
                if (character == 1) {
                    bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic);
                }
            } else if (character == 15) {
                if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                    window.setStatusBarColor(getResources().getColor(R.color.blue_dark));
                }
                setBackgroundResource(R.color.blue);
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic);
                bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
                bitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
            } else {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic);
                bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
                bitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
                if (character == 1) {
                    bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic);
                }
            }

            //Characters
            if (character == 2) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_green);
            } else if (character == 3) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_pink);
            } else if (character == 4) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_ambar);
            } else if (character == 5) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_guard);
            } else if (character == 6) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_red);
            } else if (character == 7) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_rainbow);
            } else if (character == 8) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_guard_fire);
            } else if (character == 9) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_vampire);
            } else if (character == 10) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_god_hades);
            } else if (character == 11) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_blue);
            } else if (character == 12) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_earth);
            } else if (character == 13) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_guard_water);
            } else if (character == 14) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_ice);
            } else if (character == 15) {
                bitmaps[4] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_god_poseidon);
            }

            //Enemy
            if (level == 15) {
                bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_guard);
            } else if (level == 25) {
                bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_guard_fire);
            } else if (level == 35) {
                bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_god_hades);
            } else if (level == 45) {
                bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_guard_water);
            } else if (level == 55) {
                bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_god_poseidon);
            } else {
                bitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic);
            }

            //Enemy Speed Add
            if (level < 36 && level > 15) {
                addSpeedEnemy = 20;
            } else if (level < 56 && level > 35) {
                addSpeedEnemy = 25;
            } else {
                addSpeedEnemy = 10;
            }

            //Speed
            if (level < 36 && level > 15) {
                speedX = 6F;
                speedY = 6F;
                addSpeed = 1.2F;
            } else if (level < 56 && level > 35) {
                speedX = 7F;
                speedY = 7F;
                addSpeed = 1.4F;
            }
        }
        @Override
        protected void onDraw(Canvas canvas) {
            if (paint) {
                //Balls
                if (level == 25 || level == 45 || level == 55) {
                    ballWidth = canvas.getWidth() / 9;
                } else {
                    ballWidth = canvas.getWidth() / 7;
                }
                ballHeight = ballWidth;
                ballWidthHalf = ballWidth / 2;
                ballX = canvas.getWidth() / 2 - ballWidthHalf;
                ballY = (canvas.getHeight() / 3 * 2) - ballWidth;
                ballYDir = 3F;

                Random ranBallXDir = new Random();
                int random;
                random = ranBallXDir.nextInt(3 - 1) + 1;
                if (random == 1) {
                    ballXDir = 3F;
                } else if (random == 2) {
                    ballXDir = -3F;
                }

                //Racquet
                if (level == 35 || level == 45 || level == 55) {
                    racquetWidth = canvas.getWidth() / 9 * 2;
                } else {
                    racquetWidth = canvas.getWidth() / 7 * 2;
                }
                racquetY = canvas.getHeight() / 11 * 9;
                racquetHeight = canvas.getHeight() / 50;
                racquetWidthHalf = racquetWidth / 2;

                //racquet enemy
                if (level == 55) {
                    racquetEnemyWidth = canvas.getWidth() / 9 * 2;
                } else {
                    racquetEnemyWidth = canvas.getWidth() / 14 * 2;
                }
                racquetEnemyY = canvas.getHeight() / 10;
                racquetEnemyHeight = canvas.getHeight() / 50;
                racquetEnemyWidthHalf = racquetEnemyWidth / 2;
                racquetEnemyX = canvas.getWidth() / 2 - racquetEnemyWidthHalf;

                //Character
                characterWidth = canvas.getWidth() / 7;
                characterHeight = characterWidth;
                characterY = canvas.getHeight() / 75;
                characterX = canvas.getWidth() - characterWidth - characterY;
                characterRect = new Rect(characterX, characterY, characterWidth + characterX, characterHeight + characterY);

                //Character enemy
                characterEnemyWidth = characterWidth;
                characterEnemyHeight = characterEnemyWidth;
                characterEnemyY = canvas.getHeight() - characterEnemyHeight - characterY;
                characterEnemyX = canvas.getWidth() - characterEnemyWidth - characterY;
                characterEnemyRect = new Rect(characterEnemyX, characterEnemyY, characterEnemyWidth + characterEnemyX, characterEnemyHeight + characterEnemyY);

                //Others
                canvasWidthHalf = canvas.getHeight() / 2;
                canvasWidth = canvas.getWidth();
                paint = false;
            }

            //Balls
            ballRect = new Rect(ballX, ballY, ballWidth + ballX, ballY + ballHeight);
            canvas.drawBitmap(bitmaps[0], null, ballRect, null);
            if (ballX + ballXDir > canvas.getWidth() - ballWidth) {
                ballXDir = -speedX;
            } else if (ballX + ballXDir < 0) {
                ballXDir = speedX;
            } else if (ballY + ballYDir > canvas.getHeight() - ballHeight) {
                dead = true;
            } else if (ballY + ballYDir < 0) {
                win = true;
            }
            ballX = ballX + (int) ballXDir;
            ballY = ballY + (int)ballYDir;

            //Racquet
            if (!touch) {
                racquetX = canvas.getWidth() / 2 - racquetWidthHalf;
            }
            racquetRect = new Rect(racquetX, racquetY, racquetWidth + racquetX, racquetHeight + racquetY);
            canvas.drawBitmap(bitmaps[1], null, racquetRect, null);

            //Racquet enemy
            if (racquetEnemyX + racquetEnemyWidthHalf < ballX + ballWidthHalf) {
                racquetEnemyX+=addSpeedEnemy;
            } else if (racquetEnemyX + racquetEnemyWidthHalf > ballX + ballWidthHalf) {
                racquetEnemyX-=addSpeedEnemy;
            }
            racquetEnemyRect = new Rect(racquetEnemyX, racquetEnemyY, racquetEnemyWidth + racquetEnemyX, racquetEnemyHeight + racquetEnemyY);
            canvas.drawBitmap(bitmaps[1], null, racquetEnemyRect, null);

            //Collision
            if (ballY + ballHeight >= racquetY) {
                if (ballY + ballHeight <= racquetY + ballHeight) {
                    if (ballX + ballWidth > racquetX) {
                        if (ballX < racquetX + racquetWidth) {
                            mpCollision.start();

                            speedX += addSpeed;
                            speedY += addSpeed;

                            ballYDir = -speedY;
                            ballY = racquetY - ballWidth;
                        }
                    }
                }
            }

            //Character
            canvas.drawBitmap(bitmaps[3], null, characterRect, null);

            //Character Enemy
            canvas.drawBitmap(bitmaps[4], null, characterEnemyRect, null);

            //Collision Enemy
            if (ballY <= racquetEnemyY + racquetEnemyHeight) {
                if (ballY >= racquetEnemyY) {
                    if (ballX + ballWidth > racquetEnemyX) {
                        if (ballX < racquetEnemyX + racquetEnemyWidth) {
                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.collision);
                            mp.start();
                            ballYDir = speedY;
                            ballY = racquetEnemyY + racquetEnemyHeight;
                        }
                    }
                }
            }

            if (!pause) {
                if (dead) {
                    gameOver();
                } else if (win) {
                    congratulation();
                } else {
                    invalidate();
                }
            }
        }
        private void congratulation() {
            congratualation = true;
            Intent intent = null;
            if (level < 16){
                intent = new Intent(GameKings.this, World1.class);
            } else if (level < 36 && level > 15) {
                intent = new Intent(GameKings.this, World2.class);
            } else if (level < 56 && level > 35) {
                intent = new Intent(GameKings.this, World3.class);
            }
            intent.putExtra("congratulation", true);
            mpMusicWorld1.pause();
            startActivity(intent);
        }
        public void gameOver() {
            Intent intent = null;
            if (level < 16){
                intent = new Intent(GameKings.this, World1.class);
            } else if (level < 36 && level > 15) {
                intent = new Intent(GameKings.this, World2.class);
            } else if (level < 56 && level > 35) {
                intent = new Intent(GameKings.this, World3.class);
            }
            intent.putExtra("reintentar", true);
            mpMusicWorld1.pause();
            startActivity(intent);
        }
    }
    @Override
    protected void onPause() {
        pause = true;
        if (!congratualation) {
            Intent intent = null;
            if (level < 16) {
                intent = new Intent(GameKings.this, World1.class);
            } else if (level < 36 && level > 15) {
                intent = new Intent(GameKings.this, World2.class);
            } else if (level < 56 && level > 35) {
                intent = new Intent(GameKings.this, World3.class);
            }
            intent.putExtra("reintentar", true);
            mpMusicWorld1.pause();
            startActivity(intent);
        }
        super.onPause();
    }
}
