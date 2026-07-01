package b.f.k;

import android.graphics.Bitmap$Config;

/* JADX INFO: compiled from: BitmapUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class a$a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[Bitmap$Config.values().length];
        a = iArr;
        try {
            iArr[Bitmap$Config.ARGB_8888.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[Bitmap$Config.ALPHA_8.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[Bitmap$Config.ARGB_4444.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[Bitmap$Config.RGB_565.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[Bitmap$Config.RGBA_F16.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[Bitmap$Config.HARDWARE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
