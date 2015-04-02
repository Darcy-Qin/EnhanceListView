
package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void gotoActivity1(View view) {
        Intent intent = new Intent(this, Test1Activity.class);
        startActivity(intent);
    }

    public void gotoActivity2(View view) {
        Intent intent = new Intent(this, Test2Activity.class);
        startActivity(intent);
    }

    public void gotoActivity3(View view) {
        Intent intent = new Intent(this, Test3Activity.class);
        startActivity(intent);
    }

    public void gotoActivity4(View view) {
        Intent intent = new Intent(this, Test4Activity.class);
        startActivity(intent);
    }

    public void gotoActivity5(View view) {
        Intent intent = new Intent(this, Test5Activity.class);
        startActivity(intent);
    }

    public void gotoActivity6(View view) {
        Intent intent = new Intent(this, Test6Activity.class);
        startActivity(intent);
    }
    
    public void gotoActivity7(View view) {
        Intent intent = new Intent(this, Test7Activity.class);
        startActivity(intent);
    }
    
    public void gotoActivity8(View view) {
        Intent intent = new Intent(this, Test8Activity.class);
        startActivity(intent);
    }
}
