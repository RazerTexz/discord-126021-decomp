package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import b.f.d.d.DoNotStrip;
import b.f.d.d.Throwables;
import b.f.j.j.EncodedImage2;
import b.f.j.l.BitmapCounter;
import b.f.j.l.BitmapCounterProvider;
import b.f.j.m.ImagePipelineNativeLoader;
import b.f.j.n.PlatformDecoder;
import b.f.k.BitmapUtil;
import b.f.m.DoNotOptimize;
import b.f.m.n.NativeLoader;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public abstract class DalvikPurgeableDecoder implements PlatformDecoder {
    public static final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitmapCounter f2898b;

    @DoNotOptimize
    public static class OreoUtils {
        private OreoUtils() {
        }
    }

    static {
        List<String> list = ImagePipelineNativeLoader.a;
        NativeLoader.c("imagepipeline");
        a = new byte[]{-1, ExifInterface.MARKER_EOI};
    }

    public DalvikPurgeableDecoder() {
        if (BitmapCounterProvider.c == null) {
            synchronized (BitmapCounterProvider.class) {
                if (BitmapCounterProvider.c == null) {
                    BitmapCounterProvider.c = new BitmapCounter(BitmapCounterProvider.f593b, BitmapCounterProvider.a);
                }
            }
        }
        this.f2898b = BitmapCounterProvider.c;
    }

    @VisibleForTesting
    public static boolean e(CloseableReference<PooledByteBuffer> closeableReference, int i) {
        PooledByteBuffer pooledByteBufferU = closeableReference.u();
        return i >= 2 && pooledByteBufferU.h(i + (-2)) == -1 && pooledByteBufferU.h(i - 1) == -39;
    }

    @DoNotStrip
    private static native void nativePinBitmap(Bitmap bitmap);

    @Override // b.f.j.n.PlatformDecoder
    public CloseableReference<Bitmap> a(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        int i = encodedImage2.q;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        options.inMutable = true;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        CloseableReference<PooledByteBuffer> closeableReferenceC = encodedImage2.c();
        Objects.requireNonNull(closeableReferenceC);
        try {
            return f(c(closeableReferenceC, options));
        } finally {
            closeableReferenceC.close();
        }
    }

    @Override // b.f.j.n.PlatformDecoder
    public CloseableReference<Bitmap> b(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace) {
        int i2 = encodedImage2.q;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i2;
        options.inMutable = true;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        CloseableReference<PooledByteBuffer> closeableReferenceC = encodedImage2.c();
        Objects.requireNonNull(closeableReferenceC);
        try {
            return f(d(closeableReferenceC, i, options));
        } finally {
            closeableReferenceC.close();
        }
    }

    public abstract Bitmap c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options);

    public abstract Bitmap d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options);

    public CloseableReference<Bitmap> f(Bitmap bitmap) throws Throwable {
        boolean z2;
        int i;
        long j;
        int i2;
        Objects.requireNonNull(bitmap);
        try {
            nativePinBitmap(bitmap);
            BitmapCounter bitmapCounter = this.f2898b;
            synchronized (bitmapCounter) {
                int iD = BitmapUtil.d(bitmap);
                int i3 = bitmapCounter.a;
                if (i3 < bitmapCounter.c) {
                    long j2 = bitmapCounter.f592b + ((long) iD);
                    if (j2 > bitmapCounter.d) {
                        z2 = false;
                    } else {
                        bitmapCounter.a = i3 + 1;
                        bitmapCounter.f592b = j2;
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return CloseableReference.D(bitmap, this.f2898b.e);
            }
            int iD2 = BitmapUtil.d(bitmap);
            bitmap.recycle();
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(iD2);
            BitmapCounter bitmapCounter2 = this.f2898b;
            synchronized (bitmapCounter2) {
                i = bitmapCounter2.a;
            }
            objArr[1] = Integer.valueOf(i);
            BitmapCounter bitmapCounter3 = this.f2898b;
            synchronized (bitmapCounter3) {
                j = bitmapCounter3.f592b;
            }
            objArr[2] = Long.valueOf(j);
            BitmapCounter bitmapCounter4 = this.f2898b;
            synchronized (bitmapCounter4) {
                i2 = bitmapCounter4.c;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(this.f2898b.b());
            throw new TooManyBitmapsException(String.format(locale, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", objArr));
        } catch (Exception e) {
            bitmap.recycle();
            Throwables.a(e);
            throw new RuntimeException(e);
        }
    }
}
