package b.i.a.g.j;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.i.a.g.j.m, reason: use source file name */
/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EndIconDelegate {
    public TextInputLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f1626b;
    public CheckableImageButton c;

    public EndIconDelegate(@NonNull TextInputLayout textInputLayout) {
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
