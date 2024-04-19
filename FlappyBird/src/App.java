import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        // Membuat splash frame
        JFrame splashFrame = new JFrame("Welcome to Flappy Bird!");
        splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashFrame.setSize(360, 150);
        splashFrame.setLocationRelativeTo(null);
        splashFrame.setResizable(false);

        // Buat JPanel
        JPanel splashPanel = new JPanel();
        splashPanel.setLayout(new GridBagLayout());
        splashPanel.setBackground(Color.WHITE);


        JLabel label = new JLabel("Press the button below to start the game!");
        label.setFont(new Font("Arial", Font.BOLD, 14));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        splashPanel.add(label, gbc);

        // Tombol
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 12));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tutup splash frame dan buka frame game
                splashFrame.dispose();
                JFrame frame = new JFrame("Flappy Bird");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(360, 640);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

                // Buat FlappyBird object, masukin ke frame
                FlappyBird flappyBird = new FlappyBird();
                frame.add(flappyBird);
                frame.pack();
                flappyBird.requestFocus();
                frame.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        splashPanel.add(startButton, gbc);

        splashFrame.add(splashPanel);
        splashFrame.pack();
        splashFrame.setVisible(true);
    }
}