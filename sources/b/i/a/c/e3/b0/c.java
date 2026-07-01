package b.i.a.c.e3.b0;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.e3.a0;
import b.i.a.c.e3.n$b;
import b.i.a.c.e3.z;
import b.i.a.c.f3.e0;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.Cache$CacheException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: CacheDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b.i.a.c.e3.l {
    public final Cache a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.e3.l f926b;

    @Nullable
    public final b.i.a.c.e3.l c;
    public final b.i.a.c.e3.l d;
    public final g e;

    @Nullable
    public final c$a f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    @Nullable
    public Uri j;

    @Nullable
    public b.i.a.c.e3.n k;

    @Nullable
    public b.i.a.c.e3.n l;

    @Nullable
    public b.i.a.c.e3.l m;
    public long n;
    public long o;
    public long p;

    @Nullable
    public h q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f927s;
    public long t;
    public long u;

    public c(Cache cache, @Nullable b.i.a.c.e3.l lVar, b.i.a.c.e3.l lVar2, @Nullable b.i.a.c.e3.j jVar, int i, @Nullable c$a c_a) {
        this.a = cache;
        this.f926b = lVar2;
        int i2 = g.a;
        this.e = a.f925b;
        this.g = (i & 1) != 0;
        this.h = (i & 2) != 0;
        this.i = (i & 4) != 0;
        this.d = lVar;
        this.c = new z(lVar, jVar);
        this.f = null;
    }

    @Override // b.i.a.c.e3.l
    public long a(b.i.a.c.e3.n nVar) throws IOException {
        int i;
        c$a c_a;
        try {
            Objects.requireNonNull((a) this.e);
            String string = nVar.h;
            if (string == null) {
                string = nVar.a.toString();
            }
            n$b n_bA = nVar.a();
            n_bA.h = string;
            b.i.a.c.e3.n nVarA = n_bA.a();
            this.k = nVarA;
            Cache cache = this.a;
            Uri uri = nVarA.a;
            byte[] bArr = ((n) cache.b(string)).c.get("exo_redir");
            Uri uri2 = null;
            String str = bArr != null ? new String(bArr, b.i.b.a.c.c) : null;
            if (str != null) {
                uri2 = Uri.parse(str);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.j = uri;
            this.o = nVar.f;
            boolean z2 = true;
            if (this.h && this.r) {
                i = 0;
            } else {
                i = (this.i && nVar.g == -1) ? 1 : -1;
            }
            if (i == -1) {
                z2 = false;
            }
            this.f927s = z2;
            if (z2 && (c_a = this.f) != null) {
                c_a.a(i);
            }
            if (this.f927s) {
                this.p = -1L;
            } else {
                long jA = k.a(this.a.b(string));
                this.p = jA;
                if (jA != -1) {
                    long j = jA - nVar.f;
                    this.p = j;
                    if (j < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = nVar.g;
            if (jMin != -1) {
                long j2 = this.p;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.p = jMin;
            }
            long j3 = this.p;
            if (j3 > 0 || j3 == -1) {
                t(nVarA, false);
            }
            long j4 = nVar.g;
            return j4 != -1 ? j4 : this.p;
        } catch (Throwable th) {
            q(th);
            throw th;
        }
    }

    @Override // b.i.a.c.e3.l
    public void close() throws IOException {
        this.k = null;
        this.j = null;
        this.o = 0L;
        c$a c_a = this.f;
        if (c_a != null && this.t > 0) {
            c_a.b(this.a.h(), this.t);
            this.t = 0L;
        }
        try {
            p();
        } catch (Throwable th) {
            q(th);
            throw th;
        }
    }

    @Override // b.i.a.c.e3.l
    public void d(a0 a0Var) {
        Objects.requireNonNull(a0Var);
        this.f926b.d(a0Var);
        this.d.d(a0Var);
    }

    @Override // b.i.a.c.e3.l
    public Map<String, List<String>> j() {
        return s() ? this.d.j() : Collections.emptyMap();
    }

    @Override // b.i.a.c.e3.l
    @Nullable
    public Uri n() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p() throws IOException {
        b.i.a.c.e3.l lVar = this.m;
        if (lVar == null) {
            return;
        }
        try {
            lVar.close();
        } finally {
            this.l = null;
            this.m = null;
            h hVar = this.q;
            if (hVar != null) {
                this.a.i(hVar);
                this.q = null;
            }
        }
    }

    public final void q(Throwable th) {
        if (r() || (th instanceof Cache$CacheException)) {
            this.r = true;
        }
    }

    public final boolean r() {
        return this.m == this.f926b;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x008a A[Catch: all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:9:0x001b, B:11:0x0024, B:12:0x0027, B:14:0x0038, B:16:0x003e, B:17:0x0044, B:19:0x0055, B:20:0x0059, B:22:0x005f, B:24:0x0065, B:26:0x006b, B:30:0x007a, B:31:0x008a, B:37:0x0098), top: B:42:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0090  */
    /* JADX WARN: Code duplicated, block: B:35:0x0096  */
    @Override // b.i.a.c.e3.h
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j;
        if (i2 == 0) {
            return 0;
        }
        if (this.p == 0) {
            return -1;
        }
        b.i.a.c.e3.n nVar = this.k;
        Objects.requireNonNull(nVar);
        b.i.a.c.e3.n nVar2 = this.l;
        Objects.requireNonNull(nVar2);
        try {
            if (this.o >= this.u) {
                t(nVar, true);
            }
            b.i.a.c.e3.l lVar = this.m;
            Objects.requireNonNull(lVar);
            int i3 = lVar.read(bArr, i, i2);
            if (i3 != -1) {
                if (r()) {
                    this.t += (long) i3;
                }
                long j2 = i3;
                this.o += j2;
                this.n += j2;
                long j3 = this.p;
                if (j3 != -1) {
                    this.p = j3 - j2;
                }
            } else {
                if (!s()) {
                    j = this.p;
                    if (j <= 0) {
                        if (j == -1) {
                        }
                    }
                    p();
                    t(nVar, false);
                    return read(bArr, i, i2);
                }
                long j4 = nVar2.g;
                if (j4 != -1 && this.n >= j4) {
                    j = this.p;
                    if (j <= 0) {
                        if (j == -1) {
                        }
                    }
                    p();
                    t(nVar, false);
                    return read(bArr, i, i2);
                }
                String str = nVar.h;
                int i4 = e0.a;
                this.p = 0L;
                if (this.m == this.c) {
                    m mVar = new m();
                    m.a(mVar, this.o);
                    this.a.c(str, mVar);
                }
            }
            return i3;
        } catch (Throwable th) {
            q(th);
            throw th;
        }
    }

    public final boolean s() {
        return !r();
    }

    public final void t(b.i.a.c.e3.n nVar, boolean z2) throws IOException {
        h hVarF;
        b.i.a.c.e3.n nVarA;
        b.i.a.c.e3.l lVar;
        String str = nVar.h;
        int i = e0.a;
        if (this.f927s) {
            hVarF = null;
        } else if (this.g) {
            try {
                hVarF = this.a.f(str, this.o, this.p);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            hVarF = this.a.e(str, this.o, this.p);
        }
        if (hVarF == null) {
            lVar = this.d;
            n$b n_bA = nVar.a();
            n_bA.f = this.o;
            n_bA.g = this.p;
            nVarA = n_bA.a();
        } else if (hVarF.m) {
            Uri uriFromFile = Uri.fromFile(hVarF.n);
            long j = hVarF.k;
            long j2 = this.o - j;
            long jMin = hVarF.l - j2;
            long j3 = this.p;
            if (j3 != -1) {
                jMin = Math.min(jMin, j3);
            }
            n$b n_bA2 = nVar.a();
            n_bA2.a = uriFromFile;
            n_bA2.f943b = j;
            n_bA2.f = j2;
            n_bA2.g = jMin;
            nVarA = n_bA2.a();
            lVar = this.f926b;
        } else {
            long jMin2 = hVarF.l;
            if (jMin2 == -1) {
                jMin2 = this.p;
            } else {
                long j4 = this.p;
                if (j4 != -1) {
                    jMin2 = Math.min(jMin2, j4);
                }
            }
            n$b n_bA3 = nVar.a();
            n_bA3.f = this.o;
            n_bA3.g = jMin2;
            nVarA = n_bA3.a();
            lVar = this.c;
            if (lVar == null) {
                lVar = this.d;
                this.a.i(hVarF);
                hVarF = null;
            }
        }
        this.u = (this.f927s || lVar != this.d) ? RecyclerView.FOREVER_NS : this.o + 102400;
        if (z2) {
            b.c.a.a0.d.D(this.m == this.d);
            if (lVar == this.d) {
                return;
            }
            try {
                p();
            } catch (Throwable th) {
                if (!(!hVarF.m)) {
                    throw th;
                }
                this.a.i(hVarF);
                throw th;
            }
        }
        if (hVarF != null && (!hVarF.m)) {
            this.q = hVarF;
        }
        this.m = lVar;
        this.l = nVarA;
        this.n = 0L;
        long jA = lVar.a(nVarA);
        m mVar = new m();
        if (nVarA.g == -1 && jA != -1) {
            this.p = jA;
            m.a(mVar, this.o + jA);
        }
        if (s()) {
            Uri uriN = lVar.n();
            this.j = uriN;
            Uri uri = nVar.a.equals(uriN) ^ true ? this.j : null;
            if (uri == null) {
                mVar.f935b.add("exo_redir");
                mVar.a.remove("exo_redir");
            } else {
                String string = uri.toString();
                Map<String, Object> map = mVar.a;
                Objects.requireNonNull(string);
                map.put("exo_redir", string);
                mVar.f935b.remove("exo_redir");
            }
        }
        if (this.m == this.c) {
            this.a.c(str, mVar);
        }
    }
}
