package b.i.a.g.e;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: b.i.a.g.e.h, reason: use source file name */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButtonImpl5 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ FloatingActionButtonImpl3 j;

    public FloatingActionButtonImpl5(FloatingActionButtonImpl3 floatingActionButtonImpl3) {
        this.j = floatingActionButtonImpl3;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        FloatingActionButtonImpl3 floatingActionButtonImpl3 = this.j;
        float rotation = floatingActionButtonImpl3.F.getRotation();
        if (floatingActionButtonImpl3.f1618y == rotation) {
            return true;
        }
        floatingActionButtonImpl3.f1618y = rotation;
        floatingActionButtonImpl3.u();
        return true;
    }
}
