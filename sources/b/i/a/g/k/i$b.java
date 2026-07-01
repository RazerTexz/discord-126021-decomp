package b.i.a.g.k;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.internal.TextWatcherAdapter;

/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$b extends TextWatcherAdapter {
    public final /* synthetic */ i j;

    public i$b(i iVar) {
        this.j = iVar;
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        try {
            if (TextUtils.isEmpty(editable)) {
                this.j.k.c(0);
            } else {
                this.j.k.c(Integer.parseInt(editable.toString()));
            }
        } catch (NumberFormatException unused) {
        }
    }
}
