package p007b.p225i.p226a.p242c.p257e3.p258b0;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p257e3.C2712n;
import p007b.p225i.p226a.p242c.p257e3.C2724z;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2708j;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p355b.p356a.C4483c;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.c */
/* JADX INFO: compiled from: CacheDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2684c implements InterfaceC2710l {

    /* JADX INFO: renamed from: a */
    public final Cache f6438a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2710l f6439b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final InterfaceC2710l f6440c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2710l f6441d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC2688g f6442e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final a f6443f;

    /* JADX INFO: renamed from: g */
    public final boolean f6444g;

    /* JADX INFO: renamed from: h */
    public final boolean f6445h;

    /* JADX INFO: renamed from: i */
    public final boolean f6446i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public Uri f6447j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public C2712n f6448k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public C2712n f6449l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public InterfaceC2710l f6450m;

    /* JADX INFO: renamed from: n */
    public long f6451n;

    /* JADX INFO: renamed from: o */
    public long f6452o;

    /* JADX INFO: renamed from: p */
    public long f6453p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public C2689h f6454q;

    /* JADX INFO: renamed from: r */
    public boolean f6455r;

    /* JADX INFO: renamed from: s */
    public boolean f6456s;

    /* JADX INFO: renamed from: t */
    public long f6457t;

    /* JADX INFO: renamed from: u */
    public long f6458u;

    /* JADX INFO: renamed from: b.i.a.c.e3.b0.c$a */
    /* JADX INFO: compiled from: CacheDataSource.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void m2783a(int i);

        /* JADX INFO: renamed from: b */
        void m2784b(long j, long j2);
    }

    public C2684c(Cache cache, @Nullable InterfaceC2710l interfaceC2710l, InterfaceC2710l interfaceC2710l2, @Nullable InterfaceC2708j interfaceC2708j, int i, @Nullable a aVar) {
        this.f6438a = cache;
        this.f6439b = interfaceC2710l2;
        int i2 = InterfaceC2688g.f6464a;
        this.f6442e = C2682a.f6436b;
        this.f6444g = (i & 1) != 0;
        this.f6445h = (i & 2) != 0;
        this.f6446i = (i & 4) != 0;
        this.f6441d = interfaceC2710l;
        this.f6440c = new C2724z(interfaceC2710l, interfaceC2708j);
        this.f6443f = null;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(C2712n c2712n) throws IOException {
        int i;
        a aVar;
        try {
            Objects.requireNonNull((C2682a) this.f6442e);
            String string = c2712n.f6549h;
            if (string == null) {
                string = c2712n.f6542a.toString();
            }
            C2712n.b bVarM2855a = c2712n.m2855a();
            bVarM2855a.f6559h = string;
            C2712n c2712nM2857a = bVarM2855a.m2857a();
            this.f6448k = c2712nM2857a;
            Cache cache = this.f6438a;
            Uri uri = c2712nM2857a.f6542a;
            byte[] bArr = ((C2695n) cache.mo2827b(string)).f6500c.get("exo_redir");
            Uri uri2 = null;
            String str = bArr != null ? new String(bArr, C4483c.f11945c) : null;
            if (str != null) {
                uri2 = Uri.parse(str);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.f6447j = uri;
            this.f6452o = c2712n.f6547f;
            boolean z2 = true;
            if (this.f6445h && this.f6455r) {
                i = 0;
            } else {
                i = (this.f6446i && c2712n.f6548g == -1) ? 1 : -1;
            }
            if (i == -1) {
                z2 = false;
            }
            this.f6456s = z2;
            if (z2 && (aVar = this.f6443f) != null) {
                aVar.m2783a(i);
            }
            if (this.f6456s) {
                this.f6453p = -1L;
            } else {
                long jM2814a = C2692k.m2814a(this.f6438a.mo2827b(string));
                this.f6453p = jM2814a;
                if (jM2814a != -1) {
                    long j = jM2814a - c2712n.f6547f;
                    this.f6453p = j;
                    if (j < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = c2712n.f6548g;
            if (jMin != -1) {
                long j2 = this.f6453p;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.f6453p = jMin;
            }
            long j3 = this.f6453p;
            if (j3 > 0 || j3 == -1) {
                m2782t(c2712nM2857a, false);
            }
            long j4 = c2712n.f6548g;
            return j4 != -1 ? j4 : this.f6453p;
        } catch (Throwable th) {
            m2779q(th);
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    public void close() throws IOException {
        this.f6448k = null;
        this.f6447j = null;
        this.f6452o = 0L;
        a aVar = this.f6443f;
        if (aVar != null && this.f6457t > 0) {
            aVar.m2784b(this.f6438a.mo2833h(), this.f6457t);
            this.f6457t = 0L;
        }
        try {
            m2778p();
        } catch (Throwable th) {
            m2779q(th);
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: d */
    public void mo2587d(InterfaceC2680a0 interfaceC2680a0) {
        Objects.requireNonNull(interfaceC2680a0);
        this.f6439b.mo2587d(interfaceC2680a0);
        this.f6441d.mo2587d(interfaceC2680a0);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: j */
    public Map<String, List<String>> mo2588j() {
        return m2781s() ? this.f6441d.mo2588j() : Collections.emptyMap();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        return this.f6447j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: p */
    public final void m2778p() throws IOException {
        InterfaceC2710l interfaceC2710l = this.f6450m;
        if (interfaceC2710l == null) {
            return;
        }
        try {
            interfaceC2710l.close();
        } finally {
            this.f6449l = null;
            this.f6450m = null;
            C2689h c2689h = this.f6454q;
            if (c2689h != null) {
                this.f6438a.mo2834i(c2689h);
                this.f6454q = null;
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m2779q(Throwable th) {
        if (m2780r() || (th instanceof Cache.CacheException)) {
            this.f6455r = true;
        }
    }

    /* JADX INFO: renamed from: r */
    public final boolean m2780r() {
        return this.f6450m == this.f6439b;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x008a A[Catch: all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:9:0x001b, B:11:0x0024, B:12:0x0027, B:14:0x0038, B:16:0x003e, B:17:0x0044, B:19:0x0055, B:20:0x0059, B:22:0x005f, B:24:0x0065, B:26:0x006b, B:30:0x007a, B:31:0x008a, B:37:0x0098), top: B:42:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0090  */
    /* JADX WARN: Code duplicated, block: B:35:0x0096  */
    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j;
        if (i2 == 0) {
            return 0;
        }
        if (this.f6453p == 0) {
            return -1;
        }
        C2712n c2712n = this.f6448k;
        Objects.requireNonNull(c2712n);
        C2712n c2712n2 = this.f6449l;
        Objects.requireNonNull(c2712n2);
        try {
            if (this.f6452o >= this.f6458u) {
                m2782t(c2712n, true);
            }
            InterfaceC2710l interfaceC2710l = this.f6450m;
            Objects.requireNonNull(interfaceC2710l);
            int i3 = interfaceC2710l.read(bArr, i, i2);
            if (i3 != -1) {
                if (m2780r()) {
                    this.f6457t += (long) i3;
                }
                long j2 = i3;
                this.f6452o += j2;
                this.f6451n += j2;
                long j3 = this.f6453p;
                if (j3 != -1) {
                    this.f6453p = j3 - j2;
                }
            } else {
                if (!m2781s()) {
                    j = this.f6453p;
                    if (j <= 0) {
                        if (j == -1) {
                        }
                    }
                    m2778p();
                    m2782t(c2712n, false);
                    return read(bArr, i, i2);
                }
                long j4 = c2712n2.f6548g;
                if (j4 != -1 && this.f6451n >= j4) {
                    j = this.f6453p;
                    if (j <= 0) {
                        if (j == -1) {
                        }
                    }
                    m2778p();
                    m2782t(c2712n, false);
                    return read(bArr, i, i2);
                }
                String str = c2712n.f6549h;
                int i4 = C2738e0.f6708a;
                this.f6453p = 0L;
                if (this.f6450m == this.f6440c) {
                    C2694m c2694m = new C2694m();
                    C2694m.m2815a(c2694m, this.f6452o);
                    this.f6438a.mo2828c(str, c2694m);
                }
            }
            return i3;
        } catch (Throwable th) {
            m2779q(th);
            throw th;
        }
    }

    /* JADX INFO: renamed from: s */
    public final boolean m2781s() {
        return !m2780r();
    }

    /* JADX INFO: renamed from: t */
    public final void m2782t(C2712n c2712n, boolean z2) throws IOException {
        C2689h c2689hMo2831f;
        C2712n c2712nM2857a;
        InterfaceC2710l interfaceC2710l;
        String str = c2712n.f6549h;
        int i = C2738e0.f6708a;
        if (this.f6456s) {
            c2689hMo2831f = null;
        } else if (this.f6444g) {
            try {
                c2689hMo2831f = this.f6438a.mo2831f(str, this.f6452o, this.f6453p);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            c2689hMo2831f = this.f6438a.mo2830e(str, this.f6452o, this.f6453p);
        }
        if (c2689hMo2831f == null) {
            interfaceC2710l = this.f6441d;
            C2712n.b bVarM2855a = c2712n.m2855a();
            bVarM2855a.f6557f = this.f6452o;
            bVarM2855a.f6558g = this.f6453p;
            c2712nM2857a = bVarM2855a.m2857a();
        } else if (c2689hMo2831f.f6468m) {
            Uri uriFromFile = Uri.fromFile(c2689hMo2831f.f6469n);
            long j = c2689hMo2831f.f6466k;
            long j2 = this.f6452o - j;
            long jMin = c2689hMo2831f.f6467l - j2;
            long j3 = this.f6453p;
            if (j3 != -1) {
                jMin = Math.min(jMin, j3);
            }
            C2712n.b bVarM2855a2 = c2712n.m2855a();
            bVarM2855a2.f6552a = uriFromFile;
            bVarM2855a2.f6553b = j;
            bVarM2855a2.f6557f = j2;
            bVarM2855a2.f6558g = jMin;
            c2712nM2857a = bVarM2855a2.m2857a();
            interfaceC2710l = this.f6439b;
        } else {
            long jMin2 = c2689hMo2831f.f6467l;
            if (jMin2 == -1) {
                jMin2 = this.f6453p;
            } else {
                long j4 = this.f6453p;
                if (j4 != -1) {
                    jMin2 = Math.min(jMin2, j4);
                }
            }
            C2712n.b bVarM2855a3 = c2712n.m2855a();
            bVarM2855a3.f6557f = this.f6452o;
            bVarM2855a3.f6558g = jMin2;
            c2712nM2857a = bVarM2855a3.m2857a();
            interfaceC2710l = this.f6440c;
            if (interfaceC2710l == null) {
                interfaceC2710l = this.f6441d;
                this.f6438a.mo2834i(c2689hMo2831f);
                c2689hMo2831f = null;
            }
        }
        this.f6458u = (this.f6456s || interfaceC2710l != this.f6441d) ? RecyclerView.FOREVER_NS : this.f6452o + 102400;
        if (z2) {
            C1460d.m426D(this.f6450m == this.f6441d);
            if (interfaceC2710l == this.f6441d) {
                return;
            }
            try {
                m2778p();
            } catch (Throwable th) {
                if (!(!c2689hMo2831f.f6468m)) {
                    throw th;
                }
                this.f6438a.mo2834i(c2689hMo2831f);
                throw th;
            }
        }
        if (c2689hMo2831f != null && (!c2689hMo2831f.f6468m)) {
            this.f6454q = c2689hMo2831f;
        }
        this.f6450m = interfaceC2710l;
        this.f6449l = c2712nM2857a;
        this.f6451n = 0L;
        long jMo2586a = interfaceC2710l.mo2586a(c2712nM2857a);
        C2694m c2694m = new C2694m();
        if (c2712nM2857a.f6548g == -1 && jMo2586a != -1) {
            this.f6453p = jMo2586a;
            C2694m.m2815a(c2694m, this.f6452o + jMo2586a);
        }
        if (m2781s()) {
            Uri uriMo2589n = interfaceC2710l.mo2589n();
            this.f6447j = uriMo2589n;
            Uri uri = c2712n.f6542a.equals(uriMo2589n) ^ true ? this.f6447j : null;
            if (uri == null) {
                c2694m.f6497b.add("exo_redir");
                c2694m.f6496a.remove("exo_redir");
            } else {
                String string = uri.toString();
                Map<String, Object> map = c2694m.f6496a;
                Objects.requireNonNull(string);
                map.put("exo_redir", string);
                c2694m.f6497b.remove("exo_redir");
            }
        }
        if (this.f6450m == this.f6440c) {
            this.f6438a.mo2828c(str, c2694m);
        }
    }
}
