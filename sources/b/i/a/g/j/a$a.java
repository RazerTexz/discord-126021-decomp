package b.i.a.g.j;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements TextWatcher {
    public final /* synthetic */ a j;

    public a$a(a aVar) {
        this.j = aVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@NonNull Editable editable) {
        if (this.j.a.getSuffixText() != null) {
            return;
        }
        this.j.d(editable.length() > 0);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
