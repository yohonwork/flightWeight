package work.yohon.weight.repository.db;

import java.util.Arrays;
import java.util.LinkedList;

import work.yohon.weight.repository.entity.Point;

public class GraphData {
    public static LinkedList<Point> repository = new LinkedList<>(Arrays.asList(
            // A321 G TYPE
              new Point(1, 1, "A321", "MTOW", 33.0f, 45000f)
            , new Point(2, 1, "A321", "MTOW", 19.5f, 71000f)
            , new Point(3, 1, "A321", "MTOW", 33.0f, 84000f)
            , new Point(4, 1, "A321", "MTOW", 30.5f, 89000f)
            , new Point(5, 1, "A321", "MTOW", 91.2f, 89000f)
            , new Point(6, 1, "A321", "MTOW", 93.2f, 84200f)
            , new Point(7, 1, "A321", "MTOW", 43.0f, 45000f)

            , new Point(8, 1, "A321", "MLDW", 24.0f, 75500f)
            , new Point(9, 1, "A321", "MLDW", 82.0f, 75500f)

            , new Point(10, 1, "A321", "MZFW", 37.0f, 45000f)
            , new Point(11, 1, "A321", "MZFW", 27.2f, 65500f)
            , new Point(12, 1, "A321", "MZFW", 33.5f, 67900f)
            , new Point(13, 1, "A321", "MZFW", 22.0f, 69000f)

            , new Point(14, 1, "A321", "MZFW2", 22.0f, 69000f)
            , new Point(15, 1, "A321", "MZFW2", 19.5f, 71000f)
            , new Point(16, 1, "A321", "MZFW2", 34.0f, 70500f)
            , new Point(17, 1, "A321", "MZFW2", 35.5f, 71500f)
            , new Point(18, 1, "A321", "MZFW2", 89.0f, 71500f)
            , new Point(19, 1, "A321", "MZFW2", 71.2f, 45000f)
            , new Point(20, 1, "A321", "MZFW2", 37.0f, 45000f)

            // A321 K TYPE
            , new Point(21, 2, "A321", "MTOW", 33.0f, 45000f)
            , new Point(22, 2, "A321", "MTOW", 19.5f, 71000f)
            , new Point(23, 2, "A321", "MTOW", 33.0f, 84000f)
            , new Point(24, 2, "A321", "MTOW", 30.5f, 89000f)
            , new Point(25, 2, "A321", "MTOW", 91.2f, 89000f)
            , new Point(26, 2, "A321", "MTOW", 93.2f, 84200f)
            , new Point(27, 2, "A321", "MTOW", 43.0f, 45000f)

            , new Point(28, 2, "A321", "MLDW", 26.8f, 77300f)
            , new Point(29, 2, "A321", "MLDW", 84.0f, 77300f)

            , new Point(30, 2, "A321", "MZFW", 36.0f, 45000f)
            , new Point(31, 2, "A321", "MZFW", 27.0f, 63500f)
            , new Point(32, 2, "A321", "MZFW", 33.0f, 68900f)
            , new Point(33, 2, "A321", "MZFW", 20.5f, 70000f)

            , new Point(34, 2, "A321", "MZFW2", 19.5f, 71000f)
            , new Point(35, 2, "A321", "MZFW2", 21.3f, 72500f)
            , new Point(36, 2, "A321", "MZFW2", 34.5f, 71000f)
            , new Point(37, 2, "A321", "MZFW2", 36.0f, 73300f)
            , new Point(38, 2, "A321", "MZFW2", 90.0f, 73300f)
            , new Point(39, 2, "A321", "MZFW2", 71.2f, 45000f)
            , new Point(40, 2, "A321", "MZFW2", 33.0f, 45000f)
    ));
}