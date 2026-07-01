package s.a.c2;

import d0.k$a;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a<E> implements g<E> {
    public Object a = b.d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<E> f3833b;

    public a$a(a<E> aVar) {
        this.f3833b = aVar;
    }

    @Override // s.a.c2.g
    public Object a(Continuation<? super Boolean> continuation) {
        Object obj = this.a;
        s.a.a.t tVar = b.d;
        if (obj != tVar) {
            return d0.w.i.a.b.boxBoolean(b(obj));
        }
        Object objV = this.f3833b.v();
        this.a = objV;
        if (objV != tVar) {
            return d0.w.i.a.b.boxBoolean(b(objV));
        }
        s.a.l lVarO0 = b.i.a.f.e.o.f.o0(d0.w.h.b.intercepted(continuation));
        a$d a_d = new a$d(this, lVarO0);
        while (true) {
            if (this.f3833b.r(a_d)) {
                a<E> aVar = this.f3833b;
                Objects.requireNonNull(aVar);
                lVarO0.f(new a$e(aVar, a_d));
                break;
            }
            Object objV2 = this.f3833b.v();
            this.a = objV2;
            if (objV2 instanceof i) {
                i iVar = (i) objV2;
                if (iVar.m != null) {
                    Throwable thV = iVar.v();
                    k$a k_a = d0.k.j;
                    lVarO0.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(thV)));
                    break;
                }
                Boolean boolBoxBoolean = d0.w.i.a.b.boxBoolean(false);
                k$a k_a2 = d0.k.j;
                lVarO0.resumeWith(d0.k.m97constructorimpl(boolBoxBoolean));
                break;
            }
            if (objV2 != b.d) {
                Boolean boolBoxBoolean2 = d0.w.i.a.b.boxBoolean(true);
                Function1<E, Unit> function1 = this.f3833b.l;
                lVarO0.y(boolBoxBoolean2, lVarO0.l, function1 != null ? new s.a.a.o(function1, objV2, lVarO0.o) : null);
                break;
            }
        }
        Object objU = lVarO0.u();
        if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
            d0.w.i.a.g.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public final boolean b(Object obj) throws Throwable {
        if (!(obj instanceof i)) {
            return true;
        }
        i iVar = (i) obj;
        if (iVar.m == null) {
            return false;
        }
        Throwable thV = iVar.v();
        String str = s.a.a.s.a;
        throw thV;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s.a.c2.g
    public E next() throws Throwable {
        E e = (E) this.a;
        if (e instanceof i) {
            Throwable thV = ((i) e).v();
            String str = s.a.a.s.a;
            throw thV;
        }
        s.a.a.t tVar = b.d;
        if (e == tVar) {
            throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
        }
        this.a = tVar;
        return e;
    }
}
