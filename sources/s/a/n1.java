package s.a;

import d0.w.a;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: NonCancellable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends a implements Job {
    public static final n1 j = new n1();

    public n1() {
        super(Job.h);
    }

    @Override // kotlinx.coroutines.Job
    public p D(r rVar) {
        return o1.j;
    }

    @Override // kotlinx.coroutines.Job
    public boolean a() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public void b(CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.Job
    public Sequence<Job> e() {
        return d0.f0.n.emptySequence();
    }

    @Override // kotlinx.coroutines.Job
    public m0 n(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1) {
        return o1.j;
    }

    @Override // kotlinx.coroutines.Job
    public CancellationException q() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.Job
    public m0 u(Function1<? super Throwable, Unit> function1) {
        return o1.j;
    }
}
