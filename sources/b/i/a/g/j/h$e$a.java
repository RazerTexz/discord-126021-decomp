package b.i.a.g.j;

import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$e$a implements Runnable {
    public final /* synthetic */ AutoCompleteTextView j;
    public final /* synthetic */ h$e k;

    public h$e$a(h$e h_e, AutoCompleteTextView autoCompleteTextView) {
        this.k = h_e;
        this.j = autoCompleteTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.removeTextChangedListener(this.k.a.d);
    }
}
