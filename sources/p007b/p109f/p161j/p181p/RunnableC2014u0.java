package p007b.p109f.p161j.p181p;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p007b.p109f.p161j.p181p.C2012t0;

/* JADX INFO: renamed from: b.f.j.p.u0 */
/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC2014u0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C2012t0.b f4237j;

    public RunnableC2014u0(C2012t0.b bVar) {
        this.f4237j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CloseableReference<AbstractC1917c> closeableReference;
        int i;
        boolean zM1522s;
        synchronized (this.f4237j) {
            C2012t0.b bVar = this.f4237j;
            closeableReference = bVar.f4228g;
            i = bVar.f4229h;
            bVar.f4228g = null;
            bVar.f4230i = false;
        }
        if (CloseableReference.m8640y(closeableReference)) {
            try {
                C2012t0.b.m1517n(this.f4237j, closeableReference, i);
                closeableReference.close();
            } catch (Throwable th) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th;
            }
        }
        C2012t0.b bVar2 = this.f4237j;
        synchronized (bVar2) {
            bVar2.f4231j = false;
            zM1522s = bVar2.m1522s();
        }
        if (zM1522s) {
            C2012t0.this.f4223c.execute(new RunnableC2014u0(bVar2));
        }
    }
}
