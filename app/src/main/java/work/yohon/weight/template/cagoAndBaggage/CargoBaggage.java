package work.yohon.weight.template.cagoAndBaggage;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;
import java.util.Map;

import work.yohon.weight.common.Utils;
import work.yohon.weight.template.basic.BasicDto;
import work.yohon.weight.template.passenger.PassengerDto;

public class CargoBaggage {
    private AppCompatActivity context;
    private CargoBaggageDto cargoBaggageDto;
    private final BasicDto basicDto;
    private final PassengerDto passengerDto;
    private LinkedHashMap<String, EditText> editTexts = new LinkedHashMap<>();
    public CargoBaggage(AppCompatActivity context, BasicDto basicDto, PassengerDto passengerDto) {
        this.context         = context;
        Baggage baggage      = new Baggage(0,0);
        Cargo cargo          = new Cargo(0, 0);
        Comail comail        = new Comail(0,0);
        this.basicDto        = basicDto;
        this.passengerDto    = passengerDto;
        this.cargoBaggageDto = new CargoBaggageDto(baggage, cargo, comail, this.basicDto, this.passengerDto);
        this.editTexts.put("txtBagCount", (EditText) Utils.findViewId(this.context, "txtBagCount"));
        this.editTexts.put("txtBagWeight", (EditText) Utils.findViewId(this.context, "txtBagWeight"));
        this.editTexts.put("txtBagWeightTotal", (EditText) Utils.findViewId(this.context, "txtBagWeightTotal"));
        this.editTexts.put("txtCargoCount", (EditText) Utils.findViewId(this.context, "txtCargoCount"));
        this.editTexts.put("txtCargoWeight", (EditText) Utils.findViewId(this.context, "txtCargoWeight"));
        this.editTexts.put("txtCargoWeightTotal", (EditText) Utils.findViewId(this.context, "txtCargoWeightTotal"));
        this.editTexts.put("txtComailCount", (EditText) Utils.findViewId(this.context, "txtComailCount"));
        this.editTexts.put("txtComailWeight", (EditText) Utils.findViewId(this.context, "txtComailWeight"));
        this.editTexts.put("txtComailWeightTotal", (EditText) Utils.findViewId(this.context, "txtComailWeightTotal"));
        this.editTexts.put("txtTtlDeadLoad", (EditText) Utils.findViewId(this.context, "txtTtlDeadLoad"));
        this.editTexts.put("txtTtlPayload", (EditText) Utils.findViewId(this.context, "txtTtlPayload"));
        this.editTexts.put("txtUnderLoad", (EditText) Utils.findViewId(this.context, "txtUnderLoad"));

        if (this.cargoBaggageDto != null) {
            update();
            initEvent();
        }

    }

    private void update() {
        for(Map.Entry<String, EditText> entry : editTexts.entrySet()) {
            switch (entry.getKey()) {
                case "txtBagCount": {
                    long count = cargoBaggageDto.getBaggage().getCount();
                    entry.getValue().setText(String.valueOf(count));
                }
                break;
                case "txtBagWeight": {
                    long weight = cargoBaggageDto.getBaggage().getWeight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtBagWeightTotal": {
                    long weight = cargoBaggageDto.getBaggage().getTotalWeight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtCargoCount": {
                    long count = cargoBaggageDto.getCargo().getCount();
                    entry.getValue().setText(String.valueOf(count));
                }
                break;
                case "txtCargoWeight": {
                    long weight = cargoBaggageDto.getCargo().getWeight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtCargoWeightTotal": {
                    long weight = cargoBaggageDto.getCargo().getTotalWeight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtComailCount": {
                    long count = cargoBaggageDto.getComail().getCount();
                    entry.getValue().setText(String.valueOf(count));
                }
                break;
                case "txtComailWeight": {
                    long weight = cargoBaggageDto.getComail().getWeight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtComailWeightTotal": {
                    long weight = cargoBaggageDto.getComail().getTotalWeight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtTtlDeadLoad": {
                    long ttlDeadLoad = cargoBaggageDto.getBaggage().getWeight() + cargoBaggageDto.getCargo().getWeight() + cargoBaggageDto.getComail().getWeight();
                    entry.getValue().setText(String.valueOf(ttlDeadLoad));
                }
                break;
                case "txtTtlPayload": {
                    long ttlDeadLoad = cargoBaggageDto.getTtlPayload();
                    entry.getValue().setText(String.valueOf(ttlDeadLoad));
                }
                break;
                case "txtUnderLoad": {
                    long ttlDeadLoad = cargoBaggageDto.getUnderLoad();
                    entry.getValue().setText(String.valueOf(ttlDeadLoad));
                }
                break;
            }
        }
    }

    public CargoBaggageDto getCargoBaggageDto() {
        return this.cargoBaggageDto;
    }

    private void initEvent() {
        EditText txtTtlDeadLoad = this.editTexts.get("txtTtlDeadLoad");
        EditText txtTtlPayload  = this.editTexts.get("txtTtlPayload");
        EditText txtUnderLoad   = this.editTexts.get("txtUnderLoad");

        EditText txtBagCount         = this.editTexts.get("txtBagCount");
        txtBagCount.addTextChangedListener(new TextWatcher() {

            private CargoBaggageDto cargoBaggageDto = CargoBaggage.this.cargoBaggageDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtBagCount.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cargoBaggageDto.setBaggageCounts(count);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtBagWeight      = this.editTexts.get("txtBagWeight");
        EditText txtBagWeightTotal = this.editTexts.get("txtBagWeightTotal");
        txtBagWeight.addTextChangedListener(new TextWatcher() {

            private CargoBaggageDto cargoBaggageDto = CargoBaggage.this.cargoBaggageDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtBagWeight.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cargoBaggageDto.setBaggageWeight(count);
                    String totalWeight = String.valueOf(this.cargoBaggageDto.getBaggageTotalWeight());
                    txtBagWeightTotal.setText(totalWeight);
                    String strTtlDeadLoad = String.valueOf(this.cargoBaggageDto.getTtlDeadLoad());
                    txtTtlDeadLoad.setText(strTtlDeadLoad);
                    String strTtlPayload = String.valueOf(this.cargoBaggageDto.getTtlPayload());
                    txtTtlPayload.setText(strTtlPayload);
                    String strUnderload = String.valueOf(this.cargoBaggageDto.getUnderLoad());
                    txtUnderLoad.setText(strUnderload);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtCargoCount         = this.editTexts.get("txtCargoCount");
        txtCargoCount.addTextChangedListener(new TextWatcher() {

            private CargoBaggageDto cargoBaggageDto = CargoBaggage.this.cargoBaggageDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtCargoCount.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cargoBaggageDto.setCargoCounts(count);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtCargoWeight      = this.editTexts.get("txtCargoWeight");
        EditText txtCargoWeightTotal = this.editTexts.get("txtCargoWeightTotal");
        txtCargoWeight.addTextChangedListener(new TextWatcher() {

            private CargoBaggageDto cargoBaggageDto = CargoBaggage.this.cargoBaggageDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtCargoWeight.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cargoBaggageDto.setCargoWeight(count);
                    String totalWeight = String.valueOf(this.cargoBaggageDto.getCargoTotalWeight());
                    txtCargoWeightTotal.setText(totalWeight);
                    String strTtlDeadLoad = String.valueOf(this.cargoBaggageDto.getTtlDeadLoad());
                    txtTtlDeadLoad.setText(strTtlDeadLoad);
                    String strTtlPayload = String.valueOf(this.cargoBaggageDto.getTtlPayload());
                    txtTtlPayload.setText(strTtlPayload);
                    String strUnderload = String.valueOf(this.cargoBaggageDto.getUnderLoad());
                    txtUnderLoad.setText(strUnderload);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtComailCount         = this.editTexts.get("txtComailCount");
        txtComailCount.addTextChangedListener(new TextWatcher() {

            private CargoBaggageDto cargoBaggageDto = CargoBaggage.this.cargoBaggageDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtComailCount.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cargoBaggageDto.setComailCounts(count);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtComailWeight      = this.editTexts.get("txtComailWeight");
        EditText txtComailWeightTotal = this.editTexts.get("txtComailWeightTotal");
        txtComailWeight.addTextChangedListener(new TextWatcher() {

            private CargoBaggageDto cargoBaggageDto = CargoBaggage.this.cargoBaggageDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtComailWeight.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cargoBaggageDto.setComailWeight(count);
                    String totalWeight = String.valueOf(this.cargoBaggageDto.getComailTotalWeight());
                    txtComailWeightTotal.setText(totalWeight);
                    String strTtlDeadLoad = String.valueOf(this.cargoBaggageDto.getTtlDeadLoad());
                    txtTtlDeadLoad.setText(strTtlDeadLoad);
                    String strTtlPayload = String.valueOf(this.cargoBaggageDto.getTtlPayload());
                    txtTtlPayload.setText(strTtlPayload);
                    String strUnderload = String.valueOf(this.cargoBaggageDto.getUnderLoad());
                    txtUnderLoad.setText(strUnderload);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        txtTtlDeadLoad.addTextChangedListener(new TextWatcher() {

            private CargoBaggageDto cargoBaggageDto = CargoBaggage.this.cargoBaggageDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals("")) {
                    long totalPax = 0;
                    EditText txtAZFW          = (EditText) Utils.findViewId(CargoBaggage.this.context, "txtAZFW");
                    EditText txtTotalPaxTotal = (EditText) Utils.findViewId(CargoBaggage.this.context, "txtTotalPaxTotal");
                    EditText txtDow           = (EditText) Utils.findViewId(CargoBaggage.this.context, "txtDow");
//                    EditText txtTtlDeadLoad   = (EditText) Utils.findViewId(CargoBaggage.this.context, "txtTtlDeadLoad");
                    try {
                        totalPax = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }
                    long dow = 0;
                    long totalPaxTotal   = 0;
                    try {
                        dow = Long.parseLong(txtDow.getText().toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        dow = 0;
                    }

                    try {
                        totalPaxTotal = Long.parseLong(txtTotalPaxTotal.getText().toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        totalPaxTotal = 0;
                    }

                    long azfw = (long)totalPax + dow + totalPaxTotal;
                    String strAZFW = String.valueOf(azfw);
                    txtAZFW.setText(strAZFW);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
