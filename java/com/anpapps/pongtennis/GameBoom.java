package com.anpapps.pongtennis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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

import java.util.Random;

/**
 * Created by Andres Navarro on 05/03/2016.
 */
public class GameBoom extends Activity {

    //Variables
    private Bitmap[] bitmaps;
    private boolean dead = false;
    private Paint pbBlack;
    private boolean paint = true;
    private int score = 0;
    private int canvasWidthHalf;
    private int canvasWidth;
    private Canvas canvas1;
    private Typeface font;
    private boolean pause = false;
    private boolean congratualation = false, minigame = false;

    //Ball Variables
    private Rect ballRect;
    private int ballX, ballY;
    private float ballXDir, ballYDir;
    private int ballWidth, ballHeight, ballWidthHalf;
    private boolean ballStart = true;
    private float speedX = 6F, speedY = 6F;
    private float addSpeed = 1.3F;
    private int character = 1, level = 1;

    //Bomb Variables
    private Rect bombRect;
    private int bombX, bombY;
    private int bombWidth, bombHeight;
    private int bombYDir;
    private boolean bombShow = false;
    private int minigameBombRandomNumber = 751;

    //Racquet Variables
    private Rect racquetRect;
    public int racquetX, racquetY;
    private int racquetWidth, racquetHeight, racquetWidthHalf;

    //Screen Variables
    private boolean touch = false;

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
        mpMusicWorld1 = MediaPlayer.create(this, R.raw.music_world_3);
        mpCollision = MediaPlayer.create(this, R.raw.collision);
        mpMusicWorld1.start();
    }
    public class gameView extends View {

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public gameView(Context context) {
            super(context);

            //Shared Pregerences
            SharedPreferences sharedPreferencesLoadCharacter = GameBoom.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
            character = sharedPreferencesLoadCharacter.getInt(getString(R.string.character), character);

            //Intent
            Intent getLevelPopUp = getIntent();
            level = getLevelPopUp.getIntExtra("level", 1);
            minigame = getLevelPopUp.getBooleanExtra("minigame", false);

            //Window
            Window window = getWindow();
            font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");

            //Characters
            bitmaps = new Bitmap[3];

            //Balls Background
            if (character == 10) {
                if (Integer.valueOf(android.os.Build.VERSION.SDK) > 21) {
                    window.setStatusBarColor(getResources().getColor(R.color.orange_dark));
                }
                setBackgroundResource(R.color.orange);
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

            //Bomb
            bitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            if (paint) {
                //Balls
                if (level == 7 || level == 12 || level == 31 || level == 40) {
                    ballWidth = canvas.getWidth() / 9;
                } else if (level == 18 || level == 23 || level == 28 || level == 51) {
                    ballWidth = canvas.getWidth() / 11;
                } else{
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

                //Bomb
                bombWidth = canvas.getWidth() / 7;
                bombHeight = bombWidth + (bombWidth / 4);
                bombY = 10 + bombHeight;
                if (level < 36 && level > 15) {
                    bombYDir = 5;
                } else if (level < 56 && level > 35) {
                    bombYDir = 7;
                } else {
                    bombYDir = 3;
                }

                //Racquets
                if (level == 10 || level == 12 || level == 28) {
                    racquetWidth = canvas.getWidth() / 9 * 2;
                } else if (level == 19 || level == 23 || level == 31) {
                    racquetWidth = canvas.getWidth() / 12 * 2;
                } else if (level == 40 || level == 51) {
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

                //other
                canvasWidthHalf = canvas.getHeight() / 2;
                canvasWidth = canvas.getWidth();

                canvas1 = canvas;
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
            ballY = ballY + (int) ballYDir;

            //Bomb
            if (bombShow) {
                bombRect = new Rect(bombX, bombY, bombWidth + bombX, bombY + bombHeight);
                canvas.drawBitmap(bitmaps[2], null, bombRect, null);
                if (bombY + bombYDir > canvas.getHeight() - bombHeight) {
                    bombShow = false;
                }
                bombY = bombY + bombYDir;
            } else {
                Random ranVisible = new Random();
                int visible;
                if (level < 16 && level > 2) {
                    visible = ranVisible.nextInt(451 - 1) + 1;
                } else if (level < 36 && level > 15) {
                    visible = ranVisible.nextInt(301 - 1) + 1;
                } else if (level < 56 && level > 35) {
                    visible = ranVisible.nextInt(201 - 1) + 1;
                } else if (minigame) {
                    visible = ranVisible.nextInt(minigameBombRandomNumber - 1) + 1;
                } else {
                    visible = ranVisible.nextInt(751 - 1) + 1;
                }
                if (visible == 40 && !bombShow) {
                    Random ranX = new Random();
                    int ranBombX = ranX.nextInt(6 - 1) + 1;
                    if (ranBombX == 1) {
                        bombX = canvas.getWidth() - bombWidth;
                    } else if (ranBombX == 2) {
                        bombX = canvas.getWidth() / 5 * 4;
                    } else if (ranBombX == 3) {
                        bombX = canvas.getWidth() / 5 * 3;
                    } else if (ranBombX == 4) {
                        bombX = canvas.getWidth() / 5 * 2;
                    } else if (ranBombX == 5) {
                        bombX = canvas.getWidth() / 5;
                    }
                    bombY = 10 + bombHeight;
                    bombRect = new Rect(ballX, ballY, ballWidth + ballX, ballY + ballHeight);
                    bombShow = true;
                }
            }

            //Racquet
            if (!touch) {
                racquetX = canvas.getWidth() / 2 - racquetWidthHalf;
            }
            racquetRect = new Rect(racquetX, racquetY, racquetWidth + racquetX, racquetHeight + racquetY);
            canvas.drawBitmap(bitmaps[1], null, racquetRect, null);

            //Collision
            if (ballY + ballHeight >= racquetY) {
                if (ballY + ballHeight <= racquetY + ballHeight) {
                    if (ballX + ballWidth > racquetX) {
                        if (ballX < racquetX + racquetWidth) {
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

            //Collision Bomb
            if (bombY + bombHeight >= racquetY) {
                if (bombY + bombHeight <= racquetY + racquetHeight) {
                    if (bombX + bombWidth >= racquetX) {
                        if (bombX <= racquetX + racquetWidth) {
                            bombY -= 20;
                            dead = true;

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
                minigameBombRandomNumber = 351;
            } else if (minigame && score == 20) {
                ballWidth = canvas.getWidth() / 11;
                ballHeight = ballWidth;
            } else if (minigame && score == 25) {
                racquetWidth = canvas.getWidth() / 14 * 2;
            } else if (minigame && score == 30) {
                minigameBombRandomNumber = 201;
            }

            //Score
            canvas.drawText(String.valueOf(score), canvas.getWidth() / 15 * 14, canvas.getWidth() / 6, pbBlack);

            if (!pause) {
                if (dead) {
                    gameOver();
                } else if (level == 2 && score >= 10 && !minigame) {
                    congratulation();
                } else if (level == 5 && score >= 15 && !minigame) {
                    congratulation();
                } else if (level == 7 && score >= 15 && !minigame) {
                    congratulation();
                } else if (level == 10 && score >= 15 && !minigame) {
                    congratulation();
                } else if (level == 12 && score >= 20 && !minigame) {
                    congratulation();
                } else if (level == 18 && score >= 20 && !minigame) {
                    congratulation();
                } else if (level == 19 && score >= 20 && !minigame) {
                    congratulation();
                } else if (level == 23 && score >= 20 && !minigame) {
                    congratulation();
                } else if (level == 28 && score >= 25 && !minigame) {
                    congratulation();
                } else if (level == 31 && score >= 25 && !minigame) {
                    congratulation();
                } else if (level == 40 && score >= 30 && !minigame) {
                    congratulation();
                } else if (level == 51 && score >= 30 && !minigame) {
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
                intent = new Intent(GameBoom.this, World1.class);
            }  else if (level < 36 && level > 15) {
                intent = new Intent(GameBoom.this, World2.class);
            } else if (level < 56 && level > 35) {
                intent = new Intent(GameBoom.this, World3.class);
            }
            intent.putExtra("congratulation", true);
            mpMusicWorld1.pause();
            startActivity(intent);
        }
        public void gameOver() {
            Intent intent = null;
            if (level < 16 && !minigame){
                intent = new Intent(GameBoom.this, World1.class);
                intent.putExtra("reintentar", true);
            }  else if (level < 36 && level > 15 && !minigame) {
                intent = new Intent(GameBoom.this, World2.class);
                intent.putExtra("reintentar", true);
            } else if (level < 56 && level > 35 && !minigame) {
                intent = new Intent(GameBoom.this, World3.class);
                intent.putExtra("reintentar", true);
            } else if (minigame) {
                intent = new Intent(GameBoom.this, Minigames.class);
                intent.putExtra("type", 2);
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
                intent = new Intent(GameBoom.this, World1.class);
                intent.putExtra("reintentar", true);
            } else if (level < 36 && level > 15 && !minigame) {
                intent = new Intent(GameBoom.this, World2.class);
                intent.putExtra("reintentar", true);
            } else if (level < 56 && level > 35 && !minigame) {
                intent = new Intent(GameBoom.this, World3.class);
                intent.putExtra("reintentar", true);
            } else if (minigame) {
                intent = new Intent(GameBoom.this, Minigames.class);
                intent.putExtra("type", 2);
                intent.putExtra("points", score);
                intent.putExtra("repeat", true);
            }
            mpMusicWorld1.pause();
            startActivity(intent);
        }
        super.onPause();
    }
}
