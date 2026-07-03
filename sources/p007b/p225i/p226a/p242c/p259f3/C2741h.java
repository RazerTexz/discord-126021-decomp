package p007b.p225i.p226a.p242c.p259f3;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: renamed from: b.i.a.c.f3.h */
/* JADX INFO: compiled from: CodecSpecificDataUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2741h {

    /* JADX INFO: renamed from: a */
    public static final byte[] f6721a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b */
    public static final String[] f6722b = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};

    /* JADX INFO: renamed from: a */
    public static String m3022a(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    /* JADX INFO: renamed from: b */
    public static String m3023b(int i, boolean z2, int i2, int i3, int[] iArr, int i4) {
        Object[] objArr = new Object[5];
        objArr[0] = f6722b[i];
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Character.valueOf(z2 ? 'H' : 'L');
        objArr[4] = Integer.valueOf(i4);
        StringBuilder sb = new StringBuilder(C2738e0.m3003k("hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i5 = 0; i5 < length; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }
}
