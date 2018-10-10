package com.lhengi.project2;

import android.content.Context;
import android.content.Intent;
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
        gridview.setAdapter( new ImageAdapter(this,data));

        gridview.setOnItemClickListener(shortClick);

        registerForContextMenu(gridview);
        currentContextSelect = 0;




    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);


    }

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

    public void startBigPicture(int position)
    {
        Intent intent = new Intent(getBaseContext(),Magnify.class);
        intent.putExtra("imgResource",data[position].imgResource);
        intent.putExtra("url",data[position].officialSite);
        startActivity(intent);

    }


    public AdapterView.OnItemClickListener shortClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getBaseContext(), "Reason can not be blank", Toast.LENGTH_SHORT).show();

            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&   Clicked!!!!!!!!!!!!!!!!    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            startBigPicture(position);

        }
    };


    //Data(int postion, String name, int imgResource,String officialSite, String[] dealers)

    private Data[] data = {
            new Data(0,"Tesla Model 3", R.drawable.tesla3,"https://tesla.com", new String[]{"Tesla\n1053 W Grand Ave, Chicago, IL 60642","Tesla Gallery\n" +
                    "901 N Rush St, Chicago, IL 60611", "Tesla\n" +
                    "58 Oakbrook Center, Oak Brook, IL 60523"}),
            new Data(1,"Tesla Model X", R.drawable.tesla_x,"https://tesla.com", new String[]{"Tesla\n1053 W Grand Ave, Chicago, IL 60642","Tesla Gallery\n" +
                    "901 N Rush St, Chicago, IL 60611", "Tesla\n" +
                    "58 Oakbrook Center, Oak Brook, IL 60523"}),
            new Data(2,"BMW i8", R.drawable.bmw_i8,"https://www.bmwusa.com", new String[]{"Perillo BMW\n1035 N Clark St, Chicago, IL 60610","Elmhurst BMW\n466 W Lake St, Elmhurst, IL 60126",
                    "Laurel BMW of Westmont\n1245, 430 E Ogden Ave, Westmont, IL 60559"}),
            new Data(3,"Cadillac Escalade", R.drawable.cadillac_escalade,"https://www.cadillac.com", new String[]{"Cadillac of Naperville\n1507 Ogden Ave, Naperville, IL 60540","Zeigler Buick GMC Cadillac Lincolnwood\n6900 McCormick Blvd, Lincolnwood, IL 60712"
                    , "Hawk Cadillac of Joliet\n2001 W Jefferson St, Joliet, IL 60435"}),
            new Data(4,"Honda Piolt", R.drawable.honda_piolt,"https://www.honda.com", new String[]{"Honda of Downtown Chicago\n1111 N Clark St #2, Chicago, IL 60610",
                    "Honda Superstore of Lisle\n4475 Lincoln Ave, Lisle, IL 60532", "Valley Honda\n4173 Ogden Ave, Aurora, IL 60504"}),
            new Data(5,"Jeep Wrangler", R.drawable.jeep_wrangler,"https://www.jeep.com", new String[]{"Napleton's Northwestern Chrysler Jeep Dodge Ram\n5950 N Western Ave, Chicago, IL 60659",
                    "Naperville Chrysler Jeep Dodge Ram\n1565 Ogden Ave, Naperville, IL 60540", "Marino Chrysler Jeep Dodge\n5133 W Irving Park Rd, Chicago, IL 60641"}),
            new Data(6,"Mercedes-Benz S", R.drawable.mercedes_s,"https://www.mbusa.com/en/home", new String[]{"Mercedes Benz\n401 N Michigan, Chicago, IL 60611",
                    "Mercedes-Benz of Chicago\n1520 W North Ave, Chicago, IL 60642", "Mercedes-Benz of Naperville\n1569 Ogden Ave, Naperville, IL 60540"}),
            new Data(7,"Subrau Ascent", R.drawable.subrau_sscent,"https://www.subaru.com", new String[]{"Berman Subaru of Chicago\n4330 W Irving Park Rd, Chicago, IL 60641",
                    "Gerald Subaru of Naperville\n2379 Aurora Ave, Naperville, IL 60540", "Evanston Subaru in Skokie\n3340 Oakton St, Skokie, IL 60076"}),
            new Data(8,"Toyota Camry", R.drawable.toyota_camry,"https://www.toyota.com", new String[]{"Grossinger City Toyota\n1561 N Fremont St, Chicago, IL 60642",
                    "Toyota of Naperville\n1488 Ogden Ave, Naperville, IL 60540", "Oakbrook Toyota\n550 E Ogden Ave, Westmont, IL 60559"}),
            new Data(9,"VW Toureg", R.drawable.vw_toureg,"http://www.vw.com", new String[]{"Volkswagen of Downtown Chicago\n1111 N Clark St, Chicago, IL 60610",
                    "Pugi Volkswagen\n2020 Ogden Ave, Downers Grove, IL 60515", "Bill Jacobs Volkswagen\n2211 Aurora Ave, Naperville, IL 60540"}),

    };
}
