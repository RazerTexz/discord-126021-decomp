package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.g0.u.h0 */
/* JADX INFO: compiled from: StaticListSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2287h0<T extends Collection<?>> extends AbstractC2305q0<T> implements InterfaceC2240i {
    public final Boolean _unwrapSingle;

    public AbstractC2287h0(Class<?> cls) {
        super(cls, false);
        this._unwrapSingle = null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<?> abstractC2364nMo2000H;
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
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        Boolean boolM1598b = dVarM2074l != null ? dVarM2074l.m1598b(InterfaceC2081i.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        AbstractC2364n<?> abstractC2364nM2073k = m2073k(abstractC2374x, interfaceC2206d, abstractC2364nMo2000H);
        if (abstractC2364nM2073k == null) {
            abstractC2364nM2073k = abstractC2374x.m2250n(String.class, interfaceC2206d);
        }
        if (C2342d.m2187s(abstractC2364nM2073k)) {
            return Objects.equals(boolM1598b, this._unwrapSingle) ? this : mo2025p(interfaceC2206d, boolM1598b);
        }
        return new C2290j(abstractC2374x.m1938b(String.class), true, null, abstractC2364nM2073k);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        Collection collection = (Collection) obj;
        return collection == null || collection.size() == 0;
    }

    /* JADX INFO: renamed from: p */
    public abstract AbstractC2364n<?> mo2025p(InterfaceC2206d interfaceC2206d, Boolean bool);

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public abstract void mo1808g(T t, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException;

    public AbstractC2287h0(AbstractC2287h0<?> abstractC2287h0, Boolean bool) {
        super(abstractC2287h0);
        this._unwrapSingle = bool;
    }
}
