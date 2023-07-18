package GUI;

import compressor;
import decompressor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class APPFRAME extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    APPFRAME(){
        this.setTitle("CONVERT");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compressButton=new JButton("CLICK HERE TO COMPRESS");
        compressButton.addActionListener(this);
        compressButton.setBounds(100,200,300,50);
        compressButton.setFont(new Font("Serif", Font.BOLD, 20));
        compressButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                compressButton.setBackground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                compressButton.setBackground(UIManager.getColor("control"));
            }
        });

        decompressButton=new JButton("CLICK HERE TO DECOMPRESS");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(470,200,300,50);
        decompressButton.setFont(new Font("Serif", Font.BOLD, 20));
        decompressButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                decompressButton.setBackground(Color.GREEN);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                decompressButton.setBackground(UIManager.getColor("control"));
            }
        });


        this.setVisible(true);


        this.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("background.jpg")));


        Label label = new Label("Hey! , Please choose option  from below");
        label.setFont(new Font("Serif", Font.BOLD, 25));
        label.setBounds(80,70,800,100);
        this.add(label);


        this.add(compressButton);
        this.add(decompressButton);

        
        this.setSize(1000,400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);

                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());

                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);

                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());

                }
            }
        }
    }
}
