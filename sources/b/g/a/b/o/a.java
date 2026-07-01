package b.g.a.b.o;

import b.g.a.b.d;
import b.g.a.b.d$a;
import b.g.a.b.g;
import b.g.a.b.i;
import b.g.a.b.q.c;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: compiled from: GeneratorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends d {
    public static final int m = (d$a.WRITE_NUMBERS_AS_STRINGS.h() | d$a.ESCAPE_NON_ASCII.h()) | d$a.STRICT_DUPLICATE_DETECTION.h();
    public i n;
    public int o;
    public boolean p;
    public c q;

    public a(int i, i iVar) {
        this.o = i;
        this.n = iVar;
        this.q = new c(0, null, d$a.STRICT_DUPLICATE_DETECTION.g(i) ? new b.g.a.b.q.a(this) : null);
        this.p = d$a.WRITE_NUMBERS_AS_STRINGS.g(i);
    }

    @Override // b.g.a.b.d
    public void V(String str) throws IOException {
        t0("write raw value");
        T(str);
    }

    @Override // b.g.a.b.d
    public g c() {
        return this.q;
    }

    @Override // b.g.a.b.d
    public final boolean d(d$a d_a) {
        return (d_a.h() & this.o) != 0;
    }

    @Override // b.g.a.b.d
    public void e(Object obj) {
        c cVar = this.q;
        if (cVar != null) {
            cVar.g = obj;
        }
    }

    public String o0(BigDecimal bigDecimal) throws IOException {
        if (!d$a.WRITE_BIGDECIMAL_AS_PLAIN.g(this.o)) {
            return bigDecimal.toString();
        }
        int iScale = bigDecimal.scale();
        if (iScale < -9999 || iScale > 9999) {
            throw new JsonGenerationException(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(iScale), 9999, 9999), this);
        }
        return bigDecimal.toPlainString();
    }

    public abstract void r0(int i, int i2);

    public abstract void t0(String str) throws IOException;

    public d w0(int i, int i2) {
        int i3 = this.o;
        int i4 = (i & i2) | ((~i2) & i3);
        int i5 = i3 ^ i4;
        if (i5 != 0) {
            this.o = i4;
            r0(i4, i5);
        }
        return this;
    }
}
