package b.i.a.g.j;

import android.view.View;
import android.view.View$OnFocusChangeListener;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$b implements View$OnFocusChangeListener {
    public final /* synthetic */ h j;

    public h$b(h hVar) {
        this.j = hVar;
    }

    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view, boolean z2) {
        this.j.a.setEndIconActivated(z2);
        if (z2) {
            return;
        }
        h.f(this.j, false);
        this.j.i = false;
    }
}
