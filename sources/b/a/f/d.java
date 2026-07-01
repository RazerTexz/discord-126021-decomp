package b.a.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import d0.z.d.m;

/* JADX INFO: compiled from: ChipsEditText.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public final class d extends AppCompatEditText {
    public final d$a j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, d$a d_a) {
        super(context);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(d_a, "mInputConnectionWrapperInterface");
        this.j = d_a;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        m.checkNotNullParameter(editorInfo, "outAttrs");
        return this.j.a(super.onCreateInputConnection(editorInfo));
    }
}
