package work.yohon.weight.repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import work.yohon.weight.repository.db.GraphData;
import work.yohon.weight.repository.entity.Point;

public class PointRepository implements Repository<Point> {
    private LinkedList<Point> repository;
    public PointRepository() {
        this.repository = GraphData.repository;
    }

    @Override
    public Point findByName(String name) {
        for(Point row : repository) {
            if (row.getName().equals(name)) {
                return row;
            }
        }
        return null;
    }

    @Override
    public List<Point> findAll() {
        Point[] point = new Point[repository.size()];
        return Arrays.asList(repository.toArray(point));
    }

    public List<Point> findByTypeSeqAndAircraft(long typeSeq, String aircraft) {
        List<Point> points = findAll();
        return points.stream().filter(point -> {
            if (point.getTypeSeq() == typeSeq && point.getAircraft().equals(aircraft)) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
    }
}
