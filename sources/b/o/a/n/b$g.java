package b.o.a.n;

import android.graphics.PointF;
import android.hardware.Camera$Parameters;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$g implements Runnable {
    public final /* synthetic */ float j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ float[] l;
    public final /* synthetic */ PointF[] m;
    public final /* synthetic */ b n;

    public b$g(b bVar, float f, boolean z2, float[] fArr, PointF[] pointFArr) {
        this.n = bVar;
        this.j = f;
        this.k = z2;
        this.l = fArr;
        this.m = pointFArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        Camera$Parameters parameters = this.n.f1914e0.getParameters();
        if (this.n.d1(parameters, this.j)) {
            this.n.f1914e0.setParameters(parameters);
            if (this.k) {
                b bVar = this.n;
                ((CameraView$b) bVar.m).c(bVar.E, this.l, this.m);
            }
        }
    }
}
