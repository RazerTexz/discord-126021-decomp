package s.a.c2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<E> extends c<E> implements f<E> {
    public a(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // s.a.c2.o
    public final void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(getClass().getSimpleName() + " was cancelled");
        }
        u(j(cancellationException));
    }

    @Override // s.a.c2.o
    public final g<E> iterator() {
        return new a$a(this);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // s.a.c2.o
    public final Object m(Continuation<? super v<? extends E>> continuation) {
        a$g a_g;
        if (continuation instanceof a$g) {
            a_g = (a$g) continuation;
            int i = a_g.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                a_g.label = i - Integer.MIN_VALUE;
            } else {
                a_g = new a$g(this, continuation);
            }
        } else {
            a_g = new a$g(this, continuation);
        }
        Object objU = a_g.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = a_g.label;
        if (i2 == 0) {
            d0.l.throwOnFailure(objU);
            Object objV = v();
            if (objV != b.d) {
                return objV instanceof i ? new v$a(((i) objV).m) : objV;
            }
            a_g.L$0 = this;
            a_g.L$1 = objV;
            a_g.label = 1;
            s.a.l lVarO0 = b.i.a.f.e.o.f.o0(d0.w.h.b.intercepted(a_g));
            a$b a_b = this.l == null ? new a$b(lVarO0, 2) : new a$c(lVarO0, 2, this.l);
            while (true) {
                if (r(a_b)) {
                    lVarO0.f(new a$e(this, a_b));
                    break;
                }
                Object objV2 = v();
                if (objV2 instanceof i) {
                    a_b.r((i) objV2);
                    break;
                }
                if (objV2 != b.d) {
                    lVarO0.y(a_b.n != 2 ? objV2 : new v(objV2), lVarO0.l, a_b.q(objV2));
                    break;
                }
            }
            objU = lVarO0.u();
            if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                d0.w.i.a.g.probeCoroutineSuspended(a_g);
            }
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0.l.throwOnFailure(objU);
        }
        return ((v) objU).a;
    }

    @Override // s.a.c2.c
    public p<E> n() {
        p<E> pVarN = super.n();
        if (pVarN != null) {
            boolean z2 = pVarN instanceof i;
        }
        return pVarN;
    }

    public boolean r(n<? super E> nVar) {
        int iP;
        s.a.a.k kVarK;
        if (!s()) {
            s.a.a.k kVar = this.k;
            a$f a_f = new a$f(nVar, nVar, this);
            do {
                s.a.a.k kVarK2 = kVar.k();
                if (!(!(kVarK2 instanceof r))) {
                    break;
                }
                iP = kVarK2.p(nVar, kVar, a_f);
                if (iP == 1) {
                    return true;
                }
            } while (iP != 2);
        } else {
            s.a.a.k kVar2 = this.k;
            do {
                kVarK = kVar2.k();
                if (!(!(kVarK instanceof r))) {
                }
            } while (!kVarK.e(nVar, kVar2));
            return true;
        }
        return false;
    }

    public abstract boolean s();

    public abstract boolean t();

    public void u(boolean z2) {
        i<?> iVarE = e();
        if (iVarE == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objT0 = null;
        while (true) {
            s.a.a.k kVarK = iVarE.k();
            if (kVarK instanceof s.a.a.i) {
                break;
            }
            if (kVarK.n()) {
                objT0 = b.i.a.f.e.o.f.T0(objT0, (r) kVarK);
            } else {
                Object objI = kVarK.i();
                Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
                ((s.a.a.q) objI).a.f(null);
            }
        }
        if (objT0 == null) {
            return;
        }
        if (!(objT0 instanceof ArrayList)) {
            ((r) objT0).s(iVarE);
            return;
        }
        ArrayList arrayList = (ArrayList) objT0;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((r) arrayList.get(size)).s(iVarE);
            }
        }
    }

    public Object v() {
        while (true) {
            r rVarQ = q();
            if (rVarQ == null) {
                return b.d;
            }
            if (rVarQ.t(null) != null) {
                rVarQ.q();
                return rVarQ.r();
            }
            rVarQ.u();
        }
    }
}
