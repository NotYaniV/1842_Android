package com.example.webclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity{
    public static TextView textView,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
       // StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView2 = (TextView) findViewById(R.id.textView2);
        MaterialButton but = (MaterialButton) findViewById(R.id.but);
        String fetchURL = "https://jsonplaceholder.typicode.com/todos/1" ;

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Async async = new Async();
                async.execute();
            }
        });
    }

public static class Async extends AsyncTask<Void, Void, Void> {
    String data="";
    Double salary=0.0;
    @Override
    protected Void doInBackground(Void... voids) {
        String buffer = "",line="";
        Double salaryObject ;

        try {
            URL url = new URL("https://api.jsonbin.io/b/5f98044c30aaa01ce619982d");
            HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while(line!=null){
                line = bufferedReader.readLine();
                buffer += line;
            }
            JSONArray jsonArray  = new JSONArray(buffer);
            ArrayList arrayList = new ArrayList();
            for(int i= 0; i<jsonArray.length();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                arrayList.add( "Name: " + jsonObject.get("lastName") + " "
                        + jsonObject.get("firstName") + "\n"+
                        "Emp Code: " + jsonObject.get("empCode") + "\n"
                        + "Salary :" + jsonObject.get("salary")+"\n");

                salaryObject = jsonObject.getDouble("salary");
                salary += salaryObject;
            }
            Collections.sort(arrayList);
            for(int i=0; i<arrayList.size(); i++){
                data= data+ arrayList.get(i) + "\n";
            }
        } catch (Exception e){
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.textView.setText(this.data);
        MainActivity.textView2.setText("Total Salary: " + this.salary.toString());
    }


    /*private String fetchData(String fetchURL){
        String fetchContent = null;
        try{
            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(fetchURL);
            HttpResponse httpResponse = client.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            InputStream inputStream = httpEntity.getContent();
            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
            fetchContent = s.hasNext() ? s.next() : "";
        }catch (Exception e){

        }
        return fetchContent;
    }







*/
}
}