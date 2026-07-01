package b.i.a.g.e;

import android.view.ViewTreeObserver$OnPreDrawListener;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements ViewTreeObserver$OnPreDrawListener {
    public final /* synthetic */ f j;

    public h(f fVar) {
        this.j = fVar;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        f fVar = this.j;
        float rotation = fVar.F.getRotation();
        if (fVar.f1618y == rotation) {
            return true;
        }
        fVar.f1618y = rotation;
        fVar.u();
        return true;
    }
}
