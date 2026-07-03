package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;

/* JADX INFO: renamed from: b.g.a.c.g0.u.b */
/* JADX INFO: compiled from: AsArraySerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2274b<T> extends AbstractC2239h<T> implements InterfaceC2240i {
    public AbstractC2262l _dynamicSerializers;
    public final AbstractC2364n<Object> _elementSerializer;
    public final AbstractC2360j _elementType;
    public final InterfaceC2206d _property;
    public final boolean _staticTyping;
    public final Boolean _unwrapSingle;
    public final AbstractC2215g _valueTypeSerializer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC2274b(Class<?> cls, AbstractC2360j abstractC2360j, boolean z2, AbstractC2215g abstractC2215g, AbstractC2364n<Object> abstractC2364n) {
        super(cls, false);
        boolean z3 = false;
        this._elementType = abstractC2360j;
        if (z2 || (abstractC2360j != null && abstractC2360j.m2220x())) {
            z3 = true;
        }
        this._staticTyping = z3;
        this._valueTypeSerializer = abstractC2215g;
        this._property = null;
        this._elementSerializer = abstractC2364n;
        this._dynamicSerializers = AbstractC2262l.b.f4828b;
        this._unwrapSingle = null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<?> abstractC2364nMo2000H;
        AbstractC2360j abstractC2360j;
        Object objMo1775c;
        AbstractC2215g abstractC2215gMo1955a = this._valueTypeSerializer;
        if (abstractC2215gMo1955a != null) {
            abstractC2215gMo1955a = abstractC2215gMo1955a.mo1955a(interfaceC2206d);
        }
        if (interfaceC2206d != null) {
            AbstractC2165b abstractC2165bM2257v = abstractC2374x.m2257v();
            AbstractC2188i member = interfaceC2206d.getMember();
            if (member == null || (objMo1775c = abstractC2165bM2257v.mo1775c(member)) == null) {
                abstractC2364nMo2000H = null;
            } else {
                abstractC2364nMo2000H = abstractC2374x.mo2000H(member, objMo1775c);
            }
        } else {
            abstractC2364nMo2000H = null;
        }
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        Boolean boolM1598b = dVarM2074l != null ? dVarM2074l.m1598b(InterfaceC2081i.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        if (abstractC2364nMo2000H == null) {
            abstractC2364nMo2000H = this._elementSerializer;
        }
        AbstractC2364n<?> abstractC2364nM2073k = m2073k(abstractC2374x, interfaceC2206d, abstractC2364nMo2000H);
        if (abstractC2364nM2073k == null && (abstractC2360j = this._elementType) != null && this._staticTyping && !abstractC2360j.m2221y()) {
            abstractC2364nM2073k = abstractC2374x.m2249m(this._elementType, interfaceC2206d);
        }
        return (abstractC2364nM2073k == this._elementSerializer && interfaceC2206d == this._property && this._valueTypeSerializer == abstractC2215gMo1955a && Objects.equals(this._unwrapSingle, boolM1598b)) ? this : mo2023t(interfaceC2206d, abstractC2215gMo1955a, abstractC2364nM2073k, boolM1598b);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        if (abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && mo1996q(t)) {
            mo2022s(t, abstractC2108d, abstractC2374x);
            return;
        }
        abstractC2108d.mo1646X(t);
        mo2022s(t, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(t, EnumC2112h.START_ARRAY));
        abstractC2108d.mo1654e(t);
        mo2022s(t, abstractC2108d, abstractC2374x);
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    /* JADX INFO: renamed from: r */
    public final AbstractC2364n<Object> m2045r(AbstractC2262l abstractC2262l, Class<?> cls, AbstractC2374x abstractC2374x) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nM2250n = abstractC2374x.m2250n(cls, this._property);
        AbstractC2262l abstractC2262lMo2033b = abstractC2262l.mo2033b(cls, abstractC2364nM2250n);
        if (abstractC2262l != abstractC2262lMo2033b) {
            this._dynamicSerializers = abstractC2262lMo2033b;
        }
        return abstractC2364nM2250n;
    }

    /* JADX INFO: renamed from: s */
    public abstract void mo2022s(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException;

    /* JADX INFO: renamed from: t */
    public abstract AbstractC2274b<T> mo2023t(InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, Boolean bool);

    public AbstractC2274b(AbstractC2274b<?> abstractC2274b, InterfaceC2206d interfaceC2206d, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, Boolean bool) {
        super(abstractC2274b);
        this._elementType = abstractC2274b._elementType;
        this._staticTyping = abstractC2274b._staticTyping;
        this._valueTypeSerializer = abstractC2215g;
        this._property = interfaceC2206d;
        this._elementSerializer = abstractC2364n;
        this._dynamicSerializers = AbstractC2262l.b.f4828b;
        this._unwrapSingle = bool;
    }
}
