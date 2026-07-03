package p007b.p225i.p226a.p288f.p330i.p332b;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: renamed from: b.i.a.f.i.b.s4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4180s4<V> extends FutureTask<V> implements Comparable<C4180s4<V>> {

    /* JADX INFO: renamed from: j */
    public final long f11198j;

    /* JADX INFO: renamed from: k */
    public final boolean f11199k;

    /* JADX INFO: renamed from: l */
    public final String f11200l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C4169r4 f11201m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4180s4(C4169r4 c4169r4, Callable<V> callable, boolean z2, String str) {
        super(callable);
        this.f11201m = c4169r4;
        long andIncrement = C4169r4.f11167c.getAndIncrement();
        this.f11198j = andIncrement;
        this.f11200l = str;
        this.f11199k = z2;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            c4169r4.mo5726g().f11141f.m5860a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(@NonNull Object obj) {
        C4180s4 c4180s4 = (C4180s4) obj;
        boolean z2 = this.f11199k;
        if (z2 != c4180s4.f11199k) {
            return z2 ? -1 : 1;
        }
        long j = this.f11198j;
        long j2 = c4180s4.f11198j;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.f11201m.mo5726g().f11142g.m5861b("Two tasks share the same index. index", Long.valueOf(this.f11198j));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.f11201m.mo5726g().f11141f.m5861b(this.f11200l, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4180s4(C4169r4 c4169r4, Runnable runnable, boolean z2, String str) {
        super(runnable, null);
        this.f11201m = c4169r4;
        long andIncrement = C4169r4.f11167c.getAndIncrement();
        this.f11198j = andIncrement;
        this.f11200l = str;
        this.f11199k = z2;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            c4169r4.mo5726g().f11141f.m5860a("Tasks index overflow");
        }
    }
}
