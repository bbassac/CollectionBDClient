package displaylist.collectionbdclient.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ListView;

import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperToast;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.adapter.ManageBDAdapter;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.components.ClearEventClick;
import displaylist.collectionbdclient.components.CustomEditText;
import displaylist.collectionbdclient.utils.CollectionProvider;
import displaylist.collectionbdclient.utils.ToastUtils;

public class ManageActivity extends Activity {

    Collection listBD;
    CustomEditText inputSearch;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        new JSONParseTask().execute();
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

    private class JSONParseTask extends AsyncTask<String, String, Collection> {
        SuperActivityToast superActivityToast;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            superActivityToast = ToastUtils.create(ManageActivity.this,"Loading ...");
        }

        @Override
        protected Collection doInBackground(String... args) {
            listBD = CollectionProvider.getEntireCollection(ManageActivity.this);
            return listBD;
        }

        @Override
        protected void onPostExecute(Collection json) {
            superActivityToast.dismiss();
            ToastUtils.display(ManageActivity.this, "Data Loaded");
            final ManageBDAdapter adapter = new ManageBDAdapter(getApplicationContext(), listBD, ManageActivity.this);
            listView = (ListView) findViewById(R.id.manage_list);
            listView.setAdapter(adapter);
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
        }

    }
}
