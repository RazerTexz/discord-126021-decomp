package p659s.p660a.p666e2;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import p659s.p660a.RunnableC13077d0;

/* JADX INFO: renamed from: s.a.e2.c */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13097c extends ExecutorCoroutineDispatcher {

    /* JADX INFO: renamed from: j */
    public ExecutorC13095a f27815j;

    /* JADX INFO: renamed from: k */
    public final int f27816k;

    /* JADX INFO: renamed from: l */
    public final int f27817l;

    /* JADX INFO: renamed from: m */
    public final long f27818m;

    /* JADX INFO: renamed from: n */
    public final String f27819n;

    public C13097c(int i, int i2, String str, int i3) {
        int i4 = (i3 & 1) != 0 ? C13105k.f27832b : i;
        int i5 = (i3 & 2) != 0 ? C13105k.f27833c : i2;
        String str2 = (i3 & 4) != 0 ? "DefaultDispatcher" : null;
        long j = C13105k.f27834d;
        this.f27816k = i4;
        this.f27817l = i5;
        this.f27818m = j;
        this.f27819n = str2;
        this.f27815j = new ExecutorC13095a(i4, i5, j, str2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            ExecutorC13095a.m11250e(this.f27815j, runnable, null, false, 6);
        } catch (RejectedExecutionException unused) {
            RunnableC13077d0.f27779q.m11341T(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            ExecutorC13095a.m11250e(this.f27815j, runnable, null, true, 2);
        } catch (RejectedExecutionException unused) {
            RunnableC13077d0.f27779q.dispatchYield(coroutineContext, runnable);
        }
    }
}
