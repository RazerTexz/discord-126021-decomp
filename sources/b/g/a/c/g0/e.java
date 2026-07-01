package b.g.a.c.g0;

import b.g.a.c.v;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: BeanSerializerBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static final c[] a = new c[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.g.a.c.c f701b;
    public v c;
    public List<c> d = Collections.emptyList();
    public c[] e;
    public a f;
    public Object g;
    public b.g.a.c.c0.i h;
    public b.g.a.c.g0.t.j i;

    public e(b.g.a.c.c cVar) {
        this.f701b = cVar;
    }

    public b.g.a.c.n<?> a() {
        c[] cVarArr;
        if (this.h != null && this.c.q(b.g.a.c.p.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.h.f(this.c.q(b.g.a.c.p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        a aVar = this.f;
        if (aVar != null) {
            aVar.f700b.f(this.c.q(b.g.a.c.p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        List<c> list = this.d;
        if (list == null || list.isEmpty()) {
            if (this.f == null && this.i == null) {
                return null;
            }
            cVarArr = a;
        } else {
            List<c> list2 = this.d;
            cVarArr = (c[]) list2.toArray(new c[list2.size()]);
            if (this.c.q(b.g.a.c.p.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (c cVar : cVarArr) {
                    cVar._member.f(this.c.q(b.g.a.c.p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                }
            }
        }
        c[] cVarArr2 = this.e;
        if (cVarArr2 == null || cVarArr2.length == this.d.size()) {
            return new d(this.f701b.a, this, cVarArr, this.e);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", Integer.valueOf(this.d.size()), Integer.valueOf(this.e.length)));
    }
}
