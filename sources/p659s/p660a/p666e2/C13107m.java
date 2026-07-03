package p659s.p660a.p666e2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: s.a.e2.m */
/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13107m {

    /* JADX INFO: renamed from: a */
    public static final AtomicReferenceFieldUpdater f27836a = AtomicReferenceFieldUpdater.newUpdater(C13107m.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: b */
    public static final AtomicIntegerFieldUpdater f27837b = AtomicIntegerFieldUpdater.newUpdater(C13107m.class, "producerIndex");

    /* JADX INFO: renamed from: c */
    public static final AtomicIntegerFieldUpdater f27838c = AtomicIntegerFieldUpdater.newUpdater(C13107m.class, "consumerIndex");

    /* JADX INFO: renamed from: d */
    public static final AtomicIntegerFieldUpdater f27839d = AtomicIntegerFieldUpdater.newUpdater(C13107m.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: e */
    public final AtomicReferenceArray<AbstractRunnableC13102h> f27840e = new AtomicReferenceArray<>(128);
    public volatile Object lastScheduledTask = null;
    public volatile int producerIndex = 0;
    public volatile int consumerIndex = 0;
    public volatile int blockingTasksInBuffer = 0;

    /* JADX INFO: renamed from: a */
    public final AbstractRunnableC13102h m11271a(AbstractRunnableC13102h abstractRunnableC13102h, boolean z2) {
        if (z2) {
            return m11272b(abstractRunnableC13102h);
        }
        AbstractRunnableC13102h abstractRunnableC13102h2 = (AbstractRunnableC13102h) f27836a.getAndSet(this, abstractRunnableC13102h);
        if (abstractRunnableC13102h2 != null) {
            return m11272b(abstractRunnableC13102h2);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final AbstractRunnableC13102h m11272b(AbstractRunnableC13102h abstractRunnableC13102h) {
        if (abstractRunnableC13102h.f27829k.mo11269t() == 1) {
            f27839d.incrementAndGet(this);
        }
        if (m11273c() == 127) {
            return abstractRunnableC13102h;
        }
        int i = this.producerIndex & Opcodes.LAND;
        while (this.f27840e.get(i) != null) {
            Thread.yield();
        }
        this.f27840e.lazySet(i, abstractRunnableC13102h);
        f27837b.incrementAndGet(this);
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final int m11273c() {
        return this.producerIndex - this.consumerIndex;
    }

    /* JADX INFO: renamed from: d */
    public final int m11274d() {
        return this.lastScheduledTask != null ? m11273c() + 1 : m11273c();
    }

    /* JADX INFO: renamed from: e */
    public final AbstractRunnableC13102h m11275e() {
        AbstractRunnableC13102h abstractRunnableC13102h = (AbstractRunnableC13102h) f27836a.getAndSet(this, null);
        return abstractRunnableC13102h != null ? abstractRunnableC13102h : m11276f();
    }

    /* JADX INFO: renamed from: f */
    public final AbstractRunnableC13102h m11276f() {
        AbstractRunnableC13102h andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & Opcodes.LAND;
            if (f27838c.compareAndSet(this, i, i + 1) && (andSet = this.f27840e.getAndSet(i2, null)) != null) {
                if (andSet.f27829k.mo11269t() == 1) {
                    f27839d.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final long m11277g(C13107m c13107m, boolean z2) {
        AbstractRunnableC13102h abstractRunnableC13102h;
        do {
            abstractRunnableC13102h = (AbstractRunnableC13102h) c13107m.lastScheduledTask;
            if (abstractRunnableC13102h == null) {
                return -2L;
            }
            if (z2) {
                if (!(abstractRunnableC13102h.f27829k.mo11269t() == 1)) {
                    return -2L;
                }
            }
            long jMo11270a = C13105k.f27835e.mo11270a() - abstractRunnableC13102h.f27828j;
            long j = C13105k.f27831a;
            if (jMo11270a < j) {
                return j - jMo11270a;
            }
        } while (!f27836a.compareAndSet(c13107m, abstractRunnableC13102h, null));
        m11271a(abstractRunnableC13102h, false);
        return -1L;
    }
}
