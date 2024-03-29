package work.yohon.weight.template.basic;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

import work.yohon.weight.common.Utils;

public class Basic {
    private final AppCompatActivity context;
    private final BasicDto dto;
    private final LinkedHashMap<String, EditText> editTexts;
    public Basic(AppCompatActivity context, BasicDto dto) {
        this.context   = context;
        this.dto       = dto;
        this.editTexts = new LinkedHashMap<>();
        this.editTexts.put("txtDow", (EditText) Utils.findViewId(this.context, "txtDow"));
        this.editTexts.put("txtIndex", (EditText) Utils.findViewId(this.context, "txtIndex"));
        this.editTexts.put("txtTakeOffFuel", (EditText) Utils.findViewId(this.context, "txtTakeOffFuel"));
        this.editTexts.put("txtTripFuel", (EditText) Utils.findViewId(this.context, "txtTripFuel"));
        this.editTexts.put("txtFuelIndex", (EditText) Utils.findViewId(this.context, "txtFuelIndex"));
        this.editTexts.put("txtLandingIndex", (EditText) Utils.findViewId(this.context, "txtLandingIndex"));
        this.editTexts.put("txtEstPayload", (EditText) Utils.findViewId(this.context, "txtEstPayload"));

        if (this.dto != null) {
            update();
            initEvent();
        }
    }

    private void update() {
        for (Map.Entry<String, EditText> entry : editTexts.entrySet()) {
            switch (entry.getKey()) {
                case "txtDow":
                    entry.getValue().setText(dto.getDow().toString());
                    break;
                case "txtIndex":
                    entry.getValue().setText(dto.getIndex().toString());
                    break;
                case "txtTakeOffFuel":
                    entry.getValue().setText(dto.getTakeOffFuel().toString());
                    break;
                case "txtTripFuel":
                    entry.getValue().setText(dto.getTripFuel().toString());
                    break;
                case "txtFuelIndex":
                    entry.getValue().setText(dto.getFuelIndex().toString());
                    break;
                case "txtLandingIndex":
                    entry.getValue().setText(dto.getLandingIndex().toString());
                    break;
                case "txtEstPayload":
                    entry.getValue().setText(dto.getEstPayload().toString());
                    break;
            }

        }
    }

    private void initEvent() {
        EditText txtDow         = this.editTexts.get("txtDow");
        txtDow.addTextChangedListener(new TextWatcher() {

            private BasicDto basicDto = Basic.this.dto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtDow.isFocusable() && !charSequence.toString().equals("")) {
                    double count = 0;
                    EditText txtAZFW          = (EditText) Utils.findViewId(Basic.this.context, "txtAZFW");
                    EditText txtTotalPaxTotal = (EditText) Utils.findViewId(Basic.this.context, "txtTotalPaxTotal");
                    EditText txtTtlDeadLoad   = (EditText) Utils.findViewId(Basic.this.context, "txtTtlDeadLoad");
                    try {
                        count = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.basicDto.setDow(count);
                    long totalPaxTotal = 0;
                    long ttlDeadLoad   = 0;
                    try {
                        totalPaxTotal = Long.parseLong(txtTotalPaxTotal.getText().toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        totalPaxTotal = 0;
                    }

                    try {
                        ttlDeadLoad = Long.parseLong(txtTtlDeadLoad.getText().toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        ttlDeadLoad = 0;
                    }

                    long azfw = (long)count + totalPaxTotal + ttlDeadLoad;
                    String strAZFW = String.valueOf(azfw);
                    txtAZFW.setText(strAZFW);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtIndex         = this.editTexts.get("txtIndex");
        txtIndex.addTextChangedListener(new TextWatcher() {

            private BasicDto basicDto = Basic.this.dto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtIndex.isFocusable() && !charSequence.toString().equals("")) {
                    double count = 0;
                    try {
                        count = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.basicDto.setIndex(count);

                    EditText txtIndex = (EditText) Utils.findViewId(Basic.this.context, "txtIndex");
                    EditText txtCargCpt1Deadload = (EditText) Utils.findViewId(Basic.this.context, "txtCargCpt1Deadload");
                    EditText txtCargCpt2Deadload = (EditText) Utils.findViewId(Basic.this.context, "txtCargCpt2Deadload");
                    EditText txtCargCpt3Deadload = (EditText) Utils.findViewId(Basic.this.context, "txtCargCpt3Deadload");
                    EditText txtCargCpt4Deadload = (EditText) Utils.findViewId(Basic.this.context, "txtCargCpt4Deadload");
                    EditText txtCargCpt5Deadload = (EditText) Utils.findViewId(Basic.this.context, "txtCargCpt5Deadload");
                    EditText txtPaxOATotal = (EditText) Utils.findViewId(Basic.this.context, "txtPaxOATotal");
                    EditText txtPaxOBTotal = (EditText) Utils.findViewId(Basic.this.context, "txtPaxOBTotal");
                    EditText txtPaxOCTotal = (EditText) Utils.findViewId(Basic.this.context, "txtPaxOCTotal");

                    EditText txtZfwIndex = (EditText) Utils.findViewId(Basic.this.context, "txtZfwIndex");

                    double index        = 0;
                    double cpt1Deadload = 0;
                    double cpt2Deadload = 0;
                    double cpt3Deadload = 0;
                    double cpt4Deadload = 0;
                    double cpt5Deadload = 0;
                    double paxOATotal   = 0;
                    double paxOBTotal   = 0;
                    double paxOCTotal   = 0;

                    try{
                        index = Double.parseDouble(txtIndex.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        index = 0;
                    }

                    try{
                        cpt1Deadload = Double.parseDouble(txtCargCpt1Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt1Deadload = 0;
                    }

                    try{
                        cpt2Deadload = Double.parseDouble(txtCargCpt2Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt2Deadload = 0;
                    }

                    try{
                        cpt3Deadload = Double.parseDouble(txtCargCpt3Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt3Deadload = 0;
                    }

                    try{
                        cpt4Deadload = Double.parseDouble(txtCargCpt4Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt4Deadload = 0;
                    }

                    try{
                        cpt5Deadload = Double.parseDouble(txtCargCpt5Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt5Deadload = 0;
                    }

                    try{
                        paxOATotal = Double.parseDouble(txtPaxOATotal.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        paxOATotal = 0;
                    }

                    try{
                        paxOBTotal = Double.parseDouble(txtPaxOBTotal.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        paxOBTotal = 0;
                    }

                    try{
                        paxOCTotal = Double.parseDouble(txtPaxOCTotal.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        paxOCTotal = 0;
                    }

                    double zfwIndex = index + cpt1Deadload + cpt2Deadload + cpt3Deadload + cpt4Deadload + cpt5Deadload +paxOATotal + paxOBTotal + paxOCTotal;
                    BigDecimal zfwIndexDecimal = BigDecimal.valueOf(zfwIndex).setScale(1, RoundingMode.CEILING);
                    txtZfwIndex.setText(zfwIndexDecimal.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtTakeOffFuel         = this.editTexts.get("txtTakeOffFuel");
        txtTakeOffFuel.addTextChangedListener(new TextWatcher() {

            private BasicDto basicDto = Basic.this.dto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtTakeOffFuel.isFocusable() && !charSequence.toString().equals("")) {
                    double count = 0;
                    EditText txtAZFW = (EditText) Utils.findViewId(Basic.this.context, "txtAZFW");
                    EditText txtATOW = (EditText) Utils.findViewId(Basic.this.context, "txtATOW");
                    try {
                        count = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.basicDto.setTakeOffFuel(count);

                    long azfw = 0;
                    try {
                        azfw = Long.parseLong(txtAZFW.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        azfw = 0;
                    }

                    long atow = (long) count + azfw;
                    String strATOW = String.valueOf(atow);
                    txtATOW.setText(strATOW);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtTripFuel         = this.editTexts.get("txtTripFuel");
        txtTripFuel.addTextChangedListener(new TextWatcher() {

            private BasicDto basicDto = Basic.this.dto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtTripFuel.isFocusable() && !charSequence.toString().equals("")) {
                    double tripFuel = 0;
                    EditText txtATOW = (EditText) Utils.findViewId(Basic.this.context, "txtATOW");
                    EditText txtALDW = (EditText) Utils.findViewId(Basic.this.context, "txtALDW");
                    try {
                        tripFuel = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.basicDto.setTripFuel(tripFuel);
                    long atow      = 0;
                    try {
                        atow = Long.parseLong(txtATOW.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        atow = 0;
                    }

                    long aldw      = atow - (long)tripFuel;
                    String strALDW = String.valueOf(aldw);
                    txtALDW.setText(strALDW);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtFuelIndex         = this.editTexts.get("txtFuelIndex");
        txtTripFuel.addTextChangedListener(new TextWatcher() {

            private BasicDto basicDto = Basic.this.dto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtFuelIndex.isFocusable() && !charSequence.toString().equals("")) {
                    double count = 0;
                    try {
                        count = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.basicDto.setFuelIndex(count);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtLandingIndex         = this.editTexts.get("txtLandingIndex");
        txtLandingIndex.addTextChangedListener(new TextWatcher() {

            private BasicDto basicDto = Basic.this.dto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtLandingIndex.isFocusable() && !charSequence.toString().equals("")) {
                    double count = 0;
                    try {
                        count = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.basicDto.setLandingIndex(count);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtEstPayload         = this.editTexts.get("txtEstPayload");
        txtEstPayload.addTextChangedListener(new TextWatcher() {

            private BasicDto basicDto = Basic.this.dto;
            private String preText;
            private double preValue;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText  = charSequence.toString();
                if (!preText.isEmpty()) {
                    preValue = Double.parseDouble(preText);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtEstPayload.isFocusable() && !charSequence.toString().equals("")) {
                    double count = 0;
                    EditText txtUnderLoad = (EditText) Utils.findViewId(Basic.this.context, "txtUnderLoad");
                    try {
                        count = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.basicDto.setEstPayload(count);
                    double underLoad       = Double.parseDouble(txtUnderLoad.getText().toString());
                    double estPayloadSub   = count - preValue;
                    long updateUnderload = (long)(underLoad + estPayloadSub);
                    String strUpdateUnderload = String.valueOf(updateUnderload);
                    txtUnderLoad.setText(strUpdateUnderload);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
