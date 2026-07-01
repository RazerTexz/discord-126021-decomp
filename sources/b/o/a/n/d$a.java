package b.o.a.n;

import android.hardware.camera2.CameraAccessException;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a implements Runnable {
    public final /* synthetic */ b.o.a.m.f j;
    public final /* synthetic */ b.o.a.m.f k;
    public final /* synthetic */ d l;

    public d$a(d dVar, b.o.a.m.f fVar, b.o.a.m.f fVar2) {
        this.l = dVar;
        this.j = fVar;
        this.k = fVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.l;
        boolean zH1 = dVar.h1(dVar.f1921i0, this.j);
        d dVar2 = this.l;
        if (!(dVar2.n.f == b.o.a.n.v.e.PREVIEW)) {
            if (zH1) {
                dVar2.k1();
                return;
            }
            return;
        }
        dVar2.w = b.o.a.m.f.OFF;
        dVar2.h1(dVar2.f1921i0, this.j);
        try {
            d dVar3 = this.l;
            dVar3.f1920h0.capture(dVar3.f1921i0.build(), null, null);
            d dVar4 = this.l;
            dVar4.w = this.k;
            dVar4.h1(dVar4.f1921i0, this.j);
            this.l.k1();
        } catch (CameraAccessException e) {
            throw this.l.o1(e);
        }
    }
}
