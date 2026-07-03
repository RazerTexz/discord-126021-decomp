package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.C2234c;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;

/* JADX INFO: renamed from: b.g.a.c.g0.t.b */
/* JADX INFO: compiled from: BeanAsArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2252b extends AbstractC2278d {
    private static final long serialVersionUID = 1;
    public final AbstractC2278d _defaultSerializer;

    public C2252b(AbstractC2278d abstractC2278d, Set<String> set, Set<String> set2) {
        super(abstractC2278d, set, set2);
        this._defaultSerializer = abstractC2278d;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public final void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        if (abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
            C2234c[] c2234cArr = this._filteredProps;
            if (c2234cArr == null || abstractC2374x._serializationView == null) {
                c2234cArr = this._props;
            }
            if (c2234cArr.length == 1) {
                m2019z(obj, abstractC2108d, abstractC2374x);
                return;
            }
        }
        abstractC2108d.mo1646X(obj);
        m2019z(obj, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        if (this._objectIdWriter != null) {
            m2053p(obj, abstractC2108d, abstractC2374x, abstractC2215g);
            return;
        }
        C2138b c2138bM2055r = m2055r(abstractC2215g, obj, EnumC2112h.START_ARRAY);
        abstractC2215g.mo1959e(abstractC2108d, c2138bM2055r);
        abstractC2108d.mo1654e(obj);
        m2019z(obj, abstractC2108d, abstractC2374x);
        abstractC2215g.mo1960f(abstractC2108d, c2138bM2055r);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: h */
    public AbstractC2364n<Object> mo1984h(AbstractC2352n abstractC2352n) {
        return this._defaultSerializer.mo1984h(abstractC2352n);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: s */
    public AbstractC2278d mo1985s() {
        return this;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("BeanAsArraySerializer for ");
        sbM833U.append(this._handledType.getName());
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: v */
    public AbstractC2278d mo1986v(Set set, Set set2) {
        return new C2252b(this, (Set<String>) set, (Set<String>) set2);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: w */
    public AbstractC2278d mo1987w(Object obj) {
        return new C2252b(this, this._objectIdWriter, obj);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: x */
    public AbstractC2278d mo1988x(C2260j c2260j) {
        return this._defaultSerializer.mo1988x(c2260j);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d
    /* JADX INFO: renamed from: y */
    public AbstractC2278d mo1989y(C2234c[] c2234cArr, C2234c[] c2234cArr2) {
        return this;
    }

    /* JADX INFO: renamed from: z */
    public final void m2019z(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        C2234c[] c2234cArr = this._filteredProps;
        if (c2234cArr == null || abstractC2374x._serializationView == null) {
            c2234cArr = this._props;
        }
        int i = 0;
        try {
            int length = c2234cArr.length;
            while (i < length) {
                C2234c c2234c = c2234cArr[i];
                if (c2234c == null) {
                    abstractC2108d.mo1631A();
                } else {
                    c2234c.mo1982h(obj, abstractC2108d, abstractC2374x);
                }
                i++;
            }
        } catch (Exception e) {
            m2077o(abstractC2374x, e, obj, i != c2234cArr.length ? c2234cArr[i]._name._value : "[anySetter]");
            throw null;
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(abstractC2108d, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.m8743e(new JsonMappingException.C10677a(obj, i != c2234cArr.length ? c2234cArr[i]._name._value : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    public C2252b(AbstractC2278d abstractC2278d, C2260j c2260j, Object obj) {
        super(abstractC2278d, c2260j, obj);
        this._defaultSerializer = abstractC2278d;
    }

    public C2252b(AbstractC2278d abstractC2278d) {
        super(abstractC2278d, (C2260j) null, abstractC2278d._propertyFilterId);
        this._defaultSerializer = abstractC2278d;
    }
}
