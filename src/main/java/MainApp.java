
import com.mycompany.oguz_turkaslan.Map;
import com.mycompany.oguz_turkaslan.ZoneCounter;
import interfaces.Dimension;
import interfaces.MapInterface;
import interfaces.ZoneCounterInterface;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oguz_
 */
public class MainApp {

    public static void readFile(MapInterface map, int width, int height) throws FileNotFoundException, Exception {
        boolean[][] zoneArray = new boolean[width][height];
        Scanner sc = new Scanner(chooseFile());
        while (sc.hasNextLine()) {
            for (int i = 0; i < zoneArray.length; i++) {
                String[] line = sc.nextLine().trim().split(",");
                for (int j = 0; j < line.length; j++) {
                    if (Integer.parseInt(line[j]) == 1) {
                        map.SetBorder(i, j);
                    } else {
                        map.ClearBorder(i, j);
                    }

                }
            }
        }
    }

    public static File chooseFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Choose File");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        File[] file = dialog.getFiles();
        return file[0];
    }

    public static void main(String[] args) throws Exception {
        MapInterface map = new Map();
        Dimension dim = new Dimension(24, 36);
        map.SetSize(dim);
        readFile(map, dim.width, dim.height);
        map.Show();

        ZoneCounterInterface zone = new ZoneCounter(dim);
        zone.Init(map);
        System.out.println(zone.Solve());
    }
}
