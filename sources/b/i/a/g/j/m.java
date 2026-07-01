package b.i.a.g.j;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m {
    public TextInputLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1626b;
    public CheckableImageButton c;

    public m(@NonNull TextInputLayout textInputLayout) {
        this.a = textInputLayout;
        this.f1626b = textInputLayout.getContext();
        this.c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int i) {
        return true;
    }

    public void c(boolean z2) {
    }
}
