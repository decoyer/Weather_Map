package kr.co.company.markerdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class IntentActivity extends AppCompatActivity {
    TextView timeview;
    ImageView imageview;
    TextView tempview;
    Document doc = null;
    LinearLayout layout = null;
    private String city;
    private String url;
    private String time;
    private String weather;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        timeview = (TextView) findViewById(R.id.textView1);
        imageview = (ImageView) findViewById(R.id.imageView1);
        tempview = (TextView) findViewById(R.id.textView2);
        
        // 메인 액티비티에서 수신받음
        Intent intent = getIntent();
        city = intent.getStringExtra("city");
        GetXMLTask task = new GetXMLTask(this);
        switch (city) {
            case "seoul":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=125";
                break;
            case "chuncheon":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=72&gridy=133";
                break;
            case "gangneung":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=93&gridy=132";
                break;
            case "wonju":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=77&gridy=122";
                break;
            case "asan":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=69&gridy=106";
                break;
            case "andong":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=91&gridy=105";
                break;
            case "daegu":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=89&gridy=90";
                break;
            case "daejeon":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=68&gridy=100";
                break;
            case "gwangju":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=57&gridy=74";
                break;
            case "pohang":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=105&gridy=94";
                break;
            case "ulsan":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=101&gridy=84";
                break;
            case "busan":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=97&gridy=74";
                break;
            case "mokpo":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=50&gridy=66";
                break;
            case "jeju":
                url = "https://www.kma.go.kr/wid/queryDFS.jsp?gridx=53&gridy=38";
                break;
            default:
                break;
        }
        task.execute(url);
    }

    @SuppressLint("NewApi")
    private class GetXMLTask extends AsyncTask<String, Void, Document> {
        private Activity context;

        public GetXMLTask(Activity context) {
            this.context = context;
        }

        @Override
        protected Document doInBackground(String... urls) {

            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory
                        .newInstance();
                DocumentBuilder db;

                db = dbf.newDocumentBuilder();

                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                //Toast.makeText(getBaseContext(), "Parsing Error",
                //Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {
            String s = "";
            String t = "";
            NodeList nodeList = doc.getElementsByTagName("data");

            int i = nodeList.getLength() - 1;
            Node node = nodeList.item(i);
            Element fstElmnt = (Element) node;

            NodeList nameList = fstElmnt.getElementsByTagName("temp");
            Element nameElement = (Element) nameList.item(0);
            nameList = nameElement.getChildNodes();

            NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
            Element websiteElement = (Element) websiteList.item(0);
            websiteList = websiteElement.getChildNodes();

            // 현재 날짜 출력
            long now = System.currentTimeMillis();
            Date mDate = new Date(now);
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년 MM월 dd일 a h:mm", Locale.KOREA);
            time = simpleDate.format(mDate);

            s += time + "\n";

            // 날씨에 따라 이미지 파일 출력
            weather = ((Node) websiteList.item(0)).getNodeValue();

            switch (weather) {
                case "맑음":
                    imageview.setImageDrawable(getResources().getDrawable(R.drawable.clear));
                    break;
                case "구름 조금":
                    imageview.setImageDrawable(getResources().getDrawable(R.drawable.cl));
                    break;
                case "구름 많음":
                    imageview.setImageDrawable(getResources().getDrawable(R.drawable.clou));
                    break;
                case "흐림":
                    imageview.setImageDrawable(getResources().getDrawable(R.drawable.cloudy));
                    break;
                case "비":
                    imageview.setImageDrawable(getResources().getDrawable(R.drawable.rain));
                    break;
                case "눈":
                    imageview.setImageDrawable(getResources().getDrawable(R.drawable.snow));
                    break;
                case "천둥 번개":
                    imageview.setImageDrawable(getResources().getDrawable(R.drawable.thunder));
                    break;
                default:
                    break;
            }

            // 현재 온도 출력
            t += ((Node) nameList.item(0)).getNodeValue() + "°C";

            timeview.setText(s);
            tempview.setText(t);
        }
    }
}