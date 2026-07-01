package androidx.preference;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes.dex */
public class Preference$1 implements View$OnClickListener {
    public final /* synthetic */ Preference this$0;

    public Preference$1(Preference preference) {
        this.this$0 = preference;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.this$0.performClick(view);
    }
}
