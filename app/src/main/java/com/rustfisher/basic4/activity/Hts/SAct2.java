package com.rustfisher.basic4.activity.Hts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.rustfisher.basic4.R;
import com.rustfisher.basic4.activity.SAct;
import com.rustfisher.basic4.service.HowToStopService;

public class SAct2 extends SAct {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mLogPre = "[act2] ";
        super.onCreate(savedInstanceState);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SAct3.class));
            }
        });
        bindService(new Intent(getApplicationContext(), HowToStopService.class), mConn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(getApplicationContext(), HowToStopService.class));
    }
}