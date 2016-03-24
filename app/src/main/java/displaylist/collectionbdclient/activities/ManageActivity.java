package displaylist.collectionbdclient.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperToast;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.adapter.ManageBDAdapter;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.utils.CollectionProvider;
import displaylist.collectionbdclient.utils.ToastUtils;

public class ManageActivity extends Activity {

    Collection listBD;

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
            listView = (ListView) findViewById(R.id.list);
            listView.setAdapter(adapter);
        }
    }
}
