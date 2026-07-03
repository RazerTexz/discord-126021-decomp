package p007b.p225i.p226a.p288f.p313h.p325l;

import android.database.ContentObserver;
import java.util.Iterator;

/* JADX INFO: renamed from: b.i.a.f.h.l.a2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3580a2 extends ContentObserver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C3900y1 f9843a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3580a2(C3900y1 c3900y1) {
        super(null);
        this.f9843a = c3900y1;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        C3900y1 c3900y1 = this.f9843a;
        synchronized (c3900y1.f10422f) {
            c3900y1.f10423g = null;
            AbstractC3732l2.f10072d.incrementAndGet();
        }
        synchronized (c3900y1) {
            Iterator<InterfaceC3913z1> it = c3900y1.f10424h.iterator();
            while (it.hasNext()) {
                it.next().m5397a();
            }
        }
    }
}
