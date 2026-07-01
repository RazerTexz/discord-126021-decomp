package b.i.a.g.j;

import android.text.TextUtils;
import android.view.View;
import android.view.View$OnFocusChangeListener;
import android.widget.EditText;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$b implements View$OnFocusChangeListener {
    public final /* synthetic */ a j;

    public a$b(a aVar) {
        this.j = aVar;
    }

    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view, boolean z2) {
        this.j.d((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z2);
    }
}
