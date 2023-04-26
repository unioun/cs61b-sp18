import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class NBody {
    private String backgroundPicture = "images/starfield.jpg";
    private Planet[] planets;
    private double radius;

    public NBody(String backgroundPicture) {
        this.backgroundPicture = backgroundPicture;
    }

    public NBody() {
    }

    public static double readRadius(String filePath) {
        File path = new File(filePath);
        if (path.isFile() == false) {
            return -1;
        } else {
            try {
                BufferedReader file = new BufferedReader(new FileReader(filePath));
                file.readLine();
                String radius = file.readLine();
                radius = radius.replaceAll("\n", "").replaceAll("\r", "");
                file.close();
                return Double.parseDouble(radius);
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }
        }
    }

    private static String[] readFile(String filePath) {
        /**
         * 读取filePath的文件，将文件中的数据按照行读取到String数组中
         *
         * @param filePath 文件的路径
         * @return 文件中一行一行的数据,不包括前两行radius和plantes number
         */
        String[] lines = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath,
                    StandardCharsets.UTF_8));
            String tempString = null;
            int index = 0;
            lines = new String[Integer.parseInt(reader.readLine())];
            reader.readLine();
            while (index < lines.length) {
                tempString = reader.readLine();
                tempString = tempString.trim();
                lines[index] = tempString.replaceAll("\n", "").replaceAll("\r", "");
                index++;
            }
            reader.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (EOFException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return lines;
    }

    public static Planet[] readPlanets(String path) {
        String[] lines = readFile(path);
        Planet[] Planets = new Planet[lines.length];
        int index = 0;
        Planet temp = null;
        Double xP;
        Double yP;
        Double xV;
        Double yV;
        Double ma;
        String img;
        for (String line : lines) {
            String[] data = line.split("\\s+");
            xP = Double.parseDouble(data[0]);
            yP = Double.parseDouble(data[1]);
            xV = Double.parseDouble(data[2]);
            yV = Double.parseDouble(data[3]);
            ma = Double.parseDouble(data[4]);
            img = data[5];
            temp = new Planet(xP, yP, xV, yV, ma, img);
            Planets[index] = temp;
            index++;
        }
        return Planets;
    }

    private double[] xForceArray(Planet[] planets) {
        double[] xForceArray = new double[planets.length];
        for (int i = 0; i < xForceArray.length; i++) {
            xForceArray[i] = planets[i].calcNetForceExertedByX(planets);
        }
        return xForceArray;
    }

    private double[] yForceArray(Planet[] planets) {
        double[] yForceArray = new double[planets.length];
        for (int i = 0; i < yForceArray.length; i++) {
            yForceArray[i] = planets[i].calcNetForceExertedByY(planets);
        }
        return yForceArray;
    }

    private void updateAll(Planet[] planets, double dt) {
        double[] xForceArray = xForceArray(planets);
        double[] yForceArray = yForceArray(planets);
        for (int i = 0; i < planets.length; i++) {
            planets[i].update(dt, xForceArray[i], yForceArray[i]);
        }
    }

    private void init(String dataFile) {
        planets = readPlanets(dataFile);
        radius = readRadius(dataFile);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(radius, -radius);
    }

    private void printUniverseInfo() {
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

    public void drawPlanets() {
        String images = "images/";
        for (Planet p : planets) {
            StdDraw.picture(p.xxPos, p.yyPos, images + p.imgFileName);
        }
        StdDraw.show();
        StdDraw.pause(10);
    }

    private void runUniverse(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dT = Double.parseDouble(args[1]);
        String dataFile = args[2];
        init(dataFile);
        for (int i = 0; i < T; i += dT) {
            updateAll(planets, dT);
            StdDraw.picture(0, 0, backgroundPicture);
            drawPlanets();
            StdDraw.clear();
        }
        printUniverseInfo();
    }

    public static void main(String[] args) {
        NBody body = new NBody();
        body.runUniverse(args);
    }
}
