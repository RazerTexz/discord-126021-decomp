package b.o.a.n;

import android.graphics.PointF;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$f implements Runnable {
    public final /* synthetic */ float j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ float l;
    public final /* synthetic */ float[] m;
    public final /* synthetic */ PointF[] n;
    public final /* synthetic */ d o;

    public d$f(d dVar, float f, boolean z2, float f2, float[] fArr, PointF[] pointFArr) {
        this.o = dVar;
        this.j = f;
        this.k = z2;
        this.l = f2;
        this.m = fArr;
        this.n = pointFArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.o;
        if (dVar.g1(dVar.f1921i0, this.j)) {
            this.o.k1();
            if (this.k) {
                ((CameraView$b) this.o.m).c(this.l, this.m, this.n);
            }
        }
    }
}
