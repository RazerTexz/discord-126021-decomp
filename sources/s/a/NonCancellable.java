package s.a;

import d0.w.CoroutineContextImpl;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;

/* JADX INFO: renamed from: s.a.n1, reason: use source file name */
/* JADX INFO: compiled from: NonCancellable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NonCancellable extends CoroutineContextImpl implements Job {
    public static final NonCancellable j = new NonCancellable();

    public NonCancellable() {
        super(Job.INSTANCE);
    }

    @Override // kotlinx.coroutines.Job
    public Job4 D(Job6 job6) {
        return Job3.j;
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
    public Job2 n(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1) {
        return Job3.j;
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
    public Job2 u(Function1<? super Throwable, Unit> function1) {
        return Job3.j;
    }
}
