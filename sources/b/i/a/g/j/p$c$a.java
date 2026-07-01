package b.i.a.g.j;

import android.widget.EditText;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$c$a implements Runnable {
    public final /* synthetic */ EditText j;
    public final /* synthetic */ p$c k;

    public p$c$a(p$c p_c, EditText editText) {
        this.k = p_c;
        this.j = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.removeTextChangedListener(this.k.a.d);
    }
}
