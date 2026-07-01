package b.o.a.n;

import android.graphics.PointF;
import android.hardware.Camera$Parameters;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a implements Runnable {
    public final /* synthetic */ b.o.a.t.b j;
    public final /* synthetic */ b.o.a.q.a k;
    public final /* synthetic */ PointF l;
    public final /* synthetic */ b m;

    public b$a(b bVar, b.o.a.t.b bVar2, b.o.a.q.a aVar, PointF pointF) {
        this.m = bVar;
        this.j = bVar2;
        this.k = aVar;
        this.l = pointF;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.m.p.o) {
            b bVar = this.m;
            b.o.a.n.s.a aVar = new b.o.a.n.s.a(bVar.L, bVar.o.l());
            b.o.a.t.b bVarC = this.j.c(aVar);
            Camera$Parameters parameters = this.m.f1914e0.getParameters();
            int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
            int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
            if (maxNumFocusAreas > 0) {
                parameters.setFocusAreas(bVarC.b(maxNumFocusAreas, aVar));
            }
            if (maxNumMeteringAreas > 0) {
                parameters.setMeteringAreas(bVarC.b(maxNumMeteringAreas, aVar));
            }
            parameters.setFocusMode("auto");
            this.m.f1914e0.setParameters(parameters);
            ((CameraView$b) this.m.m).e(this.k, this.l);
            this.m.n.e("focus end", 0);
            this.m.n.c("focus end", true, 2500L, new b$a$a(this));
            try {
                this.m.f1914e0.autoFocus(new b$a$b(this));
            } catch (RuntimeException e) {
                i.j.a(3, "startAutoFocus:", "Error calling autoFocus", e);
            }
        }
    }
}
