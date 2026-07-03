package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;

/* JADX INFO: renamed from: b.g.a.c.g0.u.a */
/* JADX INFO: compiled from: ArraySerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2272a<T> extends AbstractC2239h<T> implements InterfaceC2240i {
    public final InterfaceC2206d _property;
    public final Boolean _unwrapSingle;

    public AbstractC2272a(Class<T> cls) {
        super(cls);
        this._property = null;
        this._unwrapSingle = null;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        InterfaceC2081i.d dVarM2074l;
        if (interfaceC2206d != null && (dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType)) != null) {
            Boolean boolM1598b = dVarM2074l.m1598b(InterfaceC2081i.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            if (!Objects.equals(boolM1598b, this._unwrapSingle)) {
                return mo2037s(interfaceC2206d, boolM1598b);
            }
        }
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        if (m2044r(abstractC2374x) && mo1996q(t)) {
            mo2038t(t, abstractC2108d, abstractC2374x);
            return;
        }
        abstractC2108d.mo1646X(t);
        mo2038t(t, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public final void mo1808g(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(t, EnumC2112h.START_ARRAY));
        abstractC2108d.mo1654e(t);
        mo2038t(t, abstractC2108d, abstractC2374x);
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    /* JADX INFO: renamed from: r */
    public final boolean m2044r(AbstractC2374x abstractC2374x) {
        Boolean bool = this._unwrapSingle;
        return bool == null ? abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : bool.booleanValue();
    }

    /* JADX INFO: renamed from: s */
    public abstract AbstractC2364n<?> mo2037s(InterfaceC2206d interfaceC2206d, Boolean bool);

    /* JADX INFO: renamed from: t */
    public abstract void mo2038t(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException;

    public AbstractC2272a(AbstractC2272a<?> abstractC2272a, InterfaceC2206d interfaceC2206d, Boolean bool) {
        super(abstractC2272a._handledType, false);
        this._property = interfaceC2206d;
        this._unwrapSingle = bool;
    }
}
