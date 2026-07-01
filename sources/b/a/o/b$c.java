package b.a.o;

import android.view.View;
import android.view.ViewTreeObserver$OnScrollChangedListener;

/* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b$c implements ViewTreeObserver$OnScrollChangedListener {
    public final /* synthetic */ b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f252b;

    public b$c(b bVar, View view) {
        this.a = bVar;
        this.f252b = view;
    }

    @Override // android.view.ViewTreeObserver$OnScrollChangedListener
    public final void onScrollChanged() {
        b bVar = this.a;
        View view = this.f252b;
        bVar.onLayoutChange(view, view.getLeft(), this.f252b.getTop(), this.f252b.getRight(), this.f252b.getBottom(), 0, 0, 0, 0);
    }
}
