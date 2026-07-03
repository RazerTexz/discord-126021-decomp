package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.t.n */
/* JADX INFO: compiled from: StringArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2264n extends AbstractC2272a<String[]> implements InterfaceC2240i {

    /* JADX INFO: renamed from: k */
    public static final C2264n f4843k;
    public final AbstractC2364n<Object> _elementSerializer;

    static {
        C2335n.f4925k.m2168j(String.class);
        f4843k = new C2264n();
    }

    public C2264n() {
        super(String[].class);
        this._elementSerializer = null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nMo2000H;
        Object objMo1775c;
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
        InterfaceC2081i.a aVar = InterfaceC2081i.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED;
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, String[].class);
        Boolean boolM1598b = dVarM2074l != null ? dVarM2074l.m1598b(aVar) : null;
        if (abstractC2364nMo2000H == null) {
            abstractC2364nMo2000H = this._elementSerializer;
        }
        AbstractC2364n<?> abstractC2364nM2073k = m2073k(abstractC2374x, interfaceC2206d, abstractC2364nMo2000H);
        if (abstractC2364nM2073k == null) {
            abstractC2364nM2073k = abstractC2374x.m2250n(String.class, interfaceC2206d);
        }
        AbstractC2364n<?> abstractC2364n = C2342d.m2187s(abstractC2364nM2073k) ? null : abstractC2364nM2073k;
        return (abstractC2364n == this._elementSerializer && Objects.equals(boolM1598b, this._unwrapSingle)) ? this : new C2264n(this, interfaceC2206d, abstractC2364n, boolM1598b);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        return ((String[]) obj).length == 0;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        String[] strArr = (String[]) obj;
        int length = strArr.length;
        if (length == 1 && ((this._unwrapSingle == null && abstractC2374x.m2240D(EnumC2373w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            mo2038t(strArr, abstractC2108d, abstractC2374x);
            return;
        }
        abstractC2108d.mo1649b0(strArr, length);
        mo2038t(strArr, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: p */
    public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((String[]) obj).length == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
    /* JADX INFO: renamed from: s */
    public AbstractC2364n<?> mo2037s(InterfaceC2206d interfaceC2206d, Boolean bool) {
        return new C2264n(this, interfaceC2206d, this._elementSerializer, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void mo2038t(String[] strArr, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        int length = strArr.length;
        if (length == 0) {
            return;
        }
        AbstractC2364n<Object> abstractC2364n = this._elementSerializer;
        int i = 0;
        if (abstractC2364n == null) {
            while (i < length) {
                if (strArr[i] == null) {
                    abstractC2108d.mo1631A();
                } else {
                    abstractC2108d.mo1658j0(strArr[i]);
                }
                i++;
            }
            return;
        }
        int length2 = strArr.length;
        while (i < length2) {
            if (strArr[i] == null) {
                abstractC2374x.m2248l(abstractC2108d);
            } else {
                abstractC2364n.mo1807f(strArr[i], abstractC2108d, abstractC2374x);
            }
            i++;
        }
    }

    public C2264n(C2264n c2264n, InterfaceC2206d interfaceC2206d, AbstractC2364n<?> abstractC2364n, Boolean bool) {
        super(c2264n, interfaceC2206d, bool);
        this._elementSerializer = abstractC2364n;
    }
}
