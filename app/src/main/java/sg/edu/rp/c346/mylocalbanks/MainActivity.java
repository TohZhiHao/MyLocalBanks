package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
TextView dbs;
TextView ocbc;
TextView uob;
TextView website;
View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = findViewById(R.id.textViewDBS);
        ocbc = findViewById(R.id.textViewOCBC);
        uob = findViewById(R.id.textViewUOB);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        view = v;

        //menu.add(0,0,0,"Website");
        //menu.add(0,1,1,"Contact the bank");

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS ");
            ocbc.setText("OCBC");
            uob.setText("UOB");

            return true;
        }else if (id == R.id.chineseSelection) {
            dbs.setText("星展银行 ");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        }else  {
            uob.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


    public boolean onContextItemSelected(MenuItem item) {
        int num3 = 1800;
        if(view.getId() == R.id.textViewDBS){
            if(item.getItemId()==R.id.website) { //check whether the selected menu item ID is 0
        //code for action
        Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
        startActivity(intent);

        return true; //menu item successfully handled
    }
    else if(item.getItemId()==R.id.number) { //check if the selected menu item ID is 1
        //code for action
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ num3 +"11111"));
        startActivity(intentCall);

        return true;  //menu item successfully handled
    }
}else if(view.getId() == R.id.textViewOCBC){
            if(item.getItemId()==R.id.website) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==R.id.number) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ num3 +"3633333"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
    }
        else if(view.getId() == R.id.textViewUOB){
            if(item.getItemId()==R.id.website) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==R.id.number) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ num3 +"2222121"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}
