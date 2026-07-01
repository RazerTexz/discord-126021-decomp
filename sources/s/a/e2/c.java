package s.a.e2;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import s.a.d0;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c extends ExecutorCoroutineDispatcher {
    public a j;
    public final int k;
    public final int l;
    public final long m;
    public final String n;

    public c(int i, int i2, String str, int i3) {
        int i4 = (i3 & 1) != 0 ? k.f3839b : i;
        int i5 = (i3 & 2) != 0 ? k.c : i2;
        String str2 = (i3 & 4) != 0 ? "DefaultDispatcher" : null;
        long j = k.d;
        this.k = i4;
        this.l = i5;
        this.m = j;
        this.n = str2;
        this.j = new a(i4, i5, j, str2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            a.e(this.j, runnable, null, false, 6);
        } catch (RejectedExecutionException unused) {
            d0.q.T(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            a.e(this.j, runnable, null, true, 2);
        } catch (RejectedExecutionException unused) {
            d0.q.dispatchYield(coroutineContext, runnable);
        }
    }
}
