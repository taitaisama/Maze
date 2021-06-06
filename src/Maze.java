
import java.awt.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import javax.swing.*;
import javax.swing.text.*;

public class Maze extends JFrame implements ActionListener {

    private final JButton up = new JButton("↑");
    private final JButton right = new JButton("→");
    private final JButton down = new JButton("↓");
    private final JButton left = new JButton("←");
    private final JButton ans = new JButton("Get Answer");
    private final JButton gen = new JButton("Generate new Maze");
    private final JButton lol = new JButton("Customise color");
    private final JButton black = new JButton("Black");
    private final JButton blue = new JButton("Blue");
    private final JButton cyan = new JButton("Cyan");
    private final JButton darkGray = new JButton("Dark Gray");
    private final JButton gray = new JButton("Gray");
    private final JButton green = new JButton("Green");
    private final JButton yellow = new JButton("Yellow");
    private final JButton lightGray = new JButton("Light Gray");
    private final JButton magenta = new JButton("Magenta");
    private final JButton orange = new JButton("Orange");
    private final JButton pink = new JButton("Pink");
    private final JButton red = new JButton("Red");
    private final JButton white = new JButton("White");
    JTextField r = new JTextField("40");
    JTextField q = new JTextField("40");
    JTextField di = new JTextField("10");
    JTextPane ar = new JTextPane();
    JPanel col;
    JPanel go;
    int min = 0;
    int num = 0;
    long st = 0;
    int Bc = 0;
    int Fc = 0;
    int Cc = 0;
    int Rc = 0;
    int Wc = 0;
    char et = 'o';
    Color bc = Color.darkGray;//black
    private final JButton BC = new JButton("Blocked paths");
    Color fc = Color.white;
    private final JButton FC = new JButton("Movable paths");
    Color cc = Color.green;
    private final JButton CC = new JButton("Current cell");
    Color rc = Color.green;
    private final JButton RC = new JButton("Right path");
    Color wc = Color.red;
    private final JButton WC = new JButton("Wrong paths");
    int a[][], b[][];
    JLabel x = new JLabel("number of moves " + num);
    int y;
    int[] e;
    boolean ismaze = false;

    public Maze() {
        setTitle("Maze");
        Container contents = getContentPane();
        contents.setLayout(new BorderLayout());
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(0, 2));
        input.add(new JLabel("no. of columns"));
        input.add(r);
        input.add(new JLabel("no. of rows"));
        input.add(q);
        input.add(new JLabel("dificulty"));
        input.add(di);
        contents.add(input, BorderLayout.NORTH);
        JPanel press = new JPanel();
        contents.add(press, BorderLayout.SOUTH);
        press.setLayout(new FlowLayout());
        JPanel directions = new JPanel();
        directions.setLayout(new GridLayout(2, 0, 3, 3));
        press.add(directions);
        directions.add(new JLabel(" "));
        directions.add(up);
        up.addActionListener(this);
        directions.add(new JLabel(" "));
        directions.add(left);
        left.addActionListener(this);
        directions.add(down);
        down.addActionListener(this);
        directions.add(right);
        right.addActionListener(this);
        press.add(ans);
        ans.addActionListener(this);
        press.add(lol);
        lol.addActionListener(this);
        contents.add(new JScrollPane(ar), BorderLayout.CENTER);
        press.add(gen);
        gen.addActionListener(this);
        input.add(x);
        col = new JPanel();
        col.setLayout(new GridLayout(0, 1));
        col.add(new JLabel("Set the color of:-"));
        col.add(BC);
        BC.addActionListener(this);
        col.add(FC);
        FC.addActionListener(this);
        col.add(CC);
        CC.addActionListener(this);
        col.add(RC);
        RC.addActionListener(this);
        col.add(WC);
        WC.addActionListener(this);
        contents.add(col, BorderLayout.EAST);
        col.setVisible(false);
        go = new JPanel();
        go.setLayout(new GridLayout(0, 2));
        contents.add(go, BorderLayout.WEST);
        go.add(black);
        black.addActionListener(this);
        go.add(blue);
        blue.addActionListener(this);
        go.add(cyan);
        cyan.addActionListener(this);
        go.add(darkGray);
        darkGray.addActionListener(this);
        go.add(gray);
        gray.addActionListener(this);
        go.add(green);
        green.addActionListener(this);
        go.add(yellow);
        yellow.addActionListener(this);
        go.add(lightGray);
        lightGray.addActionListener(this);
        go.add(magenta);
        magenta.addActionListener(this);
        go.add(orange);
        orange.addActionListener(this);
        go.add(pink);
        pink.addActionListener(this);
        go.add(red);
        red.addActionListener(this);
        go.add(white);
        white.addActionListener(this);
        col.setLayout(new GridLayout(0, 1));
        go.setVisible(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        check();
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        e = new int[parseInt(r.getText()) * parseInt(q.getText()) + 1];
        if (event.getSource() == gen) {
            ismaze = true;
            min = 0;
            a = MazeGenerator(parseInt(r.getText()), parseInt(q.getText()), parseInt(di.getText()));
            /*for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    System.out.print(a[j][i]);
                }
                System.out.println("");
            }*/
            /*System.out.println("reset");
            System.out.println("canvassize " + parseInt(q.getText()) * 40+","+ parseInt(r.getText()) * 30 );
            System.out.println("penwidth 30");
            System.out.println("turnright 90");
            for (int i = 0; i < a[0].length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (a[j][i] == 0) {
                        System.out.println("go " + j * 40 + "," + (i * 30 + 10));
                        System.out.println("forward 20");
                    }
                }
            }
            for (int i = 0; i < a[0].length; i++) {
                if (a[0][i] == 1) {
                    System.out.println("go " + 0 + "," + (i * 30 + 10));
                }
            }
            System.out.println("penwidth 1");
            System.out.println("pencolor 255 ,0 ,0");*/
            y = e[0];
            a[y / 1000][y % 1000] = 5;
            num = 0;
            b = new int[parseInt(q.getText())][parseInt(r.getText())];
            for (int i = 0; i < parseInt(r.getText()); i++) {
                for (int j = 0; j < parseInt(q.getText()); j++) {
                    b[j][i] = a[j][i];
                }
            }
            print();

            StyledDocument doc = ar.getStyledDocument();
            Element eu = doc.getParagraphElement(0);
            MutableAttributeSet mas = new SimpleAttributeSet();
            StyleConstants.setLineSpacing(mas, -0.2f);
            StyleConstants.setSpaceAbove(mas, -0.2f);
            StyleConstants.setSpaceBelow(mas, -0.2f);
            doc.setParagraphAttributes(0, 10000, mas, true);
            check();
            x.setText("number of moves " + num);
        } else if (event.getSource() == up) {
            b[y / 1000][y % 1000] = 1;
            y -= 1;
            b[y / 1000][y % 1000] = 5;
            print();
            num++;
            check();
            x.setText("number of moves " + num);
        } else if (event.getSource() == down) {
            b[y / 1000][y % 1000] = 1;
            y += 1;
            b[y / 1000][y % 1000] = 5;
            print();
            num++;
            check();
            x.setText("number of moves " + num);
        } else if (event.getSource() == right) {
            if (y / 1000 < (parseInt(q.getText()) - 2)) {
                b[y / 1000][y % 1000] = 1;
                y += 1000;
                b[y / 1000][y % 1000] = 5;
                print();
                num++;
                check();
                x.setText("number of moves " + num);
            } else {
                num++;
                a = mazesolver();
                sprint();
                check();
                x.setText("number of moves " + num);
            }
        } else if (event.getSource() == left) {
            b[y / 1000][y % 1000] = 1;
            y -= 1000;
            b[y / 1000][y % 1000] = 5;
            print();
            num++;
            check();
            x.setText("number of moves " + num);
        } else if (event.getSource() == ans) {
            a = mazesolver();
            spprint();
            check();
            x.setText("number of moves " + num);
        } else if (event.getSource() == lol) {
            col.setVisible(true);
        } else if (event.getSource() == BC) {
            Bc = 1;
            Fc = 0;
            Cc = 0;
            Rc = 0;
            Wc = 0;
            col.setVisible(false);
            go.setVisible(true);
        } else if (event.getSource() == FC) {
            Bc = 0;
            Fc = 1;
            Cc = 0;
            Rc = 0;
            Wc = 0;
            col.setVisible(false);
            go.setVisible(true);
        } else if (event.getSource() == CC) {
            Bc = 0;
            Fc = 0;
            Cc = 1;
            Rc = 0;
            Wc = 0;
            col.setVisible(false);
            go.setVisible(true);
        } else if (event.getSource() == RC) {
            Bc = 0;
            Fc = 0;
            Cc = 0;
            Rc = 1;
            Wc = 0;
            col.setVisible(false);
            go.setVisible(true);
        } else if (event.getSource() == WC) {
            Bc = 0;
            Fc = 0;
            Cc = 0;
            Rc = 0;
            Wc = 1;
            col.setVisible(false);
            go.setVisible(true);
        } else if (event.getSource() == black) {
            et = is();
            colset(Color.black, et);
            go.setVisible(false);
        } else if (event.getSource() == blue) {
            et = is();
            colset(Color.blue, et);
            go.setVisible(false);
        } else if (event.getSource() == cyan) {
            et = is();
            colset(Color.cyan, et);
            go.setVisible(false);
        } else if (event.getSource() == darkGray) {
            et = is();
            colset(Color.darkGray, et);
            go.setVisible(false);
        } else if (event.getSource() == gray) {
            et = is();
            colset(Color.gray, et);
            go.setVisible(false);
        } else if (event.getSource() == green) {
            et = is();
            colset(Color.green, et);
            go.setVisible(false);
        } else if (event.getSource() == lightGray) {
            et = is();
            colset(Color.lightGray, et);
            go.setVisible(false);
        } else if (event.getSource() == magenta) {
            et = is();
            colset(Color.magenta, et);
            go.setVisible(false);
        } else if (event.getSource() == orange) {
            et = is();
            colset(Color.orange, et);
            go.setVisible(false);
        } else if (event.getSource() == pink) {
            et = is();
            colset(Color.pink, et);
            go.setVisible(false);
        } else if (event.getSource() == red) {
            et = is();
            colset(Color.red, et);
            go.setVisible(false);
        } else if (event.getSource() == white) {
            et = is();
            colset(Color.white, et);
            go.setVisible(false);
        } else if (event.getSource() == yellow) {
            et = is();
            colset(Color.yellow, et);
            go.setVisible(false);
        }
    }

    private void colset(Color C, char j) {
        switch (j) {
            case 'b':
                bc = C;
                break;
            case 'f':
                fc = C;
                break;
            case 'c':
                cc = C;
                break;
            case 'r':
                rc = C;
                break;
            case 'w':
                wc = C;
                break;
            default:
                break;
        }
    }

    private char is() {
        char pl = '0';
        if (Bc == 1) {
            pl = 'b';
        } else if (Fc == 1) {
            pl = 'f';
        } else if (Cc == 1) {
            pl = 'c';
        } else if (Rc == 1) {
            pl = 'r';
        } else if (Wc == 1) {
            pl = 'w';
        }
        return pl;
    }

    private void check() {
        if (ismaze == true) {
            ans.setEnabled(true);
            if (a[y / 1000][(y % 1000) + 1] == 0) {
                down.setEnabled(false);
            } else {
                down.setEnabled(true);
            }
            if (a[y / 1000][(y % 1000) - 1] == 0) {
                up.setEnabled(false);
            } else {
                up.setEnabled(true);
            }
            if (y / 1000 != parseInt(q.getText())) {
                if (a[(y / 1000) + 1][y % 1000] == 0) {
                    right.setEnabled(false);
                } else {
                    right.setEnabled(true);
                }
            } else {
                right.setEnabled(false);
            }
            if (y / 1000 != 0) {
                if (a[(y / 1000) - 1][y % 1000] == 0) {
                    left.setEnabled(false);
                } else {
                    left.setEnabled(true);
                }
            } else {
                left.setEnabled(false);
            }
        } else {
            down.setEnabled(false);
            up.setEnabled(false);
            right.setEnabled(false);
            left.setEnabled(false);
            ans.setEnabled(false);
        }
    }

    public void spprint() {
        ismaze = false;
        ar.setText("");
        appendToPane(ar, "YOU LOST YOU NOOB\n", Color.black);
        appendToPane(ar, "THE ANSWER IS...\n", Color.black);
        for (int i = 0; i < parseInt(r.getText()); i++) {
            for (int j = 0; j < parseInt(q.getText()); j++) {
                switch (a[j][i]) {
                    case 0:
                        appendToPane(ar, "██", bc);
                        break;
                    case 2:
                    case 6:
                        appendToPane(ar, "██", rc);
                        min++;
                        break;
                    default:
                        appendToPane(ar, "██", wc);
                        break;
                }
            }
            appendToPane(ar, "\n", Color.black);
        }
        min--;
        appendToPane(ar, "MINIMUM NUMBER OF MOVES = " + min, Color.black);
        min = 0;
    }

    public void sprint() {
        ismaze = false;
        appendToPane(ar, "YOU WIN!\n", Color.black);
        appendToPane(ar, "YOUR NUMBER OF MOVES ARE " + num + "\n", Color.black);
        for (int i = 0; i < parseInt(r.getText()); i++) {
            for (int j = 0; j < parseInt(q.getText()); j++) {
                switch (a[j][i]) {
                    case 2:
                    case 6:
                        min++;
                        break;
                }
            }
        }
        min--;
        appendToPane(ar, "MINIMUM NUMBER OF MOVES ARE " + min + "\n", Color.black);
        appendToPane(ar, "YOU WASTED " + (num - min) + " MOVES\n", Color.black);
        appendToPane(ar, "YOUR TIME IS " + (System.currentTimeMillis() - st) / 1000 + " SECONDS.\n", Color.black);
        appendToPane(ar, "THE SHORTEST ROUTE IS:-" + "\n", Color.black);
        for (int i = 0; i < parseInt(r.getText()); i++) {
            for (int j = 0; j < parseInt(q.getText()); j++) {
                switch (a[j][i]) {
                    case 0:
                        appendToPane(ar, "██", bc);
                        break;
                    case 2:
                    case 6:
                        appendToPane(ar, "██", rc);
                        break;
                    default:
                        appendToPane(ar, "██", wc);
                        break;
                }
            }
            appendToPane(ar, "\n", Color.black);
        }
    }

    public void print() {
        ar.setText("");
        for (int i = 0; i < parseInt(r.getText()); i++) {
            for (int j = 0; j < parseInt(q.getText()); j++) {
                switch (b[j][i]) {
                    case 0:
                        appendToPane(ar, "██", bc);
                        break;
                    case 1:
                        appendToPane(ar, "██", fc);
                        break;
                    case 5:
                        appendToPane(ar, "██", cc);
                        break;
                    default:
                        break;
                }
            }
            appendToPane(ar, "\n", Color.black);
        }
    }

    private void appendToPane(JTextPane tp, String msg, Color c)//this i copie from the internet, it is used for changing color
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }

    public int[][] MazeGenerator(int z, int x, int y) {
        int bo;
        bo = (int) x * z * y / 25;
        int c = 0, d, f = 0, p, l = 0, w, k = 0;
        a = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                a[i][j] = 0;
            }
        }
        st = System.currentTimeMillis();
        int o = (int) (Math.random() * (z - 2)) + 1;
        a[0][o] = 1;
        e[0] = o;
        f++;
        a[1][o] = 1;
        p = 1;
        e[1] = 1000 + o;
        f++;
        while (l < bo) {
            if (f >= (x * z) - 3) {
                f = 0;
            }
            if (p >= x - 1) {
                k = 1;
            }
            d = (int) (Math.random() * 9);
            if (d == 0||d==1) {//0=up
                if (o >= 2 && p >= 1 && p < x - 1) {
                    if (a[p][o - 2] == 1 || a[p + 1][o - 1] == 1 || a[p - 1][o - 1] == 1 || a[p][o - 1] == 1) {
                        c++;

                    } else {
                        a[p][o - 1] = 1;
                        o--;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                } else if (o <= 1) {
                    c++;

                } else if (o >= 2 && p < 1) {
                    if (a[p][o - 2] == 1 || a[p + 1][o - 1] == 1 || a[p][o - 1] == 1) {
                        c++;

                    } else {
                        a[p][o - 1] = 1;
                        o--;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                } else if (o >= 2 && p > x - 2) {
                    if (a[p][o - 2] == 1 || a[p - 1][o - 1] == 1 || a[p][o - 1] == 1) {
                        c++;

                    } else {
                        a[p][o - 1] = 1;
                        o--;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                }

            }
            if (d == 3||d==2) {//1=down
                if (o < z - 2 && p >= 1 && p < x - 2) {
                    if (a[p][o + 2] == 1 || a[p + 1][o + 1] == 1 || a[p - 1][o + 1] == 1 || a[p][o + 1] == 1) {
                        c++;

                    } else {
                        a[p][o + 1] = 1;
                        o++;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                } else if (o >= z - 2) {
                    c++;

                } else if (o < z - 2 && p < 1) {
                    if (a[p][o + 2] == 1 || a[p + 1][o + 1] == 1 || a[p][o + 1] == 1) {
                        c++;

                    } else {
                        a[p][o - 1] = 1;
                        o++;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                } else if (o < z - 2 && p > x - 2) {
                    if (a[p][o + 2] == 1 || a[p - 1][o + 1] == 1 || a[p][o + 1] == 1) {
                        c++;

                    } else {
                        a[p][o + 1] = 1;
                        o++;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                }

            }
            if (d == 4||d==5||d==6||d==7) {//2=back
                if (p >= 2 && o >= 1 && o < z - 1) {
                    if (a[p - 2][o] == 1 || a[p - 1][o + 1] == 1 || a[p - 1][o - 1] == 1 || a[p - 1][o] == 1) {
                        c++;

                    } else {
                        a[p - 1][o] = 1;
                        p--;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                } else if (p <= 1) {
                    c++;

                } else if (p >= 2 && o < 1) {
                    if (a[p - 2][o] == 1 || a[p - 1][o + 1] == 1 || a[p - 1][o] == 1) {
                        c++;

                    } else {
                        a[p - 1][o] = 1;
                        p--;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                } else if (p >= 2 && o > x - 2) {
                    if (a[p - 2][o] == 1 || a[p - 1][o - 1] == 1 || a[p - 1][o] == 1) {
                        c++;

                    } else {
                        a[p - 1][o] = 1;
                        p--;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                }

            }
            if (d == 8) {//3=front
                if (p == x - 2 && k == 0) {
                    a[p + 1][o] = 1;
                    p++;
                } else if (p == x - 2 && k == 1) {
                    c++;
                } else if (o >= 1 && p < x - 1) {
                    if (a[p + 2][o] == 1 || a[p + 1][o + 1] == 1 || a[p + 1][o - 1] == 1 || a[p + 1][o] == 1) {
                        c++;
                    } else {
                        a[p + 1][o] = 1;
                        p++;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                } else if (o < 1) {
                    if (a[p + 2][o] == 1 || a[p + 1][o + 1] == 1 || a[p + 1][o] == 1) {
                        c++;

                    } else {
                        a[p + 1][o] = 1;
                        p++;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                } else if (o > z - 2) {
                    if (a[p + 2][o] == 1 || a[p + 1][o - 1] == 1 || a[p + 1][o] == 1) {
                        c++;
                    } else {
                        a[p + 1][o] = 1;
                        p++;
                        e[f] = (p * 1000) + o;
                        f++;
                        c = 0;
                    }
                }

            }
            if (c >= 100) {
                c = 0;
                w = 0;
                for (int i = 0; i < z * x; i++) {
                    if (e[i] >= 1) {
                        w++;
                    }
                }
                d = (int) (Math.random() * w);
                if (d == 0) {
                    d++;
                }
                if (e[d] / 1000 == 0 || e[d] / 1000 == z - 1) {
                    c = 100;
                    continue;
                }
                p = e[d] / 1000;
                o = e[d] % 1000;
                if (k == 1) {
                    l++;
                }
            }

        }
        return a;
    }

    public int[][] mazesolver() {
        int B = 0;
        for (int i = 0; i < parseInt(q.getText()); i++) {
            if (a[0][i] == 5) {
                a[0][i]++;
                a[1][i]++;
                B = 1000 + i;
                break;
            }
        }
        int h;
        int p = B / 1000;
        int o = B % 1000;
        int xo = a.length;
        while (p < xo - 1) {
            if (a[p + 1][o] == 1) {
                p++;
                a[p][o]++;

            } else if (a[p - 1][o] == 1) {
                p--;
                a[p][o]++;

            } else if (a[p][o - 1] == 1) {
                o--;
                a[p][o]++;

            } else if (a[p][o + 1] == 1) {
                o++;
                a[p][o]++;

            } else if (a[p + 1][o] == 2) {
                a[p][o]++;
                p++;
            } else if (a[p - 1][o] == 2) {
                a[p][o]++;
                p--;
            } else if (a[p][o - 1] == 2) {
                a[p][o]++;
                o--;
            } else if (a[p][o + 1] == 2) {
                a[p][o]++;
                o++;
            }

        }
        return a;
    }

    public static void main(String[] args) {
        /*Scanner R = new Scanner (System.in);
        System.out.println("This is a customisable maze game. Enter anything to continue");
        String g = R.nextLine();
        System.out.println("The maze will start from the left side and end at the right side.");
        g = R.nextLine();
        System.out.println("Every game will have only one solution");
        g = R.nextLine();
        System.out.println("Also, if you cant solve it you can find the solution");
        System.out.println("(note : the solution is generated seperate from the creation of the maze)");
        g = R.nextLine();
        System.out.println("to customize the maze you have to enter the leangth , breadth and dificulty at the top");
        g = R.nextLine();
        System.out.println("also, you can customise the color");
        g = R.nextLine();
        System.out.println("note: it would take some time for anything above 200 by 200");
        System.out.println("it takes aprox 2 mins for 500 by 500, maximum size = 999 by 999");
        g = R.nextLine();
        System.out.println("Your time and number of moves will be calculated and shown");
        g=R.nextLine();*/
        new Maze().setVisible(true);
    }
}
