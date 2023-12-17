package work.yohon.weight.template.cgoBaggageLoadingPosition;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import work.yohon.weight.common.Utils;
import work.yohon.weight.repository.CgoBaggageLoadingPositionRepository;
import work.yohon.weight.repository.entity.CargoCpt;
import work.yohon.weight.repository.entity.Type;
import work.yohon.weight.template.cagoAndBaggage.CargoBaggageDto;

public class CgoBaggageLoadingPostion {

    public final AppCompatActivity context;
    private final CgoBaggageLoadingPositionDto cgoBaggageLoadingPositionDtos;
    private final CargoBaggageDto cargoBaggageDto;
    private final CgoBaggageLoadingPositionRepository repository = new CgoBaggageLoadingPositionRepository();
    private LinkedHashMap<String, EditText> editTexts = new LinkedHashMap<>();
    public CgoBaggageLoadingPostion(AppCompatActivity context, Type type, CargoBaggageDto cargoBaggageDto) {
        this.context         = context;
        this.cargoBaggageDto = cargoBaggageDto;
        List<CargoCpt> cargoCptList = repository.findByTypeSeq(type.getSeq());
        work.yohon.weight.template.cgoBaggageLoadingPosition.CargoCpt cpt1 = null;
        work.yohon.weight.template.cgoBaggageLoadingPosition.CargoCpt cpt2 = null;
        work.yohon.weight.template.cgoBaggageLoadingPosition.CargoCpt cpt3 = null;
        work.yohon.weight.template.cgoBaggageLoadingPosition.CargoCpt cpt4 = null;
        work.yohon.weight.template.cgoBaggageLoadingPosition.CargoCpt cpt5 = null;
        if (cargoCptList.size() == 5) {
            for(CargoCpt cpt : cargoCptList) {
                switch (cpt.getName()) {
                    case "CPT1":
                        cpt1 = cpt.value();
                        break;
                    case "CPT2":
                        cpt2 = cpt.value();
                        break;
                    case "CPT3":
                        cpt3 = cpt.value();
                        break;
                    case "CPT4":
                        cpt4 = cpt.value();
                        break;
                    case "CPT5":
                        cpt5 = cpt.value();
                        break;
                }
            }
        }
        this.cgoBaggageLoadingPositionDtos = new CgoBaggageLoadingPositionDto(cpt1, cpt2, cpt3, cpt4, cpt5, cargoBaggageDto);
        Log.d("", this.cgoBaggageLoadingPositionDtos + "");
        this.editTexts.put("txtCargoCpt1Weight", (EditText) Utils.findViewId(this.context, "txtCargoCpt1Weight"));
        this.editTexts.put("txtCargoCpt1WeightPoint", (EditText) Utils.findViewId(this.context, "txtCargoCpt1WeightPoint"));
        this.editTexts.put("txtCargCpt1Deadload", (EditText) Utils.findViewId(this.context, "txtCargCpt1Deadload"));

        this.editTexts.put("txtCargoCpt2Weight", (EditText) Utils.findViewId(this.context, "txtCargoCpt2Weight"));
        this.editTexts.put("txtCargoCpt2WeightPoint", (EditText) Utils.findViewId(this.context, "txtCargoCpt2WeightPoint"));
        this.editTexts.put("txtCargCpt2Deadload", (EditText) Utils.findViewId(this.context, "txtCargCpt2Deadload"));

        this.editTexts.put("txtCargoCpt3Weight", (EditText) Utils.findViewId(this.context, "txtCargoCpt3Weight"));
        this.editTexts.put("txtCargoCpt3WeightPoint", (EditText) Utils.findViewId(this.context, "txtCargoCpt3WeightPoint"));
        this.editTexts.put("txtCargCpt3Deadload", (EditText) Utils.findViewId(this.context, "txtCargCpt3Deadload"));

        this.editTexts.put("txtCargoCpt4Weight", (EditText) Utils.findViewId(this.context, "txtCargoCpt4Weight"));
        this.editTexts.put("txtCargoCpt4WeightPoint", (EditText) Utils.findViewId(this.context, "txtCargoCpt4WeightPoint"));
        this.editTexts.put("txtCargCpt4Deadload", (EditText) Utils.findViewId(this.context, "txtCargCpt4Deadload"));

        this.editTexts.put("txtCargoCpt5Weight", (EditText) Utils.findViewId(this.context, "txtCargoCpt5Weight"));
        this.editTexts.put("txtCargoCpt5WeightPoint", (EditText) Utils.findViewId(this.context, "txtCargoCpt5WeightPoint"));
        this.editTexts.put("txtCargCpt5Deadload", (EditText) Utils.findViewId(this.context, "txtCargCpt5Deadload"));

        this.editTexts.put("txtCgoTtl", (EditText) Utils.findViewId(this.context, "txtCgoTtl"));
        this.editTexts.put("txtBeLeftWeight", (EditText) Utils.findViewId(this.context, "txtBeLeftWeight"));

        if (this.cgoBaggageLoadingPositionDtos != null) {
            update();
            initEvent();
        }
    }

    private void update() {
        for(Map.Entry<String, EditText> entry : editTexts.entrySet()) {
            switch (entry.getKey()) {
                case "txtCargoCpt1Weight": {
                    long weight = cgoBaggageLoadingPositionDtos.getCpt1Weight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtCargoCpt1WeightPoint": {
                    double weightPoint = cgoBaggageLoadingPositionDtos.getCpt1WeightPoint();
                    entry.getValue().setText(String.valueOf(weightPoint));
                }
                break;
                case "txtCargCpt1Deadload": {
                    double deadloadPoint = cgoBaggageLoadingPositionDtos.getCpt1DeadloadPoint();
                    entry.getValue().setText(String.valueOf(deadloadPoint));
                }
                break;
                case "txtCargoCpt2Weight": {
                    long weight = cgoBaggageLoadingPositionDtos.getCpt2Weight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtCargoCpt2WeightPoint": {
                    double weightPoint = cgoBaggageLoadingPositionDtos.getCpt2WeightPoint();
                    entry.getValue().setText(String.valueOf(weightPoint));
                }
                break;
                case "txtCargCpt2Deadload": {
                    double deadloadPoint = cgoBaggageLoadingPositionDtos.getCpt2DeadloadPoint();
                    entry.getValue().setText(String.valueOf(deadloadPoint));
                }
                break;
                case "txtCargoCpt3Weight": {
                    long weight = cgoBaggageLoadingPositionDtos.getCpt3Weight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtCargoCpt3WeightPoint": {
                    double weightPoint = cgoBaggageLoadingPositionDtos.getCpt3WeightPoint();
                    entry.getValue().setText(String.valueOf(weightPoint));
                }
                break;
                case "txtCargCpt3Deadload": {
                    double deadloadPoint = cgoBaggageLoadingPositionDtos.getCpt3DeadloadPoint();
                    entry.getValue().setText(String.valueOf(deadloadPoint));
                }
                break;
                case "txtCargoCpt4Weight": {
                    long weight = cgoBaggageLoadingPositionDtos.getCpt4Weight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtCargoCpt4WeightPoint": {
                    double weightPoint = cgoBaggageLoadingPositionDtos.getCpt4WeightPoint();
                    entry.getValue().setText(String.valueOf(weightPoint));
                }
                break;
                case "txtCargCpt4Deadload": {
                    double deadloadPoint = cgoBaggageLoadingPositionDtos.getCpt4DeadloadPoint();
                    entry.getValue().setText(String.valueOf(deadloadPoint));
                }
                break;
                case "txtCargoCpt5Weight": {
                    long weight = cgoBaggageLoadingPositionDtos.getCpt5Weight();
                    entry.getValue().setText(String.valueOf(weight));
                }
                break;
                case "txtCargoCpt5WeightPoint": {
                    double weightPoint = cgoBaggageLoadingPositionDtos.getCpt5WeightPoint();
                    entry.getValue().setText(String.valueOf(weightPoint));
                }
                break;
                case "txtCargCpt5Deadload": {
                    double deadloadPoint = cgoBaggageLoadingPositionDtos.getCpt5DeadloadPoint();
                    entry.getValue().setText(String.valueOf(deadloadPoint));
                }
                break;
                case "txtCgoTtl": {
                    long deadload = cgoBaggageLoadingPositionDtos.getDeadload();
                    entry.getValue().setText(String.valueOf(deadload));
                }
                break;
                case "txtBeLeftWeight": {
                    long availableSpace = cgoBaggageLoadingPositionDtos.getAvailableSpace();
                    entry.getValue().setText(String.valueOf(availableSpace));
                }
                break;
            }
        }
    }

    private void initEvent() {
        EditText txtCgoTtl           = this.editTexts.get("txtCgoTtl");
        EditText txtBeLeftWeight           = this.editTexts.get("txtBeLeftWeight");
        EditText txtCargoCpt1Weight  = this.editTexts.get("txtCargoCpt1Weight");
        EditText txtCargCpt1Deadload = this.editTexts.get("txtCargCpt1Deadload");
        txtCargoCpt1Weight.addTextChangedListener(new TextWatcher() {

            private CgoBaggageLoadingPositionDto cgoBaggageLoadingPositionDtos = CgoBaggageLoadingPostion.this.cgoBaggageLoadingPositionDtos;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtCargoCpt1Weight.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cgoBaggageLoadingPositionDtos.setCpt1Weight(count);
                    String strDeadloadPoint = String.valueOf(this.cgoBaggageLoadingPositionDtos.getCpt1DeadloadPoint());
                    txtCargCpt1Deadload.setText(strDeadloadPoint);
                    String strTtl = String.valueOf(this.cgoBaggageLoadingPositionDtos.getDeadload());
                    txtCgoTtl.setText(strTtl);
                    String availableSpace = String.valueOf(this.cgoBaggageLoadingPositionDtos.getAvailableSpace());
                    txtBeLeftWeight.setText(availableSpace);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtCargoCpt2Weight  = this.editTexts.get("txtCargoCpt2Weight");
        EditText txtCargCpt2Deadload = this.editTexts.get("txtCargCpt2Deadload");
        txtCargoCpt2Weight.addTextChangedListener(new TextWatcher() {

            private CgoBaggageLoadingPositionDto cgoBaggageLoadingPositionDtos = CgoBaggageLoadingPostion.this.cgoBaggageLoadingPositionDtos;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtCargoCpt2Weight.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cgoBaggageLoadingPositionDtos.setCpt2Weight(count);
                    String strDeadloadPoint = String.valueOf(this.cgoBaggageLoadingPositionDtos.getCpt2DeadloadPoint());
                    txtCargCpt2Deadload.setText(strDeadloadPoint);
                    String strTtl = String.valueOf(this.cgoBaggageLoadingPositionDtos.getDeadload());
                    txtCgoTtl.setText(strTtl);
                    String availableSpace = String.valueOf(this.cgoBaggageLoadingPositionDtos.getAvailableSpace());
                    txtBeLeftWeight.setText(availableSpace);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtCargoCpt3Weight  = this.editTexts.get("txtCargoCpt3Weight");
        EditText txtCargCpt3Deadload = this.editTexts.get("txtCargCpt3Deadload");
        txtCargoCpt3Weight.addTextChangedListener(new TextWatcher() {

            private CgoBaggageLoadingPositionDto cgoBaggageLoadingPositionDtos = CgoBaggageLoadingPostion.this.cgoBaggageLoadingPositionDtos;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtCargoCpt3Weight.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cgoBaggageLoadingPositionDtos.setCpt3Weight(count);
                    String strDeadloadPoint = String.valueOf(this.cgoBaggageLoadingPositionDtos.getCpt3DeadloadPoint());
                    txtCargCpt3Deadload.setText(strDeadloadPoint);
                    String strTtl = String.valueOf(this.cgoBaggageLoadingPositionDtos.getDeadload());
                    txtCgoTtl.setText(strTtl);
                    String availableSpace = String.valueOf(this.cgoBaggageLoadingPositionDtos.getAvailableSpace());
                    txtBeLeftWeight.setText(availableSpace);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtCargoCpt4Weight  = this.editTexts.get("txtCargoCpt4Weight");
        EditText txtCargCpt4Deadload = this.editTexts.get("txtCargCpt4Deadload");
        txtCargoCpt4Weight.addTextChangedListener(new TextWatcher() {

            private CgoBaggageLoadingPositionDto cgoBaggageLoadingPositionDtos = CgoBaggageLoadingPostion.this.cgoBaggageLoadingPositionDtos;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtCargoCpt4Weight.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cgoBaggageLoadingPositionDtos.setCpt4Weight(count);
                    String strDeadloadPoint = String.valueOf(this.cgoBaggageLoadingPositionDtos.getCpt4DeadloadPoint());
                    txtCargCpt4Deadload.setText(strDeadloadPoint);
                    String strTtl = String.valueOf(this.cgoBaggageLoadingPositionDtos.getDeadload());
                    txtCgoTtl.setText(strTtl);
                    String availableSpace = String.valueOf(this.cgoBaggageLoadingPositionDtos.getAvailableSpace());
                    txtBeLeftWeight.setText(availableSpace);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtCargoCpt5Weight  = this.editTexts.get("txtCargoCpt5Weight");
        EditText txtCargCpt5Deadload = this.editTexts.get("txtCargCpt5Deadload");
        txtCargoCpt5Weight.addTextChangedListener(new TextWatcher() {

            private CgoBaggageLoadingPositionDto cgoBaggageLoadingPositionDtos = CgoBaggageLoadingPostion.this.cgoBaggageLoadingPositionDtos;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtCargoCpt5Weight.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.cgoBaggageLoadingPositionDtos.setCpt5Weight(count);
                    String strDeadloadPoint = String.valueOf(this.cgoBaggageLoadingPositionDtos.getCpt5DeadloadPoint());
                    txtCargCpt5Deadload.setText(strDeadloadPoint);
                    String strTtl = String.valueOf(this.cgoBaggageLoadingPositionDtos.getDeadload());
                    txtCgoTtl.setText(strTtl);
                    String availableSpace = String.valueOf(this.cgoBaggageLoadingPositionDtos.getAvailableSpace());
                    txtBeLeftWeight.setText(availableSpace);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }
}
