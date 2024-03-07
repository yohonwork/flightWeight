package work.yohon.weight.template.finalplan;

import static work.yohon.weight.common.Utils.isNull;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

import work.yohon.weight.common.Utils;
import work.yohon.weight.repository.entity.Type;
import work.yohon.weight.template.graph.Graph;

public class Finalplan {
    private final AppCompatActivity context;
    private Type type;
    private BigDecimal azfw;
    private BigDecimal atow;
    private BigDecimal aldw;
    private BigDecimal zfwIndex;
    private BigDecimal towIndex;
    private BigDecimal ldwIndex;
    private BigDecimal macZfcPercentage;
    private BigDecimal macTowPercentage;
    private final LinkedHashMap<String, EditText> editTexts = new LinkedHashMap<>();

    public Finalplan(AppCompatActivity context, Type type) {
        this.context = context;
        this.type    = type;
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
        EditText txtMacZfw = this.editTexts.get("txtMacZfw");
        EditText txtMacTow = this.editTexts.get("txtMacTow");

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
                    Finalplan.this.aldw = BigDecimal.valueOf(aldw);
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
                    double value = 0.0;
                    try {
                        value = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        value = 0.0;
                    }

                    Finalplan.this.zfwIndex = BigDecimal.valueOf(value);

                    EditText txtFuelIndex = (EditText) Utils.findViewId(Finalplan.this.context, "txtFuelIndex");
                    double fuelIndex = 0;
                    try{
                        fuelIndex = Double.parseDouble(txtFuelIndex.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        fuelIndex = 0;
                    }

                    Finalplan.this.towIndex = Finalplan.this.zfwIndex.add(BigDecimal.valueOf(fuelIndex)).setScale(1, RoundingMode.CEILING);
                    txtTowIndex.setText(Finalplan.this.towIndex.toString());

                    Finalplan.this.macZfcPercentage = Finalplan.this.zfwIndex.divide(BigDecimal.valueOf(2)).setScale(1, RoundingMode.DOWN).subtract(BigDecimal.valueOf(1));
                    txtMacZfw.setText(Finalplan.this.macZfcPercentage.toString());

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
                    double value = 0.0;
                    try {
                        value = Double.parseDouble(charSequence.toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        value = 0.0;
                    }

                    Finalplan.this.towIndex = BigDecimal.valueOf(value);

                    EditText txtLandingIndex = (EditText) Utils.findViewId(Finalplan.this.context, "txtLandingIndex");
                    double landingIndex = 0;
                    try{
                        landingIndex = Double.parseDouble(txtLandingIndex.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        landingIndex = 0;
                    }

                    if (isNull(zfwIndex) || isNull(towIndex)) {
                        return;
                    }

                    Finalplan.this.ldwIndex = Finalplan.this.zfwIndex.add(BigDecimal.valueOf(landingIndex)).setScale(1, RoundingMode.CEILING);
                    txtLdWIndex.setText(Finalplan.this.ldwIndex.toString());

                    Finalplan.this.macTowPercentage = Finalplan.this.towIndex.divide(BigDecimal.valueOf(2)).setScale(1, RoundingMode.DOWN).subtract(BigDecimal.valueOf(1));
                    txtMacTow.setText(Finalplan.this.macTowPercentage.toString());

                    Graph graph = new Graph(Finalplan.this.context, type, Finalplan.this.getIndexDto());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public IndexDto getIndexDto() {
        return  new IndexDto(azfw, zfwIndex, atow, towIndex, aldw, ldwIndex);
    }
}
