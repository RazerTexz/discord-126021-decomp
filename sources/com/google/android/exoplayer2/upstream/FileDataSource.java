package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import b.i.a.c.e3.g;
import b.i.a.c.e3.n;
import b.i.a.c.f3.e0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class FileDataSource extends g {

    @Nullable
    public RandomAccessFile e;

    @Nullable
    public Uri f;
    public long g;
    public boolean h;

    public FileDataSource() {
        super(false);
    }

    @Override // b.i.a.c.e3.l
    public long a(n nVar) throws FileDataSource$FileDataSourceException {
        Uri uri = nVar.a;
        this.f = uri;
        r(nVar);
        try {
            String path = uri.getPath();
            Objects.requireNonNull(path);
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.e = randomAccessFile;
            try {
                randomAccessFile.seek(nVar.f);
                long length = nVar.g;
                if (length == -1) {
                    length = this.e.length() - nVar.f;
                }
                this.g = length;
                if (length < 0) {
                    throw new FileDataSource$FileDataSourceException(null, null, 2008);
                }
                this.h = true;
                s(nVar);
                return this.g;
            } catch (IOException e) {
                throw new FileDataSource$FileDataSourceException(e, 2000);
            }
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSource$FileDataSourceException(e2, (e0.a < 21 || !FileDataSource$a.a(e2.getCause())) ? 2005 : 2006);
            }
            throw new FileDataSource$FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e2, PointerIconCompat.TYPE_WAIT);
        } catch (SecurityException e3) {
            throw new FileDataSource$FileDataSourceException(e3, 2006);
        } catch (RuntimeException e4) {
            throw new FileDataSource$FileDataSourceException(e4, 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0017 */
    @Override // b.i.a.c.e3.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws FileDataSource$FileDataSourceException {
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
            throw new FileDataSource$FileDataSourceException(e, 2000);
        }
    }

    @Override // b.i.a.c.e3.l
    @Nullable
    public Uri n() {
        return this.f;
    }

    @Override // b.i.a.c.e3.h
    public int read(byte[] bArr, int i, int i2) throws FileDataSource$FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.g;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.e;
            int i3 = e0.a;
            int i4 = randomAccessFile.read(bArr, i, (int) Math.min(j, i2));
            if (i4 > 0) {
                this.g -= (long) i4;
                p(i4);
            }
            return i4;
        } catch (IOException e) {
            throw new FileDataSource$FileDataSourceException(e, 2000);
        }
    }
}
