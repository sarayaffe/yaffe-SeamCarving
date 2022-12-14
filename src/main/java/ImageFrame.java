
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFrame extends JFrame {

    private final JLabel imageLabel;
    private final ImagePresenter imagePresenter = new ImagePresenter();
    private BufferedImage originalImage;

    public ImageFrame() {
        setLayout(new BorderLayout());

        // This is where the image will be stored.
        imageLabel = new JLabel();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        JButton resizeButton = new JButton("Resize");
        resizeButton.addActionListener(event -> {
            // This will set the image based on the current size of the label
            setSeamImageSize(imageLabel.getWidth(), imageLabel.getHeight());
        });
        northPanel.add(resizeButton);

        JButton loadButton = new JButton("Load");
        northPanel.add(loadButton);
        loadButton.addActionListener(event -> {
            chooseFile();
        });

        add(northPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        BufferedImage image;
        try {
            image = ImageIO.read(ImageFrame.class.getResourceAsStream("/Broadway_tower_edit.jpg"));
            loadSeamImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setTitle("Seam Carving");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                loadSeamImage(ImageIO.read(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void loadSeamImage(BufferedImage image) {
        originalImage = image;
        imageLabel.setIcon(new ImageIcon(image));

        setSize(image.getWidth(null), image.getHeight(null));
        pack();
    }

    private void setSeamImageSize(int newWidth, int newHeight) {
        Image newImage = imagePresenter.resizeImage(originalImage, (ImageIcon) imageLabel.getIcon(), newWidth, newHeight);

        imageLabel.setIcon(new ImageIcon(newImage));
    }

    public static void main(String[] args) {
        new ImageFrame().setVisible(true);
    }

}
