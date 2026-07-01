package s.a.e2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: s.a.e2.m, reason: use source file name */
/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WorkQueue {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f3840b = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    public static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");
    public final AtomicReferenceArray<Tasks4> e = new AtomicReferenceArray<>(128);
    public volatile Object lastScheduledTask = null;
    public volatile int producerIndex = 0;
    public volatile int consumerIndex = 0;
    public volatile int blockingTasksInBuffer = 0;

    public final Tasks4 a(Tasks4 tasks4, boolean z2) {
        if (z2) {
            return b(tasks4);
        }
        Tasks4 tasks5 = (Tasks4) a.getAndSet(this, tasks4);
        if (tasks5 != null) {
            return b(tasks5);
        }
        return null;
    }

    public final Tasks4 b(Tasks4 tasks4) {
        if (tasks4.k.t() == 1) {
            d.incrementAndGet(this);
        }
        if (c() == 127) {
            return tasks4;
        }
        int i = this.producerIndex & Opcodes.LAND;
        while (this.e.get(i) != null) {
            Thread.yield();
        }
        this.e.lazySet(i, tasks4);
        f3840b.incrementAndGet(this);
        return null;
    }

    public final int c() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int d() {
        return this.lastScheduledTask != null ? c() + 1 : c();
    }

    public final Tasks4 e() {
        Tasks4 tasks4 = (Tasks4) a.getAndSet(this, null);
        return tasks4 != null ? tasks4 : f();
    }

    public final Tasks4 f() {
        Tasks4 andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & Opcodes.LAND;
            if (c.compareAndSet(this, i, i + 1) && (andSet = this.e.getAndSet(i2, null)) != null) {
                if (andSet.k.t() == 1) {
                    d.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    public final long g(WorkQueue workQueue, boolean z2) {
        Tasks4 tasks4;
        do {
            tasks4 = (Tasks4) workQueue.lastScheduledTask;
            if (tasks4 == null) {
                return -2L;
            }
            if (z2) {
                if (!(tasks4.k.t() == 1)) {
                    return -2L;
                }
            }
            long jA = Tasks7.e.a() - tasks4.j;
            long j = Tasks7.a;
            if (jA < j) {
                return j - jA;
            }
        } while (!a.compareAndSet(workQueue, tasks4, null));
        a(tasks4, false);
        return -1L;
    }
}
