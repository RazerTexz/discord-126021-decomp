package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.math.BigDecimal;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2110f;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;

/* JADX INFO: renamed from: b.g.a.c.g0.u.w */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2316w<T> extends AbstractC2303p0<T> implements InterfaceC2240i {
    public final boolean _isInt;
    public final AbstractC2110f.b _numberType;
    public final String _schemaType;

    public AbstractC2316w(Class<?> cls, AbstractC2110f.b bVar, String str) {
        super(cls, false);
        this._numberType = bVar;
        this._schemaType = str;
        this._isInt = bVar == AbstractC2110f.b.INT || bVar == AbstractC2110f.b.LONG || bVar == AbstractC2110f.b.BIG_INTEGER;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        if (dVarM2074l == null || dVarM2074l.m1601e().ordinal() != 8) {
            return this;
        }
        if (this._handledType != BigDecimal.class) {
            return C2311t0.f4866k;
        }
        C2314v c2314v = C2314v.f4868k;
        return C2314v.a.f4869k;
    }
}
