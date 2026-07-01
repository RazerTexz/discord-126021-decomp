package s.a.e2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f3840b = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");
    public static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");
    public final AtomicReferenceArray<h> e = new AtomicReferenceArray<>(128);
    public volatile Object lastScheduledTask = null;
    public volatile int producerIndex = 0;
    public volatile int consumerIndex = 0;
    public volatile int blockingTasksInBuffer = 0;

    public final h a(h hVar, boolean z2) {
        if (z2) {
            return b(hVar);
        }
        h hVar2 = (h) a.getAndSet(this, hVar);
        if (hVar2 != null) {
            return b(hVar2);
        }
        return null;
    }

    public final h b(h hVar) {
        if (hVar.k.t() == 1) {
            d.incrementAndGet(this);
        }
        if (c() == 127) {
            return hVar;
        }
        int i = this.producerIndex & Opcodes.LAND;
        while (this.e.get(i) != null) {
            Thread.yield();
        }
        this.e.lazySet(i, hVar);
        f3840b.incrementAndGet(this);
        return null;
    }

    public final int c() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int d() {
        return this.lastScheduledTask != null ? c() + 1 : c();
    }

    public final h e() {
        h hVar = (h) a.getAndSet(this, null);
        return hVar != null ? hVar : f();
    }

    public final h f() {
        h andSet;
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

    public final long g(m mVar, boolean z2) {
        h hVar;
        do {
            hVar = (h) mVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z2) {
                if (!(hVar.k.t() == 1)) {
                    return -2L;
                }
            }
            long jA = k.e.a() - hVar.j;
            long j = k.a;
            if (jA < j) {
                return j - jA;
            }
        } while (!a.compareAndSet(mVar, hVar, null));
        a(hVar, false);
        return -1L;
    }
}
