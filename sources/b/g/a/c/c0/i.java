package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.HashMap;

/* JADX INFO: compiled from: AnnotatedMember.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends b implements Serializable {
    private static final long serialVersionUID = 1;
    public final transient e0 j;
    public final transient p k;

    public i(e0 e0Var, p pVar) {
        this.j = e0Var;
        this.k = pVar;
    }

    @Override // b.g.a.c.c0.b
    public final <A extends Annotation> A b(Class<A> cls) {
        HashMap<Class<?>, Annotation> map;
        p pVar = this.k;
        if (pVar == null || (map = pVar.j) == null) {
            return null;
        }
        return (A) map.get(cls);
    }

    public final void f(boolean z2) {
        Member memberI = i();
        if (memberI != null) {
            b.g.a.c.i0.d.d(memberI, z2);
        }
    }

    public abstract Class<?> g();

    public String h() {
        return g().getName() + "#" + c();
    }

    public abstract Member i();

    public abstract Object j(Object obj) throws UnsupportedOperationException, IllegalArgumentException;

    public final boolean k(Class<?> cls) {
        HashMap<Class<?>, Annotation> map;
        p pVar = this.k;
        if (pVar == null || (map = pVar.j) == null) {
            return false;
        }
        return map.containsKey(cls);
    }

    public abstract b l(p pVar);
}
