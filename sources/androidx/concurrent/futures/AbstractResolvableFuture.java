package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.i.b.d.a.a;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public abstract class AbstractResolvableFuture<V> implements a<V> {
    public static final AbstractResolvableFuture$AtomicHelper ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;

    @Nullable
    public volatile AbstractResolvableFuture$Listener listeners;

    @Nullable
    public volatile Object value;

    @Nullable
    public volatile AbstractResolvableFuture$Waiter waiters;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger log = Logger.getLogger(AbstractResolvableFuture.class.getName());

    static {
        AbstractResolvableFuture$AtomicHelper abstractResolvableFuture$SynchronizedHelper;
        try {
            abstractResolvableFuture$SynchronizedHelper = new AbstractResolvableFuture$SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture$Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture$Waiter.class, AbstractResolvableFuture$Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, AbstractResolvableFuture$Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, AbstractResolvableFuture$Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "value"));
            th = null;
        } catch (Throwable th) {
            th = th;
            abstractResolvableFuture$SynchronizedHelper = new AbstractResolvableFuture$SynchronizedHelper();
        }
        ATOMIC_HELPER = abstractResolvableFuture$SynchronizedHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    private void addDoneString(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            sb.append(userObjectToString(uninterruptibly));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    private static CancellationException cancellationExceptionWithCause(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t) {
        Objects.requireNonNull(t);
        return t;
    }

    private AbstractResolvableFuture$Listener clearListeners(AbstractResolvableFuture$Listener abstractResolvableFuture$Listener) {
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2;
        do {
            abstractResolvableFuture$Listener2 = this.listeners;
        } while (!ATOMIC_HELPER.casListeners(this, abstractResolvableFuture$Listener2, AbstractResolvableFuture$Listener.TOMBSTONE));
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener3 = abstractResolvableFuture$Listener;
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener4 = abstractResolvableFuture$Listener2;
        while (abstractResolvableFuture$Listener4 != null) {
            AbstractResolvableFuture$Listener abstractResolvableFuture$Listener5 = abstractResolvableFuture$Listener4.next;
            abstractResolvableFuture$Listener4.next = abstractResolvableFuture$Listener3;
            abstractResolvableFuture$Listener3 = abstractResolvableFuture$Listener4;
            abstractResolvableFuture$Listener4 = abstractResolvableFuture$Listener5;
        }
        return abstractResolvableFuture$Listener3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void complete(AbstractResolvableFuture<?> abstractResolvableFuture) {
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener = null;
        while (true) {
            abstractResolvableFuture.releaseWaiters();
            abstractResolvableFuture.afterDone();
            AbstractResolvableFuture$Listener abstractResolvableFuture$ListenerClearListeners = abstractResolvableFuture.clearListeners(abstractResolvableFuture$Listener);
            while (abstractResolvableFuture$ListenerClearListeners != null) {
                abstractResolvableFuture$Listener = abstractResolvableFuture$ListenerClearListeners.next;
                Runnable runnable = abstractResolvableFuture$ListenerClearListeners.task;
                if (runnable instanceof AbstractResolvableFuture$SetFuture) {
                    AbstractResolvableFuture$SetFuture abstractResolvableFuture$SetFuture = (AbstractResolvableFuture$SetFuture) runnable;
                    abstractResolvableFuture = abstractResolvableFuture$SetFuture.owner;
                    if (abstractResolvableFuture.value == abstractResolvableFuture$SetFuture) {
                        if (ATOMIC_HELPER.casValue(abstractResolvableFuture, abstractResolvableFuture$SetFuture, getFutureValue(abstractResolvableFuture$SetFuture.future))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    executeListener(runnable, abstractResolvableFuture$ListenerClearListeners.executor);
                }
                abstractResolvableFuture$ListenerClearListeners = abstractResolvableFuture$Listener;
            }
            return;
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof AbstractResolvableFuture$Cancellation) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((AbstractResolvableFuture$Cancellation) obj).cause);
        }
        if (obj instanceof AbstractResolvableFuture$Failure) {
            throw new ExecutionException(((AbstractResolvableFuture$Failure) obj).exception);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    public static Object getFutureValue(a<?> aVar) {
        if (aVar instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) aVar).value;
            if (!(obj instanceof AbstractResolvableFuture$Cancellation)) {
                return obj;
            }
            AbstractResolvableFuture$Cancellation abstractResolvableFuture$Cancellation = (AbstractResolvableFuture$Cancellation) obj;
            if (abstractResolvableFuture$Cancellation.wasInterrupted) {
                return abstractResolvableFuture$Cancellation.cause != null ? new AbstractResolvableFuture$Cancellation(false, abstractResolvableFuture$Cancellation.cause) : AbstractResolvableFuture$Cancellation.CAUSELESS_CANCELLED;
            }
            return obj;
        }
        boolean zIsCancelled = aVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && zIsCancelled) {
            return AbstractResolvableFuture$Cancellation.CAUSELESS_CANCELLED;
        }
        try {
            Object uninterruptibly = getUninterruptibly(aVar);
            return uninterruptibly == null ? NULL : uninterruptibly;
        } catch (CancellationException e) {
            if (zIsCancelled) {
                return new AbstractResolvableFuture$Cancellation(false, e);
            }
            return new AbstractResolvableFuture$Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e));
        } catch (ExecutionException e2) {
            return new AbstractResolvableFuture$Failure(e2.getCause());
        } catch (Throwable th) {
            return new AbstractResolvableFuture$Failure(th);
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean z2 = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private void releaseWaiters() {
        AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter;
        do {
            abstractResolvableFuture$Waiter = this.waiters;
        } while (!ATOMIC_HELPER.casWaiters(this, abstractResolvableFuture$Waiter, AbstractResolvableFuture$Waiter.TOMBSTONE));
        while (abstractResolvableFuture$Waiter != null) {
            abstractResolvableFuture$Waiter.unpark();
            abstractResolvableFuture$Waiter = abstractResolvableFuture$Waiter.next;
        }
    }

    private void removeWaiter(AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter) {
        abstractResolvableFuture$Waiter.thread = null;
        while (true) {
            AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2 = this.waiters;
            if (abstractResolvableFuture$Waiter2 == AbstractResolvableFuture$Waiter.TOMBSTONE) {
                return;
            }
            AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter3 = null;
            while (abstractResolvableFuture$Waiter2 != null) {
                AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter4 = abstractResolvableFuture$Waiter2.next;
                if (abstractResolvableFuture$Waiter2.thread != null) {
                    abstractResolvableFuture$Waiter3 = abstractResolvableFuture$Waiter2;
                } else if (abstractResolvableFuture$Waiter3 != null) {
                    abstractResolvableFuture$Waiter3.next = abstractResolvableFuture$Waiter4;
                    if (abstractResolvableFuture$Waiter3.thread == null) {
                    }
                } else if (!ATOMIC_HELPER.casWaiters(this, abstractResolvableFuture$Waiter2, abstractResolvableFuture$Waiter4)) {
                }
                abstractResolvableFuture$Waiter2 = abstractResolvableFuture$Waiter4;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // b.i.b.d.a.a
    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener = this.listeners;
        if (abstractResolvableFuture$Listener != AbstractResolvableFuture$Listener.TOMBSTONE) {
            AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2 = new AbstractResolvableFuture$Listener(runnable, executor);
            do {
                abstractResolvableFuture$Listener2.next = abstractResolvableFuture$Listener;
                if (ATOMIC_HELPER.casListeners(this, abstractResolvableFuture$Listener, abstractResolvableFuture$Listener2)) {
                    return;
                } else {
                    abstractResolvableFuture$Listener = this.listeners;
                }
            } while (abstractResolvableFuture$Listener != AbstractResolvableFuture$Listener.TOMBSTONE);
        }
        executeListener(runnable, executor);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        AbstractResolvableFuture$Cancellation abstractResolvableFuture$Cancellation;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof AbstractResolvableFuture$SetFuture)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            abstractResolvableFuture$Cancellation = new AbstractResolvableFuture$Cancellation(z2, new CancellationException("Future.cancel() was called."));
        } else {
            abstractResolvableFuture$Cancellation = z2 ? AbstractResolvableFuture$Cancellation.CAUSELESS_INTERRUPTED : AbstractResolvableFuture$Cancellation.CAUSELESS_CANCELLED;
        }
        boolean z3 = false;
        AbstractResolvableFuture<V> abstractResolvableFuture = this;
        while (true) {
            if (ATOMIC_HELPER.casValue(abstractResolvableFuture, obj, abstractResolvableFuture$Cancellation)) {
                if (z2) {
                    abstractResolvableFuture.interruptTask();
                }
                complete(abstractResolvableFuture);
                if (!(obj instanceof AbstractResolvableFuture$SetFuture)) {
                    return true;
                }
                a<? extends V> aVar = ((AbstractResolvableFuture$SetFuture) obj).future;
                if (!(aVar instanceof AbstractResolvableFuture)) {
                    aVar.cancel(z2);
                    return true;
                }
                abstractResolvableFuture = (AbstractResolvableFuture) aVar;
                obj = abstractResolvableFuture.value;
                if (!(obj == null) && !(obj instanceof AbstractResolvableFuture$SetFuture)) {
                    return true;
                }
                z3 = true;
            } else {
                obj = abstractResolvableFuture.value;
                if (!(obj instanceof AbstractResolvableFuture$SetFuture)) {
                    return z3;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof AbstractResolvableFuture$SetFuture))) {
            return getDoneValue(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter = this.waiters;
            if (abstractResolvableFuture$Waiter != AbstractResolvableFuture$Waiter.TOMBSTONE) {
                AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2 = new AbstractResolvableFuture$Waiter();
                while (true) {
                    abstractResolvableFuture$Waiter2.setNext(abstractResolvableFuture$Waiter);
                    if (ATOMIC_HELPER.casWaiters(this, abstractResolvableFuture$Waiter, abstractResolvableFuture$Waiter2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(abstractResolvableFuture$Waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof AbstractResolvableFuture$SetFuture))) {
                                return getDoneValue(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(abstractResolvableFuture$Waiter2);
                        break;
                    }
                    abstractResolvableFuture$Waiter = this.waiters;
                    if (abstractResolvableFuture$Waiter == AbstractResolvableFuture$Waiter.TOMBSTONE) {
                    }
                }
            }
            return getDoneValue(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && (!(obj3 instanceof AbstractResolvableFuture$SetFuture))) {
                return getDoneValue(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strW = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strW2 = b.d.b.a.a.w(strW, " (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z2 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strW3 = strW2 + jConvert + " " + lowerCase;
                if (z2) {
                    strW3 = b.d.b.a.a.w(strW3, ",");
                }
                strW2 = b.d.b.a.a.w(strW3, " ");
            }
            if (z2) {
                strW2 = strW2 + nanos2 + " nanoseconds ";
            }
            strW = b.d.b.a.a.w(strW2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(b.d.b.a.a.w(strW, " but future completed as timeout expired"));
        }
        throw new TimeoutException(b.d.b.a.a.y(strW, " for ", string));
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof AbstractResolvableFuture$Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof AbstractResolvableFuture$SetFuture)) & (obj != null);
    }

    public final void maybePropagateCancellationTo(@Nullable Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof AbstractResolvableFuture$SetFuture) {
            return b.d.b.a.a.J(b.d.b.a.a.U("setFuture=["), userObjectToString(((AbstractResolvableFuture$SetFuture) obj).future), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        StringBuilder sbU = b.d.b.a.a.U("remaining delay=[");
        sbU.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
        sbU.append(" ms]");
        return sbU.toString();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean set(@Nullable V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (!ATOMIC_HELPER.casValue(this, null, v)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th) {
        if (!ATOMIC_HELPER.casValue(this, null, new AbstractResolvableFuture$Failure((Throwable) checkNotNull(th)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(a<? extends V> aVar) {
        AbstractResolvableFuture$Failure abstractResolvableFuture$Failure;
        checkNotNull(aVar);
        Object obj = this.value;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!ATOMIC_HELPER.casValue(this, null, getFutureValue(aVar))) {
                    return false;
                }
                complete(this);
                return true;
            }
            AbstractResolvableFuture$SetFuture abstractResolvableFuture$SetFuture = new AbstractResolvableFuture$SetFuture(this, aVar);
            if (ATOMIC_HELPER.casValue(this, null, abstractResolvableFuture$SetFuture)) {
                try {
                    aVar.addListener(abstractResolvableFuture$SetFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        abstractResolvableFuture$Failure = new AbstractResolvableFuture$Failure(th);
                    } catch (Throwable unused) {
                        abstractResolvableFuture$Failure = AbstractResolvableFuture$Failure.FALLBACK_INSTANCE;
                    }
                    ATOMIC_HELPER.casValue(this, abstractResolvableFuture$SetFuture, abstractResolvableFuture$Failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof AbstractResolvableFuture$Cancellation) {
            aVar.cancel(((AbstractResolvableFuture$Cancellation) obj).wasInterrupted);
        }
        return false;
    }

    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            try {
                string = pendingToString();
            } catch (RuntimeException e) {
                StringBuilder sbU = b.d.b.a.a.U("Exception thrown from implementation: ");
                sbU.append(e.getClass());
                string = sbU.toString();
            }
            if (string != null && !string.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(string);
                sb.append("]");
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof AbstractResolvableFuture$Cancellation) && ((AbstractResolvableFuture$Cancellation) obj).wasInterrupted;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof AbstractResolvableFuture$SetFuture))) {
                return getDoneValue(obj2);
            }
            AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter = this.waiters;
            if (abstractResolvableFuture$Waiter != AbstractResolvableFuture$Waiter.TOMBSTONE) {
                AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2 = new AbstractResolvableFuture$Waiter();
                do {
                    abstractResolvableFuture$Waiter2.setNext(abstractResolvableFuture$Waiter);
                    if (ATOMIC_HELPER.casWaiters(this, abstractResolvableFuture$Waiter, abstractResolvableFuture$Waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(abstractResolvableFuture$Waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof AbstractResolvableFuture$SetFuture))));
                        return getDoneValue(obj);
                    }
                    abstractResolvableFuture$Waiter = this.waiters;
                } while (abstractResolvableFuture$Waiter != AbstractResolvableFuture$Waiter.TOMBSTONE);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
