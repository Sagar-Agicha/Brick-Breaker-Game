package com.NBBG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

public class Custom extends JPanel implements ActionListener, KeyListener {

    int p,a = 0;
    int row;
    int col;
    int brick;
    int next;
    public String time1 = "00:00",time2 = "02:00";
    int sec1 = 0;
    int min1 = 0;
    String dd_min1,dd_sec1;
    int sec2 = 0;
    int min2 = 2;
    String dd_min2,dd_sec2;
    public int scores = 0;
    int total_bricks;
    int life = 2;
    int playerX = 310;
    int ball_pos_X = 360;
    int ball_pos_Y = 615;
    int ball_dir_X = -1;
    int ball_dir_Y = -2;
    String name;
    boolean play;
    JLabel bg;
    public Image img;
    DecimalFormat dFormat = new DecimalFormat("00");

    String path_name;

    String filepath3 = "Sound/break1.wav";
    String filepath4 = "Sound/break2.wav";
    String filepath1 = "Sound/win.wav";
    String filepath2 = "Sound/lose.wav";
    String filepath5 = "Sound/Test.wav";
    String filepath6;

    sound music = new sound();
    sound music1 = new sound();

    Timer timer;
    Timer timer1;
    Timer timer2;
    int delay; // to control the speed.
    MapGen map;

    public Custom(int row,int col,int blocks,int delay,int bricks,int next,int p,String path_name,String name,String filepath7) {

        this.total_bricks = blocks;
        this.row = row;
        this.col = col;
        this.delay = delay;
        this.path_name = path_name;
        this.name = name;
        this.brick = bricks;
        this.next = next;
        this.p = p;
        this.filepath6 = filepath7;

        img = Toolkit.getDefaultToolkit().getImage(path_name);
        music.play_music(filepath5);
        map = new MapGen(row, col);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay,this);
        timer.start();
        stopwatch();
        countdown();
        bg = new JLabel(new ImageIcon(path_name));
        add(bg);
        music1.play_music(filepath6);
    }

    public void stopwatch(){
        timer1 = new Timer(1000, e -> {
            sec1++;
            dd_sec1 = dFormat.format(sec1);
            dd_min1 = dFormat.format(min1);
            time1 = dd_min1 + " : " + dd_sec1;

            if (sec1 == 60) {
                sec1 = 0;
                min1++;
                dd_sec1 = dFormat.format(sec1);
                dd_min1 = dFormat.format(min1);
                time1 = dd_min1 + " : " + dd_sec1;
            }
        });
    }

    public void countdown() {
        timer2 = new Timer(1000, e -> {

            sec2--;
            dd_sec2 = dFormat.format(sec2);
            dd_min2 = dFormat.format(min2);
            time2 = dd_min2 + " : " + dd_sec2;

            if (sec2 == -1) {
                sec2 = 59;
                min2--;
                dd_sec2 = dFormat.format(sec2);
                dd_min2 = dFormat.format(min2);
                time2 = dd_min2 + " : " + dd_sec2;
            }
        });
    }

    public void Right_slide() {
        play = true;
        playerX += 60; // Glider Speed
    }

    public void left_slide() {
        play = true;
        playerX -= 60; // Glider Speed
    }

    public void paint(Graphics g) {

        super.paintComponent(g);
        g.drawImage(img,0,0,null);

        // Draw
        map.draw((Graphics2D) g);

        // Borders
        g.setColor(Color.black);
        g.fillRect(0, 0, 3, 550);
        g.fillRect(0, 0, 550, 3);
        g.fillRect(528, 1, 3, 550);

        // Slider
        g.setColor(Color.red);
        g.fillRect(playerX, 645, 110, 15);

        // ball
        g.setColor(Color.white);
        g.fillOval(ball_pos_X, ball_pos_Y, 25, 25);

        //Timer
        g.setColor(Color.white);
        g.setFont(new Font("gill",Font.ITALIC,20));
        g.drawString("Time Left : " + time2 ,225,30);

        //score
        g.setColor(Color.white);
        g.setFont(new Font("gill",Font.ITALIC,20));
        g.drawString("Score : " + scores ,400,30);

        // level
        g.setColor(Color.white);
        g.setFont(new Font("gill",Font.ITALIC,20));
        g.drawString("Level : " + name,50,30);

        // life
        g.setColor(Color.white);
        g.setFont(new Font("gill",Font.ITALIC,20));
        g.drawString("Life : " + life ,150,30);

        if(ball_pos_Y > 670)
        {
            playerX = 310;
            ball_pos_X = 355;
            ball_pos_Y = 615;
            ball_dir_X = -1;
            ball_dir_Y = -2;
            a = 1;
            life--;
        }

        // Game Over
        if(life == 0)
        {

            music.play_music(filepath2);

            play = false;
            ball_dir_X = 0;
            ball_dir_Y = 0;

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("Game Over, Scores: " + scores, 110,300);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("You Lost", 200,350);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", 150,400);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (BackSpace) to Return to the Main Menu", 60,440);

            life = 0;
            music1.clip.stop();
        }

        // Game Over (Time Over)
        if(min2 == 0 && sec2 == 0)
        {
            music.play_music(filepath2);

            play = false;
            ball_dir_X = 0;
            ball_dir_Y = 0;

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("Game Over, Scores: " + scores, 110,300);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("You Lost", 180,350);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", 150,400);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (BackSpace) to Return to the Main Menu", 60,440);

            life = 0;
            music1.clip.stop();
        }

        // Game Win
        if(total_bricks == 0)
        {
            play = false;
            ball_dir_X = 0;
            ball_dir_Y = 0;

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 50));
            g.drawString("YOU WON", 155,120);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("Game Over, Scores: " + scores, 100,300);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", 170,350);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 20));
            g.drawString("Press (BackSpace) to Return to the Main Menu", 60,390);

            g.setColor(Color.white);
            g.setFont(new Font("serif",Font.BOLD, 30));
            g.drawString("Time Taken = " + time1, 120,250);

            if(p == 1) {
                g.setColor(Color.white);
                g.setFont(new Font("serif", Font.BOLD, 20));
                g.drawString("Press (TAB) to Play Next Level", 60, 420);
            }
            music.play_music(filepath1);
            music1.clip.stop();
        }
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        timer.start();

        if (play) {
            if (new Rectangle(ball_pos_X, ball_pos_Y, 20, 20).intersects(new Rectangle(playerX, 645, 30, 8))) {
                ball_dir_Y = -ball_dir_Y;
                ball_dir_X = -2;
                music.play_music(filepath4);
            }
            else if(new Rectangle(ball_pos_X, ball_pos_Y, 20, 20).intersects(new Rectangle(playerX + 70, 645, 30, 8)))
            {
                ball_dir_Y = -ball_dir_Y;
                ball_dir_X = ball_dir_X + 1;
                music.play_music(filepath4);
            }
            else if(new Rectangle(ball_pos_X, ball_pos_Y, 20, 20).intersects(new Rectangle(playerX + 30, 645, 40, 8)))
            {
                ball_dir_Y = -ball_dir_Y;
                music.play_music(filepath4);
            }

            A: for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {

                        int brick_x = j * map.b_w + 80;
                        int brick_y = i * map.b_h + 50;
                        int b_w = map.b_w;
                        int b_h = map.b_h;

                        Rectangle Rect = new Rectangle(brick_x, brick_y, b_w, b_h);
                        Rectangle ball = new Rectangle(ball_pos_X, ball_pos_Y, 25, 25);

                        if (ball.intersects(Rect)) {
                            map.destroy(0, i, j);
                            total_bricks--;
                            music.play_music(filepath3);
                            scores += 5;

                            if (ball_pos_X + 50 <= Rect.x || ball_pos_X + 1 >= Rect.x + Rect.width) {
                                ball_dir_X = -ball_dir_X;
                            } else {
                                ball_dir_Y = -ball_dir_Y;
                            }
                            break A;
                        }
                    }
                }
            }

            if (a == 1) {
                ball_pos_X += ball_dir_X;
                ball_pos_Y += ball_dir_Y;

                if (ball_pos_X < 0) {
                    ball_dir_X = -ball_dir_X;
                }
                if (ball_pos_Y < 0) {
                    ball_dir_Y = -ball_dir_Y;
                }
                if (ball_pos_X > 515) {
                    ball_dir_X = -ball_dir_X;
                }
            }
            repaint();
        }
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 450) {
                playerX = 450;
            } else {
                Right_slide();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                left_slide();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!play) {
                play = true;
                scores = 0;
                timer1.start();
                timer2.start();
                ball_pos_X = playerX + 50;
                ball_pos_Y = 615;
                ball_dir_X = -1;
                ball_dir_Y = -3;
                a = 1;

                repaint();// it is used to call paint method again n again
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            play = true;
            scores = 0;
            total_bricks = brick;
            life = 2;
            playerX = 310;
            ball_pos_X = 355;
            ball_pos_Y = 615;
            ball_dir_X = -1;
            ball_dir_Y = -2;
            map = new MapGen(row, col);
            sec1 = min1 = sec2 = 0;
            min2 = 2;
        }

        if (e.getKeyCode() == KeyEvent.VK_TAB) {

            if(next == 0){

                Custom ca = new Custom(2,3,6,8,6,1,1,"Image/bg3.jpg","2","Sound/Naruto.wav");
                JFrame ff = new JFrame();
                ff.setSize(550,700);
                ff.setVisible(true);
                ff.add(ca);
                next++;
            }
            else if(next == 1){

                Custom ca = new Custom(4,4,16,8,16,2,1,"Image/bg.jpg","3","Sound/Naruto2.wav");
                JFrame ff = new JFrame();
                ff.setSize(550,700);
                ff.setVisible(true);
                ff.add(ca);

            }
            else if(next == 2){
                Custom ca = new Custom(4,6,24,6,24,3,1,"Image/bg.jpg","4","Sound/Naruto2.wav");
                JFrame ff = new JFrame();
                ff.setSize(550,700);
                ff.setVisible(true);
                ff.add(ca);
            }
            else if(next == 3){
                Custom ca = new Custom(5,7,35,2,35,4,1,"Image/bg.jpg","5","Sound/Naruto2.wav");
                JFrame ff = new JFrame();
                ff.setSize(550,700);
                ff.setVisible(true);
                ff.add(ca);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            Main_Menu ma = new Main_Menu();
            ma.music.clip.stop();
        }
    }

}