package p659s.p660a.p663c2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.C12185b;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p659s.p660a.AbstractC13092e;
import p659s.p660a.C13126l;
import p659s.p660a.C13129m;
import p659s.p660a.p661a.C13026i;
import p659s.p660a.p661a.C13027j;
import p659s.p660a.p661a.C13028k;
import p659s.p660a.p661a.C13032o;
import p659s.p660a.p661a.C13034q;
import p659s.p660a.p661a.C13036s;
import p659s.p660a.p661a.C13037t;
import p659s.p660a.p663c2.C13075v;

/* JADX INFO: renamed from: s.a.c2.a */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC13054a<E> extends AbstractC13056c<E> implements InterfaceC13059f<E> {

    /* JADX INFO: renamed from: s.a.c2.a$a */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static final class a<E> implements InterfaceC13060g<E> {

        /* JADX INFO: renamed from: a */
        public Object f27729a = C13055b.f27742d;

        /* JADX INFO: renamed from: b */
        public final AbstractC13054a<E> f27730b;

        public a(AbstractC13054a<E> abstractC13054a) {
            this.f27730b = abstractC13054a;
        }

        @Override // p659s.p660a.p663c2.InterfaceC13060g
        /* JADX INFO: renamed from: a */
        public Object mo11207a(Continuation<? super Boolean> continuation) {
            Object obj = this.f27729a;
            C13037t c13037t = C13055b.f27742d;
            if (obj != c13037t) {
                return C12185b.boxBoolean(m11208b(obj));
            }
            Object objMo11206v = this.f27730b.mo11206v();
            this.f27729a = objMo11206v;
            if (objMo11206v != c13037t) {
                return C12185b.boxBoolean(m11208b(objMo11206v));
            }
            C13126l c13126lM4324o0 = C3404f.m4324o0(C12182b.intercepted(continuation));
            d dVar = new d(this, c13126lM4324o0);
            while (true) {
                if (this.f27730b.mo11202r(dVar)) {
                    AbstractC13054a<E> abstractC13054a = this.f27730b;
                    Objects.requireNonNull(abstractC13054a);
                    c13126lM4324o0.mo10902f(abstractC13054a.new e(dVar));
                    break;
                }
                Object objMo11206v2 = this.f27730b.mo11206v();
                this.f27729a = objMo11206v2;
                if (objMo11206v2 instanceof C13062i) {
                    C13062i c13062i = (C13062i) objMo11206v2;
                    if (c13062i.f27763m != null) {
                        Throwable thM11233v = c13062i.m11233v();
                        C12112k.a aVar = C12112k.f25169j;
                        c13126lM4324o0.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(thM11233v)));
                        break;
                    }
                    Boolean boolBoxBoolean = C12185b.boxBoolean(false);
                    C12112k.a aVar2 = C12112k.f25169j;
                    c13126lM4324o0.resumeWith(C12112k.m11474constructorimpl(boolBoxBoolean));
                    break;
                }
                if (objMo11206v2 != C13055b.f27742d) {
                    Boolean boolBoxBoolean2 = C12185b.boxBoolean(true);
                    Function1<E, Unit> function1 = this.f27730b.f27747l;
                    c13126lM4324o0.m11330y(boolBoxBoolean2, c13126lM4324o0.f27864l, function1 != null ? new C13032o(function1, objMo11206v2, c13126lM4324o0.f27871o) : null);
                    break;
                }
            }
            Object objM11326u = c13126lM4324o0.m11326u();
            if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
                C12190g.probeCoroutineSuspended(continuation);
            }
            return objM11326u;
        }

        /* JADX INFO: renamed from: b */
        public final boolean m11208b(Object obj) throws Throwable {
            if (!(obj instanceof C13062i)) {
                return true;
            }
            C13062i c13062i = (C13062i) obj;
            if (c13062i.f27763m == null) {
                return false;
            }
            Throwable thM11233v = c13062i.m11233v();
            String str = C13036s.f27703a;
            throw thM11233v;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p659s.p660a.p663c2.InterfaceC13060g
        public E next() throws Throwable {
            E e = (E) this.f27729a;
            if (e instanceof C13062i) {
                Throwable thM11233v = ((C13062i) e).m11233v();
                String str = C13036s.f27703a;
                throw thM11233v;
            }
            C13037t c13037t = C13055b.f27742d;
            if (e == c13037t) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.f27729a = c13037t;
            return e;
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$b */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static class b<E> extends AbstractC13067n<E> {

        /* JADX INFO: renamed from: m */
        public final CancellableContinuation<Object> f27731m;

        /* JADX INFO: renamed from: n */
        public final int f27732n;

        public b(CancellableContinuation<Object> cancellableContinuation, int i) {
            this.f27731m = cancellableContinuation;
            this.f27732n = i;
        }

        @Override // p659s.p660a.p663c2.InterfaceC13069p
        /* JADX INFO: renamed from: c */
        public void mo11209c(E e) {
            this.f27731m.mo10907r(C13129m.f27874a);
        }

        @Override // p659s.p660a.p663c2.InterfaceC13069p
        /* JADX INFO: renamed from: d */
        public C13037t mo11210d(E e, C13028k.b bVar) {
            if (this.f27731m.mo10904h(this.f27732n != 2 ? e : new C13075v(e), null, mo11212q(e)) != null) {
                return C13129m.f27874a;
            }
            return null;
        }

        @Override // p659s.p660a.p663c2.AbstractC13067n
        /* JADX INFO: renamed from: r */
        public void mo11211r(C13062i<?> c13062i) {
            int i = this.f27732n;
            if (i == 1 && c13062i.f27763m == null) {
                CancellableContinuation<Object> cancellableContinuation = this.f27731m;
                C12112k.a aVar = C12112k.f25169j;
                cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(null));
            } else {
                if (i == 2) {
                    CancellableContinuation<Object> cancellableContinuation2 = this.f27731m;
                    C13075v c13075v = new C13075v(new C13075v.a(c13062i.f27763m));
                    C12112k.a aVar2 = C12112k.f25169j;
                    cancellableContinuation2.resumeWith(C12112k.m11474constructorimpl(c13075v));
                    return;
                }
                CancellableContinuation<Object> cancellableContinuation3 = this.f27731m;
                Throwable thM11233v = c13062i.m11233v();
                C12112k.a aVar3 = C12112k.f25169j;
                cancellableContinuation3.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(thM11233v)));
            }
        }

        @Override // p659s.p660a.p661a.C13028k
        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ReceiveElement@");
            sbM833U.append(C3404f.m4312l0(this));
            sbM833U.append("[receiveMode=");
            return C1643a.m813A(sbM833U, this.f27732n, ']');
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$c */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static final class c<E> extends b<E> {

        /* JADX INFO: renamed from: o */
        public final Function1<E, Unit> f27733o;

        /* JADX WARN: Multi-variable type inference failed */
        public c(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.f27733o = function1;
        }

        @Override // p659s.p660a.p663c2.AbstractC13067n
        /* JADX INFO: renamed from: q */
        public Function1<Throwable, Unit> mo11212q(E e) {
            return new C13032o(this.f27733o, e, this.f27731m.getContext());
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$d */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static class d<E> extends AbstractC13067n<E> {

        /* JADX INFO: renamed from: m */
        public final a<E> f27734m;

        /* JADX INFO: renamed from: n */
        public final CancellableContinuation<Boolean> f27735n;

        /* JADX WARN: Multi-variable type inference failed */
        public d(a<E> aVar, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f27734m = aVar;
            this.f27735n = cancellableContinuation;
        }

        @Override // p659s.p660a.p663c2.InterfaceC13069p
        /* JADX INFO: renamed from: c */
        public void mo11209c(E e) {
            this.f27734m.f27729a = e;
            this.f27735n.mo10907r(C13129m.f27874a);
        }

        @Override // p659s.p660a.p663c2.InterfaceC13069p
        /* JADX INFO: renamed from: d */
        public C13037t mo11210d(E e, C13028k.b bVar) {
            if (this.f27735n.mo10904h(Boolean.TRUE, null, mo11212q(e)) != null) {
                return C13129m.f27874a;
            }
            return null;
        }

        @Override // p659s.p660a.p663c2.AbstractC13067n
        /* JADX INFO: renamed from: q */
        public Function1<Throwable, Unit> mo11212q(E e) {
            Function1<E, Unit> function1 = this.f27734m.f27730b.f27747l;
            if (function1 != null) {
                return new C13032o(function1, e, this.f27735n.getContext());
            }
            return null;
        }

        @Override // p659s.p660a.p663c2.AbstractC13067n
        /* JADX INFO: renamed from: r */
        public void mo11211r(C13062i<?> c13062i) {
            Object objMo10901c = c13062i.f27763m == null ? this.f27735n.mo10901c(Boolean.FALSE, null) : this.f27735n.mo10903g(c13062i.m11233v());
            if (objMo10901c != null) {
                this.f27734m.f27729a = c13062i;
                this.f27735n.mo10907r(objMo10901c);
            }
        }

        @Override // p659s.p660a.p661a.C13028k
        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ReceiveHasNext@");
            sbM833U.append(C3404f.m4312l0(this));
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$e */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public final class e extends AbstractC13092e {

        /* JADX INFO: renamed from: j */
        public final AbstractC13067n<?> f27736j;

        public e(AbstractC13067n<?> abstractC13067n) {
            this.f27736j = abstractC13067n;
        }

        @Override // p659s.p660a.AbstractC13123k
        /* JADX INFO: renamed from: a */
        public void mo11193a(Throwable th) {
            if (this.f27736j.mo11151n()) {
                Objects.requireNonNull(AbstractC13054a.this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            if (this.f27736j.mo11151n()) {
                Objects.requireNonNull(AbstractC13054a.this);
            }
            return Unit.f27425a;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("RemoveReceiveOnCancel[");
            sbM833U.append(this.f27736j);
            sbM833U.append(']');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$f */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class f extends C13028k.a {

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ AbstractC13054a f27738d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(C13028k c13028k, C13028k c13028k2, AbstractC13054a abstractC13054a) {
            super(c13028k2);
            this.f27738d = abstractC13054a;
        }

        @Override // p659s.p660a.p661a.AbstractC13021d
        /* JADX INFO: renamed from: c */
        public Object mo11144c(C13028k c13028k) {
            if (this.f27738d.mo11204t()) {
                return null;
            }
            return C13027j.f27683a;
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$g */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    @InterfaceC12188e(m10084c = "kotlinx.coroutines.channels.AbstractChannel", m10085f = "AbstractChannel.kt", m10086l = {624}, m10087m = "receiveOrClosed-ZYPwvRU")
    public static final class g extends AbstractC12187d {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public g(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AbstractC13054a.this.mo11200m(this);
        }
    }

    public AbstractC13054a(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // p659s.p660a.p663c2.InterfaceC13068o
    /* JADX INFO: renamed from: b */
    public final void mo11199b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(getClass().getSimpleName() + " was cancelled");
        }
        mo11205u(mo11221j(cancellationException));
    }

    @Override // p659s.p660a.p663c2.InterfaceC13068o
    public final InterfaceC13060g<E> iterator() {
        return new a(this);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p659s.p660a.p663c2.InterfaceC13068o
    /* JADX INFO: renamed from: m */
    public final Object mo11200m(Continuation<? super C13075v<? extends E>> continuation) {
        g gVar;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i = gVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                gVar.label = i - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        } else {
            gVar = new g(continuation);
        }
        Object objM11326u = gVar.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = gVar.label;
        if (i2 == 0) {
            C12113l.throwOnFailure(objM11326u);
            Object objMo11206v = mo11206v();
            if (objMo11206v != C13055b.f27742d) {
                return objMo11206v instanceof C13062i ? new C13075v.a(((C13062i) objMo11206v).f27763m) : objMo11206v;
            }
            gVar.L$0 = this;
            gVar.L$1 = objMo11206v;
            gVar.label = 1;
            C13126l c13126lM4324o0 = C3404f.m4324o0(C12182b.intercepted(gVar));
            b bVar = this.f27747l == null ? new b(c13126lM4324o0, 2) : new c(c13126lM4324o0, 2, this.f27747l);
            while (true) {
                if (mo11202r(bVar)) {
                    c13126lM4324o0.mo10902f(new e(bVar));
                    break;
                }
                Object objMo11206v2 = mo11206v();
                if (objMo11206v2 instanceof C13062i) {
                    bVar.mo11211r((C13062i) objMo11206v2);
                    break;
                }
                if (objMo11206v2 != C13055b.f27742d) {
                    c13126lM4324o0.m11330y(bVar.f27732n != 2 ? objMo11206v2 : new C13075v(objMo11206v2), c13126lM4324o0.f27864l, bVar.mo11212q(objMo11206v2));
                    break;
                }
            }
            objM11326u = c13126lM4324o0.m11326u();
            if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
                C12190g.probeCoroutineSuspended(gVar);
            }
            if (objM11326u == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(objM11326u);
        }
        return ((C13075v) objM11326u).f27770a;
    }

    @Override // p659s.p660a.p663c2.AbstractC13056c
    /* JADX INFO: renamed from: n */
    public InterfaceC13069p<E> mo11201n() {
        InterfaceC13069p<E> interfaceC13069pMo11201n = super.mo11201n();
        if (interfaceC13069pMo11201n != null) {
            boolean z2 = interfaceC13069pMo11201n instanceof C13062i;
        }
        return interfaceC13069pMo11201n;
    }

    /* JADX INFO: renamed from: r */
    public boolean mo11202r(AbstractC13067n<? super E> abstractC13067n) {
        int iM11160p;
        C13028k c13028kM11157k;
        if (!mo11203s()) {
            C13028k c13028k = this.f27746k;
            f fVar = new f(abstractC13067n, abstractC13067n, this);
            do {
                C13028k c13028kM11157k2 = c13028k.m11157k();
                if (!(!(c13028kM11157k2 instanceof AbstractC13071r))) {
                    break;
                }
                iM11160p = c13028kM11157k2.m11160p(abstractC13067n, c13028k, fVar);
                if (iM11160p == 1) {
                    return true;
                }
            } while (iM11160p != 2);
        } else {
            C13028k c13028k2 = this.f27746k;
            do {
                c13028kM11157k = c13028k2.m11157k();
                if (!(!(c13028kM11157k instanceof AbstractC13071r))) {
                }
            } while (!c13028kM11157k.m11152e(abstractC13067n, c13028k2));
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: s */
    public abstract boolean mo11203s();

    /* JADX INFO: renamed from: t */
    public abstract boolean mo11204t();

    /* JADX INFO: renamed from: u */
    public void mo11205u(boolean z2) {
        C13062i<?> c13062iM11216e = m11216e();
        if (c13062iM11216e == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objM4247T0 = null;
        while (true) {
            C13028k c13028kM11157k = c13062iM11216e.m11157k();
            if (c13028kM11157k instanceof C13026i) {
                break;
            }
            if (c13028kM11157k.mo11151n()) {
                objM4247T0 = C3404f.m4247T0(objM4247T0, (AbstractC13071r) c13028kM11157k);
            } else {
                Object objM11155i = c13028kM11157k.m11155i();
                Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
                ((C13034q) objM11155i).f27701a.m11153f(null);
            }
        }
        if (objM4247T0 == null) {
            return;
        }
        if (!(objM4247T0 instanceof ArrayList)) {
            ((AbstractC13071r) objM4247T0).mo11229s(c13062iM11216e);
            return;
        }
        ArrayList arrayList = (ArrayList) objM4247T0;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((AbstractC13071r) arrayList.get(size)).mo11229s(c13062iM11216e);
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public Object mo11206v() {
        while (true) {
            AbstractC13071r abstractC13071rM11226q = m11226q();
            if (abstractC13071rM11226q == null) {
                return C13055b.f27742d;
            }
            if (abstractC13071rM11226q.mo11230t(null) != null) {
                abstractC13071rM11226q.mo11227q();
                return abstractC13071rM11226q.mo11228r();
            }
            abstractC13071rM11226q.mo11241u();
        }
    }
}
