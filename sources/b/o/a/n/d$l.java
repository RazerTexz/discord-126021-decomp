package b.o.a.n;

import android.graphics.PointF;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$l implements Runnable {
    public final /* synthetic */ b.o.a.q.a j;
    public final /* synthetic */ PointF k;
    public final /* synthetic */ b.o.a.t.b l;
    public final /* synthetic */ d m;

    public d$l(d dVar, b.o.a.q.a aVar, PointF pointF, b.o.a.t.b bVar) {
        this.m = dVar;
        this.j = aVar;
        this.k = pointF;
        this.l = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.m;
        if (dVar.p.o) {
            ((CameraView$b) dVar.m).e(this.j, this.k);
            b.o.a.n.r.g gVarP1 = this.m.p1(this.l);
            b.o.a.n.o.i iVar = new b.o.a.n.o.i(5000L, gVarP1);
            iVar.e(this.m);
            iVar.f(new d$l$a(this, gVarP1));
        }
    }
}
