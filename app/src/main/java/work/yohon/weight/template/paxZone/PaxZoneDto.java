package work.yohon.weight.template.paxZone;

import java.util.List;

import work.yohon.weight.repository.entity.PaxForPaxZone;

public class PaxZoneDto {
    private Pax paxOA;
    private Pax paxOB;
    private Pax paxOC;
    private long ttl;

    public PaxZoneDto(List<PaxForPaxZone> paxForPaxZones, long weight) {
        paxForPaxZones.forEach((row)->{
            switch (row.getName()) {
                case "PAX OA" : {
                    this.paxOA = new Pax(0, weight, row.getWeightPoint());
                    break;
                }
                case "PAX OB" : {
                    this.paxOB = new Pax(0, weight, row.getWeightPoint());
                    break;
                }
                case "PAX OC" : {
                    this.paxOC = new Pax(0, weight, row.getWeightPoint());
                    break;
                }
            }
        });

        this.ttl   = this.paxOA.getCount().longValue()
                   + this.paxOB.getCount().longValue()
                   + this.paxOC.getCount().longValue()
                     ;
    }

    public Pax getPaxOA() {
        return this.paxOA;
    }
    public Pax getPaxOB() {
        return this.paxOB;
    }
    public Pax getPaxOC() {
        return this.paxOC;
    }
    public long getTtl() {
        return this.ttl;
    }

    public void setPaxOACount(long count) {
        this.paxOA.setCount(count);
        update();
    }

    public void setPaxOBCount(long count) {
        this.paxOB.setCount(count);
        update();
    }

    public void setPaxOCCount(long count) {
        this.paxOC.setCount(count);
        update();
    }

    private void update() {
        this.ttl = this.paxOA.getCount().longValue()
                 + this.paxOB.getCount().longValue()
                 + this.paxOC.getCount().longValue()
        ;
    }
}
