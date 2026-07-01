package b.i.a.g.j;

import android.widget.AutoCompleteTextView$OnDismissListener;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class k implements AutoCompleteTextView$OnDismissListener {
    public final /* synthetic */ h a;

    public k(h hVar) {
        this.a = hVar;
    }

    @Override // android.widget.AutoCompleteTextView$OnDismissListener
    public void onDismiss() {
        h hVar = this.a;
        hVar.i = true;
        hVar.k = System.currentTimeMillis();
        h.f(this.a, false);
    }
}
