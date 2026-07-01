package b.o.a.n;

import android.graphics.PointF;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$e implements Runnable {
    public final /* synthetic */ float j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ float l;
    public final /* synthetic */ PointF[] m;
    public final /* synthetic */ d n;

    public d$e(d dVar, float f, boolean z2, float f2, PointF[] pointFArr) {
        this.n = dVar;
        this.j = f;
        this.k = z2;
        this.l = f2;
        this.m = pointFArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.n;
        if (dVar.n1(dVar.f1921i0, this.j)) {
            this.n.k1();
            if (this.k) {
                ((CameraView$b) this.n.m).f(this.l, this.m);
            }
        }
    }
}
