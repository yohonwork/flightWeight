package work.yohon.weight.template.paxZone;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;
import java.util.Map;

import work.yohon.weight.common.Utils;
import work.yohon.weight.repository.PaxZoneRepository;
import work.yohon.weight.repository.entity.Type;
import work.yohon.weight.template.passenger.PassengerDto;

public class PaxZone {
    private final AppCompatActivity context;
    private final PaxZoneDto paxZoneDto;
    private LinkedHashMap<String, EditText> editTexts = new LinkedHashMap<>();
    private final PaxZoneRepository repository;

    public PaxZone(AppCompatActivity context, Type type, PassengerDto passengerDto) {
        this.context    = context;
        this.repository = new PaxZoneRepository();
        this.paxZoneDto = new PaxZoneDto(repository.findAll(), passengerDto.getPassengerAdult().getWeight());

        this.editTexts.put("txtPaxOACount", (EditText) Utils.findViewId(this.context, "txtPaxOACount"));
        this.editTexts.put("txtPaxOAMultiplyAdultWeight", (EditText) Utils.findViewId(this.context, "txtPaxOAMultiplyAdultWeight"));
        this.editTexts.put("txtPaxOAWeightPoint", (EditText) Utils.findViewId(this.context, "txtPaxOAWeightPoint"));
        this.editTexts.put("txtPaxOATotal", (EditText) Utils.findViewId(this.context, "txtPaxOATotal"));

        this.editTexts.put("txtPaxOBCount", (EditText) Utils.findViewId(this.context, "txtPaxOBCount"));
        this.editTexts.put("txtPaxOBMultiplyAdultWeight", (EditText) Utils.findViewId(this.context, "txtPaxOBMultiplyAdultWeight"));
        this.editTexts.put("txtPaxOBWeightPoint", (EditText) Utils.findViewId(this.context, "txtPaxOBWeightPoint"));
        this.editTexts.put("txtPaxOBTotal", (EditText) Utils.findViewId(this.context, "txtPaxOBTotal"));

        this.editTexts.put("txtPaxOCCount", (EditText) Utils.findViewId(this.context, "txtPaxOCCount"));
        this.editTexts.put("txtPaxOCMultiplyAdultWeight", (EditText) Utils.findViewId(this.context, "txtPaxOCMultiplyAdultWeight"));
        this.editTexts.put("txtPaxOCWeightPoint", (EditText) Utils.findViewId(this.context, "txtPaxOCWeightPoint"));
        this.editTexts.put("txtPaxOCTotal", (EditText) Utils.findViewId(this.context, "txtPaxOCTotal"));

        this.editTexts.put("txtPaxTtlCount", (EditText) Utils.findViewId(this.context, "txtPaxTtlCount"));

        if (this.paxZoneDto != null) {
            initEvent();
            update();
        }
    }

    private void update() {
        for (Map.Entry<String, EditText> entry : editTexts.entrySet()) {
            switch (entry.getKey()) {
                case "txtPaxOACount":
                    entry.getValue().setText(String.valueOf(0));
                    break;
                case "txtPaxOAMultiplyAdultWeight":
                    entry.getValue().setText(String.valueOf(0));
                    break;
                case "txtPaxOAWeightPoint":
                    entry.getValue().setText(String.valueOf(paxZoneDto.getPaxOA().getCorrectionValue()));
                    break;
                case "txtPaxOATotal":
                    entry.getValue().setText(String.valueOf(0));
                    break;
                case "txtPaxOBCount":
                    entry.getValue().setText(String.valueOf(0));
                    break;
                case "txtPaxOBMultiplyAdultWeight":
                    entry.getValue().setText(String.valueOf(0));
                    break;
                case "txtPaxOBWeightPoint":
                    entry.getValue().setText(String.valueOf(paxZoneDto.getPaxOB().getCorrectionValue()));
                    break;
                case "txtPaxOBTotal":
                    entry.getValue().setText(String.valueOf(0));
                    break;
                case "txtPaxOCCount":
                    entry.getValue().setText(String.valueOf(0));
                    break;
                case "txtPaxOCMultiplyAdultWeight":
                    entry.getValue().setText(String.valueOf(0));
                    break;
                case "txtPaxOCWeightPoint":
                    entry.getValue().setText(String.valueOf(paxZoneDto.getPaxOC().getCorrectionValue()));
                    break;
                case "txtPaxOCTotal":
                    entry.getValue().setText(String.valueOf(0));
                    break;
                case "txtPaxTtlCount":
                    entry.getValue().setText(String.valueOf(0));
                    break;
            }
        }
    }

    private void initEvent() {

        EditText txtPaxTtlCount              = this.editTexts.get("txtPaxTtlCount");
        EditText txtPaxOACount               = this.editTexts.get("txtPaxOACount");
        EditText txtPaxOAMultiplyAdultWeight = this.editTexts.get("txtPaxOAMultiplyAdultWeight");
        EditText txtPaxOATotal               = this.editTexts.get("txtPaxOATotal");
        txtPaxOACount.addTextChangedListener(new TextWatcher() {

            private PaxZoneDto paxZoneDto = PaxZone.this.paxZoneDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtPaxOACount.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.paxZoneDto.setPaxOACount(count);
                    txtPaxOAMultiplyAdultWeight.setText(this.paxZoneDto.getPaxOA().getWeightForParts().toString());
                    txtPaxOATotal.setText(this.paxZoneDto.getPaxOA().getValue().toString());
                    txtPaxTtlCount.setText(String.valueOf(this.paxZoneDto.getTtl()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtPaxOBCount               = this.editTexts.get("txtPaxOBCount");
        EditText txtPaxOBMultiplyAdultWeight = this.editTexts.get("txtPaxOBMultiplyAdultWeight");
        EditText txtPaxOBTotal               = this.editTexts.get("txtPaxOBTotal");
        txtPaxOBCount.addTextChangedListener(new TextWatcher() {

            private PaxZoneDto paxZoneDto = PaxZone.this.paxZoneDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtPaxOBCount.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.paxZoneDto.setPaxOBCount(count);
                    txtPaxOBMultiplyAdultWeight.setText(this.paxZoneDto.getPaxOB().getWeightForParts().toString());
                    txtPaxOBTotal.setText(this.paxZoneDto.getPaxOB().getValue().toString());
                    txtPaxTtlCount.setText(String.valueOf(this.paxZoneDto.getTtl()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtPaxOCCount               = this.editTexts.get("txtPaxOCCount");
        EditText txtPaxOCMultiplyAdultWeight = this.editTexts.get("txtPaxOCMultiplyAdultWeight");
        EditText txtPaxOCTotal               = this.editTexts.get("txtPaxOCTotal");
        txtPaxOCCount.addTextChangedListener(new TextWatcher() {

            private PaxZoneDto paxZoneDto = PaxZone.this.paxZoneDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtPaxOCCount.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.paxZoneDto.setPaxOCCount(count);
                    txtPaxOCMultiplyAdultWeight.setText(this.paxZoneDto.getPaxOC().getWeightForParts().toString());
                    txtPaxOCTotal.setText(this.paxZoneDto.getPaxOC().getValue().toString());
                    txtPaxTtlCount.setText(String.valueOf(this.paxZoneDto.getTtl()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
