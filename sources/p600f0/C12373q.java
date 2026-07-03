package p600f0;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.ThreadFactoryC12271b;
import p600f0.p601e0.p605g.C12285e;

/* JADX INFO: renamed from: f0.q */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12373q {

    /* JADX INFO: renamed from: a */
    public ExecutorService f25957a;

    /* JADX INFO: renamed from: b */
    public final ArrayDeque<C12285e.a> f25958b = new ArrayDeque<>();

    /* JADX INFO: renamed from: c */
    public final ArrayDeque<C12285e.a> f25959c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d */
    public final ArrayDeque<C12285e> f25960d = new ArrayDeque<>();

    /* JADX INFO: renamed from: a */
    public final synchronized void m10388a() {
        Iterator<C12285e.a> it = this.f25958b.iterator();
        while (it.hasNext()) {
            it.next().f25484l.cancel();
        }
        Iterator<C12285e.a> it2 = this.f25959c.iterator();
        while (it2.hasNext()) {
            it2.next().f25484l.cancel();
        }
        Iterator<C12285e> it3 = this.f25960d.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    /* JADX INFO: renamed from: b */
    public final <T> void m10389b(Deque<T> deque, T t) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        m10391d();
    }

    /* JADX INFO: renamed from: c */
    public final void m10390c(C12285e.a aVar) {
        C12238m.checkParameterIsNotNull(aVar, NotificationCompat.CATEGORY_CALL);
        aVar.f25482j.decrementAndGet();
        m10389b(this.f25959c, aVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0067  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072 A[Catch: all -> 0x00ef, TryCatch #4 {, blocks: (B:27:0x006e, B:29:0x0072, B:30:0x00a4, B:32:0x00a8), top: B:60:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a8 A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #4 {, blocks: (B:27:0x006e, B:29:0x0072, B:30:0x00a4, B:32:0x00a8), top: B:60:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:60:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x0072, please report this as an issue */
    /* JADX INFO: renamed from: d */
    public final boolean m10391d() {
        int size;
        int size2;
        int i;
        C12285e.a aVar;
        ExecutorService executorService;
        byte[] bArr = C12272c.f25397a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<C12285e.a> it = this.f25958b.iterator();
            C12238m.checkExpressionValueIsNotNull(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                C12285e.a next = it.next();
                if (this.f25959c.size() >= 64) {
                    break;
                }
                if (next.f25482j.get() < 5) {
                    it.remove();
                    next.f25482j.incrementAndGet();
                    C12238m.checkExpressionValueIsNotNull(next, "asyncCall");
                    arrayList.add(next);
                    this.f25959c.add(next);
                }
            }
            synchronized (this) {
                size = this.f25959c.size() + this.f25960d.size();
            }
            size2 = arrayList.size();
            for (i = 0; i < size2; i++) {
                aVar = (C12285e.a) arrayList.get(i);
                synchronized (this) {
                    if (this.f25957a == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        String str = C12272c.f25403g + " Dispatcher";
                        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        this.f25957a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new ThreadFactoryC12271b(str, false));
                    }
                    executorService = this.f25957a;
                    if (executorService == null) {
                        C12238m.throwNpe();
                    }
                }
                Objects.requireNonNull(aVar);
                C12238m.checkParameterIsNotNull(executorService, "executorService");
                C12373q c12373q = aVar.f25484l.f25480y.f26012m;
                byte[] bArr2 = C12272c.f25397a;
                try {
                    try {
                        executorService.execute(aVar);
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e);
                        aVar.f25484l.m10187l(interruptedIOException);
                        aVar.f25483k.mo10359b(aVar.f25484l, interruptedIOException);
                        aVar.f25484l.f25480y.f26012m.m10390c(aVar);
                    }
                } catch (Throwable th) {
                    aVar.f25484l.f25480y.f26012m.m10390c(aVar);
                    throw th;
                }
            }
            return z;
        }
        boolean z2 = size > 0;
        size2 = arrayList.size();
        while (i < size2) {
            aVar = (C12285e.a) arrayList.get(i);
            synchronized (this) {
                if (this.f25957a == null) {
                    TimeUnit timeUnit2 = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue2 = new SynchronousQueue();
                    String str2 = C12272c.f25403g + " Dispatcher";
                    C12238m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    this.f25957a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit2, synchronousQueue2, new ThreadFactoryC12271b(str2, false));
                }
                executorService = this.f25957a;
                if (executorService == null) {
                    C12238m.throwNpe();
                }
                Objects.requireNonNull(aVar);
                C12238m.checkParameterIsNotNull(executorService, "executorService");
                C12373q c12373q2 = aVar.f25484l.f25480y.f26012m;
                byte[] bArr3 = C12272c.f25397a;
                executorService.execute(aVar);
            }
        }
        return z2;
    }
}
