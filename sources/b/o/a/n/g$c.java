package b.o.a.n;

import b.o.a.l$a;

/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$c implements Runnable {
    public final /* synthetic */ l$a j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ g l;

    public g$c(g gVar, l$a l_a, boolean z2) {
        this.l = gVar;
        this.j = l_a;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.j.a(1, "takePicture:", "running. isTakingPicture:", Boolean.valueOf(this.l.W0()));
        if (this.l.W0()) {
            return;
        }
        g gVar = this.l;
        if (gVar.Q == b.o.a.m.i.VIDEO) {
            throw new IllegalStateException("Can't take hq pictures while in VIDEO mode");
        }
        l$a l_a = this.j;
        l_a.a = false;
        l_a.f1912b = gVar.C;
        l_a.e = gVar.P;
        l_a.g = gVar.B;
        gVar.Y0(l_a, this.k);
    }
}
