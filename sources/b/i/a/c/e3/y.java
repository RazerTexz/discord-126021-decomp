package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: StatsDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements l {
    public final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f956b;
    public Uri c;
    public Map<String, List<String>> d;

    public y(l lVar) {
        Objects.requireNonNull(lVar);
        this.a = lVar;
        this.c = Uri.EMPTY;
        this.d = Collections.emptyMap();
    }

    @Override // b.i.a.c.e3.l
    public long a(n nVar) throws IOException {
        this.c = nVar.a;
        this.d = Collections.emptyMap();
        long jA = this.a.a(nVar);
        Uri uriN = n();
        Objects.requireNonNull(uriN);
        this.c = uriN;
        this.d = j();
        return jA;
    }

    @Override // b.i.a.c.e3.l
    public void close() throws IOException {
        this.a.close();
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
        int i3 = this.a.read(bArr, i, i2);
        if (i3 != -1) {
            this.f956b += (long) i3;
        }
        return i3;
    }
}
