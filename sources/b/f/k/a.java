package b.f.k;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.os.Build$VERSION;
import androidx.core.util.Pools$SynchronizedPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: BitmapUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final Pools$SynchronizedPool<ByteBuffer> a = new Pools$SynchronizedPool<>(12);

    public static b a(InputStream inputStream) {
        Objects.requireNonNull(inputStream);
        ByteBuffer byteBufferAcquire = a.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = ByteBuffer.allocate(16384);
        }
        BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inJustDecodeBounds = true;
        try {
            bitmapFactory$Options.inTempStorage = byteBufferAcquire.array();
            BitmapFactory.decodeStream(inputStream, null, bitmapFactory$Options);
            return new b(bitmapFactory$Options.outWidth, bitmapFactory$Options.outHeight, Build$VERSION.SDK_INT >= 26 ? bitmapFactory$Options.outColorSpace : null);
        } finally {
            a.release(byteBufferAcquire);
        }
    }

    public static int b(Bitmap$Config bitmap$Config) {
        switch (a$a.a[bitmap$Config.ordinal()]) {
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

    public static int c(int i, int i2, Bitmap$Config bitmap$Config) {
        return b(bitmap$Config) * i * i2;
    }

    @SuppressLint({"NewApi"})
    public static int d(Bitmap bitmap) {
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
