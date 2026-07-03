package p007b.p195g.p196a.p198b.p201q;

import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import org.objectweb.asm.Opcodes;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.AbstractC2113i;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p199o.AbstractC2119a;
import p007b.p195g.p196a.p198b.p200p.C2121a;
import p007b.p195g.p196a.p198b.p200p.C2123c;
import p007b.p195g.p196a.p198b.p204t.C2142d;

/* JADX INFO: renamed from: b.g.a.b.q.b */
/* JADX INFO: compiled from: JsonGeneratorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2132b extends AbstractC2119a {

    /* JADX INFO: renamed from: r */
    public static final int[] f4564r = C2121a.f4541f;

    /* JADX INFO: renamed from: s */
    public final C2123c f4565s;

    /* JADX INFO: renamed from: t */
    public int[] f4566t;

    /* JADX INFO: renamed from: u */
    public int f4567u;

    /* JADX INFO: renamed from: v */
    public InterfaceC2115k f4568v;

    /* JADX INFO: renamed from: w */
    public boolean f4569w;

    public AbstractC2132b(C2123c c2123c, int i, AbstractC2113i abstractC2113i) {
        super(i, abstractC2113i);
        this.f4566t = f4564r;
        this.f4568v = C2142d.f4599j;
        this.f4565s = c2123c;
        if (AbstractC2108d.a.ESCAPE_NON_ASCII.m1668g(i)) {
            this.f4567u = Opcodes.LAND;
        }
        this.f4569w = !AbstractC2108d.a.QUOTE_FIELD_NAMES.m1668g(i);
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: b */
    public AbstractC2108d mo1648b(AbstractC2108d.a aVar) {
        int iM1669h = aVar.m1669h();
        this.f4529o &= ~iM1669h;
        if ((iM1669h & AbstractC2119a.f4527m) != 0) {
            if (aVar == AbstractC2108d.a.WRITE_NUMBERS_AS_STRINGS) {
                this.f4530p = false;
            } else if (aVar == AbstractC2108d.a.ESCAPE_NON_ASCII) {
                m1705y0(0);
            } else if (aVar == AbstractC2108d.a.STRICT_DUPLICATE_DETECTION) {
                C2133c c2133c = this.f4531q;
                c2133c.f4571d = null;
                this.f4531q = c2133c;
            }
        }
        if (aVar == AbstractC2108d.a.QUOTE_FIELD_NAMES) {
            this.f4569w = true;
        }
        return this;
    }

    @Override // p007b.p195g.p196a.p198b.p199o.AbstractC2119a
    /* JADX INFO: renamed from: r0 */
    public void mo1692r0(int i, int i2) {
        if ((AbstractC2119a.f4527m & i2) != 0) {
            this.f4530p = AbstractC2108d.a.WRITE_NUMBERS_AS_STRINGS.m1668g(i);
            AbstractC2108d.a aVar = AbstractC2108d.a.ESCAPE_NON_ASCII;
            if (aVar.m1668g(i2)) {
                if (aVar.m1668g(i)) {
                    m1705y0(Opcodes.LAND);
                } else {
                    m1705y0(0);
                }
            }
            AbstractC2108d.a aVar2 = AbstractC2108d.a.STRICT_DUPLICATE_DETECTION;
            if (aVar2.m1668g(i2)) {
                if (aVar2.m1668g(i)) {
                    C2133c c2133c = this.f4531q;
                    if (c2133c.f4571d == null) {
                        c2133c.f4571d = new C2131a(this);
                        this.f4531q = c2133c;
                    }
                } else {
                    C2133c c2133c2 = this.f4531q;
                    c2133c2.f4571d = null;
                    this.f4531q = c2133c2;
                }
            }
        }
        this.f4569w = !AbstractC2108d.a.QUOTE_FIELD_NAMES.m1668g(i);
    }

    /* JADX INFO: renamed from: x0 */
    public void m1704x0(String str) throws IOException {
        throw new JsonGenerationException(String.format("Can not %s, expecting field name (context: %s)", str, this.f4531q.m1677e()), this);
    }

    /* JADX INFO: renamed from: y0 */
    public AbstractC2108d m1705y0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f4567u = i;
        return this;
    }
}
