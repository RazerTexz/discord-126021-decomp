package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p257e3.AbstractC2705g;
import p007b.p225i.p226a.p242c.p257e3.C2712n;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class AssetDataSource extends AbstractC2705g {

    /* JADX INFO: renamed from: e */
    public final AssetManager f20213e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public Uri f20214f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public InputStream f20215g;

    /* JADX INFO: renamed from: h */
    public long f20216h;

    /* JADX INFO: renamed from: i */
    public boolean f20217i;

    public static final class AssetDataSourceException extends DataSourceException {
        public AssetDataSourceException(@Nullable Throwable th, int i) {
            super(th, i);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f20213e = context.getAssets();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(C2712n c2712n) throws AssetDataSourceException {
        try {
            Uri uri = c2712n.f6542a;
            this.f20214f = uri;
            String path = uri.getPath();
            Objects.requireNonNull(path);
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) {
                path = path.substring(1);
            }
            m2850r(c2712n);
            InputStream inputStreamOpen = this.f20213e.open(path, 1);
            this.f20215g = inputStreamOpen;
            if (inputStreamOpen.skip(c2712n.f6547f) < c2712n.f6547f) {
                throw new AssetDataSourceException(null, 2008);
            }
            long j = c2712n.f6548g;
            if (j != -1) {
                this.f20216h = j;
            } else {
                long jAvailable = this.f20215g.available();
                this.f20216h = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f20216h = -1L;
                }
            }
            this.f20217i = true;
            m2851s(c2712n);
            return this.f20216h;
        } catch (AssetDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0017 */
    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws AssetDataSourceException {
        this.f20214f = null;
        try {
            InputStream inputStream = this.f20215g;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f20215g = null;
            if (this.f20217i) {
                this.f20217i = false;
                m2849q();
            }
        } catch (IOException e) {
            throw new AssetDataSourceException(e, 2000);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        return this.f20214f;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws AssetDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f20216h;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new AssetDataSourceException(e, 2000);
            }
        }
        InputStream inputStream = this.f20215g;
        int i3 = C2738e0.f6708a;
        int i4 = inputStream.read(bArr, i, i2);
        if (i4 == -1) {
            return -1;
        }
        long j2 = this.f20216h;
        if (j2 != -1) {
            this.f20216h = j2 - ((long) i4);
        }
        m2848p(i4);
        return i4;
    }
}
