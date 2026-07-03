package p007b.p225i.p226a.p341g.p346e;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: b.i.a.g.e.h */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewTreeObserverOnPreDrawListenerC4410h implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4408f f11699j;

    public ViewTreeObserverOnPreDrawListenerC4410h(C4408f c4408f) {
        this.f11699j = c4408f;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        C4408f c4408f = this.f11699j;
        float rotation = c4408f.f11664F.getRotation();
        if (c4408f.f11688y == rotation) {
            return true;
        }
        c4408f.f11688y = rotation;
        c4408f.mo6105u();
        return true;
    }
}
