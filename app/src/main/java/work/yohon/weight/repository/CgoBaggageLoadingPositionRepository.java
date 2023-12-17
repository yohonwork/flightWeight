package work.yohon.weight.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import work.yohon.weight.repository.db.CargoBaggageLoadingPositionData;
import work.yohon.weight.repository.entity.CargoCpt;

public class CgoBaggageLoadingPositionRepository implements Repository<CargoCpt> {
    private LinkedList<CargoCpt> repository;
    public CgoBaggageLoadingPositionRepository() {
        this.repository = CargoBaggageLoadingPositionData.repository;
    }

    @Override
    public CargoCpt findByName(String name) {
        for(CargoCpt row : repository) {
            if (row.getName().equals(name)) {
                return row;
            }
        }
        return null;
    }

    @Override
    public List<CargoCpt> findAll() {
        CargoCpt[] cargoCpt = new CargoCpt[repository.size()];
        return Arrays.asList(repository.toArray(cargoCpt));
    }

    public List<CargoCpt> findByTypeSeq(long typeSeq) {
        List<CargoCpt> retValue = new ArrayList<>();
        for(CargoCpt row : repository) {
            if (row.getTypeSeq() == typeSeq) {
                retValue.add(row);
            }
        }
        return retValue;
    }
}
