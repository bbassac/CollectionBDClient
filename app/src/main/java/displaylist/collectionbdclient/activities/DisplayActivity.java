package displaylist.collectionbdclient.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;

import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperToast;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import displaylist.collectionbdclient.components.ClearEventClick;
import displaylist.collectionbdclient.components.CustomEditText;
import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.adapter.ListBDAdapter;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.utils.CollectionProvider;
import displaylist.collectionbdclient.utils.ToastUtils;

public class DisplayActivity extends Activity {

    ListView list;
    Collection listBD;
    CustomEditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display);
        new JSONParseTask().execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
               displayBuildDate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void displayBuildDate() {
        AlertDialog alertDialog = new AlertDialog.Builder(DisplayActivity.this).create();
        alertDialog.setTitle("Version");
        alertDialog.setMessage(getBuildDate());
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public String getBuildDate(){
        String s = "";
        try{
            ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), 0);
            ZipFile zf = new ZipFile(ai.sourceDir);
            ZipEntry ze = zf.getEntry("META-INF/MANIFEST.MF");
            long time = ze.getTime();
            SimpleDateFormat formatter = (SimpleDateFormat) SimpleDateFormat.getInstance();
            formatter.setTimeZone(TimeZone.getTimeZone("gmt"));
            s = formatter.format(new java.util.Date(time));
            zf.close();
        }catch(Exception e){
        }
        return s;
    }

    private class JSONParseTask extends AsyncTask<String, String, Collection> {
        SuperActivityToast superActivityToast;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            superActivityToast = new SuperActivityToast(DisplayActivity.this, SuperToast.Type.PROGRESS);
            superActivityToast.setText("Loading");
            superActivityToast.setBackground(SuperToast.Background.GREEN);
            superActivityToast.setTextColor(SuperToast.Background.BLACK);
            superActivityToast.setIndeterminate(true);
            superActivityToast.setProgressIndeterminate(true);
            superActivityToast.show();

        }

        @Override
        protected Collection doInBackground(String... args) {

            listBD = CollectionProvider.getEntireCollection(DisplayActivity.this);
            return listBD;
        }

        @Override
        protected void onPostExecute(Collection json) {

            superActivityToast.dismiss();
            ToastUtils.display(DisplayActivity.this, "Data Loaded");
            try {
                final ListBDAdapter adapter = new ListBDAdapter(getApplicationContext(), listBD, DisplayActivity.this);
                list = (ListView) findViewById(R.id.list);
                list.setAdapter(adapter);
                inputSearch = (CustomEditText) findViewById(R.id.search);
                inputSearch.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                        // When user changed the Text
                        adapter.getFilter().filter(cs);
                    }

                    @Override
                    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    }

                    @Override
                    public void afterTextChanged(Editable arg0) {
                    }
                });


                inputSearch.setOnClearEventListener(new ClearEventClick() {
                    @Override
                    public void clear() {
                        inputSearch.setText(null);
                        adapter.getFilter().filter(null);
                    }
                });

            } catch (Exception e) {
                ToastUtils.display(DisplayActivity.this, e.getMessage());
            }
        }
    }
}
