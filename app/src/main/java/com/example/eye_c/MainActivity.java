package com.example.eye_c;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {
    //앱키
    //String AppKey = "l7xx0bb747b47fda487cb41c728729acf337";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tmap
        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(this);

        //tmap 호출
        tMapView.setSKTMapApiKey("l7xx2d6888f82c9c40ddb8722a946d5df7ae");
        linearLayoutTmap.addView(tMapView);

        //현재 위치 (위도, 경도) 반환
        TMapPoint tpoint = tMapView.getLocationPoint();
        double Latitude = tpoint.getLatitude();
        double Longitude = tpoint.getLongitude();

        //위에서 받아온 현재위치를 중심변경
        tMapView.setCenterPoint(Latitude, Longitude);
        //현재 위치로 표시될 위도, 경도
        tMapView.setLocationPoint(Latitude, Longitude);
        //현재 위치로 표시될 아이콘 설정
        tMapView.setIconVisibility(true);
        //http 설정
        tMapView.setHttpsMode(true);

    }

    public void findRoadButton(View v){
        Toast.makeText(this, "길안내를 시작합니다", Toast.LENGTH_SHORT).show();
    }

    public void findDestButton(View v){
        Toast.makeText(this, "목적지를 안내합니다", Toast.LENGTH_SHORT).show();
    }

    public void linkCamButton(View v){
        Toast.makeText(this,"카메라를 연결합니다", Toast.LENGTH_SHORT).show();
    }


}