package p007b.p452o.p453a.p455n.p463v;

import p007b.p452o.p453a.p455n.AbstractC5135i;
import p007b.p452o.p453a.p455n.p463v.C5174a;
import p007b.p452o.p453a.p467r.C5206g;

/* JADX INFO: renamed from: b.o.a.n.v.b */
/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5175b implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C5174a f14016j;

    public RunnableC5175b(C5174a c5174a) {
        this.f14016j = c5174a;
    }

    @Override // java.lang.Runnable
    public void run() {
        C5174a.c<?> cVar;
        synchronized (this.f14016j.f14009e) {
            cVar = null;
            if (!this.f14016j.f14008d) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (C5174a.c<?> cVar2 : this.f14016j.f14007c) {
                    if (cVar2.f14015e <= jCurrentTimeMillis) {
                        cVar = cVar2;
                        break;
                    }
                }
                if (cVar != null) {
                    this.f14016j.f14008d = true;
                }
            }
        }
        if (cVar != null) {
            C5174a c5174a = this.f14016j;
            C5206g c5206g = AbstractC5135i.this.f13919k;
            c5206g.m7404c(new RunnableC5176c(c5174a, cVar, c5206g));
        }
    }
}
