package com.lhengi.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridview;
    private String[] carNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter( new ImageAdapter(this));


        carNames = (String[]) getResources().getStringArray(R.array.carNames);

        gridview.setOnItemClickListener(shortClick);




    }

    public AdapterView.OnItemClickListener shortClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,"You just short clicked "+position,Toast.LENGTH_LONG).show();
        }
    };


    //Data(int postion, String name, int imgResource,String officialSite, String[] dealers)

    private Data[] data = {
            new Data(0,"Tesla Model 3", R.drawable.tesla3,"https://tesla.com", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),
            new Data(1,"Tesla Model X", R.drawable.tesla_x,"https://tesla.com", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),
            new Data(2,"BMW i8", R.drawable.bmw_i8,"https://www.bmwusa.com", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),
            new Data(3,"Cadillac Escalade", R.drawable.cadillac_escalade,"https://www.cadillac.com", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),
            new Data(4,"Honda Piolt", R.drawable.honda_piolt,"https://www.honda.com", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),
            new Data(5,"Jeep Wrangler", R.drawable.jeep_wrangler,"https://www.jeep.com", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),
            new Data(6,"Mercedes-Benz S", R.drawable.mercedes_s,"https://www.mbusa.com/en/home", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),
            new Data(7,"Subrau Ascent", R.drawable.subrau_sscent,"https://www.subaru.com", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),
            new Data(8,"Toyota Camry", R.drawable.toyota_camry,"https://www.toyota.com", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),
            new Data(9,"VW Toureg", R.drawable.vw_toureg,"http://www.vw.com", new String[]{"Dealer 1","Dealer 2", "Dealer 3"}),

    };
}
