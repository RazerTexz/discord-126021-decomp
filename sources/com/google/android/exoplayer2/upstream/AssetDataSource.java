package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import b.i.a.c.e3.BaseDataSource;
import b.i.a.c.e3.DataSpec;
import b.i.a.c.f3.Util2;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class AssetDataSource extends BaseDataSource {
    public final AssetManager e;

    @Nullable
    public Uri f;

    @Nullable
    public InputStream g;
    public long h;
    public boolean i;

    public static final class AssetDataSourceException extends DataSourceException {
        public AssetDataSourceException(@Nullable Throwable th, int i) {
            super(th, i);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.e = context.getAssets();
    }

    @Override // b.i.a.c.e3.DataSource3
    public long a(DataSpec dataSpec) throws AssetDataSourceException {
        try {
            Uri uri = dataSpec.a;
            this.f = uri;
            String path = uri.getPath();
            Objects.requireNonNull(path);
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) {
                path = path.substring(1);
            }
            r(dataSpec);
            InputStream inputStreamOpen = this.e.open(path, 1);
            this.g = inputStreamOpen;
            if (inputStreamOpen.skip(dataSpec.f) < dataSpec.f) {
                throw new AssetDataSourceException(null, 2008);
            }
            long j = dataSpec.g;
            if (j != -1) {
                this.h = j;
            } else {
                long jAvailable = this.g.available();
                this.h = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.h = -1L;
                }
            }
            this.i = true;
            s(dataSpec);
            return this.h;
        } catch (AssetDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0017 */
    @Override // b.i.a.c.e3.DataSource3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws AssetDataSourceException {
        this.f = null;
        try {
            InputStream inputStream = this.g;
            if (inputStream != null) {
                inputStream.close();
            }
            this.g = null;
            if (this.i) {
                this.i = false;
                q();
            }
        } catch (IOException e) {
            throw new AssetDataSourceException(e, 2000);
        }
    }

    @Override // b.i.a.c.e3.DataSource3
    @Nullable
    public Uri n() {
        return this.f;
    }

    @Override // b.i.a.c.e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws AssetDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.h;
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
        InputStream inputStream = this.g;
        int i3 = Util2.a;
        int i4 = inputStream.read(bArr, i, i2);
        if (i4 == -1) {
            return -1;
        }
        long j2 = this.h;
        if (j2 != -1) {
            this.h = j2 - ((long) i4);
        }
        p(i4);
        return i4;
    }
}
