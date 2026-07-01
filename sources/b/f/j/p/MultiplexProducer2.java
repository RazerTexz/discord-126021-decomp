package b.f.j.p;

import android.util.Pair;
import b.f.j.d.Priority2;
import b.f.j.p.MultiplexProducer;
import java.util.List;

/* JADX INFO: renamed from: b.f.j.p.m0, reason: use source file name */
/* JADX INFO: compiled from: MultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class MultiplexProducer2 extends BaseProducerContextCallbacks {
    public final /* synthetic */ Pair a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MultiplexProducer.b f625b;

    public MultiplexProducer2(MultiplexProducer.b bVar, Pair pair) {
        this.f625b = bVar;
        this.a = pair;
    }

    @Override // b.f.j.p.ProducerContextCallbacks
    public void a() {
        boolean zRemove;
        List<ProducerContextCallbacks> list;
        BaseProducerContext baseProducerContext;
        List<ProducerContextCallbacks> listJ;
        List<ProducerContextCallbacks> listL;
        synchronized (this.f625b) {
            zRemove = this.f625b.f623b.remove(this.a);
            list = null;
            if (!zRemove) {
                baseProducerContext = null;
            } else if (this.f625b.f623b.isEmpty()) {
                baseProducerContext = this.f625b.f;
            } else {
                List<ProducerContextCallbacks> listK = this.f625b.k();
                listL = this.f625b.l();
                listJ = this.f625b.j();
                baseProducerContext = null;
                list = listK;
            }
            listL = null;
            listJ = null;
        }
        BaseProducerContext.s(list);
        BaseProducerContext.t(listL);
        BaseProducerContext.r(listJ);
        if (baseProducerContext != null) {
            if (!MultiplexProducer.this.c || baseProducerContext.k()) {
                baseProducerContext.u();
            } else {
                BaseProducerContext.t(baseProducerContext.v(Priority2.LOW));
            }
        }
        if (zRemove) {
            ((Consumer2) this.a.first).d();
        }
    }

    @Override // b.f.j.p.BaseProducerContextCallbacks, b.f.j.p.ProducerContextCallbacks
    public void b() {
        BaseProducerContext.r(this.f625b.j());
    }

    @Override // b.f.j.p.BaseProducerContextCallbacks, b.f.j.p.ProducerContextCallbacks
    public void c() {
        BaseProducerContext.t(this.f625b.l());
    }

    @Override // b.f.j.p.BaseProducerContextCallbacks, b.f.j.p.ProducerContextCallbacks
    public void d() {
        BaseProducerContext.s(this.f625b.k());
    }
}
