package work.yohon.weight;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import work.yohon.weight.common.Utils;
import work.yohon.weight.controller.MainController;

public class MainActivity extends AppCompatActivity {

    private MainController controller = new MainController(this);
    public boolean initSpinner = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(Utils.getLayout(this, "activity_main"));
        controller.createLayer();
    }

    public boolean isInitSpinner() {
        return this.initSpinner;
    }

    public void setInitSpinner(boolean value) {
        this.initSpinner = value;
    }
}