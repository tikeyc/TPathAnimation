package com.tikeyc.tpathanimation.avtivity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tikeyc.tpathanimation.R;
import com.tikeyc.tpathanimation.custom.CustomView.PathView;
import com.tikeyc.tpathanimation.custom.CustomView.TPathIcon;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private PathView pathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        setListen();
    }

    private void setListen() {
        pathView.addPathIconClickListener(new PathView.TPathIconClickListen() {
            @Override
            public void onPathIconClick(TPathIcon pathIcon) {
                Log.e("TAG","onPathIconClick:" + pathIcon.getTag());
            }
        });
    }


    private void initView() {
        Button startAnimation_button = (Button) findViewById(R.id.startAnimation_button);
        startAnimation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathView.startAnimation();
            }
        });
        pathView = (PathView) findViewById(R.id.pathView);

        final ArrayList<Integer> iconImageNames = new ArrayList<>();
        final ArrayList<String> iconsTitles = new ArrayList<>();
        iconImageNames.add(R.mipmap.test1);
        iconImageNames.add(R.mipmap.test2);
        iconImageNames.add(R.mipmap.test3);
        iconImageNames.add(R.mipmap.test4);
        iconImageNames.add(R.mipmap.test5);
        iconsTitles.add("test1");
        iconsTitles.add("test2");
        iconsTitles.add("test3");
        iconsTitles.add("test4");
        iconsTitles.add("test5");
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

//                setPath();
//                startAnimatorPath(fab, "fab", path);
                pathView.setShowPathIcons(iconImageNames,iconsTitles);
                pathView.postInvalidate();
            }
        };
        handler.sendEmptyMessageDelayed(0, (long) 1);

    }
}
