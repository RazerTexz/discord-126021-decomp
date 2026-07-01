package b.i.a.g.j;

import android.widget.EditText;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$d$a implements Runnable {
    public final /* synthetic */ EditText j;
    public final /* synthetic */ a$d k;

    public a$d$a(a$d a_d, EditText editText) {
        this.k = a_d;
        this.j = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.removeTextChangedListener(this.k.a.d);
    }
}
