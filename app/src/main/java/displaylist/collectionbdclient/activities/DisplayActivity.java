package displaylist.collectionbdclient.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
                ToastUtils.display(DisplayActivity.this, FileUtils.getBuildDate(DisplayActivity.this));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

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
