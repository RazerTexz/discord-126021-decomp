package b.i.a.f.h.l;

import android.database.ContentObserver;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a2 extends ContentObserver {
    public final /* synthetic */ y1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a2(y1 y1Var) {
        super(null);
        this.a = y1Var;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        y1 y1Var = this.a;
        synchronized (y1Var.f) {
            y1Var.g = null;
            l2.d.incrementAndGet();
        }
        synchronized (y1Var) {
            Iterator<z1> it = y1Var.h.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }
}
