package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: TeeDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements l {
    public final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f957b;
    public boolean c;
    public long d;

    public z(l lVar, j jVar) {
        this.a = lVar;
        this.f957b = jVar;
    }

    @Override // b.i.a.c.e3.l
    public long a(n nVar) throws IOException {
        n nVar2 = nVar;
        long jA = this.a.a(nVar2);
        this.d = jA;
        if (jA == 0) {
            return 0L;
        }
        long j = nVar2.g;
        if (j == -1 && jA != -1) {
            nVar2 = j == jA ? nVar2 : new n(nVar2.a, nVar2.f942b, nVar2.c, nVar2.d, nVar2.e, nVar2.f + 0, jA, nVar2.h, nVar2.i, nVar2.j);
        }
        this.c = true;
        this.f957b.a(nVar2);
        return this.d;
    }

    @Override // b.i.a.c.e3.l
    public void close() throws IOException {
        try {
            this.a.close();
        } finally {
            if (this.c) {
                this.c = false;
                this.f957b.close();
            }
        }
    }

    @Override // b.i.a.c.e3.l
    public void d(a0 a0Var) {
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
        if (this.d == 0) {
            return -1;
        }
        int i3 = this.a.read(bArr, i, i2);
        if (i3 > 0) {
            this.f957b.write(bArr, i, i3);
            long j = this.d;
            if (j != -1) {
                this.d = j - ((long) i3);
            }
        }
        return i3;
    }
}
