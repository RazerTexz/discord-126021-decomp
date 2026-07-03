package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import p007b.p109f.p115d.p119d.C1690m;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p161j.p175j.C1919e;
import p007b.p109f.p161j.p177l.C1930b;
import p007b.p109f.p161j.p177l.C1931c;
import p007b.p109f.p161j.p178m.C1955a;
import p007b.p109f.p161j.p179n.InterfaceC1960d;
import p007b.p109f.p186k.C2038a;
import p007b.p109f.p190m.InterfaceC2051d;
import p007b.p109f.p190m.p191n.C2061a;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public abstract class DalvikPurgeableDecoder implements InterfaceC1960d {

    /* JADX INFO: renamed from: a */
    public static final byte[] f19566a;

    /* JADX INFO: renamed from: b */
    public final C1930b f19567b;

    @InterfaceC2051d
    public static class OreoUtils {
        private OreoUtils() {
        }
    }

    static {
        List<String> list = C1955a.f3980a;
        C2061a.m1589c("imagepipeline");
        f19566a = new byte[]{-1, ExifInterface.MARKER_EOI};
    }

    public DalvikPurgeableDecoder() {
        if (C1931c.f3925c == null) {
            synchronized (C1931c.class) {
                if (C1931c.f3925c == null) {
                    C1931c.f3925c = new C1930b(C1931c.f3924b, C1931c.f3923a);
                }
            }
        }
        this.f19567b = C1931c.f3925c;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: e */
    public static boolean m8709e(CloseableReference<PooledByteBuffer> closeableReference, int i) {
        PooledByteBuffer pooledByteBufferM8642u = closeableReference.m8642u();
        return i >= 2 && pooledByteBufferM8642u.mo1395h(i + (-2)) == -1 && pooledByteBufferM8642u.mo1395h(i - 1) == -39;
    }

    @InterfaceC1680c
    private static native void nativePinBitmap(Bitmap bitmap);

    @Override // p007b.p109f.p161j.p179n.InterfaceC1960d
    /* JADX INFO: renamed from: a */
    public CloseableReference<Bitmap> mo1414a(C1919e c1919e, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        int i = c1919e.f3898q;
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
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c = c1919e.m1340c();
        Objects.requireNonNull(closeableReferenceM1340c);
        try {
            return m8712f(mo8710c(closeableReferenceM1340c, options));
        } finally {
            closeableReferenceM1340c.close();
        }
    }

    @Override // p007b.p109f.p161j.p179n.InterfaceC1960d
    /* JADX INFO: renamed from: b */
    public CloseableReference<Bitmap> mo1415b(C1919e c1919e, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace) {
        int i2 = c1919e.f3898q;
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
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c = c1919e.m1340c();
        Objects.requireNonNull(closeableReferenceM1340c);
        try {
            return m8712f(mo8711d(closeableReferenceM1340c, i, options));
        } finally {
            closeableReferenceM1340c.close();
        }
    }

    /* JADX INFO: renamed from: c */
    public abstract Bitmap mo8710c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options);

    /* JADX INFO: renamed from: d */
    public abstract Bitmap mo8711d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options);

    /* JADX INFO: renamed from: f */
    public CloseableReference<Bitmap> m8712f(Bitmap bitmap) throws Throwable {
        boolean z2;
        int i;
        long j;
        int i2;
        Objects.requireNonNull(bitmap);
        try {
            nativePinBitmap(bitmap);
            C1930b c1930b = this.f19567b;
            synchronized (c1930b) {
                int iM1541d = C2038a.m1541d(bitmap);
                int i3 = c1930b.f3917a;
                if (i3 < c1930b.f3919c) {
                    long j2 = c1930b.f3918b + ((long) iM1541d);
                    if (j2 > c1930b.f3920d) {
                        z2 = false;
                    } else {
                        c1930b.f3917a = i3 + 1;
                        c1930b.f3918b = j2;
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return CloseableReference.m8633D(bitmap, this.f19567b.f3921e);
            }
            int iM1541d2 = C2038a.m1541d(bitmap);
            bitmap.recycle();
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(iM1541d2);
            C1930b c1930b2 = this.f19567b;
            synchronized (c1930b2) {
                i = c1930b2.f3917a;
            }
            objArr[1] = Integer.valueOf(i);
            C1930b c1930b3 = this.f19567b;
            synchronized (c1930b3) {
                j = c1930b3.f3918b;
            }
            objArr[2] = Long.valueOf(j);
            C1930b c1930b4 = this.f19567b;
            synchronized (c1930b4) {
                i2 = c1930b4.f3919c;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(this.f19567b.m1372b());
            throw new TooManyBitmapsException(String.format(locale, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", objArr));
        } catch (Exception e) {
            bitmap.recycle();
            C1690m.m972a(e);
            throw new RuntimeException(e);
        }
    }
}
