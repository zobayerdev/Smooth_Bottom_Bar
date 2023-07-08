package com.trodev.smoothbottombar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class FullOfActivity extends AppCompatActivity {

    /*widget declare*/
    RecyclerView recyclerView;

    /*arraylist for name, details*/
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> details = new ArrayList<>();
    ArrayList<String> userImg = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        /*init views*/
        recyclerView = findViewById(R.id.dataRv);

        /*recyclerview configuration*/
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        /*getting json*/
        try {
            JSONObject obj = new JSONObject(loadJSONfromAssets());

            // 7- Fetch json data
            JSONArray userArray = obj.getJSONArray("smsinfo");

            // 8- implementation of loop for getting user list data
            for (int i = 0; i<userArray.length(); i++)
            {
                // 9- creating a json object for fetching single user data
                JSONObject userDetails = userArray.getJSONObject(i);

                // 10- fetching name & details an storing them arraylist
                name.add(userDetails.getString("name"));
                details.add(userDetails.getString("details"));
                userImg.add(userDetails.getString("image"));

                /* // jodi json er moddhe abar ekta json thake tokhn er jonno ei code
                //11 - create an object for getting contact
                JSONObject contact = userDetails.getJSONObject("contact");

                // 12- fetching data
                mobile.add(userDetails.getString("mobile"));*/

            }

        }
        catch (JSONException e){

        }

        // 13 - calling the customAdapter
        DataAdapter dataAdapter = new DataAdapter (name, details, userImg, FullOfActivity.this);
        recyclerView.setAdapter(dataAdapter);

    }

    private String loadJSONfromAssets() {

        String json = null;

        try {

            InputStream is = getAssets().open("sad_sms.json");
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }

        return json;
    }

}