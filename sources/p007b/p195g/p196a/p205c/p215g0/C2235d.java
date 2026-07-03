package p007b.p195g.p196a.p205c.p215g0;

import java.io.IOException;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2252b;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2260j;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2270t;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;

/* JADX INFO: renamed from: b.g.a.c.g0.d */
/* JADX INFO: compiled from: BeanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2235d extends AbstractC2278d {
    private static final long serialVersionUID = 29;

    public C2235d(AbstractC2360j abstractC2360j, C2236e c2236e, C2234c[] c2234cArr, C2234c[] c2234cArr2) {
        super(abstractC2360j, c2236e, c2234cArr, c2234cArr2);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public final void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        if (this._objectIdWriter != null) {
            abstractC2108d.mo1654e(obj);
            m2054q(obj, abstractC2108d, abstractC2374x, true);
            return;
        }
        abstractC2108d.mo1653d0(obj);
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            m2056u(obj, abstractC2108d, abstractC2374x);
            abstractC2108d.mo1664u();
        } else {
            if (this._filteredProps != null) {
                Class<?> cls = abstractC2374x._serializationView;
            }
            m2075m(abstractC2374x, obj2, obj);
            throw null;
        }
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: h */
    public AbstractC2364n<Object> mo1984h(AbstractC2352n abstractC2352n) {
        return new C2270t(this, abstractC2352n);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: s */
    public AbstractC2278d mo1985s() {
        return (this._objectIdWriter == null && this._anyGetterWriter == null && this._propertyFilterId == null) ? new C2252b(this) : this;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("BeanSerializer for ");
        sbM833U.append(this._handledType.getName());
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: v */
    public AbstractC2278d mo1986v(Set<String> set, Set<String> set2) {
        return new C2235d(this, set, set2);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: w */
    public AbstractC2278d mo1987w(Object obj) {
        return new C2235d(this, this._objectIdWriter, obj);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: x */
    public AbstractC2278d mo1988x(C2260j c2260j) {
        return new C2235d(this, c2260j, this._propertyFilterId);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: y */
    public AbstractC2278d mo1989y(C2234c[] c2234cArr, C2234c[] c2234cArr2) {
        return new C2235d(this, c2234cArr, c2234cArr2);
    }

    public C2235d(AbstractC2278d abstractC2278d, C2260j c2260j, Object obj) {
        super(abstractC2278d, c2260j, obj);
    }

    public C2235d(AbstractC2278d abstractC2278d, Set<String> set, Set<String> set2) {
        super(abstractC2278d, set, set2);
    }

    public C2235d(AbstractC2278d abstractC2278d, C2234c[] c2234cArr, C2234c[] c2234cArr2) {
        super(abstractC2278d, c2234cArr, c2234cArr2);
    }
}
