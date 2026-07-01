package b.i.a.g.j;

import com.google.android.material.internal.TextWatcherAdapter;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$a extends TextWatcherAdapter {
    public final /* synthetic */ p j;

    public p$a(p pVar) {
        this.j = pVar;
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        p pVar = this.j;
        pVar.c.setChecked(!p.d(pVar));
    }
}
