package j0.l.a;

import java.util.Iterator;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorBufferWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public class n0$b$a implements Action0 {
    public final /* synthetic */ List j;
    public final /* synthetic */ n0$b k;

    public n0$b$a(n0$b n0_b, List list) {
        this.k = n0_b;
        this.j = list;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // rx.functions.Action0
    public void call() {
        boolean z2;
        n0$b n0_b = this.k;
        List list = this.j;
        synchronized (n0_b) {
            if (n0_b.m) {
                return;
            }
            Iterator it = n0_b.l.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                } else if (((List) it.next()) == list) {
                    it.remove();
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                try {
                    n0_b.j.onNext(list);
                } catch (Throwable th) {
                    b.i.a.f.e.o.f.o1(th);
                    n0_b.onError(th);
                }
            }
        }
    }
}
