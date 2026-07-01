package b.a.j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnPreDrawListener;
import d0.z.d.m;

/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$a {
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f244b;
    public final ViewTreeObserver$OnPreDrawListener c;

    public a$a(View view, ViewGroup viewGroup, ViewTreeObserver$OnPreDrawListener viewTreeObserver$OnPreDrawListener) {
        m.checkNotNullParameter(view, "floatingView");
        m.checkNotNullParameter(viewGroup, "ancestorViewGroup");
        m.checkNotNullParameter(viewTreeObserver$OnPreDrawListener, "ancestorPreDrawListener");
        this.a = view;
        this.f244b = viewGroup;
        this.c = viewTreeObserver$OnPreDrawListener;
    }
}
