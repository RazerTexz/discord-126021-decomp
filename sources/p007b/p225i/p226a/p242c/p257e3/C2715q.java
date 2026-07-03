package p007b.p225i.p226a.p242c.p257e3;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p257e3.C2716r;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.e3.q */
/* JADX INFO: compiled from: DefaultDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2715q implements InterfaceC2710l {

    /* JADX INFO: renamed from: a */
    public final Context f6594a;

    /* JADX INFO: renamed from: b */
    public final List<InterfaceC2680a0> f6595b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2710l f6596c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public InterfaceC2710l f6597d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public InterfaceC2710l f6598e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public InterfaceC2710l f6599f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public InterfaceC2710l f6600g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public InterfaceC2710l f6601h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public InterfaceC2710l f6602i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public InterfaceC2710l f6603j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public InterfaceC2710l f6604k;

    /* JADX INFO: renamed from: b.i.a.c.e3.q$a */
    /* JADX INFO: compiled from: DefaultDataSource.java */
    public static final class a implements InterfaceC2710l.a {

        /* JADX INFO: renamed from: a */
        public final Context f6605a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC2710l.a f6606b;

        public a(Context context) {
            C2716r.b bVar = new C2716r.b();
            this.f6605a = context.getApplicationContext();
            this.f6606b = bVar;
        }

        @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C2715q mo234a() {
            return new C2715q(this.f6605a, this.f6606b.mo234a());
        }
    }

    public C2715q(Context context, InterfaceC2710l interfaceC2710l) {
        this.f6594a = context.getApplicationContext();
        Objects.requireNonNull(interfaceC2710l);
        this.f6596c = interfaceC2710l;
        this.f6595b = new ArrayList();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(C2712n c2712n) throws IOException {
        boolean z2 = true;
        C1460d.m426D(this.f6604k == null);
        String scheme = c2712n.f6542a.getScheme();
        Uri uri = c2712n.f6542a;
        int i = C2738e0.f6708a;
        String scheme2 = uri.getScheme();
        if (!TextUtils.isEmpty(scheme2) && !"file".equals(scheme2)) {
            z2 = false;
        }
        if (z2) {
            String path = c2712n.f6542a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f6597d == null) {
                    FileDataSource fileDataSource = new FileDataSource();
                    this.f6597d = fileDataSource;
                    m2864p(fileDataSource);
                }
                this.f6604k = this.f6597d;
            } else {
                if (this.f6598e == null) {
                    AssetDataSource assetDataSource = new AssetDataSource(this.f6594a);
                    this.f6598e = assetDataSource;
                    m2864p(assetDataSource);
                }
                this.f6604k = this.f6598e;
            }
        } else if (ModelAuditLogEntry.CHANGE_KEY_ASSET.equals(scheme)) {
            if (this.f6598e == null) {
                AssetDataSource assetDataSource2 = new AssetDataSource(this.f6594a);
                this.f6598e = assetDataSource2;
                m2864p(assetDataSource2);
            }
            this.f6604k = this.f6598e;
        } else if ("content".equals(scheme)) {
            if (this.f6599f == null) {
                ContentDataSource contentDataSource = new ContentDataSource(this.f6594a);
                this.f6599f = contentDataSource;
                m2864p(contentDataSource);
            }
            this.f6604k = this.f6599f;
        } else if ("rtmp".equals(scheme)) {
            if (this.f6600g == null) {
                try {
                    InterfaceC2710l interfaceC2710l = (InterfaceC2710l) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.f6600g = interfaceC2710l;
                    m2864p(interfaceC2710l);
                } catch (ClassNotFoundException unused) {
                    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.f6600g == null) {
                    this.f6600g = this.f6596c;
                }
            }
            this.f6604k = this.f6600g;
        } else if ("udp".equals(scheme)) {
            if (this.f6601h == null) {
                UdpDataSource udpDataSource = new UdpDataSource();
                this.f6601h = udpDataSource;
                m2864p(udpDataSource);
            }
            this.f6604k = this.f6601h;
        } else if ("data".equals(scheme)) {
            if (this.f6602i == null) {
                C2707i c2707i = new C2707i();
                this.f6602i = c2707i;
                m2864p(c2707i);
            }
            this.f6604k = this.f6602i;
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            if (this.f6603j == null) {
                RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f6594a);
                this.f6603j = rawResourceDataSource;
                m2864p(rawResourceDataSource);
            }
            this.f6604k = this.f6603j;
        } else {
            this.f6604k = this.f6596c;
        }
        return this.f6604k.mo2586a(c2712n);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    public void close() throws IOException {
        InterfaceC2710l interfaceC2710l = this.f6604k;
        if (interfaceC2710l != null) {
            try {
                interfaceC2710l.close();
            } finally {
                this.f6604k = null;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: d */
    public void mo2587d(InterfaceC2680a0 interfaceC2680a0) {
        Objects.requireNonNull(interfaceC2680a0);
        this.f6596c.mo2587d(interfaceC2680a0);
        this.f6595b.add(interfaceC2680a0);
        InterfaceC2710l interfaceC2710l = this.f6597d;
        if (interfaceC2710l != null) {
            interfaceC2710l.mo2587d(interfaceC2680a0);
        }
        InterfaceC2710l interfaceC2710l2 = this.f6598e;
        if (interfaceC2710l2 != null) {
            interfaceC2710l2.mo2587d(interfaceC2680a0);
        }
        InterfaceC2710l interfaceC2710l3 = this.f6599f;
        if (interfaceC2710l3 != null) {
            interfaceC2710l3.mo2587d(interfaceC2680a0);
        }
        InterfaceC2710l interfaceC2710l4 = this.f6600g;
        if (interfaceC2710l4 != null) {
            interfaceC2710l4.mo2587d(interfaceC2680a0);
        }
        InterfaceC2710l interfaceC2710l5 = this.f6601h;
        if (interfaceC2710l5 != null) {
            interfaceC2710l5.mo2587d(interfaceC2680a0);
        }
        InterfaceC2710l interfaceC2710l6 = this.f6602i;
        if (interfaceC2710l6 != null) {
            interfaceC2710l6.mo2587d(interfaceC2680a0);
        }
        InterfaceC2710l interfaceC2710l7 = this.f6603j;
        if (interfaceC2710l7 != null) {
            interfaceC2710l7.mo2587d(interfaceC2680a0);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: j */
    public Map<String, List<String>> mo2588j() {
        InterfaceC2710l interfaceC2710l = this.f6604k;
        return interfaceC2710l == null ? Collections.emptyMap() : interfaceC2710l.mo2588j();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        InterfaceC2710l interfaceC2710l = this.f6604k;
        if (interfaceC2710l == null) {
            return null;
        }
        return interfaceC2710l.mo2589n();
    }

    /* JADX INFO: renamed from: p */
    public final void m2864p(InterfaceC2710l interfaceC2710l) {
        for (int i = 0; i < this.f6595b.size(); i++) {
            interfaceC2710l.mo2587d(this.f6595b.get(i));
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterfaceC2710l interfaceC2710l = this.f6604k;
        Objects.requireNonNull(interfaceC2710l);
        return interfaceC2710l.read(bArr, i, i2);
    }
}
