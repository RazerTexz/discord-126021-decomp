package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.TypedValue;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.objectweb.asm.Opcodes;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p115d.p128m.C1720c;
import p007b.p109f.p115d.p128m.InterfaceC1718a;
import p007b.p109f.p115d.p128m.InterfaceC1719b;
import p007b.p109f.p161j.p178m.C1956b;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class WebpBitmapFactoryImpl implements InterfaceC1719b {

    /* JADX INFO: renamed from: a */
    public static InterfaceC1719b.a f19658a;

    /* JADX INFO: renamed from: b */
    public static InterfaceC1718a f19659b;

    /* JADX INFO: renamed from: b */
    public static byte[] m8735b(InputStream inputStream, BitmapFactory.Options options) {
        byte[] bArr;
        inputStream.mark(20);
        if (options == null || (bArr = options.inTempStorage) == null || bArr.length < 20) {
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

    /* JADX INFO: renamed from: c */
    public static void m8736c(String str) {
        InterfaceC1719b.a aVar = f19658a;
        if (aVar != null) {
            aVar.m1012a(str, "decoding_failure");
        }
    }

    @InterfaceC1680c
    private static Bitmap createBitmap(int i, int i2, BitmapFactory.Options options) {
        Bitmap bitmap;
        return (options == null || (bitmap = options.inBitmap) == null || !bitmap.isMutable()) ? f19659b.m1010a(i, i2, Bitmap.Config.ARGB_8888) : options.inBitmap;
    }

    @InterfaceC1680c
    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options options) {
        byte[] bArr;
        return (options == null || (bArr = options.inTempStorage) == null) ? new byte[8192] : bArr;
    }

    @InterfaceC1680c
    private static float getScaleFromOptions(BitmapFactory.Options options) {
        if (options == null) {
            return 1.0f;
        }
        int i = options.inSampleSize;
        float f = i > 1 ? 1.0f / i : 1.0f;
        if (!options.inScaled) {
            return f;
        }
        int i2 = options.inDensity;
        int i3 = options.inTargetDensity;
        return (i2 == 0 || i3 == 0 || i2 == options.inScreenDensity) ? f : i3 / i2;
    }

    @InterfaceC1680c
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        C1956b.m1411a();
        InterfaceC1719b interfaceC1719b = C1720c.f3139a;
        Bitmap bitmapOriginalDecodeByteArray = originalDecodeByteArray(bArr, i, i2, options);
        if (bitmapOriginalDecodeByteArray == null) {
            m8736c("webp_direct_decode_array_failed_on_no_webp");
        }
        return bitmapOriginalDecodeByteArray;
    }

    @InterfaceC1680c
    public static Bitmap hookDecodeFile(String str, BitmapFactory.Options options) {
        Bitmap bitmapHookDecodeStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                bitmapHookDecodeStream = hookDecodeStream(fileInputStream, null, options);
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

    @InterfaceC1680c
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        C1956b.m1411a();
        long jNativeSeek = nativeSeek(fileDescriptor, 0L, false);
        if (jNativeSeek == -1) {
            Bitmap bitmapHookDecodeStream = hookDecodeStream(new FileInputStream(fileDescriptor), rect, options);
            setPaddingDefaultValues(rect);
            return bitmapHookDecodeStream;
        }
        InputStream fileInputStream = new FileInputStream(fileDescriptor);
        if (!fileInputStream.markSupported()) {
            fileInputStream = new BufferedInputStream(fileInputStream, 20);
        }
        try {
            m8735b(fileInputStream, options);
            InterfaceC1719b interfaceC1719b = C1720c.f3139a;
            nativeSeek(fileDescriptor, jNativeSeek, true);
            Bitmap bitmapOriginalDecodeFileDescriptor = originalDecodeFileDescriptor(fileDescriptor, rect, options);
            if (bitmapOriginalDecodeFileDescriptor == null) {
                m8736c("webp_direct_decode_fd_failed_on_no_webp");
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

    @InterfaceC1680c
    public static Bitmap hookDecodeResource(Resources resources, int i, BitmapFactory.Options options) {
        TypedValue typedValue = new TypedValue();
        Bitmap bitmapHookDecodeResourceStream = null;
        try {
            InputStream inputStreamOpenRawResource = resources.openRawResource(i, typedValue);
            try {
                bitmapHookDecodeResourceStream = hookDecodeResourceStream(resources, typedValue, inputStreamOpenRawResource, null, options);
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
        if (bitmapHookDecodeResourceStream != null || options == null || options.inBitmap == null) {
            return bitmapHookDecodeResourceStream;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }

    @InterfaceC1680c
    public static Bitmap hookDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                options.inDensity = Opcodes.IF_ICMPNE;
            } else if (i != 65535) {
                options.inDensity = i;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, options);
    }

    @InterfaceC1680c
    public static Bitmap hookDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        C1956b.m1411a();
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, 20);
        }
        m8735b(inputStream, options);
        InterfaceC1719b interfaceC1719b = C1720c.f3139a;
        Bitmap bitmapOriginalDecodeStream = originalDecodeStream(inputStream, rect, options);
        if (bitmapOriginalDecodeStream == null) {
            m8736c("webp_direct_decode_stream_failed_on_no_webp");
        }
        return bitmapOriginalDecodeStream;
    }

    @InterfaceC1680c
    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options, float f, byte[] bArr2);

    @InterfaceC1680c
    private static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f, byte[] bArr);

    @InterfaceC1680c
    private static native long nativeSeek(FileDescriptor fileDescriptor, long j, boolean z2);

    @InterfaceC1680c
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        return BitmapFactory.decodeByteArray(bArr, i, i2, options);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeFile(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeResource(Resources resources, int i, BitmapFactory.Options options) {
        return BitmapFactory.decodeResource(resources, i, options);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    @InterfaceC1680c
    private static void setBitmapSize(BitmapFactory.Options options, int i, int i2) {
        if (options != null) {
            options.outWidth = i;
            options.outHeight = i2;
        }
    }

    @InterfaceC1680c
    private static boolean setOutDimensions(BitmapFactory.Options options, int i, int i2) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        options.outWidth = i;
        options.outHeight = i2;
        return true;
    }

    @InterfaceC1680c
    private static void setPaddingDefaultValues(Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    @InterfaceC1680c
    @SuppressLint({"NewApi"})
    private static boolean shouldPremultiply(BitmapFactory.Options options) {
        if (options != null) {
            return options.inPremultiplied;
        }
        return true;
    }

    @Override // p007b.p109f.p115d.p128m.InterfaceC1719b
    /* JADX INFO: renamed from: a */
    public Bitmap mo1011a(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        return hookDecodeFileDescriptor(fileDescriptor, null, options);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2) {
        return BitmapFactory.decodeByteArray(bArr, i, i2);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeResource(Resources resources, int i) {
        return BitmapFactory.decodeResource(resources, i);
    }

    @InterfaceC1680c
    private static Bitmap originalDecodeStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    @InterfaceC1680c
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2) {
        return hookDecodeByteArray(bArr, i, i2, null);
    }

    @InterfaceC1680c
    public static Bitmap hookDecodeFile(String str) {
        return hookDecodeFile(str, null);
    }

    @InterfaceC1680c
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        return hookDecodeStream(inputStream, null, null);
    }

    @InterfaceC1680c
    public static Bitmap hookDecodeResource(Resources resources, int i) {
        return hookDecodeResource(resources, i, null);
    }

    @InterfaceC1680c
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, null, null);
    }
}
