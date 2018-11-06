package top.onehundred.android.kits.demo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import liupeng.ademo.R;
import top.onehundred.android.kits.ok;

public class AppSystemActivity extends AppCompatActivity {

    @BindView(R.id.tv_info)
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_system);
        ButterKnife.bind(this);
        setTitle("AppKit & SystemKit");

        tvInfo.append("app name: " + ok.appKit().getAppName() + "\n");
        tvInfo.append("app version: " + ok.appKit().getVersionName() + "(build " + ok.appKit().getVersionCode() + ")\n");
        tvInfo.append("package name: " + ok.appKit().getPackageName() + "\n\n");

        tvInfo.append("device brand: " + ok.systemKit().getDeviceBrand() + "\n");
        tvInfo.append("device model:" + ok.systemKit().getDeviceModel() + "\n");
        tvInfo.append("system version: " + ok.systemKit().getSystemVersion() + "\n\n");
        tvInfo.append("android id: " + ok.systemKit().getAndroidId()+ "\n");
        tvInfo.append("serial: " + ok.systemKit().getSerial() + "\n");

        tvInfo.append("language: " + ok.systemKit().getLanguage() + "\n");
        tvInfo.append("country: " + ok.systemKit().getCountry());
    }
}
