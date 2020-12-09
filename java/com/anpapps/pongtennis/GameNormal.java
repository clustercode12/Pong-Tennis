package com.anpapps.pongtennis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Andres on 23/01/2016.
 */

public class GameNormal extends Activity {

    //Variables
    private Bitmap[] bitmaps;
    private boolean dead = false;
    private Paint pbBlack;
    private int score = 0;
    private boolean pause = false;
    private Typeface font;
    private int character = 1, level = 1;
    private boolean congratualation = false, minigame = false;

    //Ball Variables
    private Rect ballRect;
    private int ballX, ballY;
    private float ballXDir, ballYDir;
    private int ballWidth, ballHeight, ballWidthHalf;
    private boolean ballStart = true;
    private float speedX = 6F, speedY = 6F;
    private float addSpeed = 1.5F;

    //Racquet Variables
    private Rect racquetRect;
    public int racquetX, racquetY;
    private int racquetWidth, racquetHeight, racquetWidthHalf;

    //Screen Variables
    private boolean touch = false;
    private int canvasWidthHalf;
    private int canvasWidth;
    private boolean paint = true;

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
        mpMusicWorld1 = MediaPlayer.create(this, R.raw.music_world_1);
        mpMusicWorld1.start();
        mpCollision = MediaPlayer.create(this, R.raw.collision);
    }
    public class gameView extends View {

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public gameView(Context context) {
            super(context);

            //Shared Preferences
            SharedPreferences sharedPreferencesLoadCharacter = GameNormal.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
            character = sharedPreferencesLoadCharacter.getInt(getString(R.string.character), character);

            //Intent
            Intent getLevelPopUp = getIntent();
            level = getLevelPopUp.getIntExtra("level", 1);
            minigame = getLevelPopUp.getBooleanExtra("minigame", false);

            //Window
            Window window = getWindow();
            font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");

            //Worlds
            bitmaps = new Bitmap[2];

            //Bolls Background
            if (character == 10) {
                if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                    window.setStatusBarColor(getResources().getColor(R.color.orange_dark));
                }
                setBackgroundResource(R.color.orange);

                if (character == 1) {
                    bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic);
                }
                bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
            } else if (character == 15) {
                if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                    window.setStatusBarColor(getResources().getColor(R.color.blue_dark));
                }
                setBackgroundResource(R.color.blue);
                bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
            } else {
                if (character == 1) {
                    bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic);
                } else if (character == 3) {
                    if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                        window.setStatusBarColor(getResources().getColor(R.color.pink_dark));
                    }
                    setBackgroundResource(R.color.pink);
                } else if (character == 4) {
                    if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                        window.setStatusBarColor(getResources().getColor(R.color.orange_dark));
                    }
                    setBackgroundResource(R.color.orange);
                } else if (character == 6) {
                    if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                        window.setStatusBarColor(getResources().getColor(R.color.red_dark));
                    }
                    setBackgroundResource(R.color.red);
                } else if (character == 7) {
                    if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                        window.setStatusBarColor(getResources().getColor(R.color.purple_dark));
                    }
                    setBackgroundResource(R.color.purple);
                } else if (character == 8) {
                    if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                        window.setStatusBarColor(getResources().getColor(R.color.orange_dark));
                    }
                    setBackgroundResource(R.color.orange);
                } else if (character == 9 || character == 11 || character == 12 || character == 13 || character == 14) {
                    if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                        window.setStatusBarColor(getResources().getColor(R.color.blue_dark));
                    }
                    setBackgroundResource(R.color.blue);
                }
                bitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.racquet);
            }

            //Characters
            if (character == 2) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_green);
            } else if (character == 3) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_pink);
            } else if (character == 4) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_ambar);
            } else if (character == 5) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_guard);
            } else if (character == 6) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_red);
            } else if (character == 7) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_rainbow);
            } else if (character == 8) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_guard_fire);
            } else if (character == 9) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_vampire);
            } else if (character == 10) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_god_hades);
            } else if (character == 11) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_classic_blue);
            } else if (character == 12) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_earth);
            } else if (character == 13) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_guard_water);
            } else if (character == 14) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_ice);
            } else if (character == 15) {
                bitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.ball_god_poseidon);
            }
        }
        @Override
        protected void onDraw(Canvas canvas) {
            if (paint) {
                //Balls
                if (level == 3 || level == 6 || level == 26 || level == 32 || level == 42) {
                    ballWidth = canvas.getWidth() / 9;
                } else if (level == 9 || level == 13 || level == 22 || level == 34 || level == 49){
                    ballWidth = canvas.getWidth() / 11;
                } else {
                    ballWidth = canvas.getWidth() / 7;
                }
                ballHeight = ballWidth;
                ballWidthHalf = ballWidth / 2;
                ballX = canvas.getWidth() / 2 - ballWidthHalf;
                ballY = canvas.getHeight() / 2;
                ballYDir = 3F;

                Random ranBallXDir = new Random();
                int random;
                random = ranBallXDir.nextInt(3 - 1) + 1;
                if (random == 1) {
                    ballXDir = 3F;
                } else if (random == 2) {
                    ballXDir = -3F;
                }

                //Racquets
                if (level == 4 || level == 6 || level == 22 || level == 34) {
                    racquetWidth = canvas.getWidth() / 9 * 2;
                } else if (level == 11 || level == 13 || level == 26 || level == 32) {
                    racquetWidth = canvas.getWidth() / 12 * 2;
                } else if (level == 42 || level == 49) {
                    racquetWidth = canvas.getWidth() / 14 * 2;
                } else {
                    racquetWidth = canvas.getWidth() / 7 * 2;
                }
                racquetY = canvas.getHeight() / 11 * 9;
                racquetHeight = canvas.getHeight() / 50;
                racquetWidthHalf = racquetWidth / 2;

                //Score
                pbBlack = new Paint();
                pbBlack.setTypeface(font);
                pbBlack.setARGB(255, 0, 0, 0);
                pbBlack.setTextAlign(Paint.Align.RIGHT);
                pbBlack.setTextSize(canvas.getWidth() / 6);

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
                ballYDir = speedY;
            }
            ballX = ballX + (int) ballXDir;
            ballY = ballY + (int)ballYDir;

            //raquet¡¡
            if (!touch) {
                racquetX = canvas.getWidth() / 2 - racquetWidthHalf;
            }
            racquetRect = new Rect(racquetX, racquetY, racquetWidth + racquetX, racquetHeight + racquetY);
            canvas.drawBitmap(bitmaps[1], null, racquetRect, null);

            //collision
            if (ballY + ballHeight >= racquetY) {
                if (ballY + ballHeight <= racquetY + ballHeight) {
                    if (ballX + ballWidth > racquetX) {
                        if (ballX < racquetX + racquetWidth) {

                            //music
                            mpCollision.start();

                            if (score < 12) {
                                speedX += addSpeed;
                                speedY += addSpeed;
                            }
                            ballYDir = -speedY;
                            score++;
                            ballY = racquetY - ballWidth;
                        }
                    }
                }
            }
            //minigames configuration
            if (minigame && score == 5) {
                ballWidth = canvas.getWidth() / 9;
                ballHeight = ballWidth;
            } else if (minigame && score == 10) {
                racquetWidth = canvas.getWidth() / 9 * 2;
            } else if (minigame && score == 15) {
                ballWidth = canvas.getWidth() / 11;
            } else if (minigame && score == 20) {
                racquetWidth = canvas.getWidth() / 12 * 2;
            } else if (minigame && score == 25) {
                racquetWidth = canvas.getWidth() / 14 * 2;
            }

            //score
            canvas.drawText(String.valueOf(score), canvas.getWidth() / 15 * 14, canvas.getWidth() / 6, pbBlack);

            if (!pause) {
                if (dead) {
                    gameOver();
                } else if (level == 1 && score >= 10 && !minigame) {
                    congratulation();
                } else if (level == 3 && score >= 15 && !minigame) {
                    congratulation();
                } else if (level == 4 && score >= 15 && !minigame) {
                    congratulation();
                } else if (level == 6 && score >= 15 && !minigame) {
                    congratulation();
                } else if (level == 9 && score >= 20 && !minigame) {
                    congratulation();
                } else if (level == 11 && score >= 20 && !minigame) {
                    congratulation();
                } else if (level == 13 && score >= 20 && !minigame) {
                    congratulation();
                } else if (level == 22 && score >= 25 && !minigame) {
                    congratulation();
                } else if (level == 26 && score >= 25 && !minigame) {
                    congratulation();
                } else if (level == 32 && score >= 25 && !minigame) {
                    congratulation();
                } else if (level == 34 && score >= 25 && !minigame) {
                    congratulation();
                } else if (level == 42 && score >= 30 && !minigame) {
                    congratulation();
                } else if (level == 49 && score >= 30 && !minigame) {
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
                intent = new Intent(GameNormal.this, World1.class);
            }  else if (level < 36 && level > 15) {
                intent = new Intent(GameNormal.this, World2.class);
            }  else if (level < 56 && level > 35) {
                intent = new Intent(GameNormal.this, World3.class);
            }
            intent.putExtra("congratulation", true);
            mpMusicWorld1.pause();
            startActivity(intent);
        }
        public void gameOver() {
            Intent intent = null;
            if (level < 16 && !minigame){
                intent = new Intent(GameNormal.this, World1.class);
                intent.putExtra("reintentar", true);
            }  else if (level < 36 && level > 15 && !minigame) {
                intent = new Intent(GameNormal.this, World2.class);
                intent.putExtra("reintentar", true);
            }  else if (level < 56 && level > 35 && !minigame) {
                intent = new Intent(GameNormal.this, World3.class);
                intent.putExtra("reintentar", true);
            } else if (minigame) {
                intent = new Intent(GameNormal.this, Minigames.class);
                intent.putExtra("type", 1);
                intent.putExtra("points", score);
                intent.putExtra("repeat", true);
            }
            mpMusicWorld1.pause();
            startActivity(intent);
        }
    }
    @Override
    protected void onPause() {
        pause = true;
        if (!congratualation) {
            Intent intent = null;
            if (level < 16 && !minigame) {
                intent = new Intent(GameNormal.this, World1.class);
                intent.putExtra("reintentar", true);
            } else if (level < 36 && level > 15 && !minigame) {
                intent = new Intent(GameNormal.this, World2.class);
                intent.putExtra("reintentar", true);
            } else if (level < 56 && level > 35 && !minigame) {
                intent = new Intent(GameNormal.this, World3.class);
                intent.putExtra("reintentar", true);
            } else if (minigame) {
                intent = new Intent(GameNormal.this, Minigames.class);
                intent.putExtra("type", 1);
                intent.putExtra("points", score);
                intent.putExtra("repeat", true);
            }
            mpMusicWorld1.pause();
            startActivity(intent);
        }
        super.onPause();
    }

}