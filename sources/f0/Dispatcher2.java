package f0;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import f0.e0.Util6;
import f0.e0.Util7;
import f0.e0.g.RealCall;
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

/* JADX INFO: renamed from: f0.q, reason: use source file name */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Dispatcher2 {
    public ExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<RealCall.a> f3677b = new ArrayDeque<>();
    public final ArrayDeque<RealCall.a> c = new ArrayDeque<>();
    public final ArrayDeque<RealCall> d = new ArrayDeque<>();

    public final synchronized void a() {
        Iterator<RealCall.a> it = this.f3677b.iterator();
        while (it.hasNext()) {
            it.next().l.cancel();
        }
        Iterator<RealCall.a> it2 = this.c.iterator();
        while (it2.hasNext()) {
            it2.next().l.cancel();
        }
        Iterator<RealCall> it3 = this.d.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    public final <T> void b(Deque<T> deque, T t) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        d();
    }

    public final void c(RealCall.a aVar) {
        Intrinsics3.checkParameterIsNotNull(aVar, NotificationCompat.CATEGORY_CALL);
        aVar.j.decrementAndGet();
        b(this.c, aVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0067  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072 A[Catch: all -> 0x00ef, TryCatch #4 {, blocks: (B:27:0x006e, B:29:0x0072, B:30:0x00a4, B:32:0x00a8), top: B:60:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a8 A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #4 {, blocks: (B:27:0x006e, B:29:0x0072, B:30:0x00a4, B:32:0x00a8), top: B:60:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:60:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x0072, please report this as an issue */
    public final boolean d() {
        int size;
        int size2;
        int i;
        RealCall.a aVar;
        ExecutorService executorService;
        byte[] bArr = Util7.a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.a> it = this.f3677b.iterator();
            Intrinsics3.checkExpressionValueIsNotNull(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                RealCall.a next = it.next();
                if (this.c.size() >= 64) {
                    break;
                }
                if (next.j.get() < 5) {
                    it.remove();
                    next.j.incrementAndGet();
                    Intrinsics3.checkExpressionValueIsNotNull(next, "asyncCall");
                    arrayList.add(next);
                    this.c.add(next);
                }
            }
            synchronized (this) {
                size = this.c.size() + this.d.size();
            }
            size2 = arrayList.size();
            for (i = 0; i < size2; i++) {
                aVar = (RealCall.a) arrayList.get(i);
                synchronized (this) {
                    if (this.a == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        String str = Util7.g + " Dispatcher";
                        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new Util6(str, false));
                    }
                    executorService = this.a;
                    if (executorService == null) {
                        Intrinsics3.throwNpe();
                    }
                }
                Objects.requireNonNull(aVar);
                Intrinsics3.checkParameterIsNotNull(executorService, "executorService");
                Dispatcher2 dispatcher2 = aVar.l.f3618y.m;
                byte[] bArr2 = Util7.a;
                try {
                    try {
                        executorService.execute(aVar);
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e);
                        aVar.l.l(interruptedIOException);
                        aVar.k.b(aVar.l, interruptedIOException);
                        aVar.l.f3618y.m.c(aVar);
                    }
                } catch (Throwable th) {
                    aVar.l.f3618y.m.c(aVar);
                    throw th;
                }
            }
            return z;
        }
        boolean z2 = size > 0;
        size2 = arrayList.size();
        while (i < size2) {
            aVar = (RealCall.a) arrayList.get(i);
            synchronized (this) {
                if (this.a == null) {
                    TimeUnit timeUnit2 = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue2 = new SynchronousQueue();
                    String str2 = Util7.g + " Dispatcher";
                    Intrinsics3.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit2, synchronousQueue2, new Util6(str2, false));
                }
                executorService = this.a;
                if (executorService == null) {
                    Intrinsics3.throwNpe();
                }
                Objects.requireNonNull(aVar);
                Intrinsics3.checkParameterIsNotNull(executorService, "executorService");
                Dispatcher2 dispatcher3 = aVar.l.f3618y.m;
                byte[] bArr3 = Util7.a;
                executorService.execute(aVar);
            }
        }
        return z2;
    }
}
