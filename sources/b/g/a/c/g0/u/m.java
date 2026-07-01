package b.g.a.c.g0.u;

import b.g.a.a.i$c;
import b.g.a.a.i$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: EnumSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class m extends p0<Enum<?>> implements b.g.a.c.g0.i {
    public static final /* synthetic */ int k = 0;
    private static final long serialVersionUID = 1;
    public final Boolean _serializeAsIndex;
    public final b.g.a.c.i0.f _values;

    public m(b.g.a.c.i0.f fVar, Boolean bool) {
        super(fVar.b(), false);
        this._values = fVar;
        this._serializeAsIndex = bool;
    }

    public static Boolean p(Class<?> cls, i$d i_d, boolean z2, Boolean bool) {
        i$c i_cE = i_d == null ? null : i_d.e();
        if (i_cE == null || i_cE == i$c.ANY || i_cE == i$c.SCALAR) {
            return bool;
        }
        if (i_cE == i$c.STRING || i_cE == i$c.NATURAL) {
            return Boolean.FALSE;
        }
        if (i_cE.f() || i_cE == i$c.ARRAY) {
            return Boolean.TRUE;
        }
        Object[] objArr = new Object[3];
        objArr[0] = i_cE;
        objArr[1] = cls.getName();
        objArr[2] = z2 ? "class" : "property";
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", objArr));
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        i$d i_dL = l(xVar, dVar, this._handledType);
        if (i_dL != null) {
            Boolean boolP = p(this._handledType, i_dL, false, this._serializeAsIndex);
            if (!Objects.equals(boolP, this._serializeAsIndex)) {
                return new m(this._values, boolP);
            }
        }
        return this;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Enum<?> r2 = (Enum) obj;
        Boolean bool = this._serializeAsIndex;
        if (bool != null ? bool.booleanValue() : xVar.D(b.g.a.c.w.WRITE_ENUMS_USING_INDEX)) {
            dVar.H(r2.ordinal());
        } else if (xVar.D(b.g.a.c.w.WRITE_ENUMS_USING_TO_STRING)) {
            dVar.j0(r2.toString());
        } else {
            dVar.g0(this._values.c(r2));
        }
    }
}
