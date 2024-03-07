package work.yohon.weight.template.passenger;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;
import java.util.Map;

import work.yohon.weight.common.Utils;
import work.yohon.weight.repository.PassengerRepository;
import work.yohon.weight.repository.entity.Type;

public class Passenger {
    private final AppCompatActivity context;
    private final PassengerDto passengerDto;
    private final LinkedHashMap<String, EditText> editTexts;
    private final PassengerRepository repository;
    public Passenger(AppCompatActivity context, Type type) {
        this.context         = context;
        this.repository      = new PassengerRepository();
        this.passengerDto    = new PassengerDto(repository.findByTypeSeq(type.getSeq()));
        this.editTexts       = new LinkedHashMap<>();
        this.editTexts.put("txtAdult", (EditText) Utils.findViewId(this.context, "txtAdult"));


        this.editTexts.get("txtAdult").addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {

             }
        });
        this.editTexts.put("txtAdultWeight", (EditText) Utils.findViewId(this.context, "txtAdultWeight"));
        this.editTexts.put("txtAdultWeightTotal", (EditText) Utils.findViewId(this.context, "txtAdultWeightTotal"));
        this.editTexts.put("txtChild", (EditText) Utils.findViewId(this.context, "txtChild"));
        this.editTexts.put("txtCHildWeight", (EditText) Utils.findViewId(this.context, "txtCHildWeight"));
        this.editTexts.put("txtChildWeightTotal", (EditText) Utils.findViewId(this.context, "txtChildWeightTotal"));
        this.editTexts.put("txtInf", (EditText) Utils.findViewId(this.context, "txtInf"));
        this.editTexts.put("txtInfWeight", (EditText) Utils.findViewId(this.context, "txtInfWeight"));
        this.editTexts.put("txtInfWeightTotal", (EditText) Utils.findViewId(this.context, "txtInfWeightTotal"));
        this.editTexts.put("txtCabinBag", (EditText) Utils.findViewId(this.context, "txtCabinBag"));
        this.editTexts.put("txtCabinBagWeight", (EditText) Utils.findViewId(this.context, "txtCabinBagWeight"));
        this.editTexts.put("txtCabinBagWeightTotal", (EditText) Utils.findViewId(this.context, "txtCabinBagWeightTotal"));
        this.editTexts.put("txtTotalPax", (EditText) Utils.findViewId(this.context, "txtTotalPax"));
        this.editTexts.put("txtTotalPaxTotal", (EditText) Utils.findViewId(this.context, "txtTotalPaxTotal"));

        if (this.passengerDto != null) {
            update();
            initEvent();
        }

    }

    private void update() {
        for (Map.Entry<String, EditText> entry : editTexts.entrySet()) {
            switch (entry.getKey()) {
                case "txtAdult":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerAdult().getHeadcount()));
                    break;
                case "txtAdultWeight":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerAdult().getWeight()));
                    break;
                case "txtAdultWeightTotal":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerAdult().getTotalWeight()));
                    break;
                case "txtChild":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerChild().getHeadcount()));
                    break;
                case "txtCHildWeight":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerChild().getWeight()));
                    break;
                case "txtChildWeightTotal":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerChild().getTotalWeight()));
                    break;
                case "txtInf":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerInfants().getHeadcount()));
                    break;
                case "txtInfWeight":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerInfants().getWeight()));
                    break;
                case "txtInfWeightTotal":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerInfants().getTotalWeight()));
                    break;
                case "txtCabinBag":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerCabinBag().getCount()));
                    break;
                case "txtCabinBagWeight":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerCabinBag().getWeight()));
                    break;
                case "txtCabinBagWeightTotal":
                    entry.getValue().setText(String.valueOf(passengerDto.getPassengerCabinBag().getTotalWeight()));
                    break;
                case "txtTotalPax":
                    entry.getValue().setText(String.valueOf(passengerDto.getTotalPaxString()));
                    break;
                case "txtTotalPaxTotal":
                    entry.getValue().setText(String.valueOf(passengerDto.getTotalPaxWeight()));
                    break;
            }
        }
    }

    public long getTotalPaxWeight() {
        return this.passengerDto.getTotalPaxWeight();
    }

    public PassengerDto getPassengerDto() {
        return this.passengerDto;
    }
    private void initEvent() {
        EditText txtTotalPax         = this.editTexts.get("txtTotalPax");
        EditText txtTotalPaxTotal    = this.editTexts.get("txtTotalPaxTotal");
        EditText txtAdult            = this.editTexts.get("txtAdult");
        EditText txtAdultWeightTotal = this.editTexts.get("txtAdultWeightTotal");
        txtAdult.addTextChangedListener(new TextWatcher() {

            private PassengerDto passengerDto = Passenger.this.passengerDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtAdult.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.passengerDto.setAdultHeads(count);
                    String strAdultTotalWeight = String.valueOf(this.passengerDto.getAdultTotalWeight());
                    txtAdultWeightTotal.setText(strAdultTotalWeight);
                    txtTotalPax.setText(this.passengerDto.getTotalPaxString());
                    String strTotalWeight = String.valueOf(this.passengerDto.getTotalPaxWeight());
                    txtTotalPaxTotal.setText(strTotalWeight);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtChild            = this.editTexts.get("txtChild");
        EditText txtChildWeightTotal = this.editTexts.get("txtChildWeightTotal");
        txtChild.addTextChangedListener(new TextWatcher() {

            private PassengerDto passengerDto = Passenger.this.passengerDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtChild.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.passengerDto.setChildHeads(count);
                    String strChildTotalWeight = String.valueOf(this.passengerDto.getChildTotalWeight());
                    txtChildWeightTotal.setText(strChildTotalWeight);
                    txtTotalPax.setText(this.passengerDto.getTotalPaxString());
                    String strTotalWeight = String.valueOf(this.passengerDto.getTotalPaxWeight());
                    txtTotalPaxTotal.setText(strTotalWeight);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtInf            = this.editTexts.get("txtInf");
        EditText txtInfWeightTotal = this.editTexts.get("txtInfWeightTotal");
        txtInf.addTextChangedListener(new TextWatcher() {

            private PassengerDto passengerDto = Passenger.this.passengerDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtInf.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.passengerDto.setInfHeads(count);
                    String strInfTotalWeight = String.valueOf(this.passengerDto.getInfTotalWeight());
                    txtInfWeightTotal.setText(strInfTotalWeight);
                    txtTotalPax.setText(this.passengerDto.getTotalPaxString());
                    String strTotalWeight = String.valueOf(this.passengerDto.getTotalPaxWeight());
                    txtTotalPaxTotal.setText(strTotalWeight);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        EditText txtCabinBag            = this.editTexts.get("txtCabinBag");
        EditText txtCabinBagWeightTotal = this.editTexts.get("txtCabinBagWeightTotal");
        txtCabinBag.addTextChangedListener(new TextWatcher() {

            private PassengerDto passengerDto = Passenger.this.passengerDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (txtCabinBag.isFocusable() && !charSequence.toString().equals("")) {
                    long count = 0;
                    try {
                        count = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }

                    this.passengerDto.setCabinGagCount(count);
                    String strCabinbagTotalWeight = String.valueOf(this.passengerDto.getCabinbagTotalWeight());
                    txtCabinBagWeightTotal.setText(strCabinbagTotalWeight);
                    String strTotalWeight = String.valueOf(this.passengerDto.getTotalPaxWeight());
                    txtTotalPaxTotal.setText(strTotalWeight);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        txtTotalPaxTotal.addTextChangedListener(new TextWatcher() {

            private PassengerDto passengerDto = Passenger.this.passengerDto;
            private String preText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                preText = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals("")) {
                    long totalPax = 0;
                    EditText txtAZFW          = (EditText) Utils.findViewId(Passenger.this.context, "txtAZFW");
//                    EditText txtTotalPaxTotal = (EditText) Utils.findViewId(Passenger.this.context, "txtTotalPaxTotal");
                    EditText txtDow           = (EditText) Utils.findViewId(Passenger.this.context, "txtDow");
                    EditText txtTtlDeadLoad   = (EditText) Utils.findViewId(Passenger.this.context, "txtTtlDeadLoad");
                    try {
                        totalPax = Long.parseLong(charSequence.toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }
                    long dow = 0;
                    long ttlDeadLoad   = 0;
                    try {
                        dow = Long.parseLong(txtDow.getText().toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        dow = 0;
                    }

                    try {
                        ttlDeadLoad = Long.parseLong(txtTtlDeadLoad.getText().toString());
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                        ttlDeadLoad = 0;
                    }

                    long azfw = (long)totalPax + dow + ttlDeadLoad;
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
