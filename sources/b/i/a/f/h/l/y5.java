package b.i.a.f.h.l;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y5 implements v5 {
    @Override // b.i.a.f.h.l.v5
    public final Map<?, ?> b(Object obj) {
        return (w5) obj;
    }

    @Override // b.i.a.f.h.l.v5
    public final Object c(Object obj) {
        ((w5) obj).f();
        return obj;
    }

    @Override // b.i.a.f.h.l.v5
    public final boolean d(Object obj) {
        return !((w5) obj).g();
    }

    @Override // b.i.a.f.h.l.v5
    public final Map<?, ?> e(Object obj) {
        return (w5) obj;
    }

    @Override // b.i.a.f.h.l.v5
    public final Object f(Object obj, Object obj2) {
        w5 w5Var = (w5) obj;
        w5 w5Var2 = (w5) obj2;
        if (!w5Var2.isEmpty()) {
            if (!w5Var.g()) {
                w5Var = w5Var.isEmpty() ? new w5() : new w5(w5Var);
            }
            w5Var.h();
            if (!w5Var2.isEmpty()) {
                w5Var.putAll(w5Var2);
            }
        }
        return w5Var;
    }

    @Override // b.i.a.f.h.l.v5
    public final t5<?, ?> g(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // b.i.a.f.h.l.v5
    public final Object h(Object obj) {
        w5 w5Var = w5.j;
        return w5Var.isEmpty() ? new w5() : new w5(w5Var);
    }

    @Override // b.i.a.f.h.l.v5
    public final int i(int i, Object obj, Object obj2) {
        w5 w5Var = (w5) obj;
        if (w5Var.isEmpty()) {
            return 0;
        }
        Iterator it = w5Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
