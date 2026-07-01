package b.m.a.g.d;

import com.lyft.kronos.internal.ntp.NTPSyncException;
import d0.z.d.m;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SntpService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$c implements Runnable {
    public final /* synthetic */ i j;

    public i$c(i iVar) {
        this.j = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        i iVar = this.j;
        iVar.c();
        Iterator<String> it = iVar.h.iterator();
        do {
            z2 = false;
            if (!it.hasNext()) {
                return;
            }
            String next = it.next();
            i$a i_a = i$a.IDLE;
            AtomicReference<i$a> atomicReference = iVar.a;
            i$a i_a2 = i$a.SYNCING;
            if (atomicReference.getAndSet(i_a2) != i_a2) {
                long jB = iVar.e.b();
                b.m.a.e eVar = iVar.g;
                if (eVar != null) {
                    eVar.a(next);
                }
                try {
                    e$b e_bD = iVar.d.d(next, Long.valueOf(iVar.i));
                    m.checkExpressionValueIsNotNull(e_bD, "response");
                    if (e_bD.a() < 0) {
                        throw new NTPSyncException("Invalid time " + e_bD.a() + " received from " + next);
                    }
                    iVar.f.a(e_bD);
                    long j = e_bD.c;
                    long jB2 = iVar.e.b() - jB;
                    b.m.a.e eVar2 = iVar.g;
                    if (eVar2 != null) {
                        eVar2.b(j, jB2);
                    }
                    iVar.a.set(i_a);
                    iVar.f1909b.set(iVar.e.b());
                    z2 = true;
                } catch (Throwable th) {
                    try {
                        b.m.a.e eVar3 = iVar.g;
                        if (eVar3 != null) {
                            eVar3.c(next, th);
                        }
                        iVar.a.set(i_a);
                        iVar.f1909b.set(iVar.e.b());
                    } catch (Throwable th2) {
                        iVar.a.set(i_a);
                        iVar.f1909b.set(iVar.e.b());
                        throw th2;
                    }
                }
            }
        } while (!z2);
    }
}
