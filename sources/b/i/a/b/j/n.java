package b.i.a.b.j;

import android.content.Context;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: TransportRuntime.java */
/* JADX INFO: loaded from: classes3.dex */
public class n implements m {
    public static volatile o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.b.j.v.a f769b;
    public final b.i.a.b.j.v.a c;
    public final b.i.a.b.j.t.e d;
    public final b.i.a.b.j.t.h.l e;

    public n(b.i.a.b.j.v.a aVar, b.i.a.b.j.v.a aVar2, b.i.a.b.j.t.e eVar, b.i.a.b.j.t.h.l lVar, b.i.a.b.j.t.h.p pVar) {
        this.f769b = aVar;
        this.c = aVar2;
        this.d = eVar;
        this.e = lVar;
        pVar.a.execute(new b.i.a.b.j.t.h.n(pVar));
    }

    public static n a() {
        o oVar = a;
        if (oVar != null) {
            return ((c) oVar).u.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (a == null) {
            synchronized (n.class) {
                if (a == null) {
                    Objects.requireNonNull(context);
                    a = new c(context, null);
                }
            }
        }
    }

    public b.i.a.b.g c(d dVar) {
        Set setSingleton;
        if (dVar instanceof d) {
            Objects.requireNonNull((b.i.a.b.i.a) dVar);
            setSingleton = Collections.unmodifiableSet(b.i.a.b.i.a.d);
        } else {
            setSingleton = Collections.singleton(new b.i.a.b.b("proto"));
        }
        i$a i_aA = i.a();
        Objects.requireNonNull(dVar);
        i_aA.b("cct");
        b$b b_b = (b$b) i_aA;
        b_b.f764b = ((b.i.a.b.i.a) dVar).b();
        return new j(setSingleton, b_b.a(), this);
    }
}
