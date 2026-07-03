package p007b.p195g.p196a.p205c.p215g0;

import java.util.Collections;
import java.util.List;
import p007b.p195g.p196a.p205c.AbstractC2172c;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.C2372v;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2260j;

/* JADX INFO: renamed from: b.g.a.c.g0.e */
/* JADX INFO: compiled from: BeanSerializerBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2236e {

    /* JADX INFO: renamed from: a */
    public static final C2234c[] f4796a = new C2234c[0];

    /* JADX INFO: renamed from: b */
    public final AbstractC2172c f4797b;

    /* JADX INFO: renamed from: c */
    public C2372v f4798c;

    /* JADX INFO: renamed from: d */
    public List<C2234c> f4799d = Collections.emptyList();

    /* JADX INFO: renamed from: e */
    public C2234c[] f4800e;

    /* JADX INFO: renamed from: f */
    public C2232a f4801f;

    /* JADX INFO: renamed from: g */
    public Object f4802g;

    /* JADX INFO: renamed from: h */
    public AbstractC2188i f4803h;

    /* JADX INFO: renamed from: i */
    public C2260j f4804i;

    public C2236e(AbstractC2172c abstractC2172c) {
        this.f4797b = abstractC2172c;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> m1990a() {
        C2234c[] c2234cArr;
        if (this.f4803h != null && this.f4798c.m2279q(EnumC2366p.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.f4803h.m1902f(this.f4798c.m2279q(EnumC2366p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        C2232a c2232a = this.f4801f;
        if (c2232a != null) {
            c2232a.f4785b.m1902f(this.f4798c.m2279q(EnumC2366p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        List<C2234c> list = this.f4799d;
        if (list == null || list.isEmpty()) {
            if (this.f4801f == null && this.f4804i == null) {
                return null;
            }
            c2234cArr = f4796a;
        } else {
            List<C2234c> list2 = this.f4799d;
            c2234cArr = (C2234c[]) list2.toArray(new C2234c[list2.size()]);
            if (this.f4798c.m2279q(EnumC2366p.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (C2234c c2234c : c2234cArr) {
                    c2234c._member.m1902f(this.f4798c.m2279q(EnumC2366p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                }
            }
        }
        C2234c[] c2234cArr2 = this.f4800e;
        if (c2234cArr2 == null || c2234cArr2.length == this.f4799d.size()) {
            return new C2235d(this.f4797b.f4626a, this, c2234cArr, this.f4800e);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", Integer.valueOf(this.f4799d.size()), Integer.valueOf(this.f4800e.length)));
    }
}
