package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import b.i.a.c.e3.g;
import b.i.a.c.e3.n;
import b.i.a.c.f3.e0;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public final class ContentDataSource extends g {
    public final ContentResolver e;

    @Nullable
    public Uri f;

    @Nullable
    public AssetFileDescriptor g;

    @Nullable
    public FileInputStream h;
    public long i;
    public boolean j;

    public ContentDataSource(Context context) {
        super(false);
        this.e = context.getContentResolver();
    }

    @Override // b.i.a.c.e3.l
    public long a(n nVar) throws ContentDataSource$ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            Uri uri = nVar.a;
            this.f = uri;
            r(nVar);
            if ("content".equals(nVar.a.getScheme())) {
                Bundle bundle = new Bundle();
                if (e0.a >= 31) {
                    ContentDataSource$a.a(bundle);
                }
                assetFileDescriptorOpenAssetFileDescriptor = this.e.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.e.openAssetFileDescriptor(uri, "r");
            }
            this.g = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                String strValueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
                sb.append("Could not open file descriptor for: ");
                sb.append(strValueOf);
                throw new ContentDataSource$ContentDataSourceException(new IOException(sb.toString()), 2000);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.h = fileInputStream;
            if (length != -1 && nVar.f > length) {
                throw new ContentDataSource$ContentDataSourceException(null, 2008);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(nVar.f + startOffset) - startOffset;
            if (jSkip != nVar.f) {
                throw new ContentDataSource$ContentDataSourceException(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.i = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.i = jPosition;
                    if (jPosition < 0) {
                        throw new ContentDataSource$ContentDataSourceException(null, 2008);
                    }
                }
            } else {
                long j = length - jSkip;
                this.i = j;
                if (j < 0) {
                    throw new ContentDataSource$ContentDataSourceException(null, 2008);
                }
            }
            long jMin = nVar.g;
            if (jMin != -1) {
                long j2 = this.i;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.i = jMin;
            }
            this.j = true;
            s(nVar);
            long j3 = nVar.g;
            return j3 != -1 ? j3 : this.i;
        } catch (ContentDataSource$ContentDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            throw new ContentDataSource$ContentDataSourceException(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0037 */
    /* JADX WARN: Bottom block not found for handler: all -> 0x0055 */
    @Override // b.i.a.c.e3.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws ContentDataSource$ContentDataSourceException {
        this.f = null;
        try {
            FileInputStream fileInputStream = this.h;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.g;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.g = null;
                    if (this.j) {
                        this.j = false;
                        q();
                    }
                } catch (IOException e) {
                    throw new ContentDataSource$ContentDataSourceException(e, 2000);
                }
            } catch (Throwable th) {
                this.g = null;
                if (this.j) {
                    this.j = false;
                    q();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new ContentDataSource$ContentDataSourceException(e2, 2000);
        }
    }

    @Override // b.i.a.c.e3.l
    @Nullable
    public Uri n() {
        return this.f;
    }

    @Override // b.i.a.c.e3.h
    public int read(byte[] bArr, int i, int i2) throws ContentDataSource$ContentDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.i;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new ContentDataSource$ContentDataSourceException(e, 2000);
            }
        }
        FileInputStream fileInputStream = this.h;
        int i3 = e0.a;
        int i4 = fileInputStream.read(bArr, i, i2);
        if (i4 == -1) {
            return -1;
        }
        long j2 = this.i;
        if (j2 != -1) {
            this.i = j2 - ((long) i4);
        }
        p(i4);
        return i4;
    }
}
