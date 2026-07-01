package b.i.a.c.x2.l0;

import android.util.Log;
import android.util.Pair;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.x2.h;
import b.i.a.c.x2.i;
import b.i.a.c.x2.j;
import b.i.a.c.x2.s;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: WavExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements h {
    public j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f1285b;
    public b$b d;
    public int c = 0;
    public int e = -1;
    public long f = -1;

    static {
        a aVar = a.a;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(i iVar) throws IOException {
        return b.c.a.a0.d.r(iVar);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x01b8  */
    @Override // b.i.a.c.x2.h
    public int e(i iVar, s sVar) throws IOException {
        byte[] bArr;
        int iR;
        int i;
        b.c.a.a0.d.H(this.f1285b);
        int i2 = e0.a;
        int i3 = this.c;
        if (i3 == 0) {
            b.c.a.a0.d.D(iVar.getPosition() == 0);
            int i4 = this.e;
            if (i4 != -1) {
                iVar.l(i4);
                this.c = 3;
            } else {
                if (!b.c.a.a0.d.r(iVar)) {
                    throw ParserException.a("Unsupported or unrecognized wav file type.", null);
                }
                iVar.l((int) (iVar.f() - iVar.getPosition()));
                this.c = 1;
            }
            return 0;
        }
        if (i3 == 1) {
            x xVar = new x(16);
            d dVarA = d.a(iVar, xVar);
            while (dVarA.a != 1718449184) {
                iVar.l(((int) dVarA.f1289b) + 8);
                dVarA = d.a(iVar, xVar);
            }
            b.c.a.a0.d.D(dVarA.f1289b >= 16);
            iVar.o(xVar.a, 0, 16);
            xVar.E(0);
            int iL = xVar.l();
            int iL2 = xVar.l();
            int iK = xVar.k();
            int iK2 = xVar.k();
            int iL3 = xVar.l();
            int iL4 = xVar.l();
            int i5 = ((int) dVarA.f1289b) - 16;
            if (i5 > 0) {
                bArr = new byte[i5];
                iVar.o(bArr, 0, i5);
            } else {
                bArr = e0.f;
            }
            iVar.l((int) (iVar.f() - iVar.getPosition()));
            c cVar = new c(iL, iL2, iK, iK2, iL3, iL4, bArr);
            if (iL == 17) {
                this.d = new b$a(this.a, this.f1285b, cVar);
            } else if (iL == 6) {
                this.d = new b$c(this.a, this.f1285b, cVar, "audio/g711-alaw", -1);
            } else if (iL == 7) {
                this.d = new b$c(this.a, this.f1285b, cVar, "audio/g711-mlaw", -1);
            } else {
                if (iL == 1) {
                    iR = e0.r(iL4);
                    i = iR;
                } else if (iL == 3) {
                    iR = iL4 == 32 ? 4 : 0;
                    i = iR;
                } else if (iL != 65534) {
                    i = 0;
                } else {
                    iR = e0.r(iL4);
                    i = iR;
                }
                if (i == 0) {
                    StringBuilder sb = new StringBuilder(40);
                    sb.append("Unsupported WAV format type: ");
                    sb.append(iL);
                    throw ParserException.b(sb.toString());
                }
                this.d = new b$c(this.a, this.f1285b, cVar, "audio/raw", i);
            }
            this.c = 2;
            return 0;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                throw new IllegalStateException();
            }
            b.c.a.a0.d.D(this.f != -1);
            long position = this.f - iVar.getPosition();
            b$b b_b = this.d;
            Objects.requireNonNull(b_b);
            return b_b.c(iVar, position) ? -1 : 0;
        }
        iVar.k();
        x xVar2 = new x(8);
        d dVarA2 = d.a(iVar, xVar2);
        while (true) {
            int i6 = dVarA2.a;
            if (i6 == 1684108385) {
                iVar.l(8);
                long position2 = iVar.getPosition();
                long j = dVarA2.f1289b + position2;
                long jB = iVar.b();
                if (jB != -1 && j > jB) {
                    StringBuilder sbR = b.d.b.a.a.R(69, "Data exceeds input length: ", j, ", ");
                    sbR.append(jB);
                    Log.w("WavHeaderReader", sbR.toString());
                    j = jB;
                }
                Pair pairCreate = Pair.create(Long.valueOf(position2), Long.valueOf(j));
                this.e = ((Long) pairCreate.first).intValue();
                this.f = ((Long) pairCreate.second).longValue();
                b$b b_b2 = this.d;
                Objects.requireNonNull(b_b2);
                b_b2.b(this.e, this.f);
                this.c = 3;
                return 0;
            }
            b.d.b.a.a.g0(39, "Ignoring unknown WAV chunk: ", i6, "WavHeaderReader");
            long j2 = dVarA2.f1289b + 8;
            if (j2 > 2147483647L) {
                int i7 = dVarA2.a;
                StringBuilder sb2 = new StringBuilder(51);
                sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                sb2.append(i7);
                throw ParserException.b(sb2.toString());
            }
            iVar.l((int) j2);
            dVarA2 = d.a(iVar, xVar2);
        }
    }

    @Override // b.i.a.c.x2.h
    public void f(j jVar) {
        this.a = jVar;
        this.f1285b = jVar.p(0, 1);
        jVar.j();
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.c = j == 0 ? 0 : 3;
        b$b b_b = this.d;
        if (b_b != null) {
            b_b.a(j2);
        }
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
