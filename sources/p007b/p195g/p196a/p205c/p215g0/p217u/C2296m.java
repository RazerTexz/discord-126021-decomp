package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p219i0.C2344f;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.m */
/* JADX INFO: compiled from: EnumSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2296m extends AbstractC2303p0<Enum<?>> implements InterfaceC2240i {

    /* JADX INFO: renamed from: k */
    public static final /* synthetic */ int f4857k = 0;
    private static final long serialVersionUID = 1;
    public final Boolean _serializeAsIndex;
    public final C2344f _values;

    public C2296m(C2344f c2344f, Boolean bool) {
        super(c2344f.m2199b(), false);
        this._values = c2344f;
        this._serializeAsIndex = bool;
    }

    /* JADX INFO: renamed from: p */
    public static Boolean m2068p(Class<?> cls, InterfaceC2081i.d dVar, boolean z2, Boolean bool) {
        InterfaceC2081i.c cVarM1601e = dVar == null ? null : dVar.m1601e();
        if (cVarM1601e == null || cVarM1601e == InterfaceC2081i.c.ANY || cVarM1601e == InterfaceC2081i.c.SCALAR) {
            return bool;
        }
        if (cVarM1601e == InterfaceC2081i.c.STRING || cVarM1601e == InterfaceC2081i.c.NATURAL) {
            return Boolean.FALSE;
        }
        if (cVarM1601e.m1596f() || cVarM1601e == InterfaceC2081i.c.ARRAY) {
            return Boolean.TRUE;
        }
        Object[] objArr = new Object[3];
        objArr[0] = cVarM1601e;
        objArr[1] = cls.getName();
        objArr[2] = z2 ? "class" : "property";
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", objArr));
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        if (dVarM2074l != null) {
            Boolean boolM2068p = m2068p(this._handledType, dVarM2074l, false, this._serializeAsIndex);
            if (!Objects.equals(boolM2068p, this._serializeAsIndex)) {
                return new C2296m(this._values, boolM2068p);
            }
        }
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Enum<?> r2 = (Enum) obj;
        Boolean bool = this._serializeAsIndex;
        if (bool != null ? bool.booleanValue() : abstractC2374x.m2240D(EnumC2373w.WRITE_ENUMS_USING_INDEX)) {
            abstractC2108d.mo1634H(r2.ordinal());
        } else if (abstractC2374x.m2240D(EnumC2373w.WRITE_ENUMS_USING_TO_STRING)) {
            abstractC2108d.mo1658j0(r2.toString());
        } else {
            abstractC2108d.mo1657g0(this._values.m2200c(r2));
        }
    }
}
