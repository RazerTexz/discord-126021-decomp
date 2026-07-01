package androidx.view;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import s.a.a.n;
import s.a.k0;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BlockRunner<T> {
    private final Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> block;
    private Job cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final Function0<Unit> onDone;
    private Job runningJob;
    private final CoroutineScope scope;
    private final long timeoutInMs;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(CoroutineLiveData<T> coroutineLiveData, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, long j, CoroutineScope coroutineScope, Function0<Unit> function0) {
        m.checkNotNullParameter(coroutineLiveData, "liveData");
        m.checkNotNullParameter(function2, "block");
        m.checkNotNullParameter(coroutineScope, "scope");
        m.checkNotNullParameter(function0, "onDone");
        this.liveData = coroutineLiveData;
        this.block = function2;
        this.timeoutInMs = j;
        this.scope = coroutineScope;
        this.onDone = function0;
    }

    public static final /* synthetic */ Function2 access$getBlock$p(BlockRunner blockRunner) {
        return blockRunner.block;
    }

    public static final /* synthetic */ CoroutineLiveData access$getLiveData$p(BlockRunner blockRunner) {
        return blockRunner.liveData;
    }

    public static final /* synthetic */ Function0 access$getOnDone$p(BlockRunner blockRunner) {
        return blockRunner.onDone;
    }

    public static final /* synthetic */ Job access$getRunningJob$p(BlockRunner blockRunner) {
        return blockRunner.runningJob;
    }

    public static final /* synthetic */ long access$getTimeoutInMs$p(BlockRunner blockRunner) {
        return blockRunner.timeoutInMs;
    }

    public static final /* synthetic */ void access$setRunningJob$p(BlockRunner blockRunner, Job job) {
        blockRunner.runningJob = job;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
        CoroutineScope coroutineScope = this.scope;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        this.cancellationJob = f.H0(coroutineScope, n.f3830b.H(), null, new BlockRunner$cancel$1(this, null), 2, null);
    }

    @MainThread
    public final void maybeRun() {
        Job job = this.cancellationJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = f.H0(this.scope, null, null, new BlockRunner$maybeRun$1(this, null), 3, null);
    }
}
