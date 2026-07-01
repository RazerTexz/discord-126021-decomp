package b.i.a.c.x2.d0;

import b.i.a.c.f3.x;
import b.i.a.c.x2.a$e;
import b.i.a.c.x2.a$f;
import b.i.a.c.x2.i;
import b.i.a.c.x2.m;
import b.i.a.c.x2.m$a;
import b.i.a.c.x2.o;
import java.io.IOException;

/* JADX INFO: compiled from: FlacBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b implements a$f {
    public final o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1168b;
    public final m$a c = new m$a();

    public c$b(o oVar, int i, c$a c_a) {
        this.a = oVar;
        this.f1168b = i;
    }

    @Override // b.i.a.c.x2.a$f
    public /* synthetic */ void a() {
        b.i.a.c.x2.b.a(this);
    }

    @Override // b.i.a.c.x2.a$f
    public a$e b(i iVar, long j) throws IOException {
        long position = iVar.getPosition();
        long jC = c(iVar);
        long jF = iVar.f();
        iVar.g(Math.max(6, this.a.c));
        long jC2 = c(iVar);
        long jF2 = iVar.f();
        if (jC > j || jC2 <= j) {
            return jC2 <= j ? a$e.c(jC2, jF2) : a$e.a(jC, position);
        }
        return a$e.b(jF);
    }

    public final long c(i iVar) throws IOException {
        while (iVar.f() < iVar.b() - 6) {
            o oVar = this.a;
            int i = this.f1168b;
            m$a m_a = this.c;
            long jF = iVar.f();
            byte[] bArr = new byte[2];
            boolean zB = false;
            iVar.o(bArr, 0, 2);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                iVar.k();
                iVar.g((int) (jF - iVar.getPosition()));
            } else {
                x xVar = new x(16);
                System.arraycopy(bArr, 0, xVar.a, 0, 2);
                xVar.D(b.c.a.a0.d.z1(iVar, xVar.a, 2, 14));
                iVar.k();
                iVar.g((int) (jF - iVar.getPosition()));
                zB = m.b(xVar, oVar, i, m_a);
            }
            if (zB) {
                break;
            }
            iVar.g(1);
        }
        if (iVar.f() < iVar.b() - 6) {
            return this.c.a;
        }
        iVar.g((int) (iVar.b() - iVar.f()));
        return this.a.j;
    }
}
