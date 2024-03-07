package work.yohon.weight.template;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.List;

import work.yohon.weight.MainActivity;
import work.yohon.weight.common.Utils;
import work.yohon.weight.repository.TypeRepository;
import work.yohon.weight.repository.entity.Type;
import work.yohon.weight.template.basic.Basic;
import work.yohon.weight.template.basic.BasicDto;
import work.yohon.weight.template.cagoAndBaggage.CargoBaggage;
import work.yohon.weight.template.cgoBaggageLoadingPosition.CgoBaggageLoadingPostion;
import work.yohon.weight.template.finalplan.Finalplan;
import work.yohon.weight.template.passenger.Passenger;
import work.yohon.weight.template.paxZone.PaxZone;

public class TypeSpinner {
    private final AppCompatActivity context;
    private final int spinnerId;
    private final int simple_spinner_item;
    private final int simple_spinner_dropdown_item;
    private final TypeRepository repository;
    private final Spinner spinner;
    private boolean isInitSpinner = false;
    public TypeSpinner(AppCompatActivity context) {
        this.context                      = context;
        this.spinnerId                    = Utils.getId(this.context, "spinner");
        this.simple_spinner_item          = android.R.layout.simple_spinner_item;
        this.simple_spinner_dropdown_item = android.R.layout.simple_spinner_dropdown_item;
        this.repository                   = new TypeRepository();

        List<Type> typeList = repository.findAll();
        int size = typeList.size();
        String[] typeListStr      = new String[size];
        for(int idx = 0; idx < size; idx++) {
            typeListStr[idx] = typeList.get(idx).getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter(context, this.simple_spinner_item, typeListStr) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setTextSize(24);
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0) {
                    tv.setTextColor(Color.GRAY);
                    tv.setTextSize(24);
                } else {
                    tv.setTextColor(Color.BLACK);
                    tv.setTextSize(24);
                }
                return view;
            }
        };

        adapter.setDropDownViewResource(this.simple_spinner_dropdown_item);

        this.spinner = (Spinner) Utils.findViewId(this.context, "spinner");
        this.spinner.setAdapter(adapter);
        this.spinner.setOnItemSelectedListener(getSpinnerEvent());
    }

    public Type getType() {
        String typeName = this.spinner.getSelectedItem().toString();
        return repository.findByName(typeName);
    }

    private AdapterView.OnItemSelectedListener getSpinnerEvent() {
        return new AdapterView.OnItemSelectedListener() {

            private MainActivity context = (MainActivity) TypeSpinner.this.context;

            // 스피너 선택 했을 때 호출되는 메소드
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (!this.context.isInitSpinner()) {
                    this.context.setInitSpinner(true);
                    Type type = TypeSpinner.this.getType();
                    BasicDto basicDto = new BasicDto(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO);
                    Basic basic = new Basic(this.context, basicDto);
                    Passenger passenger = new Passenger(this.context, type);
                    CargoBaggage cargoBaggage = new CargoBaggage(this.context, basicDto, passenger.getPassengerDto());
                    CgoBaggageLoadingPostion cgoBaggageLoadingPostion = new CgoBaggageLoadingPostion(this.context, type, cargoBaggage.getCargoBaggageDto());
                    PaxZone paxZone = new PaxZone(this.context, TypeSpinner.this.getType(), passenger.getPassengerDto());
                    Finalplan finalplan = new Finalplan(this.context, TypeSpinner.this.getType());
                    return;
                }

                Type type = TypeSpinner.this.getType();
                BasicDto basicDto = new BasicDto(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO);
                Basic basic = new Basic(this.context, basicDto);
                Passenger passenger = new Passenger(this.context,type);
                CargoBaggage cargoBaggage = new CargoBaggage(this.context, basicDto, passenger.getPassengerDto());
                CgoBaggageLoadingPostion cgoBaggageLoadingPostion = new CgoBaggageLoadingPostion(this.context, type, cargoBaggage.getCargoBaggageDto());
                PaxZone paxZone = new PaxZone(this.context, type, passenger.getPassengerDto());
                Finalplan finalplan = new Finalplan(this.context, type);
            }

            // 선택이 하나도 되지 않았을 때 멧소드
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
    }

}
