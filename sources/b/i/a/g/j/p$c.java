package b.i.a.g.j;

import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$OnEndIconChangedListener;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$c implements TextInputLayout$OnEndIconChangedListener {
    public final /* synthetic */ p a;

    public p$c(p pVar) {
        this.a = pVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout$OnEndIconChangedListener
    public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
        EditText editText = textInputLayout.getEditText();
        if (editText == null || i != 1) {
            return;
        }
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editText.post(new p$c$a(this, editText));
    }
}
