package b.i.a.g.j;

import android.text.Editable;
import android.widget.AutoCompleteTextView;
import com.google.android.material.internal.TextWatcherAdapter;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$a extends TextWatcherAdapter {
    public final /* synthetic */ h j;

    public h$a(h hVar) {
        this.j = hVar;
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        AutoCompleteTextView autoCompleteTextViewD = h.d(this.j.a.getEditText());
        if (this.j.n.isTouchExplorationEnabled() && h.e(autoCompleteTextViewD) && !this.j.c.hasFocus()) {
            autoCompleteTextViewD.dismissDropDown();
        }
        autoCompleteTextViewD.post(new h$a$a(this, autoCompleteTextViewD));
    }
}
