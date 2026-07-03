package p007b.p225i.p226a.p341g.p351j;

import android.widget.AutoCompleteTextView;

/* JADX INFO: renamed from: b.i.a.g.j.k */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4440k implements AutoCompleteTextView.OnDismissListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4437h f11817a;

    public C4440k(C4437h c4437h) {
        this.f11817a = c4437h;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        C4437h c4437h = this.f11817a;
        c4437h.f11796i = true;
        c4437h.f11798k = System.currentTimeMillis();
        C4437h.m6152f(this.f11817a, false);
    }
}
