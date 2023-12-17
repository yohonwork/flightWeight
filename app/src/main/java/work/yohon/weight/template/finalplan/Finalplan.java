package work.yohon.weight.template.finalplan;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

import work.yohon.weight.common.Utils;

public class Finalplan {
    private final AppCompatActivity context;
    private BigDecimal azfw;
    private BigDecimal atow;
    private BigDecimal aldw;
    private BigDecimal zfwIndex;
    private BigDecimal towIndex;
    private BigDecimal ldwIndex;
    private BigDecimal macZfcPercentage;
    private BigDecimal macTowPercentage;
    private final LinkedHashMap<String, EditText> editTexts = new LinkedHashMap<>();

    public Finalplan(AppCompatActivity context) {
        this.context          = context;
        this.editTexts.put("txtAZFW", (EditText) Utils.findViewId(this.context, "txtAZFW"));
        this.editTexts.put("txtATOW", (EditText) Utils.findViewId(this.context, "txtATOW"));
        this.editTexts.put("txtALDW", (EditText) Utils.findViewId(this.context, "txtALDW"));
        this.editTexts.put("txtZfwIndex", (EditText) Utils.findViewId(this.context, "txtZfwIndex"));
        this.editTexts.put("txtTowIndex", (EditText) Utils.findViewId(this.context, "txtTowIndex"));
        this.editTexts.put("txtLdWIndex", (EditText) Utils.findViewId(this.context, "txtLdWIndex"));
        this.editTexts.put("txtMacZfw", (EditText) Utils.findViewId(this.context, "txtMacZfw"));
        this.editTexts.put("txtMacTow", (EditText) Utils.findViewId(this.context, "txtMacTow"));
        initEvent();
    }

    private void initEvent() {
        EditText txtAZFW     = this.editTexts.get("txtAZFW");
        EditText txtATOW     = this.editTexts.get("txtATOW");
        EditText txtALDW     =  this.editTexts.get("txtALDW");
        EditText txtZfwIndex = this.editTexts.get("txtZfwIndex");
        EditText txtTowIndex = this.editTexts.get("txtTowIndex");
        EditText txtLdWIndex = this.editTexts.get("txtLdWIndex");

        txtAZFW.addTextChangedListener(new TextWatcher() {

            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals("")) {
                    long count = 0;
                    EditText txtTakeOffFuel = (EditText) Utils.findViewId(Finalplan.this.context, "txtTakeOffFuel");
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    Finalplan.this.azfw = BigDecimal.valueOf(count);
                    long takeOffFuel = 0;
                    try {
                        takeOffFuel = Long.parseLong(txtTakeOffFuel.getText().toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        takeOffFuel = 0;
                    }
                    long atow = Finalplan.this.azfw.longValue() + takeOffFuel;
                    String strATOW = String.valueOf(atow);
                    txtATOW.setText(strATOW);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        txtATOW.addTextChangedListener(new TextWatcher() {

            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals("")) {
                    long count = 0;
                    EditText txtTripFuel = (EditText) Utils.findViewId(Finalplan.this.context, "txtTripFuel");
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    Finalplan.this.atow = BigDecimal.valueOf(count);
                    long tripFuel = 0;
                    try {
                        tripFuel = Long.parseLong(txtTripFuel.getText().toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        tripFuel = 0;
                    }
                    long aldw = Finalplan.this.atow.longValue() - tripFuel;
                    String strALDW = String.valueOf(aldw);
                    txtALDW.setText(strALDW);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        txtZfwIndex.addTextChangedListener(new TextWatcher() {
            private String preText;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals("")) {
                    EditText txtCargCpt1Deadload = (EditText) Utils.findViewId(Finalplan.this.context, "txtCargCpt1Deadload");
                    EditText txtCargCpt2Deadload = (EditText) Utils.findViewId(Finalplan.this.context, "txtCargCpt2Deadload");
                    EditText txtCargCpt3Deadload = (EditText) Utils.findViewId(Finalplan.this.context, "txtCargCpt3Deadload");
                    EditText txtCargCpt4Deadload = (EditText) Utils.findViewId(Finalplan.this.context, "txtCargCpt4Deadload");
                    EditText txtCargCpt5Deadload = (EditText) Utils.findViewId(Finalplan.this.context, "txtCargCpt5Deadload");
                    EditText txtPaxOATotal = (EditText) Utils.findViewId(Finalplan.this.context, "txtPaxOATotal");
                    EditText txtPaxOBTotal = (EditText) Utils.findViewId(Finalplan.this.context, "txtPaxOBTotal");
                    EditText txtPaxOCTotal = (EditText) Utils.findViewId(Finalplan.this.context, "txtPaxOCTotal");

                    EditText txtFuelIndex = (EditText) Utils.findViewId(Finalplan.this.context, "txtFuelIndex");

                    double cpt1Deadload = 0;
                    double cpt2Deadload = 0;
                    double cpt3Deadload = 0;
                    double cpt4Deadload = 0;
                    double cpt5Deadload = 0;
                    double paxOATotal   = 0;
                    double paxOBTotal   = 0;
                    double paxOCTotal   = 0;

                    try{
                        cpt1Deadload = Long.parseLong(txtCargCpt1Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt1Deadload = 0;
                    }

                    try{
                        cpt2Deadload = Long.parseLong(txtCargCpt2Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt2Deadload = 0;
                    }

                    try{
                        cpt3Deadload = Long.parseLong(txtCargCpt3Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt3Deadload = 0;
                    }

                    try{
                        cpt4Deadload = Long.parseLong(txtCargCpt4Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt4Deadload = 0;
                    }

                    try{
                        cpt5Deadload = Long.parseLong(txtCargCpt5Deadload.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        cpt5Deadload = 0;
                    }

                    try{
                        paxOATotal = Long.parseLong(txtPaxOATotal.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        paxOATotal = 0;
                    }

                    try{
                        paxOBTotal = Long.parseLong(txtPaxOBTotal.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        paxOBTotal = 0;
                    }

                    try{
                        paxOCTotal = Long.parseLong(txtPaxOCTotal.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        paxOCTotal = 0;
                    }

                    double zfwIndex = cpt1Deadload + cpt2Deadload + cpt3Deadload + cpt4Deadload + cpt5Deadload +paxOATotal +paxOBTotal + paxOCTotal;
                    Finalplan.this.zfwIndex = BigDecimal.valueOf(zfwIndex);

                    double fuelIndex = 0;
                    try{
                        fuelIndex = Long.parseLong(txtFuelIndex.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        fuelIndex = 0;
                    }

                    Finalplan.this.towIndex = Finalplan.this.zfwIndex.subtract(BigDecimal.valueOf(fuelIndex)).setScale(1, RoundingMode.CEILING);
                    txtTowIndex.setText(Finalplan.this.towIndex.toString());

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtTowIndex.addTextChangedListener(new TextWatcher() {
            private String preText;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals("")) {

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
