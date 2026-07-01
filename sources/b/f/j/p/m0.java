package b.f.j.p;

import android.util.Pair;
import java.util.List;

/* JADX INFO: compiled from: MultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class m0 extends e {
    public final /* synthetic */ Pair a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l0$b f625b;

    public m0(l0$b l0_b, Pair pair) {
        this.f625b = l0_b;
        this.a = pair;
    }

    @Override // b.f.j.p.y0
    public void a() {
        boolean zRemove;
        List<y0> list;
        d dVar;
        List<y0> listJ;
        List<y0> listL;
        synchronized (this.f625b) {
            zRemove = this.f625b.f623b.remove(this.a);
            list = null;
            if (!zRemove) {
                dVar = null;
            } else if (this.f625b.f623b.isEmpty()) {
                dVar = this.f625b.f;
            } else {
                List<y0> listK = this.f625b.k();
                listL = this.f625b.l();
                listJ = this.f625b.j();
                dVar = null;
                list = listK;
            }
            listL = null;
            listJ = null;
        }
        d.s(list);
        d.t(listL);
        d.r(listJ);
        if (dVar != null) {
            if (!this.f625b.h.c || dVar.k()) {
                dVar.u();
            } else {
                d.t(dVar.v(b.f.j.d.d.LOW));
            }
        }
        if (zRemove) {
            ((l) this.a.first).d();
        }
    }

    @Override // b.f.j.p.e, b.f.j.p.y0
    public void b() {
        d.r(this.f625b.j());
    }

    @Override // b.f.j.p.e, b.f.j.p.y0
    public void c() {
        d.t(this.f625b.l());
    }

    @Override // b.f.j.p.e, b.f.j.p.y0
    public void d() {
        d.s(this.f625b.k());
    }
}
