package b.o.a.q;

import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: ScrollGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$a extends GestureDetector$SimpleOnGestureListener {
    public final /* synthetic */ c$a j;
    public final /* synthetic */ f k;

    public f$a(f fVar, c$a c_a) {
        this.k = fVar;
        this.j = c_a;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0064  */
    /* JADX WARN: Code duplicated, block: B:16:0x0070  */
    /* JADX WARN: Code duplicated, block: B:17:0x0072  */
    /* JADX WARN: Code duplicated, block: B:21:0x0078  */
    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z2;
        a aVar = a.m;
        boolean z3 = false;
        f.d.a(1, "onScroll:", "distanceX=" + f, "distanceY=" + f2);
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        if (motionEvent.getX() == this.k.c[0].x) {
            float y2 = motionEvent.getY();
            f fVar = this.k;
            if (y2 != fVar.c[0].y) {
                if (Math.abs(f) >= Math.abs(f2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                f fVar2 = this.k;
                if (!z2) {
                    aVar = a.n;
                }
                fVar2.f1947b = aVar;
                fVar2.c[0].set(motionEvent.getX(), motionEvent.getY());
                z3 = z2;
            } else if (fVar.f1947b == aVar) {
                z3 = true;
            }
        } else {
            if (Math.abs(f) >= Math.abs(f2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            f fVar3 = this.k;
            if (!z2) {
                aVar = a.n;
            }
            fVar3.f1947b = aVar;
            fVar3.c[0].set(motionEvent.getX(), motionEvent.getY());
            z3 = z2;
        }
        this.k.c[1].set(motionEvent2.getX(), motionEvent2.getY());
        this.k.g = z3 ? f / ((CameraView$b) this.j).c.getWidth() : f2 / ((CameraView$b) this.j).c.getHeight();
        f fVar4 = this.k;
        fVar4.g = z3 ? -fVar4.g : fVar4.g;
        fVar4.f = true;
        return true;
    }
}
