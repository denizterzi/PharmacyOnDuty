package tr.edu.trakya.denizterzi.pharmacyonduty;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PharmacyActivity extends AppCompatActivity {
    private static String url = "http://www.edirneeo.org.tr/?p=nobetci";
    private ProgressDialog mProgressDialog;
    public ArrayList list = new ArrayList();
    private ArrayAdapter<String> adapter;
    @BindView(R.id.merkezlist)
    ListView mViewMerkezList;
    @BindView(R.id.edittext)
    EditText editT;
    @BindView(R.id.kesanList)
    ListView mKesanList;
    @BindView(R.id.uzunkopruList)
    ListView mUzunKopruList;
    @BindView(R.id.ipsalaList)
    ListView mIpsalaList;
    @BindView(R.id.havsaList)
    ListView mHavsaList;
    @BindView(R.id.enezList)
    ListView mEnezList;
    @BindView(R.id.lalapasaList)
    ListView mLalapasaList;
    @BindView(R.id.mericList)
    ListView mMericList;
    @BindView(R.id.suloglulist)
    ListView mSulogluLst;

    @BindView(R.id.queryButton)
    Button mQueryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);
        ButterKnife.bind(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);


    }

    @OnClick(R.id.queryButton)
    public void queryButtonClicked() {

        new getData().execute();
//        new getDataLalapasa().execute();
//        new getDataKesan().execute();
//        new getDataSuloglu().execute();
//        new getDataMeric().execute();
//        new getDataIpsala().execute();
//        new getDataHavsa().execute();
//        new getDataEnez().execute();
//        new getDataUzunkopru().execute();
    }

//    @OnClick(R.id.queryButton2)
//    public void queryButtonClicked2() {
//        String id = editT.getText();
//        if(id="merkez"){
//            new getDataMerkez().execute();
//        }
//        new getDataMerkez().execute();
//    }

    private class getData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr");

                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik yukleniyor");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mViewMerkezList.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }

    private class getDataMerkez extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(4)");
                Elements pharmacyOnDutyM = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(5)");
                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());
                    list.add(pharmacyOnDutyM.get(i).text());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik yukleniyor");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mViewMerkezList.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }

    private class getDataKesan extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(9)");
                // Elements pharmacyOnDutyM=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(5)");
                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());

                }
                //Elements pharmacyName=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik Yükleniyor!");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mKesanList.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }

    private class getDataSuloglu extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(12)");
                // Elements pharmacyOnDutyM=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(5)");
                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());

                }
                //Elements pharmacyName=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik Yükleniyor!");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mSulogluLst.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
//    private void WebServiceTutorial(){
//        String address_url="http://www.edirneeo.org.tr/?p=nobetci";
//        HttpURLConnection connection=null;
//        try {
//            URL url =new URL(address_url);
//            connection=(HttpURLConnection) url.openConnection();
//            int connection_state=connection.getResponseCode();
//            if(connection_state==HttpURLConnection.HTTP_OK) {
//                BufferedInputStream stream=new BufferedInputStream(connection.getInputStream());
//                DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
//                DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
//
//                org.w3c.dom.Document document=documentBuilder.parse(stream);
//
//                NodeList pharmacyNodelist=document.getElementsByTagName("table");
//                for(int i=0; i<pharmacyNodelist.getLength(); i++) {
//                    Element element=(Element) pharmacyNodelist.item(i);
//
//                }
//
//
//            }
//
//
//
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
//    }
//}


    }

    private class getDataIpsala extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(8)");
                // Elements pharmacyOnDutyM=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(5)");
                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());

                }
                //Elements pharmacyName=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik Yükleniyor!");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mIpsalaList.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }

    private class getDataMeric extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(11)");
                // Elements pharmacyOnDutyM=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(5)");
                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());

                }
                //Elements pharmacyName=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik Yükleniyor!");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mMericList.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }
    private class getDataUzunkopru extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(13)");
                // Elements pharmacyOnDutyM=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(5)");
                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());

                }
                //Elements pharmacyName=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik Yükleniyor!");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mUzunKopruList.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }
    private class getDataEnez extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(6)");
                // Elements pharmacyOnDutyM=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(5)");
                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());

                }
                //Elements pharmacyName=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik Yükleniyor!");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mEnezList.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }
    private class getDataHavsa extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(7)");
                // Elements pharmacyOnDutyM=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(5)");
                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());

                }
                //Elements pharmacyName=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik Yükleniyor!");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mHavsaList.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }
    private class getDataLalapasa extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(url).timeout(1000).get();
                Elements pharmacyOnDuty = document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(10)");
                // Elements pharmacyOnDutyM=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody >  tr:nth-child(5)");
                for (int i = 0; i < pharmacyOnDuty.size(); i++) {
                    list.add(pharmacyOnDuty.get(i).text());

                }
                //Elements pharmacyName=document.select("body > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(3)");


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(PharmacyActivity.this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMessage("Icerik Yükleniyor!");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mHavsaList.setAdapter(adapter);
            mProgressDialog.dismiss();
        }
    }
}

