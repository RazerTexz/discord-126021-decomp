package b.o.a.n;

import android.graphics.PointF;
import android.hardware.Camera$Parameters;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$f implements Runnable {
    public final /* synthetic */ float j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ PointF[] l;
    public final /* synthetic */ b m;

    public b$f(b bVar, float f, boolean z2, PointF[] pointFArr) {
        this.m = bVar;
        this.j = f;
        this.k = z2;
        this.l = pointFArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        Camera$Parameters parameters = this.m.f1914e0.getParameters();
        if (this.m.k1(parameters, this.j)) {
            this.m.f1914e0.setParameters(parameters);
            if (this.k) {
                b bVar = this.m;
                ((CameraView$b) bVar.m).f(bVar.D, this.l);
            }
        }
    }
}
