package s.a.c2;

import b.d.b.a.outline;
import d0.Result2;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.w.i.a.boxing;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import s.a.CancellableContinuationImpl3;
import s.a.CancellableContinuationImpl5;
import s.a.CancellableContinuationImpl6;
import s.a.a.LockFreeLinkedList;
import s.a.a.LockFreeLinkedList2;
import s.a.a.LockFreeLinkedList3;
import s.a.a.LockFreeLinkedList4;
import s.a.a.OnUndeliveredElement2;
import s.a.a.StackTraceRecovery;
import s.a.a.Symbol3;
import s.a.c2.Channel8;

/* JADX INFO: renamed from: s.a.c2.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractChannel<E> extends AbstractChannel3<E> implements Channel4<E> {

    /* JADX INFO: renamed from: s.a.c2.a$a */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static final class a<E> implements Channel5<E> {
        public Object a = AbstractChannel2.d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractChannel<E> f3833b;

        public a(AbstractChannel<E> abstractChannel) {
            this.f3833b = abstractChannel;
        }

        @Override // s.a.c2.Channel5
        public Object a(Continuation<? super Boolean> continuation) {
            Object obj = this.a;
            Symbol3 symbol3 = AbstractChannel2.d;
            if (obj != symbol3) {
                return boxing.boxBoolean(b(obj));
            }
            Object objV = this.f3833b.v();
            this.a = objV;
            if (objV != symbol3) {
                return boxing.boxBoolean(b(objV));
            }
            CancellableContinuationImpl5 cancellableContinuationImpl5O0 = b.i.a.f.e.o.f.o0(IntrinsicsJvm.intercepted(continuation));
            d dVar = new d(this, cancellableContinuationImpl5O0);
            while (true) {
                if (this.f3833b.r(dVar)) {
                    AbstractChannel<E> abstractChannel = this.f3833b;
                    Objects.requireNonNull(abstractChannel);
                    cancellableContinuationImpl5O0.f(abstractChannel.new e(dVar));
                    break;
                }
                Object objV2 = this.f3833b.v();
                this.a = objV2;
                if (objV2 instanceof AbstractChannel4) {
                    AbstractChannel4 abstractChannel4 = (AbstractChannel4) objV2;
                    if (abstractChannel4.m != null) {
                        Throwable thV = abstractChannel4.v();
                        Result2.a aVar = Result2.j;
                        cancellableContinuationImpl5O0.resumeWith(Result2.m97constructorimpl(Result3.createFailure(thV)));
                        break;
                    }
                    Boolean boolBoxBoolean = boxing.boxBoolean(false);
                    Result2.a aVar2 = Result2.j;
                    cancellableContinuationImpl5O0.resumeWith(Result2.m97constructorimpl(boolBoxBoolean));
                    break;
                }
                if (objV2 != AbstractChannel2.d) {
                    Boolean boolBoxBoolean2 = boxing.boxBoolean(true);
                    Function1<E, Unit> function1 = this.f3833b.l;
                    cancellableContinuationImpl5O0.y(boolBoxBoolean2, cancellableContinuationImpl5O0.l, function1 != null ? new OnUndeliveredElement2(function1, objV2, cancellableContinuationImpl5O0.o) : null);
                    break;
                }
            }
            Object objU = cancellableContinuationImpl5O0.u();
            if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return objU;
        }

        public final boolean b(Object obj) throws Throwable {
            if (!(obj instanceof AbstractChannel4)) {
                return true;
            }
            AbstractChannel4 abstractChannel4 = (AbstractChannel4) obj;
            if (abstractChannel4.m == null) {
                return false;
            }
            Throwable thV = abstractChannel4.v();
            String str = StackTraceRecovery.a;
            throw thV;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // s.a.c2.Channel5
        public E next() throws Throwable {
            E e = (E) this.a;
            if (e instanceof AbstractChannel4) {
                Throwable thV = ((AbstractChannel4) e).v();
                String str = StackTraceRecovery.a;
                throw thV;
            }
            Symbol3 symbol3 = AbstractChannel2.d;
            if (e == symbol3) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.a = symbol3;
            return e;
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$b */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static class b<E> extends AbstractChannel5<E> {
        public final CancellableContinuation<Object> m;
        public final int n;

        public b(CancellableContinuation<Object> cancellableContinuation, int i) {
            this.m = cancellableContinuation;
            this.n = i;
        }

        @Override // s.a.c2.AbstractChannel6
        public void c(E e) {
            this.m.r(CancellableContinuationImpl6.a);
        }

        @Override // s.a.c2.AbstractChannel6
        public Symbol3 d(E e, LockFreeLinkedList3.b bVar) {
            if (this.m.h(this.n != 2 ? e : new Channel8(e), null, q(e)) != null) {
                return CancellableContinuationImpl6.a;
            }
            return null;
        }

        @Override // s.a.c2.AbstractChannel5
        public void r(AbstractChannel4<?> abstractChannel4) {
            int i = this.n;
            if (i == 1 && abstractChannel4.m == null) {
                CancellableContinuation<Object> cancellableContinuation = this.m;
                Result2.a aVar = Result2.j;
                cancellableContinuation.resumeWith(Result2.m97constructorimpl(null));
            } else {
                if (i == 2) {
                    CancellableContinuation<Object> cancellableContinuation2 = this.m;
                    Channel8 channel8 = new Channel8(new Channel8.a(abstractChannel4.m));
                    Result2.a aVar2 = Result2.j;
                    cancellableContinuation2.resumeWith(Result2.m97constructorimpl(channel8));
                    return;
                }
                CancellableContinuation<Object> cancellableContinuation3 = this.m;
                Throwable thV = abstractChannel4.v();
                Result2.a aVar3 = Result2.j;
                cancellableContinuation3.resumeWith(Result2.m97constructorimpl(Result3.createFailure(thV)));
            }
        }

        @Override // s.a.a.LockFreeLinkedList3
        public String toString() {
            StringBuilder sbU = outline.U("ReceiveElement@");
            sbU.append(b.i.a.f.e.o.f.l0(this));
            sbU.append("[receiveMode=");
            return outline.A(sbU, this.n, ']');
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$c */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static final class c<E> extends b<E> {
        public final Function1<E, Unit> o;

        /* JADX WARN: Multi-variable type inference failed */
        public c(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.o = function1;
        }

        @Override // s.a.c2.AbstractChannel5
        public Function1<Throwable, Unit> q(E e) {
            return new OnUndeliveredElement2(this.o, e, this.m.getContext());
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$d */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static class d<E> extends AbstractChannel5<E> {
        public final a<E> m;
        public final CancellableContinuation<Boolean> n;

        /* JADX WARN: Multi-variable type inference failed */
        public d(a<E> aVar, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.m = aVar;
            this.n = cancellableContinuation;
        }

        @Override // s.a.c2.AbstractChannel6
        public void c(E e) {
            this.m.a = e;
            this.n.r(CancellableContinuationImpl6.a);
        }

        @Override // s.a.c2.AbstractChannel6
        public Symbol3 d(E e, LockFreeLinkedList3.b bVar) {
            if (this.n.h(Boolean.TRUE, null, q(e)) != null) {
                return CancellableContinuationImpl6.a;
            }
            return null;
        }

        @Override // s.a.c2.AbstractChannel5
        public Function1<Throwable, Unit> q(E e) {
            Function1<E, Unit> function1 = this.m.f3833b.l;
            if (function1 != null) {
                return new OnUndeliveredElement2(function1, e, this.n.getContext());
            }
            return null;
        }

        @Override // s.a.c2.AbstractChannel5
        public void r(AbstractChannel4<?> abstractChannel4) {
            Object objC = abstractChannel4.m == null ? this.n.c(Boolean.FALSE, null) : this.n.g(abstractChannel4.v());
            if (objC != null) {
                this.m.a = abstractChannel4;
                this.n.r(objC);
            }
        }

        @Override // s.a.a.LockFreeLinkedList3
        public String toString() {
            StringBuilder sbU = outline.U("ReceiveHasNext@");
            sbU.append(b.i.a.f.e.o.f.l0(this));
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$e */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public final class e extends CancellableContinuationImpl3 {
        public final AbstractChannel5<?> j;

        public e(AbstractChannel5<?> abstractChannel5) {
            this.j = abstractChannel5;
        }

        @Override // s.a.CompletionHandler
        public void a(Throwable th) {
            if (this.j.n()) {
                Objects.requireNonNull(AbstractChannel.this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            if (this.j.n()) {
                Objects.requireNonNull(AbstractChannel.this);
            }
            return Unit.a;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RemoveReceiveOnCancel[");
            sbU.append(this.j);
            sbU.append(']');
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$f */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class f extends LockFreeLinkedList3.a {
        public final /* synthetic */ AbstractChannel d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(LockFreeLinkedList3 lockFreeLinkedList3, LockFreeLinkedList3 lockFreeLinkedList4, AbstractChannel abstractChannel) {
            super(lockFreeLinkedList4);
            this.d = abstractChannel;
        }

        @Override // s.a.a.Atomic2
        public Object c(LockFreeLinkedList3 lockFreeLinkedList3) {
            if (this.d.t()) {
                return null;
            }
            return LockFreeLinkedList2.a;
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$g */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    @DebugMetadata(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = {624}, m = "receiveOrClosed-ZYPwvRU")
    public static final class g extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public g(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AbstractChannel.this.m(this);
        }
    }

    public AbstractChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // s.a.c2.Channel6
    public final void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(getClass().getSimpleName() + " was cancelled");
        }
        u(j(cancellationException));
    }

    @Override // s.a.c2.Channel6
    public final Channel5<E> iterator() {
        return new a(this);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // s.a.c2.Channel6
    public final Object m(Continuation<? super Channel8<? extends E>> continuation) {
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
        Object objU = gVar.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = gVar.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objU);
            Object objV = v();
            if (objV != AbstractChannel2.d) {
                return objV instanceof AbstractChannel4 ? new Channel8.a(((AbstractChannel4) objV).m) : objV;
            }
            gVar.L$0 = this;
            gVar.L$1 = objV;
            gVar.label = 1;
            CancellableContinuationImpl5 cancellableContinuationImpl5O0 = b.i.a.f.e.o.f.o0(IntrinsicsJvm.intercepted(gVar));
            b bVar = this.l == null ? new b(cancellableContinuationImpl5O0, 2) : new c(cancellableContinuationImpl5O0, 2, this.l);
            while (true) {
                if (r(bVar)) {
                    cancellableContinuationImpl5O0.f(new e(bVar));
                    break;
                }
                Object objV2 = v();
                if (objV2 instanceof AbstractChannel4) {
                    bVar.r((AbstractChannel4) objV2);
                    break;
                }
                if (objV2 != AbstractChannel2.d) {
                    cancellableContinuationImpl5O0.y(bVar.n != 2 ? objV2 : new Channel8(objV2), cancellableContinuationImpl5O0.l, bVar.q(objV2));
                    break;
                }
            }
            objU = cancellableContinuationImpl5O0.u();
            if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(gVar);
            }
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(objU);
        }
        return ((Channel8) objU).a;
    }

    @Override // s.a.c2.AbstractChannel3
    public AbstractChannel6<E> n() {
        AbstractChannel6<E> abstractChannel6N = super.n();
        if (abstractChannel6N != null) {
            boolean z2 = abstractChannel6N instanceof AbstractChannel4;
        }
        return abstractChannel6N;
    }

    public boolean r(AbstractChannel5<? super E> abstractChannel5) {
        int iP;
        LockFreeLinkedList3 lockFreeLinkedList3K;
        if (!s()) {
            LockFreeLinkedList3 lockFreeLinkedList3 = this.k;
            f fVar = new f(abstractChannel5, abstractChannel5, this);
            do {
                LockFreeLinkedList3 lockFreeLinkedList3K2 = lockFreeLinkedList3.k();
                if (!(!(lockFreeLinkedList3K2 instanceof AbstractChannel7))) {
                    break;
                }
                iP = lockFreeLinkedList3K2.p(abstractChannel5, lockFreeLinkedList3, fVar);
                if (iP == 1) {
                    return true;
                }
            } while (iP != 2);
        } else {
            LockFreeLinkedList3 lockFreeLinkedList4 = this.k;
            do {
                lockFreeLinkedList3K = lockFreeLinkedList4.k();
                if (!(!(lockFreeLinkedList3K instanceof AbstractChannel7))) {
                }
            } while (!lockFreeLinkedList3K.e(abstractChannel5, lockFreeLinkedList4));
            return true;
        }
        return false;
    }

    public abstract boolean s();

    public abstract boolean t();

    public void u(boolean z2) {
        AbstractChannel4<?> abstractChannel4E = e();
        if (abstractChannel4E == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objT0 = null;
        while (true) {
            LockFreeLinkedList3 lockFreeLinkedList3K = abstractChannel4E.k();
            if (lockFreeLinkedList3K instanceof LockFreeLinkedList) {
                break;
            }
            if (lockFreeLinkedList3K.n()) {
                objT0 = b.i.a.f.e.o.f.T0(objT0, (AbstractChannel7) lockFreeLinkedList3K);
            } else {
                Object objI = lockFreeLinkedList3K.i();
                Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
                ((LockFreeLinkedList4) objI).a.f(null);
            }
        }
        if (objT0 == null) {
            return;
        }
        if (!(objT0 instanceof ArrayList)) {
            ((AbstractChannel7) objT0).s(abstractChannel4E);
            return;
        }
        ArrayList arrayList = (ArrayList) objT0;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((AbstractChannel7) arrayList.get(size)).s(abstractChannel4E);
            }
        }
    }

    public Object v() {
        while (true) {
            AbstractChannel7 abstractChannel7Q = q();
            if (abstractChannel7Q == null) {
                return AbstractChannel2.d;
            }
            if (abstractChannel7Q.t(null) != null) {
                abstractChannel7Q.q();
                return abstractChannel7Q.r();
            }
            abstractChannel7Q.u();
        }
    }
}
