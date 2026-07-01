package b.i.a.g.j;

import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$OnEditTextAttachedListener;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$c implements TextInputLayout$OnEditTextAttachedListener {
    public final /* synthetic */ a a;

    public a$c(a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001c  */
    @Override // com.google.android.material.textfield.TextInputLayout$OnEditTextAttachedListener
    public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
        boolean z2;
        EditText editText = textInputLayout.getEditText();
        if (editText.hasFocus()) {
            z2 = editText.getText().length() > 0;
        }
        textInputLayout.setEndIconVisible(z2);
        textInputLayout.setEndIconCheckable(false);
        editText.setOnFocusChangeListener(this.a.e);
        editText.removeTextChangedListener(this.a.d);
        editText.addTextChangedListener(this.a.d);
    }
}
