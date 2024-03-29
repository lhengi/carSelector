package com.lhengi.project2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridview;
    private int currentContextSelect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter( new ImageAdapter(this,data));// pass the array of data objects to custom adapter

        gridview.setOnItemClickListener(shortClick);

        registerForContextMenu(gridview);
        currentContextSelect = 0;

    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);


    }


    // check for context menu selection
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.openBrower:
                Intent browersInt = new Intent(Intent.ACTION_VIEW, Uri.parse(data[info.position].officialSite));
                startActivity(browersInt);
                System.out.println("You choose to open browser");
                return true;
            case R.id.viewPic:
                startBigPicture(info.position);
                System.out.println("Open big pic");
                return true;
            case R.id.listDealers:
                Intent dealerInt = new Intent(this,ListViewActivity.class);
                dealerInt.putExtra("dealers",data[info.position].dealers);
                startActivity(dealerInt);

                System.out.println("list dealers");
                return true;
            default:
                return super.onContextItemSelected(item);



        }
    }

    // create intent, pass data for starting big pic activity
    public void startBigPicture(int position)
    {
        Intent intent = new Intent(getBaseContext(),Magnify.class);
        intent.putExtra("imgResource",data[position].imgResource);
        intent.putExtra("url",data[position].officialSite);
        startActivity(intent);

    }

    // when cell short click start a new activity to display hig res pic
    public AdapterView.OnItemClickListener shortClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            startBigPicture(position);

        }
    };


    //Data(int postion, String name, int lowimg, int imgResource,String officialSite, String[] dealers)

    // organize all data into a data object, so don't have to worry about matching index
    private Data[] data = {
            new Data(0,"Tesla Model 3",R.drawable.tesla3_l, R.drawable.tesla3,"https://www.tesla.com/model3", new String[]{"Tesla\n1053 W Grand Ave, Chicago, IL 60642","Tesla Gallery\n" +
                    "901 N Rush St, Chicago, IL 60611", "Tesla\n" +
                    "58 Oakbrook Center, Oak Brook, IL 60523"}),
            new Data(1,"Tesla Model X",R.drawable.tesla_x_l, R.drawable.tesla_x,"https://www.tesla.com/modelx", new String[]{"Tesla\n1053 W Grand Ave, Chicago, IL 60642","Tesla Gallery\n" +
                    "901 N Rush St, Chicago, IL 60611", "Tesla\n" +
                    "58 Oakbrook Center, Oak Brook, IL 60523"}),
            new Data(2,"BMW i8",R.drawable.bmw_i8_l, R.drawable.bmw_i8,"https://www.bmwusa.com/byo.html#!/model-variant-selector/i8-coupe", new String[]{"Perillo BMW\n1035 N Clark St, Chicago, IL 60610","Elmhurst BMW\n466 W Lake St, Elmhurst, IL 60126",
                    "Laurel BMW of Westmont\n1245, 430 E Ogden Ave, Westmont, IL 60559"}),
            new Data(3,"Cadillac Escalade", R.drawable.cadillac_escalade_l, R.drawable.cadillac_escalade,"https://www.cadillac.com/crossovers-suvs/escalade-esv/build-and-price/trim", new String[]{"Cadillac of Naperville\n1507 Ogden Ave, Naperville, IL 60540","Zeigler Buick GMC Cadillac Lincolnwood\n6900 McCormick Blvd, Lincolnwood, IL 60712"
                    , "Hawk Cadillac of Joliet\n2001 W Jefferson St, Joliet, IL 60435"}),
            new Data(4,"Honda Piolt",R.drawable.honda_piolt_l, R.drawable.honda_piolt,"https://automobiles.honda.com/pilot", new String[]{"Honda of Downtown Chicago\n1111 N Clark St #2, Chicago, IL 60610",
                    "Honda Superstore of Lisle\n4475 Lincoln Ave, Lisle, IL 60532", "Valley Honda\n4173 Ogden Ave, Aurora, IL 60504"}),
            new Data(5,"Jeep Wrangler",R.drawable.jeep_wrangler_l, R.drawable.jeep_wrangler,"https://www.jeep.com/wrangler.html", new String[]{"Napleton's Northwestern Chrysler Jeep Dodge Ram\n5950 N Western Ave, Chicago, IL 60659",
                    "Naperville Chrysler Jeep Dodge Ram\n1565 Ogden Ave, Naperville, IL 60540", "Marino Chrysler Jeep Dodge\n5133 W Irving Park Rd, Chicago, IL 60641"}),
            new Data(6,"Mercedes-Benz S", R.drawable.mercedes_s_l, R.drawable.mercedes_s,"https://www.mbusa.com/mercedes/vehicles/class/class-S/bodystyle-SDN", new String[]{"Mercedes Benz\n401 N Michigan, Chicago, IL 60611",
                    "Mercedes-Benz of Chicago\n1520 W North Ave, Chicago, IL 60642", "Mercedes-Benz of Naperville\n1569 Ogden Ave, Naperville, IL 60540"}),
            new Data(7,"Subrau Ascent", R.drawable.subrau_sscent_l, R.drawable.subrau_sscent,"https://www.subaru.com/vehicles/ascent/index.html", new String[]{"Berman Subaru of Chicago\n4330 W Irving Park Rd, Chicago, IL 60641",
                    "Gerald Subaru of Naperville\n2379 Aurora Ave, Naperville, IL 60540", "Evanston Subaru in Skokie\n3340 Oakton St, Skokie, IL 60076"}),
            new Data(8,"Toyota Camry", R.drawable.toyota_camry_l, R.drawable.toyota_camry,"https://www.toyota.com/camryhybrid/", new String[]{"Grossinger City Toyota\n1561 N Fremont St, Chicago, IL 60642",
                    "Toyota of Naperville\n1488 Ogden Ave, Naperville, IL 60540", "Oakbrook Toyota\n550 E Ogden Ave, Westmont, IL 60559"}),
            new Data(9,"VW Touareg",R.drawable.vw_toureg_l, R.drawable.vw_toureg,"http://www.vw.com/builder/tab/trim/model/touareg/", new String[]{"Volkswagen of Downtown Chicago\n1111 N Clark St, Chicago, IL 60610",
                    "Pugi Volkswagen\n2020 Ogden Ave, Downers Grove, IL 60515", "Bill Jacobs Volkswagen\n2211 Aurora Ave, Naperville, IL 60540"}),
            new Data(10,"Infiniti Q60",R.drawable.infiniti_q60_l, R.drawable.infiniti_q60,"https://www.infinitiusa.com/vehicles/coupes/q60.html",new String[]{"Berman INFINITI Chicago\n640 N LaSalle Dr, Chicago, IL 60654",
                    "Infiniti of Clarendon Hills\n415 E Ogden Ave, Clarendon Hills, IL 60514","INFINITI of Naperville\n1550 West Ogden Avenue, Naperville, IL 60540\n" +
                    "\n"}),
            new Data(11,"Maserati Levante GTS", R.drawable.maserati_levante_l, R.drawable.maserati_levante,"https://www.maseratiusa.com/maserati/us/en/shopping-tools/Levante-gts?modelName=LV*",new String[]{
                    "MASERATI OF CHICAGO\n834 N Rush St, Chicago, IL 60611","Maserati of Naperville\n1540 Ogden Ave, Naperville, IL 60540","Zeigler Maserati\n210 W Golf Rd, Schaumburg, IL 60195"
                    })
    };
}
