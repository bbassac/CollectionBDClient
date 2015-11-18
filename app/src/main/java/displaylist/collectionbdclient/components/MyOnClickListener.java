package displaylist.collectionbdclient.components;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.activities.DisplayActivity;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.Serie;
import displaylist.collectionbdclient.utils.SerieUtils;

/**
 * Created by b.bassac on 03/12/2014.
 */
public class MyOnClickListener implements View.OnClickListener {

	private DisplayActivity displayActivity;
	private  Collection codeLeanChapterList;
    private Context context;

	public MyOnClickListener(Context context,DisplayActivity displayActivity, Collection codeLeanChapterList) {
		this.displayActivity=displayActivity;
		this.codeLeanChapterList=codeLeanChapterList;
        this.context=context;
	}

	@Override
	public void onClick(View view) {
		final Dialog dialog = new Dialog(displayActivity);
		dialog.setContentView(R.layout.custom_dialog);
		String s_id =  String.valueOf(((TextView) view.findViewById(R.id.bd_id)).getText());
		Serie serie = SerieUtils.getBDById(codeLeanChapterList,Integer.valueOf(s_id));
		dialog.setTitle(R.string.details);

		// set the custom dialog components - textName, image and button
		((TextView) dialog.findViewById(R.id.dialog_name)).setText(serie.getNom());
		((TextView) dialog.findViewById(R.id.dialog_numero)).setText(SerieUtils.getStringPossede(serie));
		((TextView) dialog.findViewById(R.id.dialog_manquant)).setText(SerieUtils.getStringManquant(serie));
        ((ImageView) dialog.findViewById(R.id.dialog_fini)).setImageResource(SerieUtils.getResourceFini(serie));
        ((TextView) dialog.findViewById(R.id.dialog_editeur)).setText(serie.getEditeur());
		//Image
		ImageView image = (ImageView) dialog.findViewById(R.id.dialog_image);
		image.setImageBitmap(null);
		if(!TextUtils.isEmpty(serie.getImageUrl())) {
            Picasso.with(context).load("file:///android_asset/img/" + serie.getNom() + ".jpg").resize(100, 120).into(image);
		}


		dialog.show();
	}
}

