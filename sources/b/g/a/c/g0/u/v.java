package b.g.a.c.g0.u;

import b.g.a.a.i$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: NumberSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class v extends p0<Number> implements b.g.a.c.g0.i {
    public static final v k = new v(Number.class);
    public final boolean _isInt;

    public v(Class<? extends Number> cls) {
        super(cls, false);
        this._isInt = cls == BigInteger.class;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        i$d i_dL = l(xVar, dVar, this._handledType);
        if (i_dL == null || i_dL.e().ordinal() != 8) {
            return this;
        }
        return this._handledType == BigDecimal.class ? v$a.k : t0.k;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Number number = (Number) obj;
        if (number instanceof BigDecimal) {
            dVar.L((BigDecimal) number);
            return;
        }
        if (number instanceof BigInteger) {
            dVar.N((BigInteger) number);
            return;
        }
        if (number instanceof Long) {
            dVar.I(number.longValue());
            return;
        }
        if (number instanceof Double) {
            dVar.C(number.doubleValue());
            return;
        }
        if (number instanceof Float) {
            dVar.D(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            dVar.H(number.intValue());
        } else {
            dVar.J(number.toString());
        }
    }
}
