package b.i.a.g.k;

import android.view.ViewTreeObserver$OnPreDrawListener;
import com.google.android.material.timepicker.ClockFaceView;
import com.google.android.material.timepicker.ClockHandView;

/* JADX INFO: compiled from: ClockFaceView.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements ViewTreeObserver$OnPreDrawListener {
    public final /* synthetic */ ClockFaceView j;

    public b(ClockFaceView clockFaceView) {
        this.j = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        if (!this.j.isShown()) {
            return true;
        }
        this.j.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = this.j.getHeight() / 2;
        ClockFaceView clockFaceView = this.j;
        int i = (height - clockFaceView.m.r) - clockFaceView.t;
        if (i != clockFaceView.k) {
            clockFaceView.k = i;
            clockFaceView.a();
            ClockHandView clockHandView = clockFaceView.m;
            clockHandView.A = clockFaceView.k;
            clockHandView.invalidate();
        }
        return true;
    }
}
