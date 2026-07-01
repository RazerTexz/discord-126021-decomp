package b.i.a.g.j;

import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$OnEditTextAttachedListener;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$b implements TextInputLayout$OnEditTextAttachedListener {
    public final /* synthetic */ p a;

    public p$b(p pVar) {
        this.a = pVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout$OnEditTextAttachedListener
    public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
        EditText editText = textInputLayout.getEditText();
        textInputLayout.setEndIconVisible(true);
        textInputLayout.setEndIconCheckable(true);
        p pVar = this.a;
        pVar.c.setChecked(!p.d(pVar));
        editText.removeTextChangedListener(this.a.d);
        editText.addTextChangedListener(this.a.d);
    }
}
