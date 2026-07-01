package b.o.a.q;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector$SimpleOnScaleGestureListener;

/* JADX INFO: compiled from: PinchGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$a extends ScaleGestureDetector$SimpleOnScaleGestureListener {
    public final /* synthetic */ e a;

    public e$a(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.ScaleGestureDetector$SimpleOnScaleGestureListener, android.view.ScaleGestureDetector$OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        e eVar = this.a;
        eVar.e = true;
        eVar.f = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
        return true;
    }
}
