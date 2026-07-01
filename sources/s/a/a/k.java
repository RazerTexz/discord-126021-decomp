package s.a.a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public class k {
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    public volatile Object _removedRef = null;

    public final boolean e(k kVar, k kVar2) {
        k.lazySet(kVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        atomicReferenceFieldUpdater.lazySet(kVar, kVar2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, kVar2, kVar)) {
            return false;
        }
        kVar.g(kVar2);
        return true;
    }

    public final k f(p pVar) {
        Object obj;
        while (true) {
            k kVar = (k) this._prev;
            k kVar2 = kVar;
            while (true) {
                k kVar3 = null;
                while (true) {
                    obj = kVar2._next;
                    if (obj == this) {
                        if (kVar != kVar2 && !k.compareAndSet(this, kVar, kVar2)) {
                            break;
                        }
                        return kVar2;
                    }
                    if (m()) {
                        return null;
                    }
                    if (obj == null) {
                        return kVar2;
                    }
                    if (obj instanceof p) {
                        ((p) obj).a(kVar2);
                        break;
                    }
                    if (!(obj instanceof q)) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        kVar3 = kVar2;
                        kVar2 = (k) obj;
                    } else {
                        if (kVar3 != null) {
                            break;
                        }
                        kVar2 = (k) kVar2._prev;
                    }
                }
                if (!j.compareAndSet(kVar3, kVar2, ((q) obj).a)) {
                    break;
                }
                kVar2 = kVar3;
            }
        }
    }

    public final void g(k kVar) {
        k kVar2;
        do {
            kVar2 = (k) kVar._prev;
            if (i() != kVar) {
                return;
            }
        } while (!k.compareAndSet(kVar, kVar2, this));
        if (m()) {
            kVar.f(null);
        }
    }

    public final Object i() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof p)) {
                return obj;
            }
            ((p) obj).a(this);
        }
    }

    public final k j() {
        k kVar;
        Object objI = i();
        q qVar = (q) (!(objI instanceof q) ? null : objI);
        if (qVar != null && (kVar = qVar.a) != null) {
            return kVar;
        }
        Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        return (k) objI;
    }

    public final k k() {
        k kVarF = f(null);
        if (kVarF == null) {
            Object obj = this._prev;
            while (true) {
                kVarF = (k) obj;
                if (!kVarF.m()) {
                    break;
                }
                obj = kVarF._prev;
            }
        }
        return kVarF;
    }

    public final void l() {
        k kVar = this;
        while (true) {
            Object objI = kVar.i();
            if (!(objI instanceof q)) {
                kVar.f(null);
                return;
            }
            kVar = ((q) objI).a;
        }
    }

    public boolean m() {
        return i() instanceof q;
    }

    public boolean n() {
        return o() == null;
    }

    public final k o() {
        Object objI;
        k kVar;
        q qVar;
        do {
            objI = i();
            if (objI instanceof q) {
                return ((q) objI).a;
            }
            if (objI == this) {
                return (k) objI;
            }
            Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            kVar = (k) objI;
            qVar = (q) kVar._removedRef;
            if (qVar == null) {
                qVar = new q(kVar);
                l.lazySet(kVar, qVar);
            }
        } while (!j.compareAndSet(this, objI, qVar));
        kVar.f(null);
        return null;
    }

    public final int p(k kVar, k kVar2, k$a k_a) {
        k.lazySet(kVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        atomicReferenceFieldUpdater.lazySet(kVar, kVar2);
        k_a.f3828b = kVar2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, kVar2, k_a)) {
            return k_a.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this));
    }
}
