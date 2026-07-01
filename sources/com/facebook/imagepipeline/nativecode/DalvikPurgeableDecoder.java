package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.BitmapFactory$Options;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace$Named;
import android.graphics.Rect;
import android.os.Build$VERSION;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import b.f.d.d.c;
import b.f.d.d.m;
import b.f.j.j.e;
import b.f.j.l.b;
import b.f.j.m.a;
import b.f.j.n.d;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@c
public abstract class DalvikPurgeableDecoder implements d {
    public static final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2898b;

    static {
        List<String> list = a.a;
        b.f.m.n.a.c("imagepipeline");
        a = new byte[]{-1, ExifInterface.MARKER_EOI};
    }

    public DalvikPurgeableDecoder() {
        if (b.f.j.l.c.c == null) {
            synchronized (b.f.j.l.c.class) {
                if (b.f.j.l.c.c == null) {
                    b.f.j.l.c.c = new b(b.f.j.l.c.f593b, b.f.j.l.c.a);
                }
            }
        }
        this.f2898b = b.f.j.l.c.c;
    }

    @VisibleForTesting
    public static boolean e(CloseableReference<PooledByteBuffer> closeableReference, int i) {
        PooledByteBuffer pooledByteBufferU = closeableReference.u();
        return i >= 2 && pooledByteBufferU.h(i + (-2)) == -1 && pooledByteBufferU.h(i - 1) == -39;
    }

    @c
    private static native void nativePinBitmap(Bitmap bitmap);

    @Override // b.f.j.n.d
    public CloseableReference<Bitmap> a(e eVar, Bitmap$Config bitmap$Config, Rect rect, ColorSpace colorSpace) {
        int i = eVar.q;
        BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inDither = true;
        bitmapFactory$Options.inPreferredConfig = bitmap$Config;
        bitmapFactory$Options.inPurgeable = true;
        bitmapFactory$Options.inInputShareable = true;
        bitmapFactory$Options.inSampleSize = i;
        bitmapFactory$Options.inMutable = true;
        if (Build$VERSION.SDK_INT >= 26) {
            bitmapFactory$Options.inPreferredColorSpace = ColorSpace.get(ColorSpace$Named.SRGB);
        }
        CloseableReference<PooledByteBuffer> closeableReferenceC = eVar.c();
        Objects.requireNonNull(closeableReferenceC);
        try {
            return f(c(closeableReferenceC, bitmapFactory$Options));
        } finally {
            closeableReferenceC.close();
        }
    }

    @Override // b.f.j.n.d
    public CloseableReference<Bitmap> b(e eVar, Bitmap$Config bitmap$Config, Rect rect, int i, ColorSpace colorSpace) {
        int i2 = eVar.q;
        BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inDither = true;
        bitmapFactory$Options.inPreferredConfig = bitmap$Config;
        bitmapFactory$Options.inPurgeable = true;
        bitmapFactory$Options.inInputShareable = true;
        bitmapFactory$Options.inSampleSize = i2;
        bitmapFactory$Options.inMutable = true;
        if (Build$VERSION.SDK_INT >= 26) {
            bitmapFactory$Options.inPreferredColorSpace = ColorSpace.get(ColorSpace$Named.SRGB);
        }
        CloseableReference<PooledByteBuffer> closeableReferenceC = eVar.c();
        Objects.requireNonNull(closeableReferenceC);
        try {
            return f(d(closeableReferenceC, i, bitmapFactory$Options));
        } finally {
            closeableReferenceC.close();
        }
    }

    public abstract Bitmap c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory$Options bitmapFactory$Options);

    public abstract Bitmap d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory$Options bitmapFactory$Options);

    public CloseableReference<Bitmap> f(Bitmap bitmap) throws Throwable {
        boolean z2;
        int i;
        long j;
        int i2;
        Objects.requireNonNull(bitmap);
        try {
            nativePinBitmap(bitmap);
            b bVar = this.f2898b;
            synchronized (bVar) {
                int iD = b.f.k.a.d(bitmap);
                int i3 = bVar.a;
                if (i3 < bVar.c) {
                    long j2 = bVar.f592b + ((long) iD);
                    if (j2 > bVar.d) {
                        z2 = false;
                    } else {
                        bVar.a = i3 + 1;
                        bVar.f592b = j2;
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return CloseableReference.D(bitmap, this.f2898b.e);
            }
            int iD2 = b.f.k.a.d(bitmap);
            bitmap.recycle();
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(iD2);
            b bVar2 = this.f2898b;
            synchronized (bVar2) {
                i = bVar2.a;
            }
            objArr[1] = Integer.valueOf(i);
            b bVar3 = this.f2898b;
            synchronized (bVar3) {
                j = bVar3.f592b;
            }
            objArr[2] = Long.valueOf(j);
            b bVar4 = this.f2898b;
            synchronized (bVar4) {
                i2 = bVar4.c;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(this.f2898b.b());
            throw new TooManyBitmapsException(String.format(locale, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", objArr));
        } catch (Exception e) {
            bitmap.recycle();
            m.a(e);
            throw new RuntimeException(e);
        }
    }
}
