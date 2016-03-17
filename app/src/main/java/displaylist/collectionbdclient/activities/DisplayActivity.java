package displaylist.collectionbdclient.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperToast;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.adapter.ListBDAdapter;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.components.ClearEventClick;
import displaylist.collectionbdclient.components.CustomEditText;
import displaylist.collectionbdclient.utils.CollectionProvider;
import displaylist.collectionbdclient.utils.FileUtils;
import displaylist.collectionbdclient.utils.ToastUtils;

public class DisplayActivity extends Activity {

    private static final int TEXT_ID = 0;
    ListView list;
    Collection listBD;
    CustomEditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display);
        createPreferenceIfNotExists();
        new JSONParseTask().execute();
    }

    private void createPreferenceIfNotExists() {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(DisplayActivity.this);
        String url = settings.getString("collectionServerUrl", null);
        Log.i("","Preference loaded : " + url);
        if (url == null) {
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("collectionServerUrl", "http://lioncorps.free.fr/listing");
            Log.i("","created default url: ");
            editor.apply();
        }
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
                ToastUtils.display(DisplayActivity.this, FileUtils.getBuildDate(DisplayActivity.this));
                return true;
            case R.id.menu_settings:
                createExampleDialog(DisplayActivity.this).show();
                return true;

            case R.id.menu_refresh:
                new JSONParseTask().execute();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * Create and return an example alert dialog with an edit text box.
     */
    private Dialog createExampleDialog(final Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Settings");
        builder.setMessage("Server URL:");

        // Use an EditText view to get user input.
        final EditText input = new EditText(activity);
        input.setId(TEXT_ID);
        builder.setView(input);

        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String url = defaultSharedPreferences.getString("collectionServerUrl", null);
        input.setText(url);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString();
                SharedPreferences.Editor editor = defaultSharedPreferences.edit();
                editor.putString("collectionServerUrl", value);
                editor.apply();
                return;
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                return;
            }
        });

        return builder.create();
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
