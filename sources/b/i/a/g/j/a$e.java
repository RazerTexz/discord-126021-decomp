package b.i.a.g.j;

import android.text.Editable;
import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$e implements View$OnClickListener {
    public final /* synthetic */ a j;

    public a$e(a aVar) {
        this.j = aVar;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        Editable text = this.j.a.getEditText().getText();
        if (text != null) {
            text.clear();
        }
        this.j.a.refreshEndIconDrawableState();
    }
}
