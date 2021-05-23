package stopwatch;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
 
 JFrame frame = new JFrame();
 JButton startButton = new JButton("START");
 JButton resetButton = new JButton("RESET");
 JLabel timeLabel = new JLabel();
 int elapsedTime = 0;
 int seconds =0;
 int minutes =0;
 int hours =0;
 boolean started = false;
 String seconds_string = String.format("%02d", seconds);
 String minutes_string = String.format("%02d", minutes);
 String hours_string = String.format("%02d", hours);
 
 Timer timer = new Timer(1000, new ActionListener() {
  
  public void actionPerformed(ActionEvent e) {
   
   elapsedTime=elapsedTime+1000;
   hours = (elapsedTime/3600000);
   minutes = (elapsedTime/60000) % 60;
   seconds = (elapsedTime/1000) % 60;
   seconds_string = String.format("%02d", seconds);
   minutes_string = String.format("%02d", minutes);
   hours_string = String.format("%02d", hours);
   timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
   
  }
  
 });
 
 
 Stopwatch(){
  timeLabel.setBackground(Color.DARK_GRAY);
  timeLabel.setForeground(Color.GREEN);
  
  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
  timeLabel.setBounds(27,28,226,68);
  timeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 35));
  timeLabel.setBorder(BorderFactory.createBevelBorder(1));
  timeLabel.setOpaque(true);
  timeLabel.setHorizontalAlignment(JTextField.CENTER);
  
  startButton.setBounds(27,134,100,50);
  startButton.setFont(new Font("Arial", Font.PLAIN, 20));
  startButton.setFocusable(false);
  startButton.addActionListener(this);
  
  resetButton.setBounds(153,134,100,50);
  resetButton.setFont(new Font("Arial", Font.PLAIN, 20));
  resetButton.setFocusable(false);
  resetButton.addActionListener(this);
  
  frame.getContentPane().add(startButton);
  frame.getContentPane().add(resetButton);
  frame.getContentPane().add(timeLabel);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(299,277);
  frame.getContentPane().setLayout(null);
  frame.setVisible(true);
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==startButton) {
   
   if(started==false) {
    started=true;
    startButton.setText("STOP");
    start();
   }
   else {
    started=false;
    startButton.setText("START");
    stop();
   }
   
  }
  if(e.getSource()==resetButton) {
   started=false;
   startButton.setText("START");
   reset();
  }
  
 }
 
 void start() {
  timer.start();
 }
 
 void stop() {
  timer.stop();
 }
 
 void reset() {
  timer.stop();
  elapsedTime=0;
  seconds =0;
  minutes=0;
  hours=0;
  seconds_string = String.format("%02d", seconds);
  minutes_string = String.format("%02d", minutes);
  hours_string = String.format("%02d", hours);       timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
 }

}