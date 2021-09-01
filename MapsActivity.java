package kr.co.company.markerdemo;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements
        GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback {

    // 도시 좌표 지정
    private static final LatLng SEOUL = new LatLng(	37.566661, 126.978404);
    private static final LatLng CHUNCHEON = new LatLng(37.881286, 127.730080);
    private static final LatLng GANGNEUNG = new LatLng(37.751847, 128.876058);
    private static final LatLng WONJU = new LatLng(37.341966, 127.919662);
    private static final LatLng ASAN = new LatLng(36.789930, 127.002544);
    private static final LatLng ANDONG = new LatLng(36.568434, 128.729551);
    private static final LatLng DAEGU = new LatLng(35.871404, 128.601748);
    private static final LatLng DAEJEON = new LatLng(36.350464, 127.384824);
    private static final LatLng GWANGJU = new LatLng(35.160070, 126.851433);
    private static final LatLng POHANG = new LatLng(36.019206, 129.343453);
    private static final LatLng ULSAN = new LatLng(35.539624, 129.311526);
    private static final LatLng BUSAN = new LatLng(35.179773, 129.075002);
    private static final LatLng MOKPO = new LatLng(34.811826, 126.392210);
    private static final LatLng JEJU = new LatLng(33.499592, 126.531255);

    // 도시 마커 지정
    private Marker mSeoul;
    private Marker mChuncheon;
    private Marker mGangneung;
    private Marker mWonju;
    private Marker mAsan;
    private Marker mAndong;
    private Marker mDaegu;
    private Marker mDaejeon;
    private Marker mGwangju;
    private Marker mPohang;
    private Marker mUlsan;
    private Marker mBusan;
    private Marker mMokpo;
    private Marker mJeju;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * 지도가 준비되면 호출된다.
     */
    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        mSeoul = mMap.addMarker(new MarkerOptions()
                .position(SEOUL)
                .title("서울특별시")
                .snippet("https://www.seoul.go.kr")     // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.seoul)));
        mSeoul.setTag(0);

        mChuncheon = mMap.addMarker(new MarkerOptions()
                .position(CHUNCHEON)
                .title("춘천시")
                .snippet("https://www.chuncheon.go.kr") // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.chuncheon)));
        mChuncheon.setTag(0);

        mGangneung = mMap.addMarker(new MarkerOptions()
                .position(GANGNEUNG)
                .title("강릉시")
                .snippet("https://www.gn.go.kr")        // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.gangneung)));
        mGangneung.setTag(0);

        mWonju = mMap.addMarker(new MarkerOptions()
                .position(WONJU)
                .title("원주시")
                .snippet("https://www.wonju.go.kr")     // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.wonju)));
        mWonju.setTag(0);

        mAsan = mMap.addMarker(new MarkerOptions()
                .position(ASAN)
                .title("아산시")
                .snippet("https://www.asan.go.kr")      // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.asan)));
        mAsan.setTag(0);

        mAndong = mMap.addMarker(new MarkerOptions()
                .position(ANDONG)
                .title("안동시")
                .snippet("https://www.andong.go.kr")    // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.andong)));
        mAndong.setTag(0);

        mDaegu = mMap.addMarker(new MarkerOptions()
                .position(DAEGU)
                .title("대구광역시")
                .snippet("https://www.daegu.go.kr")     // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.daegu)));
        mDaegu.setTag(0);

        mDaejeon = mMap.addMarker(new MarkerOptions()
                .position(DAEJEON)
                .title("대전광역시")
                .snippet("https://www.daejeon.go.kr")   // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.daejeon)));
        mDaejeon.setTag(0);

        mGwangju = mMap.addMarker(new MarkerOptions()
                .position(GWANGJU)
                .title("광주광역시")
                .snippet("https://www.gwangju.go.kr")   // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.gwangju)));
        mGwangju.setTag(0);
        
        mPohang = mMap.addMarker(new MarkerOptions()
                .position(POHANG)
                .title("포항시")
                .snippet("https://www.pohang.go.kr")    // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pohang)));
        mPohang.setTag(0);

        mUlsan = mMap.addMarker(new MarkerOptions()
                .position(ULSAN)
                .title("울산광역시")
                .snippet("https://www.ulsan.go.kr")     // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ulsan)));
        mUlsan.setTag(0);

        mBusan = mMap.addMarker(new MarkerOptions()
                .position(BUSAN)
                .title("부산광역시")
                .snippet("https://www.busan.go.kr")     // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.busan)));
        mBusan.setTag(0);

        mMokpo = mMap.addMarker(new MarkerOptions()
                .position(MOKPO)
                .title("목포시")
                .snippet("https://www.mokpo.go.kr")     // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mokpo)));
        mMokpo.setTag(0);

        mJeju = mMap.addMarker(new MarkerOptions()
                .position(JEJU)
                .title("제주특별자치도")
                .snippet("https://www.jeju.go.kr")      // 시청 홈페이지 연결
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.jeju)));
        mJeju.setTag(0);

        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
    }

    /**
     * 사용자가 마커를 클릭하면 호출된다.
     */
    @Override
    public boolean onMarkerClick(final Marker marker) {
        Intent intent = new Intent(getApplicationContext(), IntentActivity.class);

        // 인텐트로 발신함
        if (marker.getTitle().equals("서울특별시"))
            intent.putExtra("city", "seoul");
        else if (marker.getTitle().equals("춘천시"))
            intent.putExtra("city", "chuncheon");
        else if (marker.getTitle().equals("강릉시"))
            intent.putExtra("city", "gangneung");
        else if (marker.getTitle().equals("원주시"))
            intent.putExtra("city", "wonju");
        else if (marker.getTitle().equals("아산시"))
            intent.putExtra("city", "asan");
        else if (marker.getTitle().equals("안동시"))
            intent.putExtra("city", "andong");
        else if (marker.getTitle().equals("대구광역시"))
            intent.putExtra("city", "daegu");
        else if (marker.getTitle().equals("대전광역시"))
            intent.putExtra("city", "daejeon");
        else if (marker.getTitle().equals("광주광역시"))
            intent.putExtra("city", "gwangju");
        else if (marker.getTitle().equals("포항시"))
            intent.putExtra("city", "pohang");
        else if (marker.getTitle().equals("울산광역시"))
            intent.putExtra("city", "ulsan");
        else if (marker.getTitle().equals("부산광역시"))
            intent.putExtra("city", "busan");
        else if (marker.getTitle().equals("목포시"))
            intent.putExtra("city", "mokpo");
        else if (marker.getTitle().equals("제주특별자치도"))
            intent.putExtra("city", "jeju");

        // 인텐트 호출
        startActivity(intent);

        return false;
    }
}