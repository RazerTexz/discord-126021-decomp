package b.i.a.c.e3;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
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

/* JADX INFO: compiled from: DefaultDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements l {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a0> f948b;
    public final l c;

    @Nullable
    public l d;

    @Nullable
    public l e;

    @Nullable
    public l f;

    @Nullable
    public l g;

    @Nullable
    public l h;

    @Nullable
    public l i;

    @Nullable
    public l j;

    @Nullable
    public l k;

    public q(Context context, l lVar) {
        this.a = context.getApplicationContext();
        Objects.requireNonNull(lVar);
        this.c = lVar;
        this.f948b = new ArrayList();
    }

    @Override // b.i.a.c.e3.l
    public long a(n nVar) throws IOException {
        boolean z2 = true;
        b.c.a.a0.d.D(this.k == null);
        String scheme = nVar.a.getScheme();
        Uri uri = nVar.a;
        int i = e0.a;
        String scheme2 = uri.getScheme();
        if (!TextUtils.isEmpty(scheme2) && !"file".equals(scheme2)) {
            z2 = false;
        }
        if (z2) {
            String path = nVar.a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.d == null) {
                    FileDataSource fileDataSource = new FileDataSource();
                    this.d = fileDataSource;
                    p(fileDataSource);
                }
                this.k = this.d;
            } else {
                if (this.e == null) {
                    AssetDataSource assetDataSource = new AssetDataSource(this.a);
                    this.e = assetDataSource;
                    p(assetDataSource);
                }
                this.k = this.e;
            }
        } else if (ModelAuditLogEntry.CHANGE_KEY_ASSET.equals(scheme)) {
            if (this.e == null) {
                AssetDataSource assetDataSource2 = new AssetDataSource(this.a);
                this.e = assetDataSource2;
                p(assetDataSource2);
            }
            this.k = this.e;
        } else if ("content".equals(scheme)) {
            if (this.f == null) {
                ContentDataSource contentDataSource = new ContentDataSource(this.a);
                this.f = contentDataSource;
                p(contentDataSource);
            }
            this.k = this.f;
        } else if ("rtmp".equals(scheme)) {
            if (this.g == null) {
                try {
                    l lVar = (l) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.g = lVar;
                    p(lVar);
                } catch (ClassNotFoundException unused) {
                    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.g == null) {
                    this.g = this.c;
                }
            }
            this.k = this.g;
        } else if ("udp".equals(scheme)) {
            if (this.h == null) {
                UdpDataSource udpDataSource = new UdpDataSource();
                this.h = udpDataSource;
                p(udpDataSource);
            }
            this.k = this.h;
        } else if ("data".equals(scheme)) {
            if (this.i == null) {
                i iVar = new i();
                this.i = iVar;
                p(iVar);
            }
            this.k = this.i;
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            if (this.j == null) {
                RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.a);
                this.j = rawResourceDataSource;
                p(rawResourceDataSource);
            }
            this.k = this.j;
        } else {
            this.k = this.c;
        }
        return this.k.a(nVar);
    }

    @Override // b.i.a.c.e3.l
    public void close() throws IOException {
        l lVar = this.k;
        if (lVar != null) {
            try {
                lVar.close();
            } finally {
                this.k = null;
            }
        }
    }

    @Override // b.i.a.c.e3.l
    public void d(a0 a0Var) {
        Objects.requireNonNull(a0Var);
        this.c.d(a0Var);
        this.f948b.add(a0Var);
        l lVar = this.d;
        if (lVar != null) {
            lVar.d(a0Var);
        }
        l lVar2 = this.e;
        if (lVar2 != null) {
            lVar2.d(a0Var);
        }
        l lVar3 = this.f;
        if (lVar3 != null) {
            lVar3.d(a0Var);
        }
        l lVar4 = this.g;
        if (lVar4 != null) {
            lVar4.d(a0Var);
        }
        l lVar5 = this.h;
        if (lVar5 != null) {
            lVar5.d(a0Var);
        }
        l lVar6 = this.i;
        if (lVar6 != null) {
            lVar6.d(a0Var);
        }
        l lVar7 = this.j;
        if (lVar7 != null) {
            lVar7.d(a0Var);
        }
    }

    @Override // b.i.a.c.e3.l
    public Map<String, List<String>> j() {
        l lVar = this.k;
        return lVar == null ? Collections.emptyMap() : lVar.j();
    }

    @Override // b.i.a.c.e3.l
    @Nullable
    public Uri n() {
        l lVar = this.k;
        if (lVar == null) {
            return null;
        }
        return lVar.n();
    }

    public final void p(l lVar) {
        for (int i = 0; i < this.f948b.size(); i++) {
            lVar.d(this.f948b.get(i));
        }
    }

    @Override // b.i.a.c.e3.h
    public int read(byte[] bArr, int i, int i2) throws IOException {
        l lVar = this.k;
        Objects.requireNonNull(lVar);
        return lVar.read(bArr, i, i2);
    }
}
