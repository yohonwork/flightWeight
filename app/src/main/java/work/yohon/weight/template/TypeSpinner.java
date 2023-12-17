package work.yohon.weight.template;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import work.yohon.weight.common.Utils;
import work.yohon.weight.repository.TypeRepository;
import work.yohon.weight.repository.entity.Type;

public class TypeSpinner {
    private final AppCompatActivity context;
    private final int spinnerId;
    private final int simple_spinner_item;
    private final int simple_spinner_dropdown_item;
    private final TypeRepository repository;
    private final Spinner spinner;
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
    }

    public Type getType() {
        String typeName = this.spinner.getSelectedItem().toString();
        return repository.findByName(typeName);
    }

}
