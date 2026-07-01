package s.a.e2;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Executors;
import s.a.DefaultExecutor;

/* JADX INFO: renamed from: s.a.e2.c, reason: use source file name */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Dispatcher4 extends Executors {
    public CoroutineScheduler j;
    public final int k;
    public final int l;
    public final long m;
    public final String n;

    public Dispatcher4(int i, int i2, String str, int i3) {
        int i4 = (i3 & 1) != 0 ? Tasks7.f3839b : i;
        int i5 = (i3 & 2) != 0 ? Tasks7.c : i2;
        String str2 = (i3 & 4) != 0 ? "DefaultDispatcher" : null;
        long j = Tasks7.d;
        this.k = i4;
        this.l = i5;
        this.m = j;
        this.n = str2;
        this.j = new CoroutineScheduler(i4, i5, j, str2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.e(this.j, runnable, null, false, 6);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.q.T(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.e(this.j, runnable, null, true, 2);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.q.dispatchYield(coroutineContext, runnable);
        }
    }
}
