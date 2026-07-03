package p659s.p660a.p663c2;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C11211b;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13126l;
import p659s.p660a.C13129m;
import p659s.p660a.C13146r1;
import p659s.p660a.p661a.C13026i;
import p659s.p660a.p661a.C13027j;
import p659s.p660a.p661a.C13028k;
import p659s.p660a.p661a.C13034q;
import p659s.p660a.p661a.C13036s;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.c2.c */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC13056c<E> implements InterfaceC13072s<E> {

    /* JADX INFO: renamed from: j */
    public static final AtomicReferenceFieldUpdater f27745j = AtomicReferenceFieldUpdater.newUpdater(AbstractC13056c.class, Object.class, "onCloseHandler");

    /* JADX INFO: renamed from: l */
    public final Function1<E, Unit> f27747l;

    /* JADX INFO: renamed from: k */
    public final C13026i f27746k = new C13026i();
    public volatile Object onCloseHandler = null;

    /* JADX INFO: renamed from: s.a.c2.c$a */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static final class a<E> extends AbstractC13071r {

        /* JADX INFO: renamed from: m */
        public final E f27748m;

        public a(E e) {
            this.f27748m = e;
        }

        @Override // p659s.p660a.p663c2.AbstractC13071r
        /* JADX INFO: renamed from: q */
        public void mo11227q() {
        }

        @Override // p659s.p660a.p663c2.AbstractC13071r
        /* JADX INFO: renamed from: r */
        public Object mo11228r() {
            return this.f27748m;
        }

        @Override // p659s.p660a.p663c2.AbstractC13071r
        /* JADX INFO: renamed from: s */
        public void mo11229s(C13062i<?> c13062i) {
        }

        @Override // p659s.p660a.p663c2.AbstractC13071r
        /* JADX INFO: renamed from: t */
        public C13037t mo11230t(C13028k.b bVar) {
            return C13129m.f27874a;
        }

        @Override // p659s.p660a.p661a.C13028k
        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SendBuffered@");
            sbM833U.append(C3404f.m4312l0(this));
            sbM833U.append('(');
            sbM833U.append(this.f27748m);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.c2.c$b */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class b extends C13028k.a {

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ AbstractC13056c f27749d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C13028k c13028k, C13028k c13028k2, AbstractC13056c abstractC13056c) {
            super(c13028k2);
            this.f27749d = abstractC13056c;
        }

        @Override // p659s.p660a.p661a.AbstractC13021d
        /* JADX INFO: renamed from: c */
        public Object mo11144c(C13028k c13028k) {
            if (this.f27749d.mo11220i()) {
                return null;
            }
            return C13027j.f27683a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC13056c(Function1<? super E, Unit> function1) {
        this.f27747l = function1;
    }

    /* JADX INFO: renamed from: a */
    public static final void m11213a(AbstractC13056c abstractC13056c, Continuation continuation, Object obj, C13062i c13062i) {
        UndeliveredElementException undeliveredElementExceptionM4331q;
        abstractC13056c.m11217f(c13062i);
        Throwable thM11234w = c13062i.m11234w();
        Function1<E, Unit> function1 = abstractC13056c.f27747l;
        if (function1 == null || (undeliveredElementExceptionM4331q = C3404f.m4331q(function1, obj, null, 2)) == null) {
            C12112k.a aVar = C12112k.f25169j;
            ((C13126l) continuation).resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(thM11234w)));
        } else {
            C11211b.addSuppressed(undeliveredElementExceptionM4331q, thM11234w);
            C12112k.a aVar2 = C12112k.f25169j;
            ((C13126l) continuation).resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(undeliveredElementExceptionM4331q)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0036  */
    /* JADX WARN: Code duplicated, block: B:24:0x0039 A[ORIG_RETURN, RETURN] */
    /* JADX INFO: renamed from: c */
    public Object mo11214c(AbstractC13071r abstractC13071r) {
        int iM11160p;
        boolean z2;
        C13028k c13028kM11157k;
        if (mo11219h()) {
            C13028k c13028k = this.f27746k;
            do {
                c13028kM11157k = c13028k.m11157k();
                if (c13028kM11157k instanceof InterfaceC13069p) {
                    return c13028kM11157k;
                }
            } while (!c13028kM11157k.m11152e(abstractC13071r, c13028k));
            return null;
        }
        C13028k c13028k2 = this.f27746k;
        b bVar = new b(abstractC13071r, abstractC13071r, this);
        do {
            C13028k c13028kM11157k2 = c13028k2.m11157k();
            if (c13028kM11157k2 instanceof InterfaceC13069p) {
                return c13028kM11157k2;
            }
            iM11160p = c13028kM11157k2.m11160p(abstractC13071r, c13028k2, bVar);
            z2 = true;
            if (iM11160p != 1) {
            }
            if (z2) {
                return null;
            }
            return C13055b.f27743e;
        } while (iM11160p != 2);
        z2 = false;
        if (z2) {
            return C13055b.f27743e;
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public String mo11215d() {
        return "";
    }

    /* JADX INFO: renamed from: e */
    public final C13062i<?> m11216e() {
        C13028k c13028kM11157k = this.f27746k.m11157k();
        if (!(c13028kM11157k instanceof C13062i)) {
            c13028kM11157k = null;
        }
        C13062i<?> c13062i = (C13062i) c13028kM11157k;
        if (c13062i == null) {
            return null;
        }
        m11217f(c13062i);
        return c13062i;
    }

    /* JADX INFO: renamed from: f */
    public final void m11217f(C13062i<?> c13062i) {
        Object objM4247T0 = null;
        while (true) {
            C13028k c13028kM11157k = c13062i.m11157k();
            if (!(c13028kM11157k instanceof AbstractC13067n)) {
                c13028kM11157k = null;
            }
            AbstractC13067n abstractC13067n = (AbstractC13067n) c13028kM11157k;
            if (abstractC13067n == null) {
                break;
            }
            if (abstractC13067n.mo11151n()) {
                objM4247T0 = C3404f.m4247T0(objM4247T0, abstractC13067n);
            } else {
                Object objM11155i = abstractC13067n.m11155i();
                Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
                ((C13034q) objM11155i).f27701a.m11153f(null);
            }
        }
        if (objM4247T0 == null) {
            return;
        }
        if (!(objM4247T0 instanceof ArrayList)) {
            ((AbstractC13067n) objM4247T0).mo11211r(c13062i);
            return;
        }
        ArrayList arrayList = (ArrayList) objM4247T0;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((AbstractC13067n) arrayList.get(size)).mo11211r(c13062i);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final Throwable m11218g(E e, C13062i<?> c13062i) {
        UndeliveredElementException undeliveredElementExceptionM4331q;
        m11217f(c13062i);
        Function1<E, Unit> function1 = this.f27747l;
        if (function1 == null || (undeliveredElementExceptionM4331q = C3404f.m4331q(function1, e, null, 2)) == null) {
            return c13062i.m11234w();
        }
        C11211b.addSuppressed(undeliveredElementExceptionM4331q, c13062i.m11234w());
        throw undeliveredElementExceptionM4331q;
    }

    /* JADX INFO: renamed from: h */
    public abstract boolean mo11219h();

    /* JADX INFO: renamed from: i */
    public abstract boolean mo11220i();

    @Override // p659s.p660a.p663c2.InterfaceC13072s
    /* JADX INFO: renamed from: j */
    public boolean mo11221j(Throwable th) {
        boolean z2;
        Object obj;
        C13037t c13037t;
        C13062i<?> c13062i = new C13062i<>(th);
        C13028k c13028k = this.f27746k;
        while (true) {
            C13028k c13028kM11157k = c13028k.m11157k();
            if (!(!(c13028kM11157k instanceof C13062i))) {
                z2 = false;
                break;
            }
            if (c13028kM11157k.m11152e(c13062i, c13028k)) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            c13062i = (C13062i) this.f27746k.m11157k();
        }
        m11217f(c13062i);
        if (z2 && (obj = this.onCloseHandler) != null && obj != (c13037t = C13055b.f27744f) && f27745j.compareAndSet(this, obj, c13037t)) {
            ((Function1) C12224e0.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th);
        }
        return z2;
    }

    /* JADX INFO: renamed from: k */
    public Object mo11222k(E e) {
        InterfaceC13069p<E> interfaceC13069pMo11201n;
        do {
            interfaceC13069pMo11201n = mo11201n();
            if (interfaceC13069pMo11201n == null) {
                return C13055b.f27741c;
            }
        } while (interfaceC13069pMo11201n.mo11210d(e, null) == null);
        interfaceC13069pMo11201n.mo11209c(e);
        return interfaceC13069pMo11201n.mo11232b();
    }

    @Override // p659s.p660a.p663c2.InterfaceC13072s
    /* JADX INFO: renamed from: l */
    public void mo11223l(Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f27745j;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj != C13055b.f27744f) {
                throw new IllegalStateException(C1643a.m881v("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        C13062i<?> c13062iM11216e = m11216e();
        if (c13062iM11216e == null || !atomicReferenceFieldUpdater.compareAndSet(this, function1, C13055b.f27744f)) {
            return;
        }
        function1.invoke(c13062iM11216e.f27763m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [s.a.a.k] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX INFO: renamed from: n */
    public InterfaceC13069p<E> mo11201n() {
        ?? r1;
        C13028k c13028kM11159o;
        C13026i c13026i = this.f27746k;
        while (true) {
            Object objM11155i = c13026i.m11155i();
            Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            r1 = (C13028k) objM11155i;
            if (r1 == c13026i || !(r1 instanceof InterfaceC13069p)) {
                break;
            }
            if ((!(((InterfaceC13069p) r1) instanceof C13062i) || r1.mo11150m()) && (c13028kM11159o = r1.m11159o()) != null) {
                c13028kM11159o.m11158l();
            }
            return (InterfaceC13069p) r1;
        }
        r1 = 0;
        return (InterfaceC13069p) r1;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0080  */
    /* JADX WARN: Code duplicated, block: B:40:0x0089 A[EDGE_INSN: B:40:0x0089->B:41:0x008e BREAK  A[LOOP:0: B:7:0x0013->B:56:?]] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:51:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:? A[LOOP:0: B:7:0x0013->B:56:?, LOOP_END, SYNTHETIC] */
    @Override // p659s.p660a.p663c2.InterfaceC13072s
    /* JADX INFO: renamed from: o */
    public final Object mo11224o(E e, Continuation<? super Unit> continuation) {
        Object objMo11222k;
        if (mo11222k(e) == C13055b.f27740b) {
            return Unit.f27425a;
        }
        C13126l c13126lM4324o0 = C3404f.m4324o0(C12182b.intercepted(continuation));
        while (true) {
            if (!(this.f27746k.m11156j() instanceof InterfaceC13069p) && mo11220i()) {
                AbstractC13071r c13073t = this.f27747l == null ? new C13073t(e, c13126lM4324o0) : new C13074u(e, c13126lM4324o0, this.f27747l);
                Object objMo11214c = mo11214c(c13073t);
                if (objMo11214c == null) {
                    c13126lM4324o0.mo10902f(new C13146r1(c13073t));
                    break;
                }
                if (objMo11214c instanceof C13062i) {
                    m11213a(this, c13126lM4324o0, e, (C13062i) objMo11214c);
                    break;
                }
                if (objMo11214c != C13055b.f27743e && !(objMo11214c instanceof AbstractC13067n)) {
                    throw new IllegalStateException(C1643a.m881v("enqueueSend returned ", objMo11214c).toString());
                }
                objMo11222k = mo11222k(e);
                if (objMo11222k == C13055b.f27740b) {
                    Unit unit = Unit.f27425a;
                    C12112k.a aVar = C12112k.f25169j;
                    c13126lM4324o0.resumeWith(C12112k.m11474constructorimpl(unit));
                    break;
                }
                if (objMo11222k == C13055b.f27741c) {
                    if (objMo11222k instanceof C13062i) {
                        throw new IllegalStateException(C1643a.m881v("offerInternal returned ", objMo11222k).toString());
                    }
                    m11213a(this, c13126lM4324o0, e, (C13062i) objMo11222k);
                    break;
                }
            } else {
                objMo11222k = mo11222k(e);
                if (objMo11222k == C13055b.f27740b) {
                    Unit unit2 = Unit.f27425a;
                    C12112k.a aVar2 = C12112k.f25169j;
                    c13126lM4324o0.resumeWith(C12112k.m11474constructorimpl(unit2));
                    break;
                }
                if (objMo11222k == C13055b.f27741c) {
                    if (objMo11222k instanceof C13062i) {
                        throw new IllegalStateException(C1643a.m881v("offerInternal returned ", objMo11222k).toString());
                    }
                    m11213a(this, c13126lM4324o0, e, (C13062i) objMo11222k);
                    break;
                }
            }
        }
        Object objM11326u = c13126lM4324o0.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        return objM11326u == C12183c.getCOROUTINE_SUSPENDED() ? objM11326u : Unit.f27425a;
    }

    @Override // p659s.p660a.p663c2.InterfaceC13072s
    public final boolean offer(E e) throws Throwable {
        Object objMo11222k = mo11222k(e);
        if (objMo11222k == C13055b.f27740b) {
            return true;
        }
        if (objMo11222k != C13055b.f27741c) {
            if (!(objMo11222k instanceof C13062i)) {
                throw new IllegalStateException(C1643a.m881v("offerInternal returned ", objMo11222k).toString());
            }
            Throwable thM11218g = m11218g(e, (C13062i) objMo11222k);
            String str = C13036s.f27703a;
            throw thM11218g;
        }
        C13062i<?> c13062iM11216e = m11216e();
        if (c13062iM11216e == null) {
            return false;
        }
        Throwable thM11218g2 = m11218g(e, c13062iM11216e);
        String str2 = C13036s.f27703a;
        throw thM11218g2;
    }

    @Override // p659s.p660a.p663c2.InterfaceC13072s
    /* JADX INFO: renamed from: p */
    public final boolean mo11225p() {
        return m11216e() != null;
    }

    /* JADX INFO: renamed from: q */
    public final AbstractC13071r m11226q() {
        C13028k c13028k;
        C13028k c13028kM11159o;
        C13026i c13026i = this.f27746k;
        while (true) {
            Object objM11155i = c13026i.m11155i();
            Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            c13028k = (C13028k) objM11155i;
            if (c13028k == c13026i || !(c13028k instanceof AbstractC13071r)) {
                break;
            }
            if ((!(((AbstractC13071r) c13028k) instanceof C13062i) || c13028k.mo11150m()) && (c13028kM11159o = c13028k.m11159o()) != null) {
                c13028kM11159o.m11158l();
            }
            return (AbstractC13071r) c13028k;
        }
        c13028k = null;
        return (AbstractC13071r) c13028k;
    }

    public String toString() {
        String string;
        String string2;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(MentionUtilsKt.MENTIONS_CHAR);
        sb.append(C3404f.m4312l0(this));
        sb.append('{');
        C13028k c13028kM11156j = this.f27746k.m11156j();
        if (c13028kM11156j == this.f27746k) {
            string2 = "EmptyQueue";
        } else {
            if (c13028kM11156j instanceof C13062i) {
                string = c13028kM11156j.toString();
            } else if (c13028kM11156j instanceof AbstractC13067n) {
                string = "ReceiveQueued";
            } else if (c13028kM11156j instanceof AbstractC13071r) {
                string = "SendQueued";
            } else {
                string = "UNEXPECTED:" + c13028kM11156j;
            }
            C13028k c13028kM11157k = this.f27746k.m11157k();
            if (c13028kM11157k != c13028kM11156j) {
                StringBuilder sbM836X = C1643a.m836X(string, ",queueSize=");
                C13026i c13026i = this.f27746k;
                Object objM11155i = c13026i.m11155i();
                Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                int i = 0;
                for (C13028k c13028kM11156j2 = (C13028k) objM11155i; !C12238m.areEqual(c13028kM11156j2, c13026i); c13028kM11156j2 = c13028kM11156j2.m11156j()) {
                    i++;
                }
                sbM836X.append(i);
                string2 = sbM836X.toString();
                if (c13028kM11157k instanceof C13062i) {
                    string2 = string2 + ",closedForSend=" + c13028kM11157k;
                }
            } else {
                string2 = string;
            }
        }
        sb.append(string2);
        sb.append('}');
        sb.append(mo11215d());
        return sb.toString();
    }
}
