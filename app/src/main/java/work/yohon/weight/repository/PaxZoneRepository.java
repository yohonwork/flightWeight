package work.yohon.weight.repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import work.yohon.weight.repository.db.PaxZoneData;
import work.yohon.weight.repository.entity.PaxForPaxZone;

public class PaxZoneRepository implements Repository<PaxForPaxZone> {
    private LinkedList<PaxForPaxZone> repository;
    public PaxZoneRepository() {
        this.repository = PaxZoneData.repository;
    }

    @Override
    public PaxForPaxZone findByName(String name) {
        for(PaxForPaxZone row : repository) {
            if (row.getName().equals(name)) {
                return row;
            }
        }
        return null;
    }

    @Override
    public List<PaxForPaxZone> findAll() {
        PaxForPaxZone[] type = new PaxForPaxZone[repository.size()];
        return Arrays.asList(repository.toArray(type));
    }
}
