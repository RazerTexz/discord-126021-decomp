package p659s.p660a.p661a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: s.a.a.k */
/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13028k {

    /* JADX INFO: renamed from: j */
    public static final AtomicReferenceFieldUpdater f27684j = AtomicReferenceFieldUpdater.newUpdater(C13028k.class, Object.class, "_next");

    /* JADX INFO: renamed from: k */
    public static final AtomicReferenceFieldUpdater f27685k = AtomicReferenceFieldUpdater.newUpdater(C13028k.class, Object.class, "_prev");

    /* JADX INFO: renamed from: l */
    public static final AtomicReferenceFieldUpdater f27686l = AtomicReferenceFieldUpdater.newUpdater(C13028k.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    public volatile Object _removedRef = null;

    /* JADX INFO: renamed from: s.a.a.k$a */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static abstract class a extends AbstractC13021d<C13028k> {

        /* JADX INFO: renamed from: b */
        public C13028k f27687b;

        /* JADX INFO: renamed from: c */
        public final C13028k f27688c;

        public a(C13028k c13028k) {
            this.f27688c = c13028k;
        }

        @Override // p659s.p660a.p661a.AbstractC13021d
        /* JADX INFO: renamed from: b */
        public void mo11143b(C13028k c13028k, Object obj) {
            C13028k c13028k2 = c13028k;
            boolean z2 = obj == null;
            C13028k c13028k3 = z2 ? this.f27688c : this.f27687b;
            if (c13028k3 != null && C13028k.f27684j.compareAndSet(c13028k2, this, c13028k3) && z2) {
                C13028k c13028k4 = this.f27688c;
                C13028k c13028k5 = this.f27687b;
                C12238m.checkNotNull(c13028k5);
                c13028k4.m11154g(c13028k5);
            }
        }
    }

    /* JADX INFO: renamed from: s.a.a.k$b */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class b extends AbstractC13033p {
    }

    /* JADX INFO: renamed from: e */
    public final boolean m11152e(C13028k c13028k, C13028k c13028k2) {
        f27685k.lazySet(c13028k, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f27684j;
        atomicReferenceFieldUpdater.lazySet(c13028k, c13028k2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, c13028k2, c13028k)) {
            return false;
        }
        c13028k.m11154g(c13028k2);
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final C13028k m11153f(AbstractC13033p abstractC13033p) {
        Object obj;
        while (true) {
            C13028k c13028k = (C13028k) this._prev;
            C13028k c13028k2 = c13028k;
            while (true) {
                C13028k c13028k3 = null;
                while (true) {
                    obj = c13028k2._next;
                    if (obj == this) {
                        if (c13028k != c13028k2 && !f27685k.compareAndSet(this, c13028k, c13028k2)) {
                            break;
                        }
                        return c13028k2;
                    }
                    if (mo11150m()) {
                        return null;
                    }
                    if (obj == null) {
                        return c13028k2;
                    }
                    if (obj instanceof AbstractC13033p) {
                        ((AbstractC13033p) obj).mo11142a(c13028k2);
                        break;
                    }
                    if (!(obj instanceof C13034q)) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        c13028k3 = c13028k2;
                        c13028k2 = (C13028k) obj;
                    } else {
                        if (c13028k3 != null) {
                            break;
                        }
                        c13028k2 = (C13028k) c13028k2._prev;
                    }
                }
                if (!f27684j.compareAndSet(c13028k3, c13028k2, ((C13034q) obj).f27701a)) {
                    break;
                }
                c13028k2 = c13028k3;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m11154g(C13028k c13028k) {
        C13028k c13028k2;
        do {
            c13028k2 = (C13028k) c13028k._prev;
            if (m11155i() != c13028k) {
                return;
            }
        } while (!f27685k.compareAndSet(c13028k, c13028k2, this));
        if (mo11150m()) {
            c13028k.m11153f(null);
        }
    }

    /* JADX INFO: renamed from: i */
    public final Object m11155i() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof AbstractC13033p)) {
                return obj;
            }
            ((AbstractC13033p) obj).mo11142a(this);
        }
    }

    /* JADX INFO: renamed from: j */
    public final C13028k m11156j() {
        C13028k c13028k;
        Object objM11155i = m11155i();
        C13034q c13034q = (C13034q) (!(objM11155i instanceof C13034q) ? null : objM11155i);
        if (c13034q != null && (c13028k = c13034q.f27701a) != null) {
            return c13028k;
        }
        Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        return (C13028k) objM11155i;
    }

    /* JADX INFO: renamed from: k */
    public final C13028k m11157k() {
        C13028k c13028kM11153f = m11153f(null);
        if (c13028kM11153f == null) {
            Object obj = this._prev;
            while (true) {
                c13028kM11153f = (C13028k) obj;
                if (!c13028kM11153f.mo11150m()) {
                    break;
                }
                obj = c13028kM11153f._prev;
            }
        }
        return c13028kM11153f;
    }

    /* JADX INFO: renamed from: l */
    public final void m11158l() {
        C13028k c13028k = this;
        while (true) {
            Object objM11155i = c13028k.m11155i();
            if (!(objM11155i instanceof C13034q)) {
                c13028k.m11153f(null);
                return;
            }
            c13028k = ((C13034q) objM11155i).f27701a;
        }
    }

    /* JADX INFO: renamed from: m */
    public boolean mo11150m() {
        return m11155i() instanceof C13034q;
    }

    /* JADX INFO: renamed from: n */
    public boolean mo11151n() {
        return m11159o() == null;
    }

    /* JADX INFO: renamed from: o */
    public final C13028k m11159o() {
        Object objM11155i;
        C13028k c13028k;
        C13034q c13034q;
        do {
            objM11155i = m11155i();
            if (objM11155i instanceof C13034q) {
                return ((C13034q) objM11155i).f27701a;
            }
            if (objM11155i == this) {
                return (C13028k) objM11155i;
            }
            Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            c13028k = (C13028k) objM11155i;
            c13034q = (C13034q) c13028k._removedRef;
            if (c13034q == null) {
                c13034q = new C13034q(c13028k);
                f27686l.lazySet(c13028k, c13034q);
            }
        } while (!f27684j.compareAndSet(this, objM11155i, c13034q));
        c13028k.m11153f(null);
        return null;
    }

    /* JADX INFO: renamed from: p */
    public final int m11160p(C13028k c13028k, C13028k c13028k2, a aVar) {
        f27685k.lazySet(c13028k, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f27684j;
        atomicReferenceFieldUpdater.lazySet(c13028k, c13028k2);
        aVar.f27687b = c13028k2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, c13028k2, aVar)) {
            return aVar.mo11142a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this));
    }
}
