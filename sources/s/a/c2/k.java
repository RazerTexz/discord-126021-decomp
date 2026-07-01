package s.a.c2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LinkedListChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class k<E> extends a<E> {
    public k(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // s.a.c2.c
    public final boolean h() {
        return false;
    }

    @Override // s.a.c2.c
    public final boolean i() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s.a.c2.c
    public Object k(E e) {
        p pVar;
        do {
            Object objK = super.k(e);
            s.a.a.t tVar = b.f3834b;
            if (objK == tVar) {
                return tVar;
            }
            if (objK != b.c) {
                if (objK instanceof i) {
                    return objK;
                }
                throw new IllegalStateException(b.d.b.a.a.v("Invalid offerInternal result ", objK).toString());
            }
            s.a.a.i iVar = this.k;
            c$a c_a = new c$a(e);
            while (true) {
                s.a.a.k kVarK = iVar.k();
                if (kVarK instanceof p) {
                    pVar = (p) kVarK;
                    break;
                }
                if (kVarK.e(c_a, iVar)) {
                    pVar = null;
                    break;
                }
            }
            if (pVar == null) {
                return b.f3834b;
            }
        } while (!(pVar instanceof i));
        return pVar;
    }

    @Override // s.a.c2.a
    public final boolean s() {
        return true;
    }

    @Override // s.a.c2.a
    public final boolean t() {
        return true;
    }
}
