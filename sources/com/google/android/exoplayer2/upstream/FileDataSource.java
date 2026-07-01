package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.PointerIconCompat;
import b.i.a.c.e3.BaseDataSource;
import b.i.a.c.e3.DataSpec;
import b.i.a.c.f3.Util2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class FileDataSource extends BaseDataSource {

    @Nullable
    public RandomAccessFile e;

    @Nullable
    public Uri f;
    public long g;
    public boolean h;

    public static class FileDataSourceException extends DataSourceException {
        public FileDataSourceException(Throwable th, int i) {
            super(th, i);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    @RequiresApi(21)
    public static final class a {
        @DoNotInline
        private static boolean b(@Nullable Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public FileDataSource() {
        super(false);
    }

    @Override // b.i.a.c.e3.DataSource3
    public long a(DataSpec dataSpec) throws FileDataSourceException {
        Uri uri = dataSpec.a;
        this.f = uri;
        r(dataSpec);
        try {
            String path = uri.getPath();
            Objects.requireNonNull(path);
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.e = randomAccessFile;
            try {
                randomAccessFile.seek(dataSpec.f);
                long length = dataSpec.g;
                if (length == -1) {
                    length = this.e.length() - dataSpec.f;
                }
                this.g = length;
                if (length < 0) {
                    throw new FileDataSourceException(null, null, 2008);
                }
                this.h = true;
                s(dataSpec);
                return this.g;
            } catch (IOException e) {
                throw new FileDataSourceException(e, 2000);
            }
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e2, (Util2.a < 21 || !a.b(e2.getCause())) ? 2005 : 2006);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e2, PointerIconCompat.TYPE_WAIT);
        } catch (SecurityException e3) {
            throw new FileDataSourceException(e3, 2006);
        } catch (RuntimeException e4) {
            throw new FileDataSourceException(e4, 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0017 */
    @Override // b.i.a.c.e3.DataSource3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws FileDataSourceException {
        this.f = null;
        try {
            RandomAccessFile randomAccessFile = this.e;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.e = null;
            if (this.h) {
                this.h = false;
                q();
            }
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }

    @Override // b.i.a.c.e3.DataSource3
    @Nullable
    public Uri n() {
        return this.f;
    }

    @Override // b.i.a.c.e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.g;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.e;
            int i3 = Util2.a;
            int i4 = randomAccessFile.read(bArr, i, (int) Math.min(j, i2));
            if (i4 > 0) {
                this.g -= (long) i4;
                p(i4);
            }
            return i4;
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }
}
