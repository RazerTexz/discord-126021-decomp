package com.google.android.exoplayer2.upstream.cache;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.e3.DataSink;
import b.i.a.c.e3.DataSpec;
import b.i.a.c.e3.b0.ReusableBufferedOutputStream;
import b.i.a.c.f3.Util2;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheDataSink implements DataSink {
    public final Cache a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2981b;
    public final int c;

    @Nullable
    public DataSpec d;
    public long e;

    @Nullable
    public File f;

    @Nullable
    public OutputStream g;
    public long h;
    public long i;
    public ReusableBufferedOutputStream j;

    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    public CacheDataSink(Cache cache, long j) {
        AnimatableValueParser.E(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < Permission.SPEAK) {
            Log.w("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        Objects.requireNonNull(cache);
        this.a = cache;
        this.f2981b = j == -1 ? RecyclerView.FOREVER_NS : j;
        this.c = 20480;
    }

    @Override // b.i.a.c.e3.DataSink
    public void a(DataSpec dataSpec) throws CacheDataSinkException {
        Objects.requireNonNull(dataSpec.h);
        if (dataSpec.g == -1 && dataSpec.c(2)) {
            this.d = null;
            return;
        }
        this.d = dataSpec;
        this.e = dataSpec.c(4) ? this.f2981b : RecyclerView.FOREVER_NS;
        this.i = 0L;
        try {
            c(dataSpec);
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    public final void b() throws IOException {
        OutputStream outputStream = this.g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            OutputStream outputStream2 = this.g;
            int i = Util2.a;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException unused) {
                }
            }
            this.g = null;
            File file = this.f;
            this.f = null;
            this.a.g(file, this.h);
        } catch (Throwable th) {
            OutputStream outputStream3 = this.g;
            int i2 = Util2.a;
            if (outputStream3 != null) {
                try {
                    outputStream3.close();
                } catch (IOException unused2) {
                }
            }
            this.g = null;
            File file2 = this.f;
            this.f = null;
            file2.delete();
            throw th;
        }
    }

    public final void c(DataSpec dataSpec) throws IOException {
        long j = dataSpec.g;
        long jMin = j != -1 ? Math.min(j - this.i, this.e) : -1L;
        Cache cache = this.a;
        String str = dataSpec.h;
        int i = Util2.a;
        this.f = cache.a(str, dataSpec.f + this.i, jMin);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f);
        if (this.c > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.j;
            if (reusableBufferedOutputStream == null) {
                this.j = new ReusableBufferedOutputStream(fileOutputStream, this.c);
            } else {
                reusableBufferedOutputStream.a(fileOutputStream);
            }
            this.g = this.j;
        } else {
            this.g = fileOutputStream;
        }
        this.h = 0L;
    }

    @Override // b.i.a.c.e3.DataSink
    public void close() throws CacheDataSinkException {
        if (this.d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    @Override // b.i.a.c.e3.DataSink
    public void write(byte[] bArr, int i, int i2) throws CacheDataSinkException {
        DataSpec dataSpec = this.d;
        if (dataSpec == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.h == this.e) {
                    b();
                    c(dataSpec);
                }
                int iMin = (int) Math.min(i2 - i3, this.e - this.h);
                OutputStream outputStream = this.g;
                int i4 = Util2.a;
                outputStream.write(bArr, i + i3, iMin);
                i3 += iMin;
                long j = iMin;
                this.h += j;
                this.i += j;
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }
}
