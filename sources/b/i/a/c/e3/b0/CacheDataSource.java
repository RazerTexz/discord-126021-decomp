package b.i.a.c.e3.b0;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.e3.DataSink;
import b.i.a.c.e3.DataSource3;
import b.i.a.c.e3.DataSpec;
import b.i.a.c.e3.TeeDataSource;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.f3.Util2;
import b.i.b.a.Charsets;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.c, reason: use source file name */
/* JADX INFO: compiled from: CacheDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CacheDataSource implements DataSource3 {
    public final Cache a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataSource3 f926b;

    @Nullable
    public final DataSource3 c;
    public final DataSource3 d;
    public final CacheKeyFactory2 e;

    @Nullable
    public final a f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    @Nullable
    public Uri j;

    @Nullable
    public DataSpec k;

    @Nullable
    public DataSpec l;

    @Nullable
    public DataSource3 m;
    public long n;
    public long o;
    public long p;

    @Nullable
    public CacheSpan q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f927s;
    public long t;
    public long u;

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.c$a */
    /* JADX INFO: compiled from: CacheDataSource.java */
    public interface a {
        void a(int i);

        void b(long j, long j2);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource3 dataSource3, DataSource3 dataSource4, @Nullable DataSink dataSink, int i, @Nullable a aVar) {
        this.a = cache;
        this.f926b = dataSource4;
        int i2 = CacheKeyFactory2.a;
        this.e = b.i.a.c.e3.b0.a.f925b;
        this.g = (i & 1) != 0;
        this.h = (i & 2) != 0;
        this.i = (i & 4) != 0;
        this.d = dataSource3;
        this.c = new TeeDataSource(dataSource3, dataSink);
        this.f = null;
    }

    @Override // b.i.a.c.e3.DataSource3
    public long a(DataSpec dataSpec) throws IOException {
        int i;
        a aVar;
        try {
            Objects.requireNonNull((b.i.a.c.e3.b0.a) this.e);
            String string = dataSpec.h;
            if (string == null) {
                string = dataSpec.a.toString();
            }
            DataSpec.b bVarA = dataSpec.a();
            bVarA.h = string;
            DataSpec dataSpecA = bVarA.a();
            this.k = dataSpecA;
            Cache cache = this.a;
            Uri uri = dataSpecA.a;
            byte[] bArr = ((DefaultContentMetadata) cache.b(string)).c.get("exo_redir");
            Uri uri2 = null;
            String str = bArr != null ? new String(bArr, Charsets.c) : null;
            if (str != null) {
                uri2 = Uri.parse(str);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.j = uri;
            this.o = dataSpec.f;
            boolean z2 = true;
            if (this.h && this.r) {
                i = 0;
            } else {
                i = (this.i && dataSpec.g == -1) ? 1 : -1;
            }
            if (i == -1) {
                z2 = false;
            }
            this.f927s = z2;
            if (z2 && (aVar = this.f) != null) {
                aVar.a(i);
            }
            if (this.f927s) {
                this.p = -1L;
            } else {
                long jA = ContentMetadata.a(this.a.b(string));
                this.p = jA;
                if (jA != -1) {
                    long j = jA - dataSpec.f;
                    this.p = j;
                    if (j < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = dataSpec.g;
            if (jMin != -1) {
                long j2 = this.p;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.p = jMin;
            }
            long j3 = this.p;
            if (j3 > 0 || j3 == -1) {
                t(dataSpecA, false);
            }
            long j4 = dataSpec.g;
            return j4 != -1 ? j4 : this.p;
        } catch (Throwable th) {
            q(th);
            throw th;
        }
    }

    @Override // b.i.a.c.e3.DataSource3
    public void close() throws IOException {
        this.k = null;
        this.j = null;
        this.o = 0L;
        a aVar = this.f;
        if (aVar != null && this.t > 0) {
            aVar.b(this.a.h(), this.t);
            this.t = 0L;
        }
        try {
            p();
        } catch (Throwable th) {
            q(th);
            throw th;
        }
    }

    @Override // b.i.a.c.e3.DataSource3
    public void d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        this.f926b.d(transferListener);
        this.d.d(transferListener);
    }

    @Override // b.i.a.c.e3.DataSource3
    public Map<String, List<String>> j() {
        return s() ? this.d.j() : Collections.emptyMap();
    }

    @Override // b.i.a.c.e3.DataSource3
    @Nullable
    public Uri n() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p() throws IOException {
        DataSource3 dataSource3 = this.m;
        if (dataSource3 == null) {
            return;
        }
        try {
            dataSource3.close();
        } finally {
            this.l = null;
            this.m = null;
            CacheSpan cacheSpan = this.q;
            if (cacheSpan != null) {
                this.a.i(cacheSpan);
                this.q = null;
            }
        }
    }

    public final void q(Throwable th) {
        if (r() || (th instanceof Cache.CacheException)) {
            this.r = true;
        }
    }

    public final boolean r() {
        return this.m == this.f926b;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x008a A[Catch: all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:9:0x001b, B:11:0x0024, B:12:0x0027, B:14:0x0038, B:16:0x003e, B:17:0x0044, B:19:0x0055, B:20:0x0059, B:22:0x005f, B:24:0x0065, B:26:0x006b, B:30:0x007a, B:31:0x008a, B:37:0x0098), top: B:42:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0090  */
    /* JADX WARN: Code duplicated, block: B:35:0x0096  */
    @Override // b.i.a.c.e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j;
        if (i2 == 0) {
            return 0;
        }
        if (this.p == 0) {
            return -1;
        }
        DataSpec dataSpec = this.k;
        Objects.requireNonNull(dataSpec);
        DataSpec dataSpec2 = this.l;
        Objects.requireNonNull(dataSpec2);
        try {
            if (this.o >= this.u) {
                t(dataSpec, true);
            }
            DataSource3 dataSource3 = this.m;
            Objects.requireNonNull(dataSource3);
            int i3 = dataSource3.read(bArr, i, i2);
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
                    t(dataSpec, false);
                    return read(bArr, i, i2);
                }
                long j4 = dataSpec2.g;
                if (j4 != -1 && this.n >= j4) {
                    j = this.p;
                    if (j <= 0) {
                        if (j == -1) {
                        }
                    }
                    p();
                    t(dataSpec, false);
                    return read(bArr, i, i2);
                }
                String str = dataSpec.h;
                int i4 = Util2.a;
                this.p = 0L;
                if (this.m == this.c) {
                    ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                    ContentMetadataMutations.a(contentMetadataMutations, this.o);
                    this.a.c(str, contentMetadataMutations);
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

    public final void t(DataSpec dataSpec, boolean z2) throws IOException {
        CacheSpan cacheSpanF;
        DataSpec dataSpecA;
        DataSource3 dataSource3;
        String str = dataSpec.h;
        int i = Util2.a;
        if (this.f927s) {
            cacheSpanF = null;
        } else if (this.g) {
            try {
                cacheSpanF = this.a.f(str, this.o, this.p);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpanF = this.a.e(str, this.o, this.p);
        }
        if (cacheSpanF == null) {
            dataSource3 = this.d;
            DataSpec.b bVarA = dataSpec.a();
            bVarA.f = this.o;
            bVarA.g = this.p;
            dataSpecA = bVarA.a();
        } else if (cacheSpanF.m) {
            Uri uriFromFile = Uri.fromFile(cacheSpanF.n);
            long j = cacheSpanF.k;
            long j2 = this.o - j;
            long jMin = cacheSpanF.l - j2;
            long j3 = this.p;
            if (j3 != -1) {
                jMin = Math.min(jMin, j3);
            }
            DataSpec.b bVarA2 = dataSpec.a();
            bVarA2.a = uriFromFile;
            bVarA2.f943b = j;
            bVarA2.f = j2;
            bVarA2.g = jMin;
            dataSpecA = bVarA2.a();
            dataSource3 = this.f926b;
        } else {
            long jMin2 = cacheSpanF.l;
            if (jMin2 == -1) {
                jMin2 = this.p;
            } else {
                long j4 = this.p;
                if (j4 != -1) {
                    jMin2 = Math.min(jMin2, j4);
                }
            }
            DataSpec.b bVarA3 = dataSpec.a();
            bVarA3.f = this.o;
            bVarA3.g = jMin2;
            dataSpecA = bVarA3.a();
            dataSource3 = this.c;
            if (dataSource3 == null) {
                dataSource3 = this.d;
                this.a.i(cacheSpanF);
                cacheSpanF = null;
            }
        }
        this.u = (this.f927s || dataSource3 != this.d) ? RecyclerView.FOREVER_NS : this.o + 102400;
        if (z2) {
            AnimatableValueParser.D(this.m == this.d);
            if (dataSource3 == this.d) {
                return;
            }
            try {
                p();
            } catch (Throwable th) {
                if (!(!cacheSpanF.m)) {
                    throw th;
                }
                this.a.i(cacheSpanF);
                throw th;
            }
        }
        if (cacheSpanF != null && (!cacheSpanF.m)) {
            this.q = cacheSpanF;
        }
        this.m = dataSource3;
        this.l = dataSpecA;
        this.n = 0L;
        long jA = dataSource3.a(dataSpecA);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (dataSpecA.g == -1 && jA != -1) {
            this.p = jA;
            ContentMetadataMutations.a(contentMetadataMutations, this.o + jA);
        }
        if (s()) {
            Uri uriN = dataSource3.n();
            this.j = uriN;
            Uri uri = dataSpec.a.equals(uriN) ^ true ? this.j : null;
            if (uri == null) {
                contentMetadataMutations.f935b.add("exo_redir");
                contentMetadataMutations.a.remove("exo_redir");
            } else {
                String string = uri.toString();
                Map<String, Object> map = contentMetadataMutations.a;
                Objects.requireNonNull(string);
                map.put("exo_redir", string);
                contentMetadataMutations.f935b.remove("exo_redir");
            }
        }
        if (this.m == this.c) {
            this.a.c(str, contentMetadataMutations);
        }
    }
}
