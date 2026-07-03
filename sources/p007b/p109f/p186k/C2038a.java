package p007b.p109f.p186k;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.util.Pools;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.k.a */
/* JADX INFO: compiled from: BitmapUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2038a {

    /* JADX INFO: renamed from: a */
    public static final Pools.SynchronizedPool<ByteBuffer> f4275a = new Pools.SynchronizedPool<>(12);

    /* JADX INFO: renamed from: b.f.k.a$a */
    /* JADX INFO: compiled from: BitmapUtil.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f4276a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f4276a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4276a[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4276a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4276a[Bitmap.Config.RGB_565.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4276a[Bitmap.Config.RGBA_F16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4276a[Bitmap.Config.HARDWARE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static C2039b m1538a(InputStream inputStream) {
        Objects.requireNonNull(inputStream);
        ByteBuffer byteBufferAcquire = f4275a.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = ByteBuffer.allocate(16384);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = byteBufferAcquire.array();
            BitmapFactory.decodeStream(inputStream, null, options);
            return new C2039b(options.outWidth, options.outHeight, Build.VERSION.SDK_INT >= 26 ? options.outColorSpace : null);
        } finally {
            f4275a.release(byteBufferAcquire);
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m1539b(Bitmap.Config config) {
        switch (a.f4276a[config.ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
                return 8;
            case 6:
                return 4;
            default:
                throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
        }
    }

    /* JADX INFO: renamed from: c */
    public static int m1540c(int i, int i2, Bitmap.Config config) {
        return m1539b(config) * i * i2;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: d */
    public static int m1541d(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getByteCount();
        }
    }
}
