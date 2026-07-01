package b.i.a.c.a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: IcyDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements b.i.a.c.e3.l {
    public final b.i.a.c.e3.l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f832b;
    public final s$a c;
    public final byte[] d;
    public int e;

    public s(b.i.a.c.e3.l lVar, int i, s$a s_a) {
        b.c.a.a0.d.j(i > 0);
        this.a = lVar;
        this.f832b = i;
        this.c = s_a;
        this.d = new byte[1];
        this.e = i;
    }

    @Override // b.i.a.c.e3.l
    public long a(b.i.a.c.e3.n nVar) {
        throw new UnsupportedOperationException();
    }

    @Override // b.i.a.c.e3.l
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // b.i.a.c.e3.l
    public void d(b.i.a.c.e3.a0 a0Var) {
        Objects.requireNonNull(a0Var);
        this.a.d(a0Var);
    }

    @Override // b.i.a.c.e3.l
    public Map<String, List<String>> j() {
        return this.a.j();
    }

    @Override // b.i.a.c.e3.l
    @Nullable
    public Uri n() {
        return this.a.n();
    }

    @Override // b.i.a.c.e3.h
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long jMax;
        if (this.e == 0) {
            boolean z2 = true;
            if (this.a.read(this.d, 0, 1) == -1) {
                z2 = false;
                break;
            }
            int i3 = (this.d[0] & 255) << 4;
            if (i3 != 0) {
                byte[] bArr2 = new byte[i3];
                int i4 = i3;
                int i5 = 0;
                while (true) {
                    if (i4 <= 0) {
                        while (i3 > 0) {
                            int i6 = i3 - 1;
                            if (bArr2[i6] != 0) {
                                break;
                            }
                            i3 = i6;
                        }
                        if (i3 <= 0) {
                            break;
                        }
                        s$a s_a = this.c;
                        b.i.a.c.f3.x xVar = new b.i.a.c.f3.x(bArr2, i3);
                        e0$a e0_a = (e0$a) s_a;
                        if (e0_a.n) {
                            e0 e0Var = e0_a.o;
                            Map<String, String> map = e0.j;
                            jMax = Math.max(e0Var.v(), e0_a.j);
                        } else {
                            jMax = e0_a.j;
                        }
                        int iA = xVar.a();
                        b.i.a.c.x2.w wVar = e0_a.m;
                        Objects.requireNonNull(wVar);
                        wVar.c(xVar, iA);
                        wVar.d(jMax, 1, iA, 0, null);
                        e0_a.n = true;
                        break;
                    }
                    int i7 = this.a.read(bArr2, i5, i4);
                    if (i7 == -1) {
                        z2 = false;
                        break;
                    }
                    i5 += i7;
                    i4 -= i7;
                }
            }
            if (!z2) {
                return -1;
            }
            this.e = this.f832b;
        }
        int i8 = this.a.read(bArr, i, Math.min(this.e, i2));
        if (i8 != -1) {
            this.e -= i8;
        }
        return i8;
    }
}
