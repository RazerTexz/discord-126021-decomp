package b.i.a.g.j;

import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$OnEndIconChangedListener;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$e implements TextInputLayout$OnEndIconChangedListener {
    public final /* synthetic */ h a;

    public h$e(h hVar) {
        this.a = hVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout$OnEndIconChangedListener
    public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
        if (autoCompleteTextView == null || i != 3) {
            return;
        }
        autoCompleteTextView.post(new h$e$a(this, autoCompleteTextView));
        if (autoCompleteTextView.getOnFocusChangeListener() == this.a.e) {
            autoCompleteTextView.setOnFocusChangeListener(null);
        }
        autoCompleteTextView.setOnTouchListener(null);
        autoCompleteTextView.setOnDismissListener(null);
    }
}
