package b.g.a.c.g0.u;

import b.g.a.a.i$d;
import b.g.a.b.f$b;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.math.BigDecimal;

/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w<T> extends p0<T> implements b.g.a.c.g0.i {
    public final boolean _isInt;
    public final f$b _numberType;
    public final String _schemaType;

    public w(Class<?> cls, f$b f_b, String str) {
        super(cls, false);
        this._numberType = f_b;
        this._schemaType = str;
        this._isInt = f_b == f$b.INT || f_b == f$b.LONG || f_b == f$b.BIG_INTEGER;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        i$d i_dL = l(xVar, dVar, this._handledType);
        if (i_dL == null || i_dL.e().ordinal() != 8) {
            return this;
        }
        if (this._handledType != BigDecimal.class) {
            return t0.k;
        }
        v vVar = v.k;
        return v$a.k;
    }
}
