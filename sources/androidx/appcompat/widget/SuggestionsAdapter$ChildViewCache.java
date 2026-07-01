package androidx.appcompat.widget;

import android.R$id;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class SuggestionsAdapter$ChildViewCache {
    public final ImageView mIcon1;
    public final ImageView mIcon2;
    public final ImageView mIconRefine;
    public final TextView mText1;
    public final TextView mText2;

    public SuggestionsAdapter$ChildViewCache(View view) {
        this.mText1 = (TextView) view.findViewById(R$id.text1);
        this.mText2 = (TextView) view.findViewById(R$id.text2);
        this.mIcon1 = (ImageView) view.findViewById(R$id.icon1);
        this.mIcon2 = (ImageView) view.findViewById(R$id.icon2);
        this.mIconRefine = (ImageView) view.findViewById(androidx.appcompat.R$id.edit_query);
    }
}
