package androidx.work.impl.utils.futures;

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
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public abstract class AbstractFuture<V> implements a<V> {
    public static final AbstractFuture$AtomicHelper ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;

    @Nullable
    public volatile AbstractFuture$Listener listeners;

    @Nullable
    public volatile Object value;

    @Nullable
    public volatile AbstractFuture$Waiter waiters;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());

    static {
        AbstractFuture$AtomicHelper abstractFuture$SynchronizedHelper;
        try {
            abstractFuture$SynchronizedHelper = new AbstractFuture$SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AbstractFuture$Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture$Waiter.class, AbstractFuture$Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, AbstractFuture$Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, AbstractFuture$Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            th = null;
        } catch (Throwable th) {
            th = th;
            abstractFuture$SynchronizedHelper = new AbstractFuture$SynchronizedHelper();
        }
        ATOMIC_HELPER = abstractFuture$SynchronizedHelper;
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

    private AbstractFuture$Listener clearListeners(AbstractFuture$Listener abstractFuture$Listener) {
        AbstractFuture$Listener abstractFuture$Listener2;
        do {
            abstractFuture$Listener2 = this.listeners;
        } while (!ATOMIC_HELPER.casListeners(this, abstractFuture$Listener2, AbstractFuture$Listener.TOMBSTONE));
        AbstractFuture$Listener abstractFuture$Listener3 = abstractFuture$Listener;
        AbstractFuture$Listener abstractFuture$Listener4 = abstractFuture$Listener2;
        while (abstractFuture$Listener4 != null) {
            AbstractFuture$Listener abstractFuture$Listener5 = abstractFuture$Listener4.next;
            abstractFuture$Listener4.next = abstractFuture$Listener3;
            abstractFuture$Listener3 = abstractFuture$Listener4;
            abstractFuture$Listener4 = abstractFuture$Listener5;
        }
        return abstractFuture$Listener3;
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
    public static void complete(AbstractFuture<?> abstractFuture) {
        AbstractFuture$Listener abstractFuture$Listener = null;
        while (true) {
            abstractFuture.releaseWaiters();
            abstractFuture.afterDone();
            AbstractFuture$Listener abstractFuture$ListenerClearListeners = abstractFuture.clearListeners(abstractFuture$Listener);
            while (abstractFuture$ListenerClearListeners != null) {
                abstractFuture$Listener = abstractFuture$ListenerClearListeners.next;
                Runnable runnable = abstractFuture$ListenerClearListeners.task;
                if (runnable instanceof AbstractFuture$SetFuture) {
                    AbstractFuture$SetFuture abstractFuture$SetFuture = (AbstractFuture$SetFuture) runnable;
                    abstractFuture = abstractFuture$SetFuture.owner;
                    if (abstractFuture.value == abstractFuture$SetFuture) {
                        if (ATOMIC_HELPER.casValue(abstractFuture, abstractFuture$SetFuture, getFutureValue(abstractFuture$SetFuture.future))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    executeListener(runnable, abstractFuture$ListenerClearListeners.executor);
                }
                abstractFuture$ListenerClearListeners = abstractFuture$Listener;
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
        if (obj instanceof AbstractFuture$Cancellation) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((AbstractFuture$Cancellation) obj).cause);
        }
        if (obj instanceof AbstractFuture$Failure) {
            throw new ExecutionException(((AbstractFuture$Failure) obj).exception);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    public static Object getFutureValue(a<?> aVar) {
        if (aVar instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) aVar).value;
            if (!(obj instanceof AbstractFuture$Cancellation)) {
                return obj;
            }
            AbstractFuture$Cancellation abstractFuture$Cancellation = (AbstractFuture$Cancellation) obj;
            if (abstractFuture$Cancellation.wasInterrupted) {
                return abstractFuture$Cancellation.cause != null ? new AbstractFuture$Cancellation(false, abstractFuture$Cancellation.cause) : AbstractFuture$Cancellation.CAUSELESS_CANCELLED;
            }
            return obj;
        }
        boolean zIsCancelled = aVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && zIsCancelled) {
            return AbstractFuture$Cancellation.CAUSELESS_CANCELLED;
        }
        try {
            Object uninterruptibly = getUninterruptibly(aVar);
            return uninterruptibly == null ? NULL : uninterruptibly;
        } catch (CancellationException e) {
            if (zIsCancelled) {
                return new AbstractFuture$Cancellation(false, e);
            }
            return new AbstractFuture$Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e));
        } catch (ExecutionException e2) {
            return new AbstractFuture$Failure(e2.getCause());
        } catch (Throwable th) {
            return new AbstractFuture$Failure(th);
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
        AbstractFuture$Waiter abstractFuture$Waiter;
        do {
            abstractFuture$Waiter = this.waiters;
        } while (!ATOMIC_HELPER.casWaiters(this, abstractFuture$Waiter, AbstractFuture$Waiter.TOMBSTONE));
        while (abstractFuture$Waiter != null) {
            abstractFuture$Waiter.unpark();
            abstractFuture$Waiter = abstractFuture$Waiter.next;
        }
    }

    private void removeWaiter(AbstractFuture$Waiter abstractFuture$Waiter) {
        abstractFuture$Waiter.thread = null;
        while (true) {
            AbstractFuture$Waiter abstractFuture$Waiter2 = this.waiters;
            if (abstractFuture$Waiter2 == AbstractFuture$Waiter.TOMBSTONE) {
                return;
            }
            AbstractFuture$Waiter abstractFuture$Waiter3 = null;
            while (abstractFuture$Waiter2 != null) {
                AbstractFuture$Waiter abstractFuture$Waiter4 = abstractFuture$Waiter2.next;
                if (abstractFuture$Waiter2.thread != null) {
                    abstractFuture$Waiter3 = abstractFuture$Waiter2;
                } else if (abstractFuture$Waiter3 != null) {
                    abstractFuture$Waiter3.next = abstractFuture$Waiter4;
                    if (abstractFuture$Waiter3.thread == null) {
                    }
                } else if (!ATOMIC_HELPER.casWaiters(this, abstractFuture$Waiter2, abstractFuture$Waiter4)) {
                }
                abstractFuture$Waiter2 = abstractFuture$Waiter4;
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
        AbstractFuture$Listener abstractFuture$Listener = this.listeners;
        if (abstractFuture$Listener != AbstractFuture$Listener.TOMBSTONE) {
            AbstractFuture$Listener abstractFuture$Listener2 = new AbstractFuture$Listener(runnable, executor);
            do {
                abstractFuture$Listener2.next = abstractFuture$Listener;
                if (ATOMIC_HELPER.casListeners(this, abstractFuture$Listener, abstractFuture$Listener2)) {
                    return;
                } else {
                    abstractFuture$Listener = this.listeners;
                }
            } while (abstractFuture$Listener != AbstractFuture$Listener.TOMBSTONE);
        }
        executeListener(runnable, executor);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        AbstractFuture$Cancellation abstractFuture$Cancellation;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof AbstractFuture$SetFuture)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            abstractFuture$Cancellation = new AbstractFuture$Cancellation(z2, new CancellationException("Future.cancel() was called."));
        } else {
            abstractFuture$Cancellation = z2 ? AbstractFuture$Cancellation.CAUSELESS_INTERRUPTED : AbstractFuture$Cancellation.CAUSELESS_CANCELLED;
        }
        boolean z3 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (ATOMIC_HELPER.casValue(abstractFuture, obj, abstractFuture$Cancellation)) {
                if (z2) {
                    abstractFuture.interruptTask();
                }
                complete(abstractFuture);
                if (!(obj instanceof AbstractFuture$SetFuture)) {
                    return true;
                }
                a<? extends V> aVar = ((AbstractFuture$SetFuture) obj).future;
                if (!(aVar instanceof AbstractFuture)) {
                    aVar.cancel(z2);
                    return true;
                }
                abstractFuture = (AbstractFuture) aVar;
                obj = abstractFuture.value;
                if (!(obj == null) && !(obj instanceof AbstractFuture$SetFuture)) {
                    return true;
                }
                z3 = true;
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof AbstractFuture$SetFuture)) {
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
        if ((obj != null) && (!(obj instanceof AbstractFuture$SetFuture))) {
            return getDoneValue(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            AbstractFuture$Waiter abstractFuture$Waiter = this.waiters;
            if (abstractFuture$Waiter != AbstractFuture$Waiter.TOMBSTONE) {
                AbstractFuture$Waiter abstractFuture$Waiter2 = new AbstractFuture$Waiter();
                while (true) {
                    abstractFuture$Waiter2.setNext(abstractFuture$Waiter);
                    if (ATOMIC_HELPER.casWaiters(this, abstractFuture$Waiter, abstractFuture$Waiter2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(abstractFuture$Waiter2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof AbstractFuture$SetFuture))) {
                                return getDoneValue(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(abstractFuture$Waiter2);
                        break;
                    }
                    abstractFuture$Waiter = this.waiters;
                    if (abstractFuture$Waiter == AbstractFuture$Waiter.TOMBSTONE) {
                    }
                }
            }
            return getDoneValue(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && (!(obj3 instanceof AbstractFuture$SetFuture))) {
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
        return this.value instanceof AbstractFuture$Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof AbstractFuture$SetFuture)) & (obj != null);
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
        if (obj instanceof AbstractFuture$SetFuture) {
            return b.d.b.a.a.J(b.d.b.a.a.U("setFuture=["), userObjectToString(((AbstractFuture$SetFuture) obj).future), "]");
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
        if (!ATOMIC_HELPER.casValue(this, null, new AbstractFuture$Failure((Throwable) checkNotNull(th)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(a<? extends V> aVar) {
        AbstractFuture$Failure abstractFuture$Failure;
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
            AbstractFuture$SetFuture abstractFuture$SetFuture = new AbstractFuture$SetFuture(this, aVar);
            if (ATOMIC_HELPER.casValue(this, null, abstractFuture$SetFuture)) {
                try {
                    aVar.addListener(abstractFuture$SetFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        abstractFuture$Failure = new AbstractFuture$Failure(th);
                    } catch (Throwable unused) {
                        abstractFuture$Failure = AbstractFuture$Failure.FALLBACK_INSTANCE;
                    }
                    ATOMIC_HELPER.casValue(this, abstractFuture$SetFuture, abstractFuture$Failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof AbstractFuture$Cancellation) {
            aVar.cancel(((AbstractFuture$Cancellation) obj).wasInterrupted);
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
        return (obj instanceof AbstractFuture$Cancellation) && ((AbstractFuture$Cancellation) obj).wasInterrupted;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof AbstractFuture$SetFuture))) {
                return getDoneValue(obj2);
            }
            AbstractFuture$Waiter abstractFuture$Waiter = this.waiters;
            if (abstractFuture$Waiter != AbstractFuture$Waiter.TOMBSTONE) {
                AbstractFuture$Waiter abstractFuture$Waiter2 = new AbstractFuture$Waiter();
                do {
                    abstractFuture$Waiter2.setNext(abstractFuture$Waiter);
                    if (ATOMIC_HELPER.casWaiters(this, abstractFuture$Waiter, abstractFuture$Waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(abstractFuture$Waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof AbstractFuture$SetFuture))));
                        return getDoneValue(obj);
                    }
                    abstractFuture$Waiter = this.waiters;
                } while (abstractFuture$Waiter != AbstractFuture$Waiter.TOMBSTONE);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
