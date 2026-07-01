package b.o.a.n;

import b.o.a.l$a;

/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$d implements Runnable {
    public final /* synthetic */ l$a j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ g l;

    public g$d(g gVar, l$a l_a, boolean z2) {
        this.l = gVar;
        this.j = l_a;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.j.a(1, "takePictureSnapshot:", "running. isTakingPicture:", Boolean.valueOf(this.l.W0()));
        if (this.l.W0()) {
            return;
        }
        l$a l_a = this.j;
        g gVar = this.l;
        l_a.f1912b = gVar.C;
        l_a.a = true;
        l_a.e = gVar.P;
        l_a.g = b.o.a.m.j.JPEG;
        this.l.Z0(this.j, b.o.a.x.a.g(gVar.U0(b.o.a.n.t.b.OUTPUT)), this.k);
    }
}
