package b.c.a.a0;

import java.io.IOException;

/* JADX INFO: compiled from: IntegerParser.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements h0<Integer> {
    public static final o a = new o();

    @Override // b.c.a.a0.h0
    public Integer a(b.c.a.a0.i0.c cVar, float f) throws IOException {
        return Integer.valueOf(Math.round(p.d(cVar) * f));
    }
}
