package com.google.android.exoplayer2.upstream.cache;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p257e3.C2712n;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2708j;
import p007b.p225i.p226a.p242c.p257e3.p258b0.C2697p;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheDataSink implements InterfaceC2708j {

    /* JADX INFO: renamed from: a */
    public final Cache f20263a;

    /* JADX INFO: renamed from: b */
    public final long f20264b;

    /* JADX INFO: renamed from: c */
    public final int f20265c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public C2712n f20266d;

    /* JADX INFO: renamed from: e */
    public long f20267e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public File f20268f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public OutputStream f20269g;

    /* JADX INFO: renamed from: h */
    public long f20270h;

    /* JADX INFO: renamed from: i */
    public long f20271i;

    /* JADX INFO: renamed from: j */
    public C2697p f20272j;

    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    public CacheDataSink(Cache cache, long j) {
        C1460d.m429E(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < Permission.SPEAK) {
            Log.w("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        Objects.requireNonNull(cache);
        this.f20263a = cache;
        this.f20264b = j == -1 ? RecyclerView.FOREVER_NS : j;
        this.f20265c = 20480;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2708j
    /* JADX INFO: renamed from: a */
    public void mo2852a(C2712n c2712n) throws CacheDataSinkException {
        Objects.requireNonNull(c2712n.f6549h);
        if (c2712n.f6548g == -1 && c2712n.m2856c(2)) {
            this.f20266d = null;
            return;
        }
        this.f20266d = c2712n;
        this.f20267e = c2712n.m2856c(4) ? this.f20264b : RecyclerView.FOREVER_NS;
        this.f20271i = 0L;
        try {
            m8944c(c2712n);
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m8943b() throws IOException {
        OutputStream outputStream = this.f20269g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            OutputStream outputStream2 = this.f20269g;
            int i = C2738e0.f6708a;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException unused) {
                }
            }
            this.f20269g = null;
            File file = this.f20268f;
            this.f20268f = null;
            this.f20263a.mo2832g(file, this.f20270h);
        } catch (Throwable th) {
            OutputStream outputStream3 = this.f20269g;
            int i2 = C2738e0.f6708a;
            if (outputStream3 != null) {
                try {
                    outputStream3.close();
                } catch (IOException unused2) {
                }
            }
            this.f20269g = null;
            File file2 = this.f20268f;
            this.f20268f = null;
            file2.delete();
            throw th;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m8944c(C2712n c2712n) throws IOException {
        long j = c2712n.f6548g;
        long jMin = j != -1 ? Math.min(j - this.f20271i, this.f20267e) : -1L;
        Cache cache = this.f20263a;
        String str = c2712n.f6549h;
        int i = C2738e0.f6708a;
        this.f20268f = cache.mo2826a(str, c2712n.f6547f + this.f20271i, jMin);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f20268f);
        if (this.f20265c > 0) {
            C2697p c2697p = this.f20272j;
            if (c2697p == null) {
                this.f20272j = new C2697p(fileOutputStream, this.f20265c);
            } else {
                c2697p.m2822a(fileOutputStream);
            }
            this.f20269g = this.f20272j;
        } else {
            this.f20269g = fileOutputStream;
        }
        this.f20270h = 0L;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2708j
    public void close() throws CacheDataSinkException {
        if (this.f20266d == null) {
            return;
        }
        try {
            m8943b();
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2708j
    public void write(byte[] bArr, int i, int i2) throws CacheDataSinkException {
        C2712n c2712n = this.f20266d;
        if (c2712n == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.f20270h == this.f20267e) {
                    m8943b();
                    m8944c(c2712n);
                }
                int iMin = (int) Math.min(i2 - i3, this.f20267e - this.f20270h);
                OutputStream outputStream = this.f20269g;
                int i4 = C2738e0.f6708a;
                outputStream.write(bArr, i + i3, iMin);
                i3 += iMin;
                long j = iMin;
                this.f20270h += j;
                this.f20271i += j;
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }
}
