package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.C2234c;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;

/* JADX INFO: renamed from: b.g.a.c.g0.t.t */
/* JADX INFO: compiled from: UnwrappingBeanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2270t extends AbstractC2278d implements Serializable {
    private static final long serialVersionUID = 1;
    public final AbstractC2352n _nameTransformer;

    public C2270t(C2270t c2270t, C2260j c2260j, Object obj) {
        super(c2270t, c2260j, obj);
        this._nameTransformer = c2270t._nameTransformer;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public final void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        abstractC2108d.mo1654e(obj);
        if (this._objectIdWriter != null) {
            m2054q(obj, abstractC2108d, abstractC2374x, false);
            return;
        }
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            m2056u(obj, abstractC2108d, abstractC2374x);
            return;
        }
        if (this._filteredProps != null) {
            Class<?> cls = abstractC2374x._serializationView;
        }
        m2075m(abstractC2374x, obj2, obj);
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        if (abstractC2374x.m2240D(EnumC2373w.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            abstractC2374x.m1943g(this._handledType, "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        abstractC2108d.mo1654e(obj);
        if (this._objectIdWriter != null) {
            m2053p(obj, abstractC2108d, abstractC2374x, abstractC2215g);
            return;
        }
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            m2056u(obj, abstractC2108d, abstractC2374x);
        } else {
            C2234c[] c2234cArr = this._filteredProps;
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
        return this;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("UnwrappingBeanSerializer for ");
        sbM833U.append(this._handledType.getName());
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: v */
    public AbstractC2278d mo1986v(Set<String> set, Set<String> set2) {
        return new C2270t(this, set, set2);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: w */
    public AbstractC2278d mo1987w(Object obj) {
        return new C2270t(this, this._objectIdWriter, obj);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: x */
    public AbstractC2278d mo1988x(C2260j c2260j) {
        return new C2270t(this, c2260j);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: y */
    public AbstractC2278d mo1989y(C2234c[] c2234cArr, C2234c[] c2234cArr2) {
        return new C2270t(this, c2234cArr, c2234cArr2);
    }

    public C2270t(C2270t c2270t, Set<String> set, Set<String> set2) {
        super(c2270t, set, set2);
        this._nameTransformer = c2270t._nameTransformer;
    }

    public C2270t(C2270t c2270t, C2234c[] c2234cArr, C2234c[] c2234cArr2) {
        super(c2270t, c2234cArr, c2234cArr2);
        this._nameTransformer = c2270t._nameTransformer;
    }

    public C2270t(C2270t c2270t, C2260j c2260j) {
        super(c2270t, c2260j, c2270t._propertyFilterId);
        this._nameTransformer = c2270t._nameTransformer;
    }

    public C2270t(AbstractC2278d abstractC2278d, AbstractC2352n abstractC2352n) {
        super(abstractC2278d, AbstractC2278d.m2051t(abstractC2278d._props, abstractC2352n), AbstractC2278d.m2051t(abstractC2278d._filteredProps, abstractC2352n));
        this._nameTransformer = abstractC2352n;
    }
}
