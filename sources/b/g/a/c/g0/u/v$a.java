package b.g.a.c.g0.u;

import b.g.a.b.d$a;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: compiled from: NumberSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$a extends u0 {
    public static final v$a k = new v$a();

    public v$a() {
        super(BigDecimal.class);
    }

    @Override // b.g.a.c.g0.u.u0, b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return false;
    }

    @Override // b.g.a.c.g0.u.u0, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        String string;
        if (dVar.d(d$a.WRITE_BIGDECIMAL_AS_PLAIN)) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            int iScale = bigDecimal.scale();
            if (!(iScale >= -9999 && iScale <= 9999)) {
                xVar.G(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(bigDecimal.scale()), 9999, 9999), new Object[0]);
                throw null;
            }
            string = bigDecimal.toPlainString();
        } else {
            string = obj.toString();
        }
        dVar.j0(string);
    }

    @Override // b.g.a.c.g0.u.u0
    public String p(Object obj) {
        throw new IllegalStateException();
    }
}
