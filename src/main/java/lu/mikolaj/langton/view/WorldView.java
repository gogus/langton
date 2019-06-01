package lu.mikolaj.langton.view;

import lu.mikolaj.langton.domain.Cell;
import lu.mikolaj.langton.domain.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class WorldView {
    private World world;

    public WorldView(World world) {
        this.world = world;
    }

    public File render() throws IOException {
        int maxX = 0;
        int maxY = 0;

        for (Cell cell: this.world.getBlackCells()) {
            int absX = Math.abs(cell.getCoordinateX());
            int absY = Math.abs(cell.getCoordinateY());

            if (maxX < absX) {
                maxX = absX;
            }

            if (maxY < absY) {
                maxY = absY;
            }
        }

        int imageWidth = Math.max(maxX, 100);
        int imageHeight = Math.max(maxY, 100);

        int centerX = imageWidth / 2;
        int centerY = imageHeight / 2;

        final BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0,0, imageWidth, imageHeight);
        graphics2D.setPaint( Color.BLACK);

        for (Cell cell: this.world.getBlackCells()) {
            if (cell.getColor().equals(lu.mikolaj.langton.domain.Color.BLACK)) {
                graphics2D.drawLine(
                    centerX + cell.getCoordinateX(),
                    centerY + cell.getCoordinateY(),
                    centerX + cell.getCoordinateX(),
                    centerY + cell.getCoordinateY()
                );
            }
        }

        graphics2D.dispose();
        String pathName = System.getProperty("java.io.tmpdir") + "/" + UUID.randomUUID().toString() + ".png";

        ImageIO.write(image, "png", new File(pathName));

        return new File(pathName);
    }
}
