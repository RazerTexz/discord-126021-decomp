package b.b.a.a;

import android.content.Context;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;

/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$d extends AppCompatDialog {
    public a$d(a aVar, Context context, int i) {
        super(context, i);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
    }
}
