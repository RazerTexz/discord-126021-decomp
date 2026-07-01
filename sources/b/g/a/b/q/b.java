package b.g.a.b.q;

import b.g.a.b.d$a;
import b.g.a.b.i;
import b.g.a.b.k;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: JsonGeneratorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends b.g.a.b.o.a {
    public static final int[] r = b.g.a.b.p.a.f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b.g.a.b.p.c f671s;
    public int[] t;
    public int u;
    public k v;
    public boolean w;

    public b(b.g.a.b.p.c cVar, int i, i iVar) {
        super(i, iVar);
        this.t = r;
        this.v = b.g.a.b.t.d.j;
        this.f671s = cVar;
        if (d$a.ESCAPE_NON_ASCII.g(i)) {
            this.u = Opcodes.LAND;
        }
        this.w = !d$a.QUOTE_FIELD_NAMES.g(i);
    }

    @Override // b.g.a.b.d
    public b.g.a.b.d b(d$a d_a) {
        int iH = d_a.h();
        this.o &= ~iH;
        if ((iH & b.g.a.b.o.a.m) != 0) {
            if (d_a == d$a.WRITE_NUMBERS_AS_STRINGS) {
                this.p = false;
            } else if (d_a == d$a.ESCAPE_NON_ASCII) {
                y0(0);
            } else if (d_a == d$a.STRICT_DUPLICATE_DETECTION) {
                c cVar = this.q;
                cVar.d = null;
                this.q = cVar;
            }
        }
        if (d_a == d$a.QUOTE_FIELD_NAMES) {
            this.w = true;
        }
        return this;
    }

    @Override // b.g.a.b.o.a
    public void r0(int i, int i2) {
        if ((b.g.a.b.o.a.m & i2) != 0) {
            this.p = d$a.WRITE_NUMBERS_AS_STRINGS.g(i);
            d$a d_a = d$a.ESCAPE_NON_ASCII;
            if (d_a.g(i2)) {
                if (d_a.g(i)) {
                    y0(Opcodes.LAND);
                } else {
                    y0(0);
                }
            }
            d$a d_a2 = d$a.STRICT_DUPLICATE_DETECTION;
            if (d_a2.g(i2)) {
                if (d_a2.g(i)) {
                    c cVar = this.q;
                    if (cVar.d == null) {
                        cVar.d = new a(this);
                        this.q = cVar;
                    }
                } else {
                    c cVar2 = this.q;
                    cVar2.d = null;
                    this.q = cVar2;
                }
            }
        }
        this.w = !d$a.QUOTE_FIELD_NAMES.g(i);
    }

    public void x0(String str) throws IOException {
        throw new JsonGenerationException(String.format("Can not %s, expecting field name (context: %s)", str, this.q.e()), this);
    }

    public b.g.a.b.d y0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.u = i;
        return this;
    }
}
