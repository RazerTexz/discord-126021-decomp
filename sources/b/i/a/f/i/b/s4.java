package b.i.a.f.i.b;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class s4<V> extends FutureTask<V> implements Comparable<s4<V>> {
    public final long j;
    public final boolean k;
    public final String l;
    public final /* synthetic */ r4 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s4(r4 r4Var, Callable<V> callable, boolean z2, String str) {
        super(callable);
        this.m = r4Var;
        long andIncrement = r4.c.getAndIncrement();
        this.j = andIncrement;
        this.l = str;
        this.k = z2;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            r4Var.g().f.a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(@NonNull Object obj) {
        s4 s4Var = (s4) obj;
        boolean z2 = this.k;
        if (z2 != s4Var.k) {
            return z2 ? -1 : 1;
        }
        long j = this.j;
        long j2 = s4Var.j;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.m.g().g.b("Two tasks share the same index. index", Long.valueOf(this.j));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.m.g().f.b(this.l, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s4(r4 r4Var, Runnable runnable, boolean z2, String str) {
        super(runnable, null);
        this.m = r4Var;
        long andIncrement = r4.c.getAndIncrement();
        this.j = andIncrement;
        this.l = str;
        this.k = z2;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            r4Var.g().f.a("Tasks index overflow");
        }
    }
}
