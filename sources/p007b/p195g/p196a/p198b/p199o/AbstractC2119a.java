package p007b.p195g.p196a.p198b.p199o;

import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import java.math.BigDecimal;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.AbstractC2111g;
import p007b.p195g.p196a.p198b.AbstractC2113i;
import p007b.p195g.p196a.p198b.p201q.C2131a;
import p007b.p195g.p196a.p198b.p201q.C2133c;

/* JADX INFO: renamed from: b.g.a.b.o.a */
/* JADX INFO: compiled from: GeneratorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2119a extends AbstractC2108d {

    /* JADX INFO: renamed from: m */
    public static final int f4527m = (AbstractC2108d.a.WRITE_NUMBERS_AS_STRINGS.m1669h() | AbstractC2108d.a.ESCAPE_NON_ASCII.m1669h()) | AbstractC2108d.a.STRICT_DUPLICATE_DETECTION.m1669h();

    /* JADX INFO: renamed from: n */
    public AbstractC2113i f4528n;

    /* JADX INFO: renamed from: o */
    public int f4529o;

    /* JADX INFO: renamed from: p */
    public boolean f4530p;

    /* JADX INFO: renamed from: q */
    public C2133c f4531q;

    public AbstractC2119a(int i, AbstractC2113i abstractC2113i) {
        this.f4529o = i;
        this.f4528n = abstractC2113i;
        this.f4531q = new C2133c(0, null, AbstractC2108d.a.STRICT_DUPLICATE_DETECTION.m1668g(i) ? new C2131a(this) : null);
        this.f4530p = AbstractC2108d.a.WRITE_NUMBERS_AS_STRINGS.m1668g(i);
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: V */
    public void mo1644V(String str) throws IOException {
        mo1693t0("write raw value");
        mo1642T(str);
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: c */
    public AbstractC2111g mo1650c() {
        return this.f4531q;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: d */
    public final boolean mo1652d(AbstractC2108d.a aVar) {
        return (aVar.m1669h() & this.f4529o) != 0;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: e */
    public void mo1654e(Object obj) {
        C2133c c2133c = this.f4531q;
        if (c2133c != null) {
            c2133c.f4574g = obj;
        }
    }

    /* JADX INFO: renamed from: o0 */
    public String m1691o0(BigDecimal bigDecimal) throws IOException {
        if (!AbstractC2108d.a.WRITE_BIGDECIMAL_AS_PLAIN.m1668g(this.f4529o)) {
            return bigDecimal.toString();
        }
        int iScale = bigDecimal.scale();
        if (iScale < -9999 || iScale > 9999) {
            throw new JsonGenerationException(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(iScale), 9999, 9999), this);
        }
        return bigDecimal.toPlainString();
    }

    /* JADX INFO: renamed from: r0 */
    public abstract void mo1692r0(int i, int i2);

    /* JADX INFO: renamed from: t0 */
    public abstract void mo1693t0(String str) throws IOException;

    /* JADX INFO: renamed from: w0 */
    public AbstractC2108d m1694w0(int i, int i2) {
        int i3 = this.f4529o;
        int i4 = (i & i2) | ((~i2) & i3);
        int i5 = i3 ^ i4;
        if (i5 != 0) {
            this.f4529o = i4;
            mo1692r0(i4, i5);
        }
        return this;
    }
}
