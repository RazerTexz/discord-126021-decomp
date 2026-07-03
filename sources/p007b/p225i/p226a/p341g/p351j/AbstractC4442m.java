package p007b.p225i.p226a.p341g.p351j;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.i.a.g.j.m */
/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4442m {

    /* JADX INFO: renamed from: a */
    public TextInputLayout f11819a;

    /* JADX INFO: renamed from: b */
    public Context f11820b;

    /* JADX INFO: renamed from: c */
    public CheckableImageButton f11821c;

    public AbstractC4442m(@NonNull TextInputLayout textInputLayout) {
        this.f11819a = textInputLayout;
        this.f11820b = textInputLayout.getContext();
        this.f11821c = textInputLayout.getEndIconView();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo6146a();

    /* JADX INFO: renamed from: b */
    public boolean mo6154b(int i) {
        return true;
    }

    /* JADX INFO: renamed from: c */
    public void mo6147c(boolean z2) {
    }
}
