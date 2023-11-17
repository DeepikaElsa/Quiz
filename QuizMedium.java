package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizMedium extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    void Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which of the below is valid way to instantiate an array in java?";
        questions[0][1] = "int myArray [] = {1, 3, 5};";
        questions[0][2] = "int myArray [] [] = {1,2,3,4};";
        questions[0][3] = "int [] myArray = (5, 4, 3);";
        questions[0][4] = "int [] myArray = {“1”, “2”, “3”};";

        questions[1][0] = "What are the valid statements for static keyword in Java?";
        questions[1][1] = "We can have static block in a class.";
        questions[1][2] = "The static block in a class is executed every time an object of class is created.";
        questions[1][3] = "We can have static method implementations in interface";
        questions[1][4] = "We can define static block inside a method.";

        questions[2][0] = "Which of the following statements are true for inheritance in Java?";
        questions[2][1] = "The “extend” keyword is used to extend a class in java.";
        questions[2][2] = "You can extend multiple classes in java.";
        questions[2][3] = "Private members of the superclass are accessible to the subclass.";
        questions[2][4] = "We cannott extend Final classes in java.";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "Which of the below are not unchecked exceptions in java?";
        questions[4][1] = "RuntimeException";
        questions[4][2] = "ClassCastException";
        questions[4][3] = "NullPointerException";
        questions[4][4] = "IOException";

        questions[5][0] = " Which of the following statement are false for java?";
        questions[5][1] = "JVM is responsible for converting Byte code to the machine-specific code.";
        questions[5][2] = "We only need JRE to run java programs.";
        questions[5][3] = "JDK is required to compile java programs.";
        questions[5][4] = "JRE doesnot contain JVM";

        questions[6][0] = "Can we have two main methods in a java class?";
        questions[6][1] = "Yes";
        questions[6][2] = "No";
        questions[6][3] = "Maybe";
        questions[6][4] = "Maybe not";

        questions[7][0] = "Which of the following statement is false about annotations in java?";
        questions[7][1] = " @interface keyword is used to create custom annotation";
        questions[7][2] = " @Override is a built-in annotation in java";
        questions[7][3] = "Annotations cannot be applied to fields in a class.";
        questions[7][4] = "@Retention is one of the meta annotation in java.";

        questions[8][0] = "Which of the following statement is false about Enum in java?";
        questions[8][1] = "All java enum implicitly extends java.lang.Enum class.";
        questions[8][2] = "Java enum can implement interfaces.";
        questions[8][3] = "Enum constants are implicitly static and final.";
        questions[8][4] = "We can create instance of enum using new operator.";

        questions[9][0] = "Which of the below are not built-in class loaders in java?";
        questions[9][1] = "Bootstrap Class Loader";
        questions[9][2] = "Extensions Class Loader";
        questions[9][3] = "Runtime Class Loader";
        questions[9][4] = "System Class Loader";

        answers[0][1] = "int myArray [] = {1, 3, 5};";
        answers[1][1] = "We can have static method implementations in interface.";
        answers[2][1] = "We cannot extend Final classes in java.";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "IOException";
        answers[5][1] = "JRE doesnot contain JVM";
        answers[6][1] = "Yes";
        answers[7][1] = "Annotations cannot be applied to fields in a class.";
        answers[8][1] = "We can create instance of enum using new operator.";
        answers[9][1] = "Runtime Class Loader";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        qno.setBounds(100, 450, 50, 30); // Add this line to reset the position of qno label
    
        question.setText(questions[count][0]);
        question.setBounds(150, 450, 900, 30); // Update the position of the question label
    
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
    
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
    
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
    
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
    
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}