package androidx.appcompat.widget;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar$3 implements View$OnClickListener {
    public final /* synthetic */ Toolbar this$0;

    public Toolbar$3(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        this.this$0.collapseActionView();
    }
}
