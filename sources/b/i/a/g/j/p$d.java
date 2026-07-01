package b.i.a.g.j;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.EditText;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$d implements View$OnClickListener {
    public final /* synthetic */ p j;

    public p$d(p pVar) {
        this.j = pVar;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        EditText editText = this.j.a.getEditText();
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (p.d(this.j)) {
            editText.setTransformationMethod(null);
        } else {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            editText.setSelection(selectionEnd);
        }
        this.j.a.refreshEndIconDrawableState();
    }
}
