package GUI;

import CodeFiles.Compress;
import CodeFiles.Decompress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class View extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        compressButton = new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);

        this.add(compressButton);
        this.add(decompressButton);

        this.getContentPane().setBackground(Color.lightGray);


        this.setSize(500,200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    Compress.method(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }


        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    Decompress.method(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static void main(String[] args){
        View view = new View();
        view.setVisible(true);
    }
}
