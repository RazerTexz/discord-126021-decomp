package b.i.a.c.x2.k0;

import b.i.a.c.x2.a$e;
import b.i.a.c.x2.a$f;
import java.io.IOException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: TsBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f0$a implements a$f {
    public final b.i.a.c.f3.d0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.f3.x f1248b = new b.i.a.c.f3.x();
    public final int c;
    public final int d;

    public f0$a(int i, b.i.a.c.f3.d0 d0Var, int i2) {
        this.c = i;
        this.a = d0Var;
        this.d = i2;
    }

    @Override // b.i.a.c.x2.a$f
    public void a() {
        this.f1248b.B(b.i.a.c.f3.e0.f);
    }

    @Override // b.i.a.c.x2.a$f
    public a$e b(b.i.a.c.x2.i iVar, long j) throws IOException {
        long position = iVar.getPosition();
        int iMin = (int) Math.min(this.d, iVar.b() - position);
        this.f1248b.A(iMin);
        iVar.o(this.f1248b.a, 0, iMin);
        b.i.a.c.f3.x xVar = this.f1248b;
        int i = xVar.c;
        long j2 = -1;
        long j3 = -1;
        long j4 = -9223372036854775807L;
        while (xVar.a() >= 188) {
            byte[] bArr = xVar.a;
            int i2 = xVar.f984b;
            while (i2 < i && bArr[i2] != 71) {
                i2++;
            }
            int i3 = i2 + Opcodes.NEWARRAY;
            if (i3 > i) {
                break;
            }
            long jK1 = b.c.a.a0.d.K1(xVar, i2, this.c);
            if (jK1 != -9223372036854775807L) {
                long jB = this.a.b(jK1);
                if (jB > j) {
                    return j4 == -9223372036854775807L ? a$e.a(jB, position) : a$e.b(position + j3);
                }
                if (100000 + jB > j) {
                    return a$e.b(position + ((long) i2));
                }
                j4 = jB;
                j3 = i2;
            }
            xVar.E(i3);
            j2 = i3;
        }
        return j4 != -9223372036854775807L ? a$e.c(j4, position + j2) : a$e.a;
    }
}
