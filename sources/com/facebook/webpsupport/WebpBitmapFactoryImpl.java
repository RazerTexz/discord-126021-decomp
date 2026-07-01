package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.graphics.Rect;
import android.util.TypedValue;
import b.f.d.d.c;
import b.f.d.m.a;
import b.f.d.m.b;
import b.f.d.m.b$a;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
@c
public class WebpBitmapFactoryImpl implements b {
    public static b$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f2908b;

    public static byte[] b(InputStream inputStream, BitmapFactory$Options bitmapFactory$Options) {
        byte[] bArr;
        inputStream.mark(20);
        if (bitmapFactory$Options == null || (bArr = bitmapFactory$Options.inTempStorage) == null || bArr.length < 20) {
            bArr = new byte[20];
        }
        try {
            inputStream.read(bArr, 0, 20);
            inputStream.reset();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    public static void c(String str) {
        b$a b_a = a;
        if (b_a != null) {
            b_a.a(str, "decoding_failure");
        }
    }

    @c
    private static Bitmap createBitmap(int i, int i2, BitmapFactory$Options bitmapFactory$Options) {
        Bitmap bitmap;
        return (bitmapFactory$Options == null || (bitmap = bitmapFactory$Options.inBitmap) == null || !bitmap.isMutable()) ? f2908b.a(i, i2, Bitmap$Config.ARGB_8888) : bitmapFactory$Options.inBitmap;
    }

    @c
    private static byte[] getInTempStorageFromOptions(BitmapFactory$Options bitmapFactory$Options) {
        byte[] bArr;
        return (bitmapFactory$Options == null || (bArr = bitmapFactory$Options.inTempStorage) == null) ? new byte[8192] : bArr;
    }

    @c
    private static float getScaleFromOptions(BitmapFactory$Options bitmapFactory$Options) {
        if (bitmapFactory$Options == null) {
            return 1.0f;
        }
        int i = bitmapFactory$Options.inSampleSize;
        float f = i > 1 ? 1.0f / i : 1.0f;
        if (!bitmapFactory$Options.inScaled) {
            return f;
        }
        int i2 = bitmapFactory$Options.inDensity;
        int i3 = bitmapFactory$Options.inTargetDensity;
        return (i2 == 0 || i3 == 0 || i2 == bitmapFactory$Options.inScreenDensity) ? f : i3 / i2;
    }

    @c
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory$Options bitmapFactory$Options) {
        b.f.j.m.b.a();
        b bVar = b.f.d.m.c.a;
        Bitmap bitmapOriginalDecodeByteArray = originalDecodeByteArray(bArr, i, i2, bitmapFactory$Options);
        if (bitmapOriginalDecodeByteArray == null) {
            c("webp_direct_decode_array_failed_on_no_webp");
        }
        return bitmapOriginalDecodeByteArray;
    }

    @c
    public static Bitmap hookDecodeFile(String str, BitmapFactory$Options bitmapFactory$Options) {
        Bitmap bitmapHookDecodeStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                bitmapHookDecodeStream = hookDecodeStream(fileInputStream, null, bitmapFactory$Options);
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Exception unused) {
        }
        return bitmapHookDecodeStream;
    }

    @c
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory$Options bitmapFactory$Options) {
        b.f.j.m.b.a();
        long jNativeSeek = nativeSeek(fileDescriptor, 0L, false);
        if (jNativeSeek == -1) {
            Bitmap bitmapHookDecodeStream = hookDecodeStream(new FileInputStream(fileDescriptor), rect, bitmapFactory$Options);
            setPaddingDefaultValues(rect);
            return bitmapHookDecodeStream;
        }
        InputStream fileInputStream = new FileInputStream(fileDescriptor);
        if (!fileInputStream.markSupported()) {
            fileInputStream = new BufferedInputStream(fileInputStream, 20);
        }
        try {
            b(fileInputStream, bitmapFactory$Options);
            b bVar = b.f.d.m.c.a;
            nativeSeek(fileDescriptor, jNativeSeek, true);
            Bitmap bitmapOriginalDecodeFileDescriptor = originalDecodeFileDescriptor(fileDescriptor, rect, bitmapFactory$Options);
            if (bitmapOriginalDecodeFileDescriptor == null) {
                c("webp_direct_decode_fd_failed_on_no_webp");
            }
            try {
                return bitmapOriginalDecodeFileDescriptor;
            } catch (Throwable unused) {
                return bitmapOriginalDecodeFileDescriptor;
            }
        } finally {
            try {
                fileInputStream.close();
            } catch (Throwable unused2) {
            }
        }
    }

    @c
    public static Bitmap hookDecodeResource(Resources resources, int i, BitmapFactory$Options bitmapFactory$Options) {
        TypedValue typedValue = new TypedValue();
        Bitmap bitmapHookDecodeResourceStream = null;
        try {
            InputStream inputStreamOpenRawResource = resources.openRawResource(i, typedValue);
            try {
                bitmapHookDecodeResourceStream = hookDecodeResourceStream(resources, typedValue, inputStreamOpenRawResource, null, bitmapFactory$Options);
                if (inputStreamOpenRawResource != null) {
                    inputStreamOpenRawResource.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStreamOpenRawResource != null) {
                        try {
                            inputStreamOpenRawResource.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception unused) {
        }
        if (bitmapHookDecodeResourceStream != null || bitmapFactory$Options == null || bitmapFactory$Options.inBitmap == null) {
            return bitmapHookDecodeResourceStream;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }

    @c
    public static Bitmap hookDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory$Options bitmapFactory$Options) {
        if (bitmapFactory$Options == null) {
            bitmapFactory$Options = new BitmapFactory$Options();
        }
        if (bitmapFactory$Options.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                bitmapFactory$Options.inDensity = Opcodes.IF_ICMPNE;
            } else if (i != 65535) {
                bitmapFactory$Options.inDensity = i;
            }
        }
        if (bitmapFactory$Options.inTargetDensity == 0 && resources != null) {
            bitmapFactory$Options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, bitmapFactory$Options);
    }

    @c
    public static Bitmap hookDecodeStream(InputStream inputStream, Rect rect, BitmapFactory$Options bitmapFactory$Options) {
        b.f.j.m.b.a();
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, 20);
        }
        b(inputStream, bitmapFactory$Options);
        b bVar = b.f.d.m.c.a;
        Bitmap bitmapOriginalDecodeStream = originalDecodeStream(inputStream, rect, bitmapFactory$Options);
        if (bitmapOriginalDecodeStream == null) {
            c("webp_direct_decode_stream_failed_on_no_webp");
        }
        return bitmapOriginalDecodeStream;
    }

    @c
    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory$Options bitmapFactory$Options, float f, byte[] bArr2);

    @c
    private static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory$Options bitmapFactory$Options, float f, byte[] bArr);

    @c
    private static native long nativeSeek(FileDescriptor fileDescriptor, long j, boolean z2);

    @c
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory$Options bitmapFactory$Options) {
        return BitmapFactory.decodeByteArray(bArr, i, i2, bitmapFactory$Options);
    }

    @c
    private static Bitmap originalDecodeFile(String str, BitmapFactory$Options bitmapFactory$Options) {
        return BitmapFactory.decodeFile(str, bitmapFactory$Options);
    }

    @c
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory$Options bitmapFactory$Options) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, bitmapFactory$Options);
    }

    @c
    private static Bitmap originalDecodeResource(Resources resources, int i, BitmapFactory$Options bitmapFactory$Options) {
        return BitmapFactory.decodeResource(resources, i, bitmapFactory$Options);
    }

    @c
    private static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory$Options bitmapFactory$Options) {
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, bitmapFactory$Options);
    }

    @c
    private static Bitmap originalDecodeStream(InputStream inputStream, Rect rect, BitmapFactory$Options bitmapFactory$Options) {
        return BitmapFactory.decodeStream(inputStream, rect, bitmapFactory$Options);
    }

    @c
    private static void setBitmapSize(BitmapFactory$Options bitmapFactory$Options, int i, int i2) {
        if (bitmapFactory$Options != null) {
            bitmapFactory$Options.outWidth = i;
            bitmapFactory$Options.outHeight = i2;
        }
    }

    @c
    private static boolean setOutDimensions(BitmapFactory$Options bitmapFactory$Options, int i, int i2) {
        if (bitmapFactory$Options == null || !bitmapFactory$Options.inJustDecodeBounds) {
            return false;
        }
        bitmapFactory$Options.outWidth = i;
        bitmapFactory$Options.outHeight = i2;
        return true;
    }

    @c
    private static void setPaddingDefaultValues(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    @c
    @SuppressLint({"NewApi"})
    private static boolean shouldPremultiply(BitmapFactory$Options bitmapFactory$Options) {
        if (bitmapFactory$Options != null) {
            return bitmapFactory$Options.inPremultiplied;
        }
        return true;
    }

    @Override // b.f.d.m.b
    public Bitmap a(FileDescriptor fileDescriptor, Rect rect, BitmapFactory$Options bitmapFactory$Options) {
        return hookDecodeFileDescriptor(fileDescriptor, null, bitmapFactory$Options);
    }

    @c
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2) {
        return BitmapFactory.decodeByteArray(bArr, i, i2);
    }

    @c
    private static Bitmap originalDecodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    @c
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    @c
    private static Bitmap originalDecodeResource(Resources resources, int i) {
        return BitmapFactory.decodeResource(resources, i);
    }

    @c
    private static Bitmap originalDecodeStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    @c
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2) {
        return hookDecodeByteArray(bArr, i, i2, null);
    }

    @c
    public static Bitmap hookDecodeFile(String str) {
        return hookDecodeFile(str, null);
    }

    @c
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        return hookDecodeStream(inputStream, null, null);
    }

    @c
    public static Bitmap hookDecodeResource(Resources resources, int i) {
        return hookDecodeResource(resources, i, null);
    }

    @c
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, null, null);
    }
}
