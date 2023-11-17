package quiz.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Score extends JFrame implements ActionListener {
    Score(String name, int score) {
        this.setBounds(400, 150, 750, 550);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout((LayoutManager) null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        this.add(image);

        JLabel heading = new JLabel("Thank you " + name + " for playing Simple Minds");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", 0, 26));
        this.add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", 0, 26));
        this.add(lblscore);

        JButton quizMediumButton = new JButton("Go to QuizMedium");
        quizMediumButton.setBounds(380, 350, 200, 30);
        quizMediumButton.setBackground(new Color(30, 144, 255));
        quizMediumButton.setForeground(Color.WHITE);
        quizMediumButton.addActionListener(this);
        quizMediumButton.setActionCommand("Go to QuizMedium"); // Set the action command
        this.add(quizMediumButton);

        JButton quizHardButton = new JButton("Go to QuizHard");
        quizHardButton.setBounds(590, 350, 200, 30);
        quizHardButton.setBackground(new Color(30, 144, 255));
        quizHardButton.setForeground(Color.WHITE);
        quizHardButton.addActionListener(this);
        quizHardButton.setActionCommand("Go to QuizHard"); // Set the action command
        this.add(quizHardButton);
        
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);

        if (ae.getActionCommand().equals("Go to QuizMedium")) {
            new QuizMedium(); // User clicked QuizMedium button
        } else if (ae.getActionCommand().equals("Go to QuizHard")) {
            new QuizHard(getName()); // User clicked QuizHard button

        }
    }

    public static void main(String[] args) {
        new Score("name", 0);
    }
}
