package com.example.castlebook;

import android.database.Cursor;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseHelper test = new DatabaseHelper(this);
    private ListView mListView1, mListView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        //Cursor res= test.getAllData();

        Cursor alldata = test.getAllData();
        if(alldata.getCount() == 0){
            System.out.println("RUNN");
            addBooks();
        }
        List<String> fiction = new ArrayList<String>();
        Cursor res = test.getData("Fiction");
        while(res.moveToNext()){
            fiction.add("Book name "+res.getString(1)+", Authors "+res.getString(2)+",Category "+res.getString(3)+",Link "+res.getString(4));

        }
        mListView1 = (ListView)findViewById(R.id.mListView1);

       mListView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fiction));
   //     mListView2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data2));

//        ListUtils.setDynamicHeight(mListView1);
//        ListUtils.setDynamicHeight(mListView2);
    }

    private void addBooks() {

        test.addData("Black Leopard, Red Wolf","Marlon James","Fiction","https://drive.google.com/uc?export=download&id=1SJZUzvxCM6JH7P11h7p3zfAUF8dbOzbz");
        test.addData("The Hate U Give", "Angie Thomas","Fiction", "https://drive.google.com/uc?export=download&id=1QwImzxWTjKk4RJx-2gpiNGIhJhu2YA24");
        test.addData("My Lovely Wife","Samantha Downing","Fiction", "https://drive.google.com/uc?export=download&id=1ZOEoVIbvqTXzUKI1Iw2x61yO6qQybh5q");
        test.addData("The Silent Patient","Alex Michaelides","Fiction", "https://drive.google.com/uc?export=download&id=1cQgpwCEoa6cT22YJrll-2R5Ab0c25YDa");
        test.addData("1984","George Orwell", "Science Fiction", "https://drive.google.com/uc?export=download&id=16X3DHBfhAs1uVSKhQXOXHWwUc6Tlrhl-");
        test.addData("Neuromancer","William Gibson", "Science Fiction" ,"https://drive.google.com/uc?export=download&id=1TZ2SJXf6Zhs0931BOT9maRmzr3g4Ric6");
        test.addData("The Left Hand of Darkness","Ursula K. Le Guin", "Science Fiction", "https://drive.google.com/uc?export=download&id=1mtJlh7iZCj1sxJENcJHb_AtfRP9kYcdH");
        test.addData("The Time Machine","H. G. Wells", "Science Fiction","https://drive.google.com/uc?export=download&id=1oR_NfezOBKi340e_XcqVuspx3_3rB6te");
        test.addData("Frankenstein","Mary Shelley", "Science Fiction","https://drive.google.com/uc?export=download&id=1hfY8XZJZKK_8uDHCFfT0oD8Tz5owQAOE");
        test.addData("The Forever War","Joe Haldeman", "Science Fiction","https://drive.google.com/uc?export=download&id=16DbT_CfJ6lD-_enajNgWUidqUgt102sZ");
        test.addData("Dracula","Bram Stoker","Horror Fiction","https://drive.google.com/uc?export=download&id=1VpzRMFqdGAzBSQovGIYqxrWgDBmI25lY");
        test.addData("The Haunting of Hill House","Shirley Jackson","Horror Fiction","https://drive.google.com/uc?export=download&id=1V1g6xZWBbni8lyOLauBVHZoOjd1y0xXM");
        test.addData("House of Leaves","Mark Z. Danielewski","Horror Fiction","https://drive.google.com/uc?export=download&id=1A1Oy906PCyy1gNIg7ZWsNB7EXMdA5hk1");
        test.addData("Pet Sematary","Stephen King","Horror Fiction","https://drive.google.com/uc?export=download&id=1fV2yJNMMgJxRdByMWg9osmrQEnEbTpHh");
        test.addData("The Shining","Stephen King","Horror Fiction","https://drive.google.com/uc?export=download&id=1Ojh5y8ZaPuMcAdeXEiNo11NN7n_E4hyj");
        test.addData("Carrie","Stephen King","Horror Fiction","https://drive.google.com/uc?export=download&id=1s_KnYft9JeMmEMoeRfaYB9Iot2yYa9nh");
        test.addData("In Cold Blood","Truman Capote","Crime Fiction", "https://drive.google.com/uc?export=download&id=1pyq6qhWC6xPiNAqU6vj-8zhqW9v3h_42");
        test.addData("The MoonStone","Wilkie Collins","Crime Fiction","https://drive.google.com/uc?export=download&id=1n54_S6DRpBEm8lLzJ7tgBQ4GoBfZs7LE");
        test.addData("The Big Sleep","Raymond Chandler","Crime Fiction","https://drive.google.com/uc?export=download&id=1gmnBO94lpgtGnrS2z_zg6e6uOzgxWB_y");
        test.addData("The Murders in the Rue Morgue","Edgar Allan Poe",",Crime Fiction","https://drive.google.com/uc?export=download&id=1c480fu6Wlkj9w8OxzaLPH5I1UMcxaL0o");
        test.addData("Murder on the Orient Express","Agatha Christie","Crime Fiction","https://drive.google.com/uc?export=download&id=1IXV7SElkcC-83b3IqpW-mqBSbaJvL68e");
        test.addData("The Talented Mr. Ripley","Patricia Highsmith","Crime Fiction", "https://drive.google.com/uc?export=download&id=1RfnSHQ-ygE_X45TNSuSNtnVXtOQ8Oysf");
        test.addData("The Lord of the Rings","J. R. R. Tolkien","Fantasy", "https://drive.google.com/uc?export=download&id=1UC4Jre_yXlCMzxpc_34sJ8NJq16gFPVP");
        test.addData("A Song of Ice and Fire","George R. R. Martin" ,"Fantasy","https://drive.google.com/uc?export=download&id=1dp0fWR4la6bXDe6W9EoEHEsw-3GJXAVs");
        test.addData("The Hobbit, or There and Back Again","J. R. R. Tolkien" ,"Fantasy","https://drive.google.com/uc?export=download&id=18OU05FUrZ837u2qA-IY1jjwSZxk8lH_n");
        test.addData("The Name of the Wind","Patrick Rothfuss ","Fantasy", "https://drive.google.com/uc?export=download&id=1Lqd_WueUNw6xvnGK5Ei8EYdR_08BCoZ_");
        test.addData("The Lies of Locke Lamora","Scott Lynch" ,"Fantasy","https://drive.google.com/uc?export=download&id=1uDGYw-4NIXfJBK2usBAa4D7-qZmL1ilz");
    }
    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_library) {

        } else if (id == R.id.nav_downloads) {

        } else if (id == R.id.nav_about) {

        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


