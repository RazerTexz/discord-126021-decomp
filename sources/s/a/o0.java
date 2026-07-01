package s.a;

import b.d.b.a.outline;
import kotlin.Unit;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends g1<Job> {
    public final Job2 n;

    public o0(Job job, Job2 job2) {
        super(job);
        this.n = job2;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.n.dispose();
        return Unit.a;
    }

    @Override // s.a.CompletionHandler2
    public void q(Throwable th) {
        this.n.dispose();
    }

    @Override // s.a.a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbU = outline.U("DisposeOnCompletion[");
        sbU.append(this.n);
        sbU.append(']');
        return sbU.toString();
    }
}
