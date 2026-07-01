package b.i.a.g.j;

import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$OnEndIconChangedListener;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$d implements TextInputLayout$OnEndIconChangedListener {
    public final /* synthetic */ a a;

    public a$d(a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout$OnEndIconChangedListener
    public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
        EditText editText = textInputLayout.getEditText();
        if (editText == null || i != 2) {
            return;
        }
        editText.post(new a$d$a(this, editText));
        if (editText.getOnFocusChangeListener() == this.a.e) {
            editText.setOnFocusChangeListener(null);
        }
    }
}
