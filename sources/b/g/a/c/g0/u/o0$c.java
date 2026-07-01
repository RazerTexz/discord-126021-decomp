package b.g.a.c.g0.u;

import java.io.IOException;

/* JADX INFO: compiled from: StdKeySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class o0$c extends q0<Object> {
    public final b.g.a.c.i0.f _values;

    public o0$c(Class<?> cls, b.g.a.c.i0.f fVar) {
        super(cls, false);
        this._values = fVar;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        if (xVar.D(b.g.a.c.w.WRITE_ENUMS_USING_TO_STRING)) {
            dVar.y(obj.toString());
            return;
        }
        Enum<?> r2 = (Enum) obj;
        if (xVar.D(b.g.a.c.w.WRITE_ENUM_KEYS_USING_INDEX)) {
            dVar.y(String.valueOf(r2.ordinal()));
        } else {
            dVar.x(this._values.c(r2));
        }
    }
}
