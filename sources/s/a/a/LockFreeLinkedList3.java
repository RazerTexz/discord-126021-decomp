package s.a.a;

import com.discord.widgets.chat.input.MentionUtils;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: s.a.a.k, reason: use source file name */
/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LockFreeLinkedList3 {
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedList3.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedList3.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedList3.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    public volatile Object _removedRef = null;

    /* JADX INFO: renamed from: s.a.a.k$a */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static abstract class a extends Atomic2<LockFreeLinkedList3> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LockFreeLinkedList3 f3828b;
        public final LockFreeLinkedList3 c;

        public a(LockFreeLinkedList3 lockFreeLinkedList3) {
            this.c = lockFreeLinkedList3;
        }

        @Override // s.a.a.Atomic2
        public void b(LockFreeLinkedList3 lockFreeLinkedList3, Object obj) {
            LockFreeLinkedList3 lockFreeLinkedList4 = lockFreeLinkedList3;
            boolean z2 = obj == null;
            LockFreeLinkedList3 lockFreeLinkedList5 = z2 ? this.c : this.f3828b;
            if (lockFreeLinkedList5 != null && LockFreeLinkedList3.j.compareAndSet(lockFreeLinkedList4, this, lockFreeLinkedList5) && z2) {
                LockFreeLinkedList3 lockFreeLinkedList6 = this.c;
                LockFreeLinkedList3 lockFreeLinkedList7 = this.f3828b;
                Intrinsics3.checkNotNull(lockFreeLinkedList7);
                lockFreeLinkedList6.g(lockFreeLinkedList7);
            }
        }
    }

    /* JADX INFO: renamed from: s.a.a.k$b */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class b extends Atomic3 {
    }

    public final boolean e(LockFreeLinkedList3 lockFreeLinkedList3, LockFreeLinkedList3 lockFreeLinkedList4) {
        k.lazySet(lockFreeLinkedList3, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedList3, lockFreeLinkedList4);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedList4, lockFreeLinkedList3)) {
            return false;
        }
        lockFreeLinkedList3.g(lockFreeLinkedList4);
        return true;
    }

    public final LockFreeLinkedList3 f(Atomic3 atomic3) {
        Object obj;
        while (true) {
            LockFreeLinkedList3 lockFreeLinkedList3 = (LockFreeLinkedList3) this._prev;
            LockFreeLinkedList3 lockFreeLinkedList4 = lockFreeLinkedList3;
            while (true) {
                LockFreeLinkedList3 lockFreeLinkedList5 = null;
                while (true) {
                    obj = lockFreeLinkedList4._next;
                    if (obj == this) {
                        if (lockFreeLinkedList3 != lockFreeLinkedList4 && !k.compareAndSet(this, lockFreeLinkedList3, lockFreeLinkedList4)) {
                            break;
                        }
                        return lockFreeLinkedList4;
                    }
                    if (m()) {
                        return null;
                    }
                    if (obj == null) {
                        return lockFreeLinkedList4;
                    }
                    if (obj instanceof Atomic3) {
                        ((Atomic3) obj).a(lockFreeLinkedList4);
                        break;
                    }
                    if (!(obj instanceof LockFreeLinkedList4)) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        lockFreeLinkedList5 = lockFreeLinkedList4;
                        lockFreeLinkedList4 = (LockFreeLinkedList3) obj;
                    } else {
                        if (lockFreeLinkedList5 != null) {
                            break;
                        }
                        lockFreeLinkedList4 = (LockFreeLinkedList3) lockFreeLinkedList4._prev;
                    }
                }
                if (!j.compareAndSet(lockFreeLinkedList5, lockFreeLinkedList4, ((LockFreeLinkedList4) obj).a)) {
                    break;
                }
                lockFreeLinkedList4 = lockFreeLinkedList5;
            }
        }
    }

    public final void g(LockFreeLinkedList3 lockFreeLinkedList3) {
        LockFreeLinkedList3 lockFreeLinkedList4;
        do {
            lockFreeLinkedList4 = (LockFreeLinkedList3) lockFreeLinkedList3._prev;
            if (i() != lockFreeLinkedList3) {
                return;
            }
        } while (!k.compareAndSet(lockFreeLinkedList3, lockFreeLinkedList4, this));
        if (m()) {
            lockFreeLinkedList3.f(null);
        }
    }

    public final Object i() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof Atomic3)) {
                return obj;
            }
            ((Atomic3) obj).a(this);
        }
    }

    public final LockFreeLinkedList3 j() {
        LockFreeLinkedList3 lockFreeLinkedList3;
        Object objI = i();
        LockFreeLinkedList4 lockFreeLinkedList4 = (LockFreeLinkedList4) (!(objI instanceof LockFreeLinkedList4) ? null : objI);
        if (lockFreeLinkedList4 != null && (lockFreeLinkedList3 = lockFreeLinkedList4.a) != null) {
            return lockFreeLinkedList3;
        }
        Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        return (LockFreeLinkedList3) objI;
    }

    public final LockFreeLinkedList3 k() {
        LockFreeLinkedList3 lockFreeLinkedList3F = f(null);
        if (lockFreeLinkedList3F == null) {
            Object obj = this._prev;
            while (true) {
                lockFreeLinkedList3F = (LockFreeLinkedList3) obj;
                if (!lockFreeLinkedList3F.m()) {
                    break;
                }
                obj = lockFreeLinkedList3F._prev;
            }
        }
        return lockFreeLinkedList3F;
    }

    public final void l() {
        LockFreeLinkedList3 lockFreeLinkedList3 = this;
        while (true) {
            Object objI = lockFreeLinkedList3.i();
            if (!(objI instanceof LockFreeLinkedList4)) {
                lockFreeLinkedList3.f(null);
                return;
            }
            lockFreeLinkedList3 = ((LockFreeLinkedList4) objI).a;
        }
    }

    public boolean m() {
        return i() instanceof LockFreeLinkedList4;
    }

    public boolean n() {
        return o() == null;
    }

    public final LockFreeLinkedList3 o() {
        Object objI;
        LockFreeLinkedList3 lockFreeLinkedList3;
        LockFreeLinkedList4 lockFreeLinkedList4;
        do {
            objI = i();
            if (objI instanceof LockFreeLinkedList4) {
                return ((LockFreeLinkedList4) objI).a;
            }
            if (objI == this) {
                return (LockFreeLinkedList3) objI;
            }
            Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            lockFreeLinkedList3 = (LockFreeLinkedList3) objI;
            lockFreeLinkedList4 = (LockFreeLinkedList4) lockFreeLinkedList3._removedRef;
            if (lockFreeLinkedList4 == null) {
                lockFreeLinkedList4 = new LockFreeLinkedList4(lockFreeLinkedList3);
                l.lazySet(lockFreeLinkedList3, lockFreeLinkedList4);
            }
        } while (!j.compareAndSet(this, objI, lockFreeLinkedList4));
        lockFreeLinkedList3.f(null);
        return null;
    }

    public final int p(LockFreeLinkedList3 lockFreeLinkedList3, LockFreeLinkedList3 lockFreeLinkedList4, a aVar) {
        k.lazySet(lockFreeLinkedList3, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedList3, lockFreeLinkedList4);
        aVar.f3828b = lockFreeLinkedList4;
        if (atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedList4, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtils.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this));
    }
}
