package b.i.a.c.e3;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.e3.DataSource3;
import b.i.a.c.e3.DefaultHttpDataSource;
import b.i.a.c.f3.Util2;
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

/* JADX INFO: renamed from: b.i.a.c.e3.q, reason: use source file name */
/* JADX INFO: compiled from: DefaultDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDataSource implements DataSource3 {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TransferListener> f948b;
    public final DataSource3 c;

    @Nullable
    public DataSource3 d;

    @Nullable
    public DataSource3 e;

    @Nullable
    public DataSource3 f;

    @Nullable
    public DataSource3 g;

    @Nullable
    public DataSource3 h;

    @Nullable
    public DataSource3 i;

    @Nullable
    public DataSource3 j;

    @Nullable
    public DataSource3 k;

    /* JADX INFO: renamed from: b.i.a.c.e3.q$a */
    /* JADX INFO: compiled from: DefaultDataSource.java */
    public static final class a implements DataSource3.a {
        public final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DataSource3.a f949b;

        public a(Context context) {
            DefaultHttpDataSource.b bVar = new DefaultHttpDataSource.b();
            this.a = context.getApplicationContext();
            this.f949b = bVar;
        }

        @Override // b.i.a.c.e3.DataSource3.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DefaultDataSource a() {
            return new DefaultDataSource(this.a, this.f949b.a());
        }
    }

    public DefaultDataSource(Context context, DataSource3 dataSource3) {
        this.a = context.getApplicationContext();
        Objects.requireNonNull(dataSource3);
        this.c = dataSource3;
        this.f948b = new ArrayList();
    }

    @Override // b.i.a.c.e3.DataSource3
    public long a(DataSpec dataSpec) throws IOException {
        boolean z2 = true;
        AnimatableValueParser.D(this.k == null);
        String scheme = dataSpec.a.getScheme();
        Uri uri = dataSpec.a;
        int i = Util2.a;
        String scheme2 = uri.getScheme();
        if (!TextUtils.isEmpty(scheme2) && !"file".equals(scheme2)) {
            z2 = false;
        }
        if (z2) {
            String path = dataSpec.a.getPath();
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
                    DataSource3 dataSource3 = (DataSource3) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.g = dataSource3;
                    p(dataSource3);
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
                DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
                this.i = dataSchemeDataSource;
                p(dataSchemeDataSource);
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
        return this.k.a(dataSpec);
    }

    @Override // b.i.a.c.e3.DataSource3
    public void close() throws IOException {
        DataSource3 dataSource3 = this.k;
        if (dataSource3 != null) {
            try {
                dataSource3.close();
            } finally {
                this.k = null;
            }
        }
    }

    @Override // b.i.a.c.e3.DataSource3
    public void d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        this.c.d(transferListener);
        this.f948b.add(transferListener);
        DataSource3 dataSource3 = this.d;
        if (dataSource3 != null) {
            dataSource3.d(transferListener);
        }
        DataSource3 dataSource4 = this.e;
        if (dataSource4 != null) {
            dataSource4.d(transferListener);
        }
        DataSource3 dataSource5 = this.f;
        if (dataSource5 != null) {
            dataSource5.d(transferListener);
        }
        DataSource3 dataSource6 = this.g;
        if (dataSource6 != null) {
            dataSource6.d(transferListener);
        }
        DataSource3 dataSource7 = this.h;
        if (dataSource7 != null) {
            dataSource7.d(transferListener);
        }
        DataSource3 dataSource8 = this.i;
        if (dataSource8 != null) {
            dataSource8.d(transferListener);
        }
        DataSource3 dataSource9 = this.j;
        if (dataSource9 != null) {
            dataSource9.d(transferListener);
        }
    }

    @Override // b.i.a.c.e3.DataSource3
    public Map<String, List<String>> j() {
        DataSource3 dataSource3 = this.k;
        return dataSource3 == null ? Collections.emptyMap() : dataSource3.j();
    }

    @Override // b.i.a.c.e3.DataSource3
    @Nullable
    public Uri n() {
        DataSource3 dataSource3 = this.k;
        if (dataSource3 == null) {
            return null;
        }
        return dataSource3.n();
    }

    public final void p(DataSource3 dataSource3) {
        for (int i = 0; i < this.f948b.size(); i++) {
            dataSource3.d(this.f948b.get(i));
        }
    }

    @Override // b.i.a.c.e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        DataSource3 dataSource3 = this.k;
        Objects.requireNonNull(dataSource3);
        return dataSource3.read(bArr, i, i2);
    }
}
