package b.i.a.g.j;

import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$a$a implements Runnable {
    public final /* synthetic */ AutoCompleteTextView j;
    public final /* synthetic */ h$a k;

    public h$a$a(h$a h_a, AutoCompleteTextView autoCompleteTextView) {
        this.k = h_a;
        this.j = autoCompleteTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zIsPopupShowing = this.j.isPopupShowing();
        h.f(this.k.j, zIsPopupShowing);
        this.k.j.i = zIsPopupShowing;
    }
}
