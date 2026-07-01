package f0;

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

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public ExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<f0.e0.g.e$a> f3677b = new ArrayDeque<>();
    public final ArrayDeque<f0.e0.g.e$a> c = new ArrayDeque<>();
    public final ArrayDeque<f0.e0.g.e> d = new ArrayDeque<>();

    public final synchronized void a() {
        Iterator<f0.e0.g.e$a> it = this.f3677b.iterator();
        while (it.hasNext()) {
            it.next().l.cancel();
        }
        Iterator<f0.e0.g.e$a> it2 = this.c.iterator();
        while (it2.hasNext()) {
            it2.next().l.cancel();
        }
        Iterator<f0.e0.g.e> it3 = this.d.iterator();
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

    public final void c(f0.e0.g.e$a e_a) {
        d0.z.d.m.checkParameterIsNotNull(e_a, NotificationCompat.CATEGORY_CALL);
        e_a.j.decrementAndGet();
        b(this.c, e_a);
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
        f0.e0.g.e$a e_a;
        ExecutorService executorService;
        byte[] bArr = f0.e0.c.a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<f0.e0.g.e$a> it = this.f3677b.iterator();
            d0.z.d.m.checkExpressionValueIsNotNull(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                f0.e0.g.e$a next = it.next();
                if (this.c.size() >= 64) {
                    break;
                }
                if (next.j.get() < 5) {
                    it.remove();
                    next.j.incrementAndGet();
                    d0.z.d.m.checkExpressionValueIsNotNull(next, "asyncCall");
                    arrayList.add(next);
                    this.c.add(next);
                }
            }
            synchronized (this) {
                size = this.c.size() + this.d.size();
            }
            size2 = arrayList.size();
            for (i = 0; i < size2; i++) {
                e_a = (f0.e0.g.e$a) arrayList.get(i);
                synchronized (this) {
                    if (this.a == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        String str = f0.e0.c.g + " Dispatcher";
                        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new f0.e0.b(str, false));
                    }
                    executorService = this.a;
                    if (executorService == null) {
                        d0.z.d.m.throwNpe();
                    }
                }
                Objects.requireNonNull(e_a);
                d0.z.d.m.checkParameterIsNotNull(executorService, "executorService");
                q qVar = e_a.l.f3618y.m;
                byte[] bArr2 = f0.e0.c.a;
                try {
                    try {
                        executorService.execute(e_a);
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e);
                        e_a.l.l(interruptedIOException);
                        e_a.k.b(e_a.l, interruptedIOException);
                        e_a.l.f3618y.m.c(e_a);
                    }
                } catch (Throwable th) {
                    e_a.l.f3618y.m.c(e_a);
                    throw th;
                }
            }
            return z;
        }
        boolean z2 = size > 0;
        size2 = arrayList.size();
        while (i < size2) {
            e_a = (f0.e0.g.e$a) arrayList.get(i);
            synchronized (this) {
                if (this.a == null) {
                    TimeUnit timeUnit2 = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue2 = new SynchronousQueue();
                    String str2 = f0.e0.c.g + " Dispatcher";
                    d0.z.d.m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit2, synchronousQueue2, new f0.e0.b(str2, false));
                }
                executorService = this.a;
                if (executorService == null) {
                    d0.z.d.m.throwNpe();
                }
                Objects.requireNonNull(e_a);
                d0.z.d.m.checkParameterIsNotNull(executorService, "executorService");
                q qVar2 = e_a.l.f3618y.m;
                byte[] bArr3 = f0.e0.c.a;
                executorService.execute(e_a);
            }
        }
        return z2;
    }
}
